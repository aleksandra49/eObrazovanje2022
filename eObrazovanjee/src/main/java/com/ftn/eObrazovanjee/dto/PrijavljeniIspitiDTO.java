package com.ftn.eObrazovanjee.dto;

import java.util.Date;

public class PrijavljeniIspitiDTO {

	private Long prijavljenIspitId;
	private String naziv;
	private Date datumIspita;

	
	public Long getPrijavljenIspitId() {
		return prijavljenIspitId;
	}
	public void setPrijavljenIspitId(Long prijavljenIspitId) {
		this.prijavljenIspitId = prijavljenIspitId;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Date getDatumIspita() {
		return datumIspita;
	}
	public void setDatumIspita(Date datumIspita) {
		this.datumIspita = datumIspita;
	}
	
	
	
	public PrijavljeniIspitiDTO(Long prijavljenIspitId, String naziv, Date datumIspita) {
		super();
		this.prijavljenIspitId = prijavljenIspitId;
		this.naziv = naziv;
		this.datumIspita = datumIspita;
		
	}
	
	
}
