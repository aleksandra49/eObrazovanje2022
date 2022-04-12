package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void save(Profesor profesor) {
		repository.save(profesor);
		
	}
	
	public void remove(Long id){
		repository.deleteById(id);
	}
}
