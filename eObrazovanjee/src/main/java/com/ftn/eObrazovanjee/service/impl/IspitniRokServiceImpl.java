package com.ftn.eObrazovanjee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.eObrazovanjee.model.IspitniRok;
import com.ftn.eObrazovanjee.repository.IspitniRokRepository;
import com.ftn.eObrazovanjee.service.IspitniRokService;

@Service
@Transactional
public class IspitniRokServiceImpl implements IspitniRokService{

	@Autowired
	IspitniRokRepository repository;
	
	public IspitniRok findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@Override
	public List<IspitniRok> findAll() {

		return repository.findAll();
	}
	
	@Override
	public void save(IspitniRok ispitniRok) {
		repository.save(ispitniRok);
		
	}
	
	@Override
	public void remove(Long id){
		repository.deleteById(id);
	}
}
