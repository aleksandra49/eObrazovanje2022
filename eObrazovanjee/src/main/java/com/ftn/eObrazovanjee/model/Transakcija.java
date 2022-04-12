package com.ftn.eObrazovanjee.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transakcija {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date datum;
	private String svrha;
	private double promenaStanja;
	
	public Transakcija() {
		super();
	}

	public Transakcija(Long id, Date datum, String svrha, double promenaStanja) {
		super();
		this.id = id;
		this.datum = datum;
		this.svrha = svrha;
		this.promenaStanja = promenaStanja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getSvrha() {
		return svrha;
	}

	public void setSvrha(String svrha) {
		this.svrha = svrha;
	}

	public double getPromenaStanja() {
		return promenaStanja;
	}

	public void setPromenaStanja(double promenaStanja) {
		this.promenaStanja = promenaStanja;
	}
	
	
	

	
}
