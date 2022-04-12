package com.ftn.eObrazovanjee.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
	
	private Date pocetak;
	private Date kraj;
	private boolean polozen;
	
	
	//student
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "student", referencedColumnName = "student_id", nullable = false)
    private Student student;
	
	//predmetinstanca
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "predmetInstanca", referencedColumnName = "predmetInstanca_id", nullable = false)
    private PredmetInstanca predmetInstanca;
	
		
	
	
	
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
	
	
	
	

}
