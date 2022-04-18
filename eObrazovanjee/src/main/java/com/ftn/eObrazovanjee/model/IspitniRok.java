package com.ftn.eObrazovanjee.model;

import java.util.Date;
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
public class IspitniRok {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nazivRoka")
	private String nazivRoka;
	
	@Column(name = "pocetakRoka")
	private Date pocetakRoka;
	
	@Column(name = "krajRoka")
	private Date krajRoka;
	
	@OneToMany(mappedBy = "ispitniRok", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Ispit> ispit = new HashSet<Ispit>();

	public IspitniRok(Long id, String nazivRoka, Date pocetakRoka, Date krajRoka, Set<Ispit> ispit) {
		super();
		this.id = id;
		this.nazivRoka = nazivRoka;
		this.pocetakRoka = pocetakRoka;
		this.krajRoka = krajRoka;
		this.ispit = ispit;
	}

	public IspitniRok() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivRoka() {
		return nazivRoka;
	}

	public void setNazivRoka(String nazivRoka) {
		this.nazivRoka = nazivRoka;
	}

	public Date getPocetakRoka() {
		return pocetakRoka;
	}

	public void setPocetakRoka(Date pocetakRoka) {
		this.pocetakRoka = pocetakRoka;
	}

	public Date getKrajRoka() {
		return krajRoka;
	}

	public void setKrajRoka(Date krajRoka) {
		this.krajRoka = krajRoka;
	}

	public Set<Ispit> getIspit() {
		return ispit;
	}

	public void setIspit(Set<Ispit> ispit) {
		this.ispit = ispit;
	}
	
	
	
}
