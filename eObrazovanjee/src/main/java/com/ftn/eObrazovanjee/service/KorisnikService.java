package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.repository.KorisnikRepository;


@Service
public class KorisnikService {

	@Autowired
	KorisnikRepository repository;
	
	public Korisnik findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	
	public List<Korisnik> findAll() {

		return repository.findAll();
	}
	
	
	public void save(Korisnik ispit) {
		repository.save(ispit);
		
	}
	
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	
}
