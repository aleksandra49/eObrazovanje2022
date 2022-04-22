package com.ftn.eObrazovanjee.dto;

import java.util.ArrayList;

public class FinansijskaKarticaDTO {
	
	private Long id;
	private String personalniBroj;
	private int trenutnoStanje;
	private String racunFakulteta;
	private StudentDTO studentDto;
	private ArrayList<TransakcijaDTO> transakcijaDTO;
	
	
	public FinansijskaKarticaDTO() {
		super();
	}

	public FinansijskaKarticaDTO(Long id, String personalniBroj, int trenutnoStanje, String racunFakulteta,
			StudentDTO studentDto, ArrayList<TransakcijaDTO> transakcijaDTO) {
		super();
		this.id = id;
		this.personalniBroj = personalniBroj;
		this.trenutnoStanje = trenutnoStanje;
		this.racunFakulteta = racunFakulteta;
		this.studentDto = studentDto;
		this.transakcijaDTO = transakcijaDTO;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonalniBroj() {
		return personalniBroj;
	}

	public void setPersonalniBroj(String personalniBroj) {
		this.personalniBroj = personalniBroj;
	}

	public int getTrenutnoStanje() {
		return trenutnoStanje;
	}

	public void setTrenutnoStanje(int trenutnoStanje) {
		this.trenutnoStanje = trenutnoStanje;
	}

	public String getRacunFakulteta() {
		return racunFakulteta;
	}

	public void setRacunFakulteta(String racunFakulteta) {
		this.racunFakulteta = racunFakulteta;
	}

	public StudentDTO getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDTO studentDto) {
		this.studentDto = studentDto;
	}

	public ArrayList<TransakcijaDTO> getTransakcijaDTO() {
		return transakcijaDTO;
	}

	public void setTransakcijaDTO(ArrayList<TransakcijaDTO> transakcijaDTO) {
		this.transakcijaDTO = transakcijaDTO;
	}
	
	
	
	

}
