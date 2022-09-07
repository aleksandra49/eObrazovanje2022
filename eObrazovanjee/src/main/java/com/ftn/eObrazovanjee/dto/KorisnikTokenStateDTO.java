package com.ftn.eObrazovanjee.dto;

import com.ftn.eObrazovanjee.model.Uloga;

public class KorisnikTokenStateDTO {

	private String accessToken;
    private Long expiresIn;
    private KorisnikDTO korisnikDTO;
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
	public KorisnikDTO getKorisnikDTO() {
		return korisnikDTO;
	}
	public void setKorisnikDTO(KorisnikDTO korisnikDTO) {
		this.korisnikDTO = korisnikDTO;
	}
	public KorisnikTokenStateDTO(String accessToken, Long expiresIn, KorisnikDTO korisnikDTO) {
		super();
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
		this.korisnikDTO = korisnikDTO;
	}
    
    
	
	

    

        
}