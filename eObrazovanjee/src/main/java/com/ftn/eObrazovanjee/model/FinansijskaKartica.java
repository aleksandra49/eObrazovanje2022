package com.ftn.eObrazovanjee.model;

import javax.persistence.CascadeType;
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
	
	private String personalniBroj;
	
	private int trenutnoStanje;
	
	private String racunFakulteta;
	
	@OneToOne(mappedBy = "finansijskaKartica",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Student student;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Transakcija transakcija;
	
	
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
			Student student, Transakcija transakcija) {
		super();
		this.id = id;
		this.personalniBroj = personalniBroj;
		this.trenutnoStanje = trenutnoStanje;
		this.racunFakulteta = racunFakulteta;
		this.student = student;
		this.transakcija = transakcija;
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

	public Transakcija getTransakcija() {
		return transakcija;
	}

	public void setTransakcija(Transakcija transakcija) {
		this.transakcija = transakcija;
	}
	
	
	
	
	
	
	

}
