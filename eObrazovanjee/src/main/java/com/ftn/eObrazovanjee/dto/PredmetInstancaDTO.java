package com.ftn.eObrazovanjee.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.Predmet;

public class PredmetInstancaDTO {

	private Long id;
	private Date pocetak;
	private Date kraj;
	private PredmetDTO predmet;
	private ArrayList<IspitDTO> ispit;
	private ArrayList<PredavanjePredmetaDTO> predavanjePredmetaDTO;
	private ArrayList<PohadjanjePredmetaDTO> pohadjanjePredmetaDTO;
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


	public ArrayList<PredavanjePredmetaDTO> getPredavanjePredmetaDTO() {
		return predavanjePredmetaDTO;
	}
	public void setPredavanjePredmetaDTO(ArrayList<PredavanjePredmetaDTO> predavanjePredmetaDTO) {
		this.predavanjePredmetaDTO = predavanjePredmetaDTO;
	}
	public ArrayList<PohadjanjePredmetaDTO> getPohadjanjePredmetaDTO() {
		return pohadjanjePredmetaDTO;
	}
	public void setPohadjanjePredmetaDTO(ArrayList<PohadjanjePredmetaDTO> pohadjanjePredmetaDTO) {
		this.pohadjanjePredmetaDTO = pohadjanjePredmetaDTO;
	}
	
	
	
	public PredmetDTO getPredmet() {
		return predmet;
	}
	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
	public ArrayList<IspitDTO> getIspit() {
		return ispit;
	}
	public void setIspit(ArrayList<IspitDTO> ispit) {
		this.ispit = ispit;
	}
	public PredmetInstancaDTO() {
		super();
	}
	public PredmetInstancaDTO(Long id, Date pocetak, Date kraj, PredmetDTO predmet, ArrayList<IspitDTO> ispit,
			ArrayList<PredavanjePredmetaDTO> predavanjePredmetaDTO, ArrayList<PohadjanjePredmetaDTO> pohadjanjePredmetaDTO) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.predmet = predmet;
		this.ispit = ispit;
		this.predavanjePredmetaDTO = predavanjePredmetaDTO;
		this.pohadjanjePredmetaDTO = pohadjanjePredmetaDTO;
	}

	

	
	
}
