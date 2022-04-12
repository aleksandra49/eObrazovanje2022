package com.ftn.eObrazovanjee.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ispit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "naziv")
	private String naziv;
	
	@Column(name = "datumVreme")
	private LocalDateTime datumVreme;
	
	@Column(name = "brojOsvojenihBodova")
	private int brojOsvojenihBodova;
	
	@OneToMany(mappedBy = "ispit", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<PolaganjeIspita> polaganjeIspita = new HashSet<PolaganjeIspita>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private IspitniRok ispitniRok;
	
	@OneToMany(mappedBy = "ispit", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<DeoIspita> deoIspita = new HashSet<DeoIspita>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private PredmetInstanca predmetInstanca;

	public Ispit(Long id, String naziv, LocalDateTime datumVreme, int brojOsvojenihBodova,
			Set<PolaganjeIspita> polaganjeIspita, IspitniRok ispitniRok, Set<DeoIspita> deoIspita,
			PredmetInstanca predmetInstanca) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumVreme = datumVreme;
		this.brojOsvojenihBodova = brojOsvojenihBodova;
		this.polaganjeIspita = polaganjeIspita;
		this.ispitniRok = ispitniRok;
		this.deoIspita = deoIspita;
		this.predmetInstanca = predmetInstanca;
	}

	public Ispit() {
		super();
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

	public LocalDateTime getDatumVreme() {
		return datumVreme;
	}

	public void setDatumVreme(LocalDateTime datumVreme) {
		this.datumVreme = datumVreme;
	}

	public int getBrojOsvojenihBodova() {
		return brojOsvojenihBodova;
	}

	public void setBrojOsvojenihBodova(int brojOsvojenihBodova) {
		this.brojOsvojenihBodova = brojOsvojenihBodova;
	}

	public Set<PolaganjeIspita> getPolaganjeIspita() {
		return polaganjeIspita;
	}

	public void setPolaganjeIspita(Set<PolaganjeIspita> polaganjeIspita) {
		this.polaganjeIspita = polaganjeIspita;
	}

	public IspitniRok getIspitniRok() {
		return ispitniRok;
	}

	public void setIspitniRok(IspitniRok ispitniRok) {
		this.ispitniRok = ispitniRok;
	}

	public Set<DeoIspita> getDeoIspita() {
		return deoIspita;
	}

	public void setDeoIspita(Set<DeoIspita> deoIspita) {
		this.deoIspita = deoIspita;
	}

	public PredmetInstanca getPredmetInstanca() {
		return predmetInstanca;
	}

	public void setPredmetInstanca(PredmetInstanca predmetInstanca) {
		this.predmetInstanca = predmetInstanca;
	}
	
	

}
