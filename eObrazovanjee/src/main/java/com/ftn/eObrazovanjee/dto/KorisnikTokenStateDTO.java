package com.ftn.eObrazovanjee.dto;

import com.ftn.eObrazovanjee.model.Uloga;

public class KorisnikTokenStateDTO {

	private String accessToken;
    private Long expiresIn;
	private Long id;
	private String korisnickoIme;
	private String lozinka;
	private Uloga uloga;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Long getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public Uloga getUloga() {
		return uloga;
	}
	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
	public KorisnikTokenStateDTO(String accessToken, Long expiresIn, Long id, String korisnickoIme, String lozinka,
			Uloga uloga) {
		super();
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.uloga = uloga;
	}
	
	

    

        
}