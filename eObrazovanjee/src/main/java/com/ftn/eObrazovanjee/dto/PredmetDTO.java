package com.ftn.eObrazovanjee.dto;

public class PredmetDTO {

	private Long id;
	private String naziv;
	private Integer espb;
	private String oznaka;
	
	
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
	public Integer getEspb() {
		return espb;
	}
	public void setEspb(Integer espb) {
		this.espb = espb;
	}
	public String getOznaka() {
		return oznaka;
	}
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	
	
	public PredmetDTO() {
		super();
	}
	public PredmetDTO(Long id, String naziv, Integer espb, String oznaka) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.oznaka = oznaka;

	}
	

	
	
	
	
}
