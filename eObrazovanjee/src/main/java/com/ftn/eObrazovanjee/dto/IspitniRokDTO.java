package com.ftn.eObrazovanjee.dto;

import java.util.ArrayList;
import java.util.Date;

import com.ftn.eObrazovanjee.model.IspitniRok;


public class IspitniRokDTO {


	private Long id;
	private String nazivRoka;
	private Date pocetakRoka;
	private Date krajRoka;
	private ArrayList<IspitDTO> ispiti;
	
	public IspitniRokDTO(Long id, String nazivRoka, Date pocetakRoka, Date krajRoka, ArrayList<IspitDTO> ispiti) {
		super();
		this.id = id;
		this.nazivRoka = nazivRoka;
		this.pocetakRoka = pocetakRoka;
		this.krajRoka = krajRoka;
		this.ispiti = ispiti;
	}

	public IspitniRokDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivRoka() {
		return nazivRoka;
	}

	public void setNazivRoka(String nazivRoka) {
		this.nazivRoka = nazivRoka;
	}

	public Date getPocetakRoka() {
		return pocetakRoka;
	}

	public void setPocetakRoka(Date pocetakRoka) {
		this.pocetakRoka = pocetakRoka;
	}

	public Date getKrajRoka() {
		return krajRoka;
	}

	public void setKrajRoka(Date krajRoka) {
		this.krajRoka = krajRoka;
	}

	public ArrayList<IspitDTO> getIspiti() {
		return ispiti;
	}

	public void setIspiti(ArrayList<IspitDTO> ispiti) {
		this.ispiti = ispiti;
	}
	
	
	
	
}
