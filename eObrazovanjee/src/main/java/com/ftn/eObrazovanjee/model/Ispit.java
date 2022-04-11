package com.ftn.eObrazovanjee.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ispit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String naziv;
	
	private LocalDateTime datumVreme;
	
	private int brojOsvojenihBodova;
	
	private PolaganjeIspita polaganjeIspita;
	
	private IspitniRok ispitniRok;
	
	private DeoIspita deoIspita;
	
	private PredmetInstanca predmetInstanca;

}
