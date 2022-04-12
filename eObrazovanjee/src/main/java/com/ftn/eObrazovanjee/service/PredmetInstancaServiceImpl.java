package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
	
}
