package com.ftn.eObrazovanjee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipDokumenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nazivDokumenta;
	
	public TipDokumenta() {
		super();
	}
	
	public TipDokumenta(Long id, String nazivDokumenta) {
		super();
		this.id = id;
		this.nazivDokumenta = nazivDokumenta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivDokumenta() {
		return nazivDokumenta;
	}

	public void setNazivDokumenta(String nazivDokumenta) {
		this.nazivDokumenta = nazivDokumenta;
	}
	
	
	
	
}
