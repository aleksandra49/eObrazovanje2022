package com.ftn.eObrazovanjee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FinansijskaKartica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String personalniBroj;
	private int trenutnoStanje;
	private String racunFakulteta;
	
	public FinansijskaKartica() {
		super();
	}

	public FinansijskaKartica(Long id, String personalniBroj, int trenutnoStanje, String racunFakulteta) {
		super();
		this.id = id;
		this.personalniBroj = personalniBroj;
		this.trenutnoStanje = trenutnoStanje;
		this.racunFakulteta = racunFakulteta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonalniBroj() {
		return personalniBroj;
	}

	public void setPersonalniBroj(String personalniBroj) {
		this.personalniBroj = personalniBroj;
	}

	public int getTrenutnoStanje() {
		return trenutnoStanje;
	}

	public void setTrenutnoStanje(int trenutnoStanje) {
		this.trenutnoStanje = trenutnoStanje;
	}

	public String getRacunFakulteta() {
		return racunFakulteta;
	}

	public void setRacunFakulteta(String racunFakulteta) {
		this.racunFakulteta = racunFakulteta;
	}
	
	
	
	
	

}
