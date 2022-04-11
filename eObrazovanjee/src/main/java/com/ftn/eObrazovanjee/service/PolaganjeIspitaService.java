package com.ftn.eObrazovanjee.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.repository.PolaganjeIspitaRepository;


@Service
public class PolaganjeIspitaService {

	@Autowired
	PolaganjeIspitaRepository repository;
	
	public PolaganjeIspita findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	
	public List<PolaganjeIspita> findAll() {

		return repository.findAll();
	}
	
	
	public void save(PolaganjeIspita ispit) {
		repository.save(ispit);
		
	}
	
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	
}
