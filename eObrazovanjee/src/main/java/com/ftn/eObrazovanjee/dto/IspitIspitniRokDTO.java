package com.ftn.eObrazovanjee.dto;

import java.util.Date;

public class IspitIspitniRokDTO {
	
	private Integer ispitId;
	private String nazivPredmeta;
	private Date datumIVremeRoka;
	private String nazivRoka;
	public Integer getIspitId() {
		return ispitId;
	}
	public void setIspitId(Integer ispitId) {
		this.ispitId = ispitId;
	}
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	public Date getDatumIVremeRoka() {
		return datumIVremeRoka;
	}
	public void setDatumIVremeRoka(Date datumIVremeRoka) {
		this.datumIVremeRoka = datumIVremeRoka;
	}
	public String getNazivRoka() {
		return nazivRoka;
	}
	public void setNazivRoka(String nazivRoka) {
		this.nazivRoka = nazivRoka;
	}
	public IspitIspitniRokDTO(Integer ispitId, String nazivPredmeta, Date datumIVremeRoka, String nazivRoka) {
		super();
		this.ispitId = ispitId;
		this.nazivPredmeta = nazivPredmeta;
		this.datumIVremeRoka = datumIVremeRoka;
		this.nazivRoka = nazivRoka;
	}
	

	
}
