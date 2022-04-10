package com.ftn.eObrazovanjee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "predavanja")
public class PredavanjePredmeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "profesor_id", referencedColumnName = "id")
    private Profesor nastavnik;

    @ManyToOne()
    @JoinColumn(name = "instanca_id", referencedColumnName = "id")
    private PredmetInstanca instanca;

    @Column(name = "obrisan")
    private boolean obrisan;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Profesor getNastavnik() {
		return nastavnik;
	}
	public void setNastavnik(Profesor nastavnik) {
		this.nastavnik = nastavnik;
	}
	public boolean isObrisan() {
		return obrisan;
	}
	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	
	
	public PredmetInstanca getInstanca() {
		return instanca;
	}
	public void setInstanca(PredmetInstanca instanca) {
		this.instanca = instanca;
	}
	public PredavanjePredmeta() {
		super();
	}
	public PredavanjePredmeta(Long id, Profesor nastavnik, PredmetInstanca instanca, boolean obrisan) {
		super();
		this.id = id;
		this.nastavnik = nastavnik;
		this.instanca = instanca;
		this.obrisan = obrisan;
	}

	
	
    
    

}
