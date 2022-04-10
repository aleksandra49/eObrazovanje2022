package com.ftn.eObrazovanjee.dto;

import java.util.List;

public class StudentDTO {
	
	private Long id;
	private String ime;
	private String prezime;
	private String indeks;
	private String email;
	private boolean active;
	private List<StudijskaGodinaDTO> studijskeGodineDTO;
	//private List<DokumentDTO> dokumentiDTO;
	//private List<FinansijskaKarticaDTO> finansijskaKarticaDTO;
	//private List<TransakcijaDTO> transkacijeDTO;
	private List<PohadjanjePredmetaDTO> pohadjanjaPredmetaDTO;
	//private List<IspitDTO> ispitDTO;
	//private KorisnikDTO korisnikDTO;
	
	
	public StudentDTO() {
		super();
	}
	
	//pun konstruktor


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getIndeks() {
		return indeks;
	}


	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public List<StudijskaGodinaDTO> getStudijskeGodineDTO() {
		return studijskeGodineDTO;
	}


	public void setStudijskeGodineDTO(List<StudijskaGodinaDTO> studijskeGodineDTO) {
		this.studijskeGodineDTO = studijskeGodineDTO;
	}


	public List<PohadjanjePredmetaDTO> getPohadjanjaPredmetaDTO() {
		return pohadjanjaPredmetaDTO;
	}


	public void setPohadjanjaPredmetaDTO(List<PohadjanjePredmetaDTO> pohadjanjaPredmetaDTO) {
		this.pohadjanjaPredmetaDTO = pohadjanjaPredmetaDTO;
	}
	
	
	
	
	
	
	
	

	
	
	

}
