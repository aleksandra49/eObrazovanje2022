package com.ftn.eObrazovanjee.model;


import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "profesori")
public class Profesor {

	
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;
    
    @Column(name = "email")
    private String email;
    
    
    @OneToOne
    @JoinColumn(name = "korisnik", referencedColumnName = "id")
    private Korisnik korisnik;
    
    @OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Set<PredavanjePredmeta> predavanja = new HashSet<>();


    
	public Profesor() {
		super();
	}



	public Profesor(Long id, String ime, String prezime, String email, Korisnik korisnik,
			Set<PredavanjePredmeta> predavanja) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.korisnik = korisnik;
		this.predavanja = predavanja;
	}



	public Set<PredavanjePredmeta> getPredavanja() {
		return predavanja;
	}


	public void setPredavanja(Set<PredavanjePredmeta> predavanja) {
		this.predavanja = predavanja;
	}


	public Korisnik getKorisnik() {
		return korisnik;
	}


	public void setKorisnik(Korisnik korisnik) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

  
    
    

}
