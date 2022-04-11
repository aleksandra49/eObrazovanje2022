package com.ftn.eObrazovanjee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.repository.PolaganjeIspitaRepository;
import com.ftn.eObrazovanjee.service.PolaganjeIspitaService;

public class PolaganjeIspitaServiceImpl implements PolaganjeIspitaService{

	@Autowired
	PolaganjeIspitaRepository repository;
	
	public PolaganjeIspita findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@Override
	public List<PolaganjeIspita> findAll() {

		return repository.findAll();
	}
	
	@Override
	public void save(PolaganjeIspita ispit) {
		repository.save(ispit);
		
	}
	
	@Override
	public void remove(Long id){
		repository.deleteById(id);
	}
	
}
