package com.ftn.eObrazovanjee.dto;

public class UlogovaniProfesorDTO {
	public String ime;
	public String prezime;
	public String email;
	public String korisnickoIme;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public UlogovaniProfesorDTO(String ime, String prezime, String email, String korisnickoIme) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.korisnickoIme = korisnickoIme;
	}
	
	
	
}
