package com.ftn.eObrazovanjee.dto;

import java.util.Date;

public class TransakcijaDTO {

	private Long id;
	private Date datum;
	private String svrha;
	private double promenaStanja;
	
	
	public TransakcijaDTO() {
		super();
	}

	public TransakcijaDTO(Long id, Date datum, String svrha, double promenaStanja) {
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
