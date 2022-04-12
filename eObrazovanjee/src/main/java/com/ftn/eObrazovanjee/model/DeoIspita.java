package com.ftn.eObrazovanjee.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
@Entity
public class DeoIspita {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "naziv")
	private String naziv;
	
	@Column(name = "broj_osvojenih_bodova")
	private Double brojOsvojenihBodova;
	
	@Column(name = "min_bodova")
	private int minBodova;
	
	@Column(name = "polozio")
	private boolean polozio;
	
	//ispit
	//@ManyToOne
	//@JoinColumn(name = "ispit", referencedColumnName = "ispit_id", nullable = false)
	//private Ispit ispit;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ispit", referencedColumnName = "id", nullable = false)
    private Ispit ispit;

	public DeoIspita() {
		super();
	}

	public DeoIspita(Long id, String naziv, Double brojOsvojenihBodova, int minBodova, boolean polozio, Ispit ispit) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.brojOsvojenihBodova = brojOsvojenihBodova;
		this.minBodova = minBodova;
		this.polozio = polozio;
		this.ispit = ispit;
	}
	
	

	public DeoIspita(String naziv, Double brojOsvojenihBodova, int minBodova, boolean polozio, Ispit ispit) {
		super();
		this.naziv = naziv;
		this.brojOsvojenihBodova = brojOsvojenihBodova;
		this.minBodova = minBodova;
		this.polozio = polozio;
		this.ispit = ispit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Double getBrojOsvojenihBodova() {
		return brojOsvojenihBodova;
	}

	public void setBrojOsvojenihBodova(Double brojOsvojenihBodova) {
		this.brojOsvojenihBodova = brojOsvojenihBodova;
	}

	public int getMinBodova() {
		return minBodova;
	}

	public void setMinBodova(int minBodova) {
		this.minBodova = minBodova;
	}

	public boolean isPolozio() {
		return polozio;
	}

	public void setPolozio(boolean polozio) {
		this.polozio = polozio;
	}

	public Ispit getIspit() {
		return ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}
	
	//student
	
	
	
	
	
	
	

}
