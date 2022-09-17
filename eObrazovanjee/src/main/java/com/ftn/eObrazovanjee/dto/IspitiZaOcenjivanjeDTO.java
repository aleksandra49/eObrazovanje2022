package com.ftn.eObrazovanjee.dto;

import java.util.Date;

public class IspitiZaOcenjivanjeDTO {
	private String studentIme;
	private String studentPrezime;
	private Long polozenIspitId;
	private String nazivPredmeta;
	private Date datumIspita;
	
	public String getStudentIme() {
		return studentIme;
	}
	public void setStudentIme(String studentIme) {
		this.studentIme = studentIme;
	}
	public String getStudentPrezime() {
		return studentPrezime;
	}
	public void setStudentPrezime(String studentPrezime) {
		this.studentPrezime = studentPrezime;
	}
	public Long getPolozenIspitId() {
		return polozenIspitId;
	}
	public void setPolozenIspitId(Long polozenIspitId) {
		this.polozenIspitId = polozenIspitId;
	}
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	public Date getDatumIspita() {
		return datumIspita;
	}
	public void setDatumIspita(Date datumIspita) {
		this.datumIspita = datumIspita;
	}
	public IspitiZaOcenjivanjeDTO(String studentIme, String studentPrezime, Long polozenIspitId, String nazivPredmeta,
			Date datumIspita) {
		super();
		this.studentIme = studentIme;
		this.studentPrezime = studentPrezime;
		this.polozenIspitId = polozenIspitId;
		this.nazivPredmeta = nazivPredmeta;
		this.datumIspita = datumIspita;
	}
	
	
}
