package com.ftn.eObrazovanjee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.repository.IspitRepository;
import com.ftn.eObrazovanjee.service.IspitService;

public class IspitServiceImpl implements IspitService{

	@Autowired
	IspitRepository repository;
	
	public Ispit findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@Override
	public List<Ispit> findAll() {

		return repository.findAll();
	}
	
	@Override
	public void save(Ispit ispit) {
		repository.save(ispit);
		
	}
	
	@Override
	public void remove(Long id){
		repository.deleteById(id);
	}
	
}
