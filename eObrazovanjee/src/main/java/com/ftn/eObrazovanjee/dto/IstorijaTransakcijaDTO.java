package com.ftn.eObrazovanjee.dto;


import java.util.Date;

public class IstorijaTransakcijaDTO {
	
	private Long idTransakcije;
	private Date datum;
	private Double promenaStanja;
	private String svrha;
	private String personalniBroj;
	private String racunFakulteta;
	private Double trenutnoStanje;
	
	public IstorijaTransakcijaDTO() {
		super();
	}

	public IstorijaTransakcijaDTO(Long idTransakcije, Date datum, Double promenaStanja, String svrha,
			String personalniBroj, String racunFakulteta, Double trenutnoStanje) {
		super();
		this.idTransakcije = idTransakcije;
		this.datum = datum;
		this.promenaStanja = promenaStanja;
		this.svrha = svrha;
		this.personalniBroj = personalniBroj;
		this.racunFakulteta = racunFakulteta;
		this.trenutnoStanje = trenutnoStanje;
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

	public String getPersonalniBroj() {
		return personalniBroj;
	}

	public void setPersonalniBroj(String personalniBroj) {
		this.personalniBroj = personalniBroj;
	}

	public String getRacunFakulteta() {
		return racunFakulteta;
	}

	public void setRacunFakulteta(String racunFakulteta) {
		this.racunFakulteta = racunFakulteta;
	}

	public Double getTrenutnoStanje() {
		return trenutnoStanje;
	}

	public void setTrenutnoStanje(Double trenutnoStanje) {
		this.trenutnoStanje = trenutnoStanje;
	}
	
	
	
	
	
	

}
