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
    private Profesor profesor;

    @ManyToOne()
    @JoinColumn(name = "instanca_id", referencedColumnName = "id")
    private PredmetInstanca instanca;
    
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
		return instanca;
	}
	public void setInstanca(PredmetInstanca instanca) {
		this.instanca = instanca;
	}
	
	public PredavanjePredmeta() {
		super();
	}
	
	public PredavanjePredmeta(Long id, Profesor profesor, PredmetInstanca instanca, TipPredavacaVezbi tipPredavaca) {
		super();
		this.id = id;
		this.profesor = profesor;
		this.instanca = instanca;
		this.tipPredavaca = tipPredavaca;

	}
	

	
	
    
    

}
