package com.ftn.eObrazovanjee.dto;

public class KorisnikTokenStateDTO {

	private String accessToken;
    private Long expiresIn;
    
	public KorisnikTokenStateDTO(String accessToken, Long expiresIn) {
		super();
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
	}
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
        
}
