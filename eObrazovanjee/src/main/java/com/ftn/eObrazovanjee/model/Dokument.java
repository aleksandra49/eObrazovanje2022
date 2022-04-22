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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Dokument {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "naziv")
	private String naziv;
	
    @Column(name = "uri")
	private String uri;
	
	@ManyToOne(cascade = CascadeType.REFRESH , fetch = FetchType.LAZY)
	private Student student;
	
	@OneToMany(mappedBy = "dokument", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<TipDokumenta> tipDokumenta = new HashSet<>();
	
	
	public Dokument() {
		super();
	}
	

	public Dokument(Long id, String naziv, String uri, Student student, Set<TipDokumenta> tipDokumenta) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.uri = uri;
		this.student = student;
		this.tipDokumenta = tipDokumenta;
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	public Set<TipDokumenta> getTipDokumenta() {
		return tipDokumenta;
	}


	public void setTipDokumenta(Set<TipDokumenta> tipDokumenta) {
		this.tipDokumenta = tipDokumenta;
	}

	

	

	
	
	
	
	
	

}
