package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.PredmetInstanca;
import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl  {
	
	@Autowired
	ProfesorRepository repository;
	
	public Profesor findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Profesor> findAll() {

		return repository.findAll();
	}
	
	public Profesor save(Profesor profesor) {
		return repository.save(profesor);
		
	}
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	
	public Page<Profesor> findAll(Pageable page) {
		return repository.findAll(page);
	}
}
