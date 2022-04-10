package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.repository.DeoIspitaRepository;
import com.ftn.eObrazovanjee.repository.PohadjanjePredmetaRepository;


@Service
public class DeoIspitaService {
	
	@Autowired
	DeoIspitaRepository deoIspitaRepository;
	
	public DeoIspita findOne(Long id) {
		return deoIspitaRepository.findById(id).orElse(null);
	}

	public List<DeoIspita> findAll() {
		return deoIspitaRepository.findAll();
	}
	
	public DeoIspita save(DeoIspita deoIspita) {
		return deoIspitaRepository.save(deoIspita);
	}

	public void remove(Long id) {
		deoIspitaRepository.deleteById(id);
	}

}
