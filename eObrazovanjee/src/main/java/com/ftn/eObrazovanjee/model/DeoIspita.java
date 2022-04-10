package com.ftn.eObrazovanjee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
@Entity
public class DeoIspita {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String naziv;
	private Double brojOsvojenihBodova;
	private int minBodova;
	private boolean polozio;
	
	//predmetinstanca ili predmetspec
	//ispit
	//student
	
	
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
	
	
	
	
	

}
