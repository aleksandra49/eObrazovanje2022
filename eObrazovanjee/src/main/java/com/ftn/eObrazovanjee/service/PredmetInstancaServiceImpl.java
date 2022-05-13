package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.model.PredmetInstanca;
import com.ftn.eObrazovanjee.repository.PredmetInstancaRepository;

@Service
public class PredmetInstancaServiceImpl {

	@Autowired
	PredmetInstancaRepository repository;
	
	public PredmetInstanca findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<PredmetInstanca> findAll() {

		return repository.findAll();
	}
	
	public PredmetInstanca save(PredmetInstanca predmetInstanca) {
		return repository.save(predmetInstanca);
		
	}
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	public Page<PredmetInstanca> findAll(Pageable page) {
		return repository.findAll(page);
	}
	
}
