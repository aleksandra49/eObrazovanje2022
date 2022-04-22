package com.ftn.eObrazovanjee.dto;

import java.util.ArrayList;

public class DokumentDTO {

	private Long id;
	private String naziv;
	private String uri;
	private StudentDTO studentDto;
	private ArrayList<TipDokumentaDTO> tipDokumentaDTOs;
	
	
	public DokumentDTO() {
		super();
	}



	public DokumentDTO(Long id, String naziv, String uri, StudentDTO studentDto,
			ArrayList<TipDokumentaDTO> tipDokumentaDTOs) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.uri = uri;
		this.studentDto = studentDto;
		this.tipDokumentaDTOs = tipDokumentaDTOs;
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}


	public StudentDTO getStudentDto() {
		return studentDto;
	}


	public void setStudentDto(StudentDTO studentDto) {
		this.studentDto = studentDto;
	}



	public ArrayList<TipDokumentaDTO> getTipDokumentaDTOs() {
		return tipDokumentaDTOs;
	}



	public void setTipDokumentaDTOs(ArrayList<TipDokumentaDTO> tipDokumentaDTOs) {
		this.tipDokumentaDTOs = tipDokumentaDTOs;
	}

	
	
	
	
	
}
