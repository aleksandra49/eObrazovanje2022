package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ftn.eObrazovanjee.model.TipDokumenta;
import com.ftn.eObrazovanjee.repository.TipDokumentaRepository;

@Service
public class TipDokumentaService {
	
	@Autowired
	public TipDokumentaRepository tipDokumentaRepository;
	
	public List<TipDokumenta> findAll() {
		return tipDokumentaRepository.findAll();
	}
	
	public TipDokumenta findOne(Long id) {
		return tipDokumentaRepository.findById(id).orElse(null);
	}
	
	public TipDokumenta save(TipDokumenta tipDokumenta) {
		return tipDokumentaRepository.save(tipDokumenta);
	}

	public void delete (Long id) {
		tipDokumentaRepository.deleteById(id);
	}
	
	public Page<TipDokumenta> findAll(Pageable page) {
		return tipDokumentaRepository.findAll(page);
	}
	
	

}
