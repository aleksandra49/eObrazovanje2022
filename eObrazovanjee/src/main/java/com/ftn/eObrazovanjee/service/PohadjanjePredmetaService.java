package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.PohadjanjePredmeta;
import com.ftn.eObrazovanjee.repository.PohadjanjePredmetaRepository;

@Service
public class PohadjanjePredmetaService {
	
	@Autowired
	PohadjanjePredmetaRepository pohadjanjePredmetaRepository;


	public PohadjanjePredmeta findOne(Long id) {
		return pohadjanjePredmetaRepository.findById(id).orElse(null);
	}

	public List<PohadjanjePredmeta> findAll() {
		return pohadjanjePredmetaRepository.findAll();
	}
	
	public void save(PohadjanjePredmeta pohadjanjePredmeta) {
		pohadjanjePredmetaRepository.save(pohadjanjePredmeta);	
	}
	
	public void remove(Long id){
		pohadjanjePredmetaRepository.deleteById(id);
	}

}
