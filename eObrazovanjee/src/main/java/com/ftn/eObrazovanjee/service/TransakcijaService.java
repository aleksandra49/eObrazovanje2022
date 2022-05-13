package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.Transakcija;
import com.ftn.eObrazovanjee.repository.TransakcijaRepository;

@Service
public class TransakcijaService {
	
	@Autowired
	public TransakcijaRepository transakcijaRepository;

	public List<Transakcija> findAll() {
		return transakcijaRepository.findAll();
	}
	
	public Transakcija findOne(Long id) {
		return transakcijaRepository.findById(id).orElse(null);
	}
	
	public Transakcija save(Transakcija transakcija) {
		return transakcijaRepository.save(transakcija);
	}
	
	public Page<Transakcija> findAll(Pageable page) {
		return transakcijaRepository.findAll(page);
	}

	public void delete (Long id) {
		transakcijaRepository.deleteById(id);
	}
}
