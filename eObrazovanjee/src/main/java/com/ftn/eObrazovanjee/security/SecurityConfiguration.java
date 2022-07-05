package com.ftn.eObrazovanjee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.ftn.eObrazovanjee.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

				// sve neautentifikovane zahteve obradi uniformno i posalji 401 gresku
				.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()

				// svim korisnicima dopusti da pristupe putanjama /auth/**
				.authorizeRequests()
				.antMatchers("/auth/login").permitAll()
				.antMatchers("/auth/parent/signup")
				.permitAll()
				.antMatchers("api/korisnik/get").permitAll()
				.antMatchers("api/ispit/get").permitAll()
				.antMatchers("api/ispit/add").permitAll()
				.antMatchers("api/korisnik/add").permitAll()

				.anyRequest().authenticated().and()

		
				.addFilterBefore(new AuthentictionTokenFilter(tokenUtils, userDetailsService),
						BasicAuthenticationFilter.class);

		// zbog jednostavnosti primera
		http.cors().and().csrf().disable();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TokenAuthenticationFilter ce ignorisati sve ispod navedene putanje
		web.ignoring().antMatchers(HttpMethod.GET, "/serviceOffers/**");
		web.ignoring().antMatchers(HttpMethod.GET, "/serviceOffers/type/**");
		web.ignoring().antMatchers(HttpMethod.GET, "/serviceProviders/**");
		web.ignoring().antMatchers(HttpMethod.GET, "/ratings/**");
		web.ignoring().antMatchers(HttpMethod.GET, "/photos/**");
		web.ignoring().antMatchers(HttpMethod.GET, "/v3/api-docs");
		web.ignoring().antMatchers(HttpMethod.POST, "/payment/create");
		web.ignoring().antMatchers(HttpMethod.POST, "/payment/refund");
		web.ignoring().antMatchers(HttpMethod.POST, "/reservations");
		
		web.ignoring().antMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs", "/v3/api-docs/**", "/api/v1/KidsParty/v3/api-docs");

	}
	
}
