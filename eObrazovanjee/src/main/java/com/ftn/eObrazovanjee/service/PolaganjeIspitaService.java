package com.ftn.eObrazovanjee.service;

import java.util.List;

import com.ftn.eObrazovanjee.model.PolaganjeIspita;

public interface PolaganjeIspitaService {
	
	void save(PolaganjeIspita polaganjeIspita);
	List<PolaganjeIspita> findAll();
	PolaganjeIspita findOne(Long id);
	void remove(Long id);
	
}
