package com.ftn.eObrazovanjee.service;

import java.util.List;

import com.ftn.eObrazovanjee.model.IspitniRok;


public interface IspitniRokService {

	void save(IspitniRok ispitniRok);
	List<IspitniRok> findAll();
	IspitniRok findOne(Long id);
	void remove(Long id);
}
