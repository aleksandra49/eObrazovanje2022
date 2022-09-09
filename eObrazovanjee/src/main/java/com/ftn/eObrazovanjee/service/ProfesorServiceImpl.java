package com.ftn.eObrazovanjee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.dto.PolozenPredmetDTO;
import com.ftn.eObrazovanjee.dto.UlogovaniProfesorDTO;
import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.PredmetInstanca;
import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.repository.KorisnikRepository;
import com.ftn.eObrazovanjee.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl  {
	
	@Autowired
	ProfesorRepository repository;
	@Autowired
	KorisnikRepository korisnikRepository;
	

	public Profesor findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Profesor> findAll() {

		List<Profesor> profesori = repository.findAll();
		return profesori;
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
