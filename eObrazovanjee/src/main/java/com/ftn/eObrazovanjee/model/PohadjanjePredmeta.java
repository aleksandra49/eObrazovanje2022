package com.ftn.eObrazovanjee.model;

import java.util.Date;

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
public class PohadjanjePredmeta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "pocetak")
	private Date pocetak;
	
	@Column(name = "kraj")
	private Date kraj;
	
	@Column(name = "polozen")
	private boolean polozen;
	
	
	//student
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "student", referencedColumnName = "id", nullable = false)
    private Student student;
	
	//predmetinstanca
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "predmetInstanca", referencedColumnName = "id", nullable = false)
    private PredmetInstanca predmetInstanca;
	

	
	public PohadjanjePredmeta() {
		super();
	}
	
	
	public PohadjanjePredmeta(Long id, Date pocetak, Date kraj, boolean polozen, Student student,
			PredmetInstanca predmetInstanca) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.polozen = polozen;
		this.student = student;
		this.predmetInstanca = predmetInstanca;
	}
	
	


	public PohadjanjePredmeta(Date pocetak, Date kraj, boolean polozen, Student student,
			PredmetInstanca predmetInstanca) {
		super();
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.polozen = polozen;
		this.student = student;
		this.predmetInstanca = predmetInstanca;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getPocetak() {
		return pocetak;
	}
	public void setPocetak(Date pocetak) {
		this.pocetak = pocetak;
	}
	public Date getKraj() {
		return kraj;
	}
	public void setKraj(Date kraj) {
		this.kraj = kraj;
	}
	public boolean isPolozen() {
		return polozen;
	}
	public void setPolozen(boolean polozen) {
		this.polozen = polozen;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public PredmetInstanca getPredmetInstanca() {
		return predmetInstanca;
	}

	public void setPredmetInstanca(PredmetInstanca predmetInstanca) {
		this.predmetInstanca = predmetInstanca;
	}
	
	
	
	

}
