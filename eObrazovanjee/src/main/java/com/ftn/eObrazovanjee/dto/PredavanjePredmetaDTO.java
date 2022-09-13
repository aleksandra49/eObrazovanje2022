package com.ftn.eObrazovanjee.dto;

import com.ftn.eObrazovanjee.model.TipPredavacaVezbi;

public class PredavanjePredmetaDTO {

	private Long id;
	private PredmetInstancaDTO predmetInstanca;
	private ProfesorDTO profesor;
	private TipPredavacaVezbi tipPredavaca;
	private PredmetDTO predmet;
	
	
	public PredmetDTO getPredmet() {
		return predmet;
	}
	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PredmetInstancaDTO getPredmetInstanca() {
		return predmetInstanca;
	}
	public void setPredmetInstanca(PredmetInstancaDTO predmetInstanca) {
		this.predmetInstanca = predmetInstanca;
	}

	public ProfesorDTO getProfesor() {
		return profesor;
	}
	public void setProfesor(ProfesorDTO profesor) {
		this.profesor = profesor;
	}
	public TipPredavacaVezbi getTipPredavaca() {
		return tipPredavaca;
	}
	public void setTipPredavaca(TipPredavacaVezbi tipPredavaca) {
		this.tipPredavaca = tipPredavaca;
	}
	public PredavanjePredmetaDTO(Long id, PredmetInstancaDTO predmetInstanca, ProfesorDTO profesor,
			TipPredavacaVezbi tipPredavaca) {
		super();
		this.id = id;
		this.predmetInstanca = predmetInstanca;

		this.profesor = profesor;
		this.tipPredavaca = tipPredavaca;
	}
	public PredavanjePredmetaDTO() {
		super();
	}
	public PredavanjePredmetaDTO(Long id, PredmetInstancaDTO predmetInstanca, ProfesorDTO profesor,
			TipPredavacaVezbi tipPredavaca, PredmetDTO predmet) {
		super();
		this.id = id;
		this.predmetInstanca = predmetInstanca;
		this.profesor = profesor;
		this.tipPredavaca = tipPredavaca;
		this.predmet = predmet;
	}
	
	
}
