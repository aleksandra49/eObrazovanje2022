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
	
	@Column(name = "ime")
	private String ime;
	
	@Column(name = "prezime")
	private String prezime;
	
	//@Column(name = "indeks", unique = true, nullable = false)
	//String indeks;
	@Column(name = "indeks")
	private String indeks;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "active")
	private boolean active;
	//private boolean active = true;
	
	
	//studijskagodina
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<StudijskaGodina> studijskaGodina = new HashSet<StudijskaGodina>();
	
	//dokument
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Dokument> dokumenti = new HashSet<Dokument>();
	
	//finakart
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id", nullable = false)
    private FinansijskaKartica finansijskaKartica;
//	
//	//transakcija
//	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<Transakcija> transakcije;
//	
	//pohadjanjepredmeta
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<PohadjanjePredmeta> pohadjanjePredmeta = new HashSet<PohadjanjePredmeta>();
	
//	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//	private Set<PohadjanjePredmeta> pohadjanjePredmeta = new HashSet<PohadjanjePredmeta>();
//	
//	//polaganjeispit
//	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//	private Set<PolaganjeIspita> polaganjeIspita = new HashSet<PolaganjeIspita>();
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "korisnik", referencedColumnName = "id")
    private Korisnik korisnik;
	
	
	
	
	
	public Student() {
		super();
	}
	
	
	
	public Student(Long id, String ime, String prezime, String indeks, String email, boolean active,
			Set<StudijskaGodina> studijskaGodina, Set<Dokument> dokumenti, FinansijskaKartica finansijskaKartica,
			Set<PohadjanjePredmeta> pohadjanjePredmeta, Korisnik korisnik) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks;
		this.email = email;
		this.active = active;
		this.studijskaGodina = studijskaGodina;
		this.dokumenti = dokumenti;
		this.finansijskaKartica = finansijskaKartica;
		this.pohadjanjePredmeta = pohadjanjePredmeta;
		this.korisnik = korisnik;
	}


	

	public Student(String ime, String prezime, String indeks, String email, boolean active,
			Set<StudijskaGodina> studijskaGodina, Set<Dokument> dokumenti, FinansijskaKartica finansijskaKartica,
			Set<PohadjanjePredmeta> pohadjanjePredmeta, Korisnik korisnik) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks;
		this.email = email;
		this.active = active;
		this.studijskaGodina = studijskaGodina;
		this.dokumenti = dokumenti;
		this.finansijskaKartica = finansijskaKartica;
		this.pohadjanjePredmeta = pohadjanjePredmeta;
		this.korisnik = korisnik;
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

	public Set<StudijskaGodina> getStudijskaGodina() {
		return studijskaGodina;
	}

	public void setStudijskaGodina(Set<StudijskaGodina> studijskaGodina) {
		this.studijskaGodina = studijskaGodina;
	}

	public Set<Dokument> getDokumenti() {
		return dokumenti;
	}

	public void setDokumenti(Set<Dokument> dokumenti) {
		this.dokumenti = dokumenti;
	}

	public FinansijskaKartica getFinansijskaKartica() {
		return finansijskaKartica;
	}

	public void setFinansijskaKartica(FinansijskaKartica finansijskaKartica) {
		this.finansijskaKartica = finansijskaKartica;
	}

	public Set<PohadjanjePredmeta> getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}

	public void setPohadjanjePredmeta(Set<PohadjanjePredmeta> pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	
	
	
	
	

}
