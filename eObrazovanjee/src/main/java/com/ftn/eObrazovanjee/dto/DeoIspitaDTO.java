package com.ftn.eObrazovanjee.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeoIspitaDTO {
	
	private Long id;
	private String naziv;
	private Double brojOsvojenihBodova;
	private int minBodova;
	private boolean polozio;
	
	//private List<StudentDTO> studentDTO;
	private IspitDTO ispitDTO;
	//private Set<IspitDTO> ispitDTO = new HashSet();
	//private List<PredmetInstancaDTO> predmetInstancaDTO;

	public DeoIspitaDTO() {
		super();
	}
	
	//pun
	

//	public DeoIspitaDTO(Long id, String naziv, Double brojOsvojenihBodova, int minBodova, boolean polozio,
//			List<StudentDTO> studentDTO, ArrayList<IspitDTO> ispitDTO) {
//		super();
//		this.id = id;
//		this.naziv = naziv;
//		this.brojOsvojenihBodova = brojOsvojenihBodova;
//		this.minBodova = minBodova;
//		this.polozio = polozio;
//		//this.studentDTO = studentDTO;
//		this.ispitDTO = ispitDTO;
//	}
	
	public DeoIspitaDTO(Long id, String naziv, Double brojOsvojenihBodova, int minBodova, boolean polozio,
			IspitDTO ispitDTO) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.brojOsvojenihBodova = brojOsvojenihBodova;
		this.minBodova = minBodova;
		this.polozio = polozio;
		this.ispitDTO = ispitDTO;
	}

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

	public IspitDTO getIspitDTO() {
		return ispitDTO;
	}

	public void setIspitDTO(IspitDTO ispitDTO) {
		this.ispitDTO = ispitDTO;
	}

	/*public List<StudentDTO> getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(List<StudentDTO> studentDTO) {
		this.studentDTO = studentDTO;
	}*/

	
	
	

	

}
