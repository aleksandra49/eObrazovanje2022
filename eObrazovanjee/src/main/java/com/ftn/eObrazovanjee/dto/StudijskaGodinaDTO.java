package com.ftn.eObrazovanjee.dto;

import java.util.Date;
import java.util.List;

import com.ftn.eObrazovanjee.model.NacinFinansiranja;

public class StudijskaGodinaDTO {
	
	private Long id;
	private Date pocetakStudija;
	private Date krajStudija;
	private NacinFinansiranja nacinFinansiranja;
	private int godinaStudija;
	private int skolskaGodina;
	
	private List<StudentDTO> studentDTO;

	
	
	public StudijskaGodinaDTO() {
		super();
	}

	//pun
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPocetakStudija() {
		return pocetakStudija;
	}

	public void setPocetakStudija(Date pocetakStudija) {
		this.pocetakStudija = pocetakStudija;
	}

	public Date getKrajStudija() {
		return krajStudija;
	}

	public void setKrajStudija(Date krajStudija) {
		this.krajStudija = krajStudija;
	}

	

	public NacinFinansiranja getNacinFinansiranja() {
		return nacinFinansiranja;
	}

	public void setNacinFinansiranja(NacinFinansiranja nacinFinansiranja) {
		this.nacinFinansiranja = nacinFinansiranja;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public int getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(int skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public List<StudentDTO> getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(List<StudentDTO> studentDTO) {
		this.studentDTO = studentDTO;
	}

}
