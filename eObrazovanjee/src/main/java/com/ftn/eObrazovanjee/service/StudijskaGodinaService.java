package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.model.StudijskaGodina;
import com.ftn.eObrazovanjee.repository.PohadjanjePredmetaRepository;
import com.ftn.eObrazovanjee.repository.StudijskaGodinaRepository;

@Service
public class StudijskaGodinaService {
	
	@Autowired
	StudijskaGodinaRepository studijskaGodinaRepository;
	
	
	public StudijskaGodina findOne(Long id) {
		return studijskaGodinaRepository.findById(id).orElse(null);
	}

	public List<StudijskaGodina> findAll() {
		return studijskaGodinaRepository.findAll();
	}
	
	public StudijskaGodina save(StudijskaGodina studijskaGodina) {
		return studijskaGodinaRepository.save(studijskaGodina);
	}

}
