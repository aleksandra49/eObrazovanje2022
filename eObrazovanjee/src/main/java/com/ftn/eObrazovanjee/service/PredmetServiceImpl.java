package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.Predmet;
import com.ftn.eObrazovanjee.repository.PredmetRepository;

@Service
public class PredmetServiceImpl {

	@Autowired
	PredmetRepository repository;
	
	public Predmet findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Predmet> findAll() {

		return repository.findAll();
	}
	
	public void save(Predmet predmet) {
		repository.save(predmet);
		
	}
	
	public void remove(Long id){
		repository.deleteById(id);
	}
}
