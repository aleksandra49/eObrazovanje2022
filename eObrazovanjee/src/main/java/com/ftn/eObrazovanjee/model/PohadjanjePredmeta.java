package com.ftn.eObrazovanjee.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	//predmetinstanca
	//ispit
		
	
	
	
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
