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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FinansijskaKartica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "personalni_broj")
	private String personalniBroj;
	
	@Column(name = "trenutno_stanje")
	private int trenutnoStanje;
	
	@Column(name = "racun_fakulteta")
	private String racunFakulteta;
	
	@OneToOne(mappedBy = "finansijskaKartica",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Student student;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Transakcija> transakcije = new HashSet<Transakcija>();
	
	
	public FinansijskaKartica() {
		super();
	}

	
	public FinansijskaKartica(Long id, String personalniBroj, int trenutnoStanje, String racunFakulteta) {
		super();
		this.id = id;
		this.personalniBroj = personalniBroj;
		this.trenutnoStanje = trenutnoStanje;
		this.racunFakulteta = racunFakulteta;
	}
	

	public FinansijskaKartica(Long id, String personalniBroj, int trenutnoStanje, String racunFakulteta,
			Student student, Set<Transakcija> transakcije) {
		super();
		this.id = id;
		this.personalniBroj = personalniBroj;
		this.trenutnoStanje = trenutnoStanje;
		this.racunFakulteta = racunFakulteta;
		this.student = student;
		this.transakcije = transakcije;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonalniBroj() {
		return personalniBroj;
	}

	public void setPersonalniBroj(String personalniBroj) {
		this.personalniBroj = personalniBroj;
	}

	public int getTrenutnoStanje() {
		return trenutnoStanje;
	}

	public void setTrenutnoStanje(int trenutnoStanje) {
		this.trenutnoStanje = trenutnoStanje;
	}

	public String getRacunFakulteta() {
		return racunFakulteta;
	}

	public void setRacunFakulteta(String racunFakulteta) {
		this.racunFakulteta = racunFakulteta;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	public Set<Transakcija> getTransakcije() {
		return transakcije;
	}


	public void setTransakcije(Set<Transakcija> transakcije) {
		this.transakcije = transakcije;
	}

	

	
	
	
	
	
	
	

}
