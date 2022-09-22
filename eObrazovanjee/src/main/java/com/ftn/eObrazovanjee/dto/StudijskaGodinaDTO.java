package com.ftn.eObrazovanjee.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.ftn.eObrazovanjee.model.NacinFinansiranja;
import lombok.Builder;

@Builder
public class StudijskaGodinaDTO {
	
	private Long id;
//	private Date pocetakStudija;
//	private Date krajStudija;
	private LocalDateTime pocetakStudija;
	private LocalDateTime krajStudija;
	private NacinFinansiranja nacinFinansiranja;
	private int godinaStudija;
	private int skolskaGodina;
	
	//private List<StudentDTO> studentDTO;
	private StudentDTO studnetDTO;

	
	
	public StudijskaGodinaDTO() {
		super();
	}

//	public StudijskaGodinaDTO(Long id, Date pocetakStudija, Date krajStudija, NacinFinansiranja nacinFinansiranja,
//			int godinaStudija, int skolskaGodina, StudentDTO studnetDTO) {
//		super();
//		this.id = id;
//		this.pocetakStudija = pocetakStudija;
//		this.krajStudija = krajStudija;
//		this.nacinFinansiranja = nacinFinansiranja;
//		this.godinaStudija = godinaStudija;
//		this.skolskaGodina = skolskaGodina;
//		this.studnetDTO = studnetDTO;
//	}
//	
//	
//
//	
//
//	public StudijskaGodinaDTO(Long id, Date pocetakStudija, Date krajStudija, NacinFinansiranja nacinFinansiranja,
//			int godinaStudija, int skolskaGodina) {
//		super();
//		this.id = id;
//		this.pocetakStudija = pocetakStudija;
//		this.krajStudija = krajStudija;
//		this.nacinFinansiranja = nacinFinansiranja;
//		this.godinaStudija = godinaStudija;
//		this.skolskaGodina = skolskaGodina;
//	}
	
	

	

	public StudijskaGodinaDTO(Long id, LocalDateTime pocetakStudija, LocalDateTime krajStudija,
		NacinFinansiranja nacinFinansiranja, int godinaStudija, int skolskaGodina) {
	super();
	this.id = id;
	this.pocetakStudija = pocetakStudija;
	this.krajStudija = krajStudija;
	this.nacinFinansiranja = nacinFinansiranja;
	this.godinaStudija = godinaStudija;
	this.skolskaGodina = skolskaGodina;
}

	public StudijskaGodinaDTO(Long id, LocalDateTime pocetakStudija, LocalDateTime krajStudija,
		NacinFinansiranja nacinFinansiranja, int godinaStudija, int skolskaGodina, StudentDTO studnetDTO) {
	super();
	this.id = id;
	this.pocetakStudija = pocetakStudija;
	this.krajStudija = krajStudija;
	this.nacinFinansiranja = nacinFinansiranja;
	this.godinaStudija = godinaStudija;
	this.skolskaGodina = skolskaGodina;
	this.studnetDTO = studnetDTO;
}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Date getPocetakStudija() {
//		return pocetakStudija;
//	}
//
//	public void setPocetakStudija(Date pocetakStudija) {
//		this.pocetakStudija = pocetakStudija;
//	}
//
//	public Date getKrajStudija() {
//		return krajStudija;
//	}
//
//	public void setKrajStudija(Date krajStudija) {
//		this.krajStudija = krajStudija;
//	}
	
	

	

	public NacinFinansiranja getNacinFinansiranja() {
		return nacinFinansiranja;
	}

	public LocalDateTime getPocetakStudija() {
		return pocetakStudija;
	}

	public void setPocetakStudija(LocalDateTime pocetakStudija) {
		this.pocetakStudija = pocetakStudija;
	}

	public LocalDateTime getKrajStudija() {
		return krajStudija;
	}

	public void setKrajStudija(LocalDateTime krajStudija) {
		this.krajStudija = krajStudija;
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

	public StudentDTO getStudnetDTO() {
		return studnetDTO;
	}

	public void setStudnetDTO(StudentDTO studnetDTO) {
		this.studnetDTO = studnetDTO;
	}

	

}
