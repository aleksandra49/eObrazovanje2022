package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.model.PredavanjePredmeta;
import com.ftn.eObrazovanjee.repository.PredavanjePredmetaRepository;



@Service
public class PredavanjePredmetaServiceImpl  {

	@Autowired
	PredavanjePredmetaRepository repository;
	
	public PredavanjePredmeta findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<PredavanjePredmeta> findAll() {

		return repository.findAll();
	}
	
	public PredavanjePredmeta save(PredavanjePredmeta predavanje) {
		return repository.save(predavanje);
		
	}
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	
	public Page<PredavanjePredmeta> findAll(Pageable page) {
		return repository.findAll(page);
	}
	
}
