package com.ftn.eObrazovanjee.dto;

import java.util.Date;

public class PredmetInstancaPredmetDTO {
	
	private Long id;
	private String naziv;
	private Integer espb;
	private String oznaka;
	private Date pocetak;
	private Date kraj;
	
	public PredmetInstancaPredmetDTO() {
		super();
	}

	public PredmetInstancaPredmetDTO(Long id, String naziv, Integer espb, String oznaka, Date pocetak, Date kraj) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.oznaka = oznaka;
		this.pocetak = pocetak;
		this.kraj = kraj;
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

	public Date getPocetak() {
		return pocetak;
	}

	public void setPocetak(Date pocetak) {
		this.pocetak = pocetak;
	}

	public Date getKraj() {
		return kraj;
	}

	public void setKraj(Date kraj) {
		this.kraj = kraj;
	}
	
	
	
	

}
