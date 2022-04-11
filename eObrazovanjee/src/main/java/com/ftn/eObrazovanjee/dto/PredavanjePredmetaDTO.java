package com.ftn.eObrazovanjee.dto;

import com.ftn.eObrazovanjee.model.TipPredavacaVezbi;

public class PredavanjePredmetaDTO {

	private Long id;
	private PredmetInstancaDTO predmetInstanca;
	private boolean obrisan;
	private ProfesorDTO profesor;
	private TipPredavacaVezbi tipPredavaca;
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
	public boolean isObrisan() {
		return obrisan;
	}
	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
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
	public PredavanjePredmetaDTO(Long id, PredmetInstancaDTO predmetInstanca, boolean obrisan, ProfesorDTO profesor,
			TipPredavacaVezbi tipPredavaca) {
		super();
		this.id = id;
		this.predmetInstanca = predmetInstanca;
		this.obrisan = obrisan;
		this.profesor = profesor;
		this.tipPredavaca = tipPredavaca;
	}
	public PredavanjePredmetaDTO() {
		super();
	}
	
	
}
