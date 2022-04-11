package com.ftn.eObrazovanjee.service;

import java.util.List;

import com.ftn.eObrazovanjee.model.Korisnik;


public interface KorisnikService {

	void save(Korisnik korisnik);
	List<Korisnik> findAll();
	Korisnik findOne(Long id);
	void remove(Long id);
	
}
