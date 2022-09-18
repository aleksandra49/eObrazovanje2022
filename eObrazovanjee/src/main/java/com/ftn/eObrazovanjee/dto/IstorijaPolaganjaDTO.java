package com.ftn.eObrazovanjee.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class IstorijaPolaganjaDTO {
	
	
	private String studentIme;
	private String studentPrezime;
	private String nazivPredmeta;
	private int brojBodova;
	private Date datumVreme;
	private int ispitId;
	private int studentId;
	
	public IstorijaPolaganjaDTO(String studentIme, String studentPrezime, String nazivPredmeta, int brojBodova,
			Date datumVreme, int ispitId, int studentId) {
		super();
		this.studentIme = studentIme;
		this.studentPrezime = studentPrezime;
		this.nazivPredmeta = nazivPredmeta;
		this.brojBodova = brojBodova;
		this.datumVreme = datumVreme;
		this.ispitId = ispitId;
		this.studentId = studentId;
	}
	
	public IstorijaPolaganjaDTO() {
		super();
	}

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

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public int getBrojBodova() {
		return brojBodova;
	}

	public void setBrojBodova(int brojBodova) {
		this.brojBodova = brojBodova;
	}

	public Date getDatumVreme() {
		return datumVreme;
	}

	public void setDatumVreme(Date datumVreme) {
		this.datumVreme = datumVreme;
	}

	public int getIspitId() {
		return ispitId;
	}

	public void setIspitId(int ispitId) {
		this.ispitId = ispitId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	
	
	
	

}
