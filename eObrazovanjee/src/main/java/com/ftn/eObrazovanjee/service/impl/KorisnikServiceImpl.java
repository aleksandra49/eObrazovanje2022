package com.ftn.eObrazovanjee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.repository.KorisnikRepository;
import com.ftn.eObrazovanjee.service.KorisnikService;

public class KorisnikServiceImpl implements KorisnikService{

	@Autowired
	KorisnikRepository repository;
	
	public Korisnik findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@Override
	public List<Korisnik> findAll() {

		return repository.findAll();
	}
	
	@Override
	public void save(Korisnik ispit) {
		repository.save(ispit);
		
	}
	
	@Override
	public void remove(Long id){
		repository.deleteById(id);
	}
	
}
