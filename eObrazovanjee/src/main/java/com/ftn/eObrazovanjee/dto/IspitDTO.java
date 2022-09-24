package com.ftn.eObrazovanjee.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.model.IspitniRok;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.model.PredmetInstanca;

public class IspitDTO {

	private Long id;
	private String naziv;
	private Date datumVreme;
	private int broj_osvojenih_bodova;
	private ArrayList<PolaganjeIspitaDTO> polaganjeIspita;
	private IspitniRokDTO ispitniRok;
	private ArrayList<DeoIspitaDTO> deoIspitaDTO;
	private PredmetInstancaDTO predmetInstanca;
	
	public IspitDTO(Long id, String naziv, Date datumVreme, 
			ArrayList<PolaganjeIspitaDTO> polaganjeIspita, IspitniRokDTO ispitniRok, ArrayList<DeoIspitaDTO> deoIspitaDTO,
			PredmetInstancaDTO predmetInstanca) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumVreme = datumVreme;

		this.polaganjeIspita = polaganjeIspita;
		this.ispitniRok = ispitniRok;
		this.deoIspitaDTO = deoIspitaDTO;
		this.predmetInstanca = predmetInstanca;
	}

	
	
	
	
	public IspitDTO(Long id, String naziv, Date datumVreme, int broj_osvojenih_bodova,
			ArrayList<PolaganjeIspitaDTO> polaganjeIspita, IspitniRokDTO ispitniRok,
			ArrayList<DeoIspitaDTO> deoIspitaDTO, PredmetInstancaDTO predmetInstanca) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumVreme = datumVreme;
		this.broj_osvojenih_bodova = broj_osvojenih_bodova;
		this.polaganjeIspita = polaganjeIspita;
		this.ispitniRok = ispitniRok;
		this.deoIspitaDTO = deoIspitaDTO;
		this.predmetInstanca = predmetInstanca;
	}





	public int getBroj_osvojenih_bodova() {
		return broj_osvojenih_bodova;
	}



	public void setBroj_osvojenih_bodova(int broj_osvojenih_bodova) {
		this.broj_osvojenih_bodova = broj_osvojenih_bodova;
	}



	public IspitDTO() {
		super();
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

	public Date getDatumVreme() {
		return datumVreme;
	}

	public void setDatumVreme(Date datumVreme) {
		this.datumVreme = datumVreme;
	}



	public ArrayList<PolaganjeIspitaDTO> getPolaganjeIspita() {
		return polaganjeIspita;
	}

	public void setPolaganjeIspita(ArrayList<PolaganjeIspitaDTO> polaganjeIspita) {
		this.polaganjeIspita = polaganjeIspita;
	}

	public IspitniRokDTO getIspitniRok() {
		return ispitniRok;
	}

	public void setIspitniRok(IspitniRokDTO ispitniRok) {
		this.ispitniRok = ispitniRok;
	}

	public ArrayList<DeoIspitaDTO> getDeoIspitaDTO() {
		return deoIspitaDTO;
	}

	public void setDeoIspitaDTO(ArrayList<DeoIspitaDTO> deoIspitaDTO) {
		this.deoIspitaDTO = deoIspitaDTO;
	}

	public PredmetInstancaDTO getPredmetInstanca() {
		return predmetInstanca;
	}

	public void setPredmetInstanca(PredmetInstancaDTO predmetInstanca) {
		this.predmetInstanca = predmetInstanca;
	}
	
	
	

	
	
	
	
}
