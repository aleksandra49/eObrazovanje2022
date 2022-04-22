package com.ftn.eObrazovanjee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TipDokumenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "naziv_dokumenta")
	private String nazivDokumenta;
	
	@ManyToOne
    @JoinColumn(name = "dokument_id", referencedColumnName = "id")
	private Dokument dokument;
	
	public TipDokumenta() {
		super();
	}

	public TipDokumenta(Long id, String nazivDokumenta, Dokument dokument) {
		super();
		this.id = id;
		this.nazivDokumenta = nazivDokumenta;
		this.dokument = dokument;
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

	public Dokument getDokument() {
		return dokument;
	}

	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}
	
	
	
	
}
