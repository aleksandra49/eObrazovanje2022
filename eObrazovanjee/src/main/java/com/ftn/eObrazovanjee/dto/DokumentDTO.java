package com.ftn.eObrazovanjee.dto;

public class DokumentDTO {

	private Long id;
	private String naziv;
	private String uri;
	
	
	public DokumentDTO() {
		super();
	}

	public DokumentDTO(Long id, String naziv, String uri) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.uri = uri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
	
	
}
