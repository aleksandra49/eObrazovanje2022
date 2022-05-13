package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.Predmet;
import com.ftn.eObrazovanjee.repository.PredmetRepository;

@Service
public class PredmetServiceImpl {

	@Autowired
	PredmetRepository repository;
	
	public Predmet findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Predmet> findAll() {

		return repository.findAll();
	}
	
	public Page<Predmet> findAll(Pageable pagable) {
		return repository.findAll(pagable);
	}
	
	public Predmet save(Predmet predmet) {
		return repository.save(predmet);
		
	}
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	
	//@Override
    public void delete(Predmet predmet) {
		//predmet.setDeleted(true);
        repository.save(predmet);
    }
}
