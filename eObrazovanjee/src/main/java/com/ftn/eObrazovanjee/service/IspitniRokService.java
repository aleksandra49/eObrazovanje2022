package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.eObrazovanjee.model.IspitniRok;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.repository.IspitniRokRepository;


@Service
@Transactional
public class IspitniRokService {

	@Autowired
	IspitniRokRepository repository;
	
	public IspitniRok findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<IspitniRok> findAll() {

		return repository.findAll();
	}
	
	
	public IspitniRok save(IspitniRok ispitniRok) {
		return repository.save(ispitniRok);
		
	}
	
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	
	public Page<IspitniRok> findAll(Pageable page) {
		return repository.findAll(page);
	}
	
}
