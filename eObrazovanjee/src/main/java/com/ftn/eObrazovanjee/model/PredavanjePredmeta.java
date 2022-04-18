package com.ftn.eObrazovanjee.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Profesor profesor;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private PredmetInstanca predmetInstanca;
    
	@Column(name = "tip_predavaca")
	private TipPredavacaVezbi tipPredavaca;

    
    
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public TipPredavacaVezbi getTipPredavaca() {
		return tipPredavaca;
	}
	public void setTipPredavaca(TipPredavacaVezbi tipPredavaca) {
		this.tipPredavaca = tipPredavaca;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

		
	public PredmetInstanca getInstanca() {
		return predmetInstanca;
	}
	public void setInstanca(PredmetInstanca instanca) {
		this.predmetInstanca = instanca;
	}
	
	public PredavanjePredmeta() {
		super();
	}
	
	public PredavanjePredmeta(Long id, Profesor profesor, PredmetInstanca predmetInstanca, TipPredavacaVezbi tipPredavaca) {
		super();
		this.id = id;
		this.profesor = profesor;
		this.predmetInstanca = predmetInstanca;
		this.tipPredavaca = tipPredavaca;

	}
	

	
	
    
    

}
