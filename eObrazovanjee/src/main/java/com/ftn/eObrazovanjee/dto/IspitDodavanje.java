package com.ftn.eObrazovanjee.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class IspitDodavanje {

	private Long id;
	private String naziv;
	private Date datumVreme;
	private Long predmetId;
	private Long ispitniRokId;
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

	public Date getDatumVreme() {
		return datumVreme;
	}
	public void setDatumVreme(Date datumVreme) {
		this.datumVreme = datumVreme;
	}
	public Long getPredmetId() {
		return predmetId;
	}
	public void setPredmetId(Long predmetId) {
		this.predmetId = predmetId;
	}
	public Long getIspitniRokId() {
		return ispitniRokId;
	}
	public void setIspitniRokId(Long ispitniRokId) {
		this.ispitniRokId = ispitniRokId;
	}
	public IspitDodavanje(Long id, String naziv, Date datumVreme, Long predmetId, Long ispitniRokId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumVreme = datumVreme;
		this.predmetId = predmetId;
		this.ispitniRokId = ispitniRokId;
	}
	public IspitDodavanje() {
		super();
	}
	
	


}
