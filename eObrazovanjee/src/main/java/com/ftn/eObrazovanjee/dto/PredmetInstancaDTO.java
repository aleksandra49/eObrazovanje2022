package com.ftn.eObrazovanjee.dto;

import java.util.Date;
import java.util.List;

import com.ftn.eObrazovanjee.model.Predmet;

public class PredmetInstancaDTO {

	private Long id;
	private Date pocetak;
	private Date kraj;
	private Predmet predmet;
	private List<PredavanjePredmetaDTO> predavanjePredmetaDTO;
	private List<PohadjanjePredmetaDTO> pohadjanjePredmetaDTO;
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

	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public List<PredavanjePredmetaDTO> getPredavanjePredmetaDTO() {
		return predavanjePredmetaDTO;
	}
	public void setPredavanjePredmetaDTO(List<PredavanjePredmetaDTO> predavanjePredmetaDTO) {
		this.predavanjePredmetaDTO = predavanjePredmetaDTO;
	}
	public List<PohadjanjePredmetaDTO> getPohadjanjePredmetaDTO() {
		return pohadjanjePredmetaDTO;
	}
	public void setPohadjanjePredmetaDTO(List<PohadjanjePredmetaDTO> pohadjanjePredmetaDTO) {
		this.pohadjanjePredmetaDTO = pohadjanjePredmetaDTO;
	}
	
	public PredmetInstancaDTO() {
		super();
	}
	
	public PredmetInstancaDTO(Long id, Date pocetak, Date kraj, Predmet predmet,
			List<PredavanjePredmetaDTO> predavanjePredmetaDTO, List<PohadjanjePredmetaDTO> pohadjanjePredmetaDTO) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.predmet = predmet;
		this.predavanjePredmetaDTO = predavanjePredmetaDTO;
		this.pohadjanjePredmetaDTO = pohadjanjePredmetaDTO;
	}
	
	
}
