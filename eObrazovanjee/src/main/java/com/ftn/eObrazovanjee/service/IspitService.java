package com.ftn.eObrazovanjee.service;

import java.util.List;

import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.IspitniRok;

public interface IspitService {
	
	void save(Ispit ispit);
	List<Ispit> findAll();
	Ispit findOne(Long id);
	void remove(Long id);
	
}
