package com.ftn.eObrazovanjee.dto;

public class PolozenPredmetDTO {
	private String nazivPredmeta;
	private int brojOsvojenihBodova;
	private Long ispit_id;
	private Long student_id;
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	public int getBrojOsvojenihBodova() {
		return brojOsvojenihBodova;
	}
	public void setBrojOsvojenihBodova(int brojOsvojenihBodova) {
		this.brojOsvojenihBodova = brojOsvojenihBodova;
	}

	public Long getIspit_id() {
		return ispit_id;
	}
	public void setIspit_id(Long ispit_id) {
		this.ispit_id = ispit_id;
	}
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	public PolozenPredmetDTO(String nazivPredmeta, int brojOsvojenihBodova, Long ispit_id,
			Long student_id) {
		super();
		this.nazivPredmeta = nazivPredmeta;
		this.brojOsvojenihBodova = brojOsvojenihBodova;
		this.ispit_id = ispit_id;
		this.student_id = student_id;
	}
	
	
}
