package com.ftn.eObrazovanjee.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.model.Korisnik;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtils {

	@Value("spring-security-example")
	private String APP_NAME;
	
	// Tajna koju samo backend aplikacija treba da zna kako bi mogla da generise i proveri JWT https://jwt.io/
	@Value("somesecret")
	public String SECRET;

	// Period vazenja
	@Value("30000000")
	private Long EXPIRES_IN;

	// Naziv headera kroz koji ce se prosledjivati JWT u komunikaciji server-klijent
	@Value("Authorization")
	private String AUTH_HEADER;
	
	// Algoritam za potpisivanje JWT
	private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
	
	
	// Funkcija za generisanje JWT token
	public String generateToken(String username, Long id, String roles) {
		return Jwts.builder()
				.setIssuer(APP_NAME)
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(generateExpirationDate())
				.claim("roles", roles)
				.claim("userId", id)
					// .claim("key", value) //moguce je postavljanje proizvoljnih podataka u telo JWT tokena
				.signWith(SIGNATURE_ALGORITHM, SECRET).compact();
	}
		
	private Date generateExpirationDate() {
		return new Date(new Date().getTime() + EXPIRES_IN);
	}

	
	// Funkcija za validaciju JWT tokena
	public Boolean validateToken(String token, UserDetails userDetails) {
		Korisnik korisnik = (Korisnik) userDetails;
		final String username = getUsernameFromToken(token);
		final Date created = getIssuedAtDateFromToken(token);
		
		return (username != null && username.equals(userDetails.getUsername()));
	}
	
	public String getUsernameFromToken(String token) {
		String username;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}
	
	// Funkcija za citanje svih podataka iz JWT tokena
	private Claims getAllClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token)
					.getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}
	
	public Date getIssuedAtDateFromToken(String token) {
		Date issueAt;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			issueAt = claims.getIssuedAt();
		} catch (Exception e) {
			issueAt = null;
		}
		return issueAt;
	}

	public Long getExpiredIn() {
		return EXPIRES_IN;
	}

	public String getToken(HttpServletRequest request) {
		String authHeader = getAuthHeaderFromHeader(request);
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);
		}
		return null;
	}
	
	public String getAuthHeaderFromHeader(HttpServletRequest request) {
		return request.getHeader(AUTH_HEADER);
	}
}
