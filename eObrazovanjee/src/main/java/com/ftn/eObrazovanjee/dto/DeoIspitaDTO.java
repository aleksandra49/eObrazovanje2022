package com.ftn.eObrazovanjee.dto;

import java.util.Date;
import java.util.List;

public class DeoIspitaDTO {
	
	private Long id;
	private String naziv;
	private Double brojOsvojenihBodova;
	private int minBodova;
	private boolean polozio;
	
	private List<StudentDTO> studentDTO;
	//private List<IspitDTO> ispitDTO;
	//private List<PredmetInstancaDTO> predmetInstancaDTO;

	public DeoIspitaDTO() {
		super();
	}
	
	//pun
	

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

	public Double getBrojOsvojenihBodova() {
		return brojOsvojenihBodova;
	}

	public void setBrojOsvojenihBodova(Double brojOsvojenihBodova) {
		this.brojOsvojenihBodova = brojOsvojenihBodova;
	}

	public int getMinBodova() {
		return minBodova;
	}

	public void setMinBodova(int minBodova) {
		this.minBodova = minBodova;
	}

	public boolean isPolozio() {
		return polozio;
	}

	public void setPolozio(boolean polozio) {
		this.polozio = polozio;
	}

	public List<StudentDTO> getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(List<StudentDTO> studentDTO) {
		this.studentDTO = studentDTO;
	}
	
	

	

}
