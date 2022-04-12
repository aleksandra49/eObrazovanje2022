package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.Dokument;
import com.ftn.eObrazovanjee.repository.DokumentRepository;

@Service
public class DokumentService {
	
	@Autowired
	DokumentRepository dokumentRepository;
	
	public List<Dokument> findAll() {
		return dokumentRepository.findAll();
	}
	
	public Dokument findOne(Long id) {
		return dokumentRepository.findById(id).orElse(null);
	}
	
	public Dokument save(Dokument dokument) {
		return dokumentRepository.save(dokument);
	}

	public void delete (Long id) {
		dokumentRepository.deleteById(id);
	}

}
