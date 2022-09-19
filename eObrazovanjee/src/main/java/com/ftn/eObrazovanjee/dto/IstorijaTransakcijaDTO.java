package com.ftn.eObrazovanjee.dto;


import java.util.Date;

public class IstorijaTransakcijaDTO {
	
	private Long idTransakcije;
	private Date datum;
	private Double promenaStanja;
	private String svrha;
	
	public IstorijaTransakcijaDTO() {
		super();
	}
	
	public IstorijaTransakcijaDTO(Long idTransakcije, Date datum, Double promenaStanja, String svrha) {
		super();
		this.idTransakcije = idTransakcije;
		this.datum = datum;
		this.promenaStanja = promenaStanja;
		this.svrha = svrha;
	}

	public Long getIdTransakcije() {
		return idTransakcije;
	}

	public void setIdTransakcije(Long idTransakcije) {
		this.idTransakcije = idTransakcije;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Double getPromenaStanja() {
		return promenaStanja;
	}

	public void setPromenaStanja(Double promenaStanja) {
		this.promenaStanja = promenaStanja;
	}

	public String getSvrha() {
		return svrha;
	}

	public void setSvrha(String svrha) {
		this.svrha = svrha;
	}
	
	
	
	
	

}
