package com.ftn.eObrazovanjee.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String ime;
	private String prezime;
	
	//@Column(name = "indeks", unique = true, nullable = false)
	//String indeks;
	private String indeks;
	
	private String email;
	private boolean active;
	//private boolean active = true;
	
	
	//studijskagodina
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<StudijskaGodina> studijskaGodina;
	
	//dokument
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Dokument> dokumenti;
	
	//finakart
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "finansijska_kartica_id", nullable = false)
    private FinansijskaKartica finansijskaKartica;
//	
//	//transakcija
//	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<Transakcija> transakcije;
//	
	//pohadjanjepredmeta
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<PohadjanjePredmeta> pohadjanjePredmeta;
	
//	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//	private Set<PohadjanjePredmeta> pohadjanjePredmeta = new HashSet<PohadjanjePredmeta>();
//	
//	//polaganjeispit
//	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//	private Set<PolaganjeIspita> polaganjeIspita = new HashSet<PolaganjeIspita>();
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "korisnik_id", nullable = false)
    private Korisnik korisnik;
	
	
	
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
	
	
	
	
	
	

}
