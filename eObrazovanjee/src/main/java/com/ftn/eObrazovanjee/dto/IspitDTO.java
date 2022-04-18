package com.ftn.eObrazovanjee.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.model.IspitniRok;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.model.PredmetInstanca;

public class IspitDTO {

	private Long id;
	private String naziv;
	private LocalDateTime datumVreme;
	private int brojOsvojenihBodova;
	
	private Set<PolaganjeIspitaDTO> polaganjeIspita = new HashSet();
	private IspitniRokDTO ispitniRok;
	private Set<DeoIspitaDTO> deoIspitaDTO = new HashSet();
	private PredmetInstancaDTO predmetInstanca;
	
	public IspitDTO(Long id, String naziv, LocalDateTime datumVreme, int brojOsvojenihBodova,
			Set<PolaganjeIspitaDTO> polaganjeIspita, IspitniRokDTO ispitniRok, Set<DeoIspitaDTO> deoIspitaDTO,
			PredmetInstancaDTO predmetInstanca) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumVreme = datumVreme;
		this.brojOsvojenihBodova = brojOsvojenihBodova;
		this.polaganjeIspita = polaganjeIspita;
		this.ispitniRok = ispitniRok;
		this.deoIspitaDTO = deoIspitaDTO;
		this.predmetInstanca = predmetInstanca;
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

	public LocalDateTime getDatumVreme() {
		return datumVreme;
	}

	public void setDatumVreme(LocalDateTime datumVreme) {
		this.datumVreme = datumVreme;
	}

	public int getBrojOsvojenihBodova() {
		return brojOsvojenihBodova;
	}

	public void setBrojOsvojenihBodova(int brojOsvojenihBodova) {
		this.brojOsvojenihBodova = brojOsvojenihBodova;
	}

	public Set<PolaganjeIspitaDTO> getPolaganjeIspita() {
		return polaganjeIspita;
	}

	public void setPolaganjeIspita(Set<PolaganjeIspitaDTO> polaganjeIspita) {
		this.polaganjeIspita = polaganjeIspita;
	}

	public IspitniRokDTO getIspitniRok() {
		return ispitniRok;
	}

	public void setIspitniRok(IspitniRokDTO ispitniRok) {
		this.ispitniRok = ispitniRok;
	}

	public Set<DeoIspitaDTO> getDeoIspitaDTO() {
		return deoIspitaDTO;
	}

	public void setDeoIspitaDTO(Set<DeoIspitaDTO> deoIspitaDTO) {
		this.deoIspitaDTO = deoIspitaDTO;
	}

	public PredmetInstancaDTO getPredmetInstanca() {
		return predmetInstanca;
	}

	public void setPredmetInstanca(PredmetInstancaDTO predmetInstanca) {
		this.predmetInstanca = predmetInstanca;
	}
	
	
	

	
	
	
	
}
