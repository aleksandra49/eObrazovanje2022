package com.ftn.eObrazovanjee.dto;

import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.model.Uloga;

public class KorisnikDTO {

	private Long id;
	private String korisnickoIme;
	private String lozinka;
	private Uloga uloga;
	private ProfesorDTO profesor;
	private StudentDTO student;
	
	
	
	public KorisnikDTO(Long id, String korisnickoIme, String lozinka, Uloga uloga) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.uloga = uloga;
	}

	public KorisnikDTO(Long id, String korisnickoIme, String lozinka, Uloga uloga, ProfesorDTO profesor, StudentDTO student) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.uloga = uloga;
		this.profesor = profesor;
		this.student = student;
	}
	
	public KorisnikDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public Uloga getUloga() {
		return uloga;
	}
	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
	public ProfesorDTO getProfesor() {
		return profesor;
	}
	public void setProfesor(ProfesorDTO profesor) {
		this.profesor = profesor;
	}
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	
	
	
	
}
