package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.repository.IspitRepository;



@Service
public class IspitService {

	@Autowired
	IspitRepository repository;
	
	public Ispit findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	
	public List<Ispit> findAll() {

		return repository.findAll();
	}
	
	
	public Ispit save(Ispit ispit) {
		return repository.save(ispit);
		
	}
	
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	
	public Page<Ispit> findAll(Pageable page) {
		return repository.findAll(page);
	}
	
}
