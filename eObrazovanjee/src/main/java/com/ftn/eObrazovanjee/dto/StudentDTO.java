package com.ftn.eObrazovanjee.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class StudentDTO {
	
	private Long id;
	private String ime;
	private String prezime;
	private String indeks;
	private String email;
	private boolean active;
	//private Set<StudijskaGodinaDTO> studijskeGodineDTO = new HashSet();
	private ArrayList<StudijskaGodinaDTO> studijskeGodineDTO;
	//private Set<DokumentDTO> dokumentiDTO = new HashSet();
	private ArrayList<DokumentDTO> dokumentiDTO;
	private FinansijskaKarticaDTO finansijskaKarticaDTO;
	//private Set<PohadjanjePredmetaDTO> pohadjanjaPredmetaDTO = new HashSet();
	private ArrayList<PohadjanjePredmetaDTO> pohadjanjaPredmetaDTO;
	private KorisnikDTO korisnikDTO;
	private ArrayList<PolaganjeIspitaDTO> polaganjeIspita;
	
	
	public StudentDTO() {
		super();
	}


	public StudentDTO(Long id, String ime, String prezime, String indeks, String email, boolean active,
			ArrayList<StudijskaGodinaDTO> studijskeGodineDTO, ArrayList<DokumentDTO> dokumentiDTO,
			FinansijskaKarticaDTO finansijskaKarticaDTO, ArrayList<PohadjanjePredmetaDTO> pohadjanjaPredmetaDTO,
			KorisnikDTO korisnikDTO, ArrayList<PolaganjeIspitaDTO> polaganjeIspita) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks;
		this.email = email;
		this.active = active;
		this.studijskeGodineDTO = studijskeGodineDTO;
		this.dokumentiDTO = dokumentiDTO;
		this.finansijskaKarticaDTO = finansijskaKarticaDTO;
		this.pohadjanjaPredmetaDTO = pohadjanjaPredmetaDTO;
		this.korisnikDTO = korisnikDTO;
		this.polaganjeIspita = polaganjeIspita;
	}


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


	public ArrayList<StudijskaGodinaDTO> getStudijskeGodineDTO() {
		return studijskeGodineDTO;
	}


	public void setStudijskeGodineDTO(ArrayList<StudijskaGodinaDTO> studijskeGodineDTO) {
		this.studijskeGodineDTO = studijskeGodineDTO;
	}


	public ArrayList<DokumentDTO> getDokumentiDTO() {
		return dokumentiDTO;
	}


	public void setDokumentiDTO(ArrayList<DokumentDTO> dokumentiDTO) {
		this.dokumentiDTO = dokumentiDTO;
	}


	public FinansijskaKarticaDTO getFinansijskaKarticaDTO() {
		return finansijskaKarticaDTO;
	}


	public void setFinansijskaKarticaDTO(FinansijskaKarticaDTO finansijskaKarticaDTO) {
		this.finansijskaKarticaDTO = finansijskaKarticaDTO;
	}


	public ArrayList<PohadjanjePredmetaDTO> getPohadjanjaPredmetaDTO() {
		return pohadjanjaPredmetaDTO;
	}


	public void setPohadjanjaPredmetaDTO(ArrayList<PohadjanjePredmetaDTO> pohadjanjaPredmetaDTO) {
		this.pohadjanjaPredmetaDTO = pohadjanjaPredmetaDTO;
	}


	public KorisnikDTO getKorisnikDTO() {
		return korisnikDTO;
	}


	public void setKorisnikDTO(KorisnikDTO korisnikDTO) {
		this.korisnikDTO = korisnikDTO;
	}


	public ArrayList<PolaganjeIspitaDTO> getPolaganjeIspita() {
		return polaganjeIspita;
	}


	public void setPolaganjeIspita(ArrayList<PolaganjeIspitaDTO> polaganjeIspita) {
		this.polaganjeIspita = polaganjeIspita;
	}




	
	

}
