package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;
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
	
	
	public Korisnik save(Korisnik ispit) {
		return repository.save(ispit);
		
	}
	
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	
	public Page<Korisnik> findAll(Pageable page) {
		return repository.findAll(page);
	}
	
}
