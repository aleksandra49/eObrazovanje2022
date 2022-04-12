package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.FinansijskaKartica;
import com.ftn.eObrazovanjee.repository.FinansijskaKarticaRepository;

@Service
public class FinansijskaKarticaService {

	@Autowired
	public FinansijskaKarticaRepository finansijskaKarticaRepository;

	public List<FinansijskaKartica> findAll() {
		return finansijskaKarticaRepository.findAll();
	}
	
	public FinansijskaKartica findOne(Long id) {
		return finansijskaKarticaRepository.findById(id).orElse(null);
	}
	
	public FinansijskaKartica save(FinansijskaKartica finansijskaKartica) {
		return finansijskaKarticaRepository.save(finansijskaKartica);
	}

	public void delete (Long id) {
		finansijskaKarticaRepository.deleteById(id);
	}
}
