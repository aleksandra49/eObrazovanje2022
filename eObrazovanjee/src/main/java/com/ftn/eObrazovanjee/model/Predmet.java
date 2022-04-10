package com.ftn.eObrazovanjee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Predmet {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "naziv")
	private String naziv;

	@Column(name = "espb")
	private Integer espb;
	
	@Column(name = "oznaka")
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

	public Predmet() {
		super();
	}

	public Predmet(Long id, String naziv, Integer espb, String oznaka) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.oznaka = oznaka;
	}
	
	
}
