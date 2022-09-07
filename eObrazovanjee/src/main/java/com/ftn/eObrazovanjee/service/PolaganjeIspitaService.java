package com.ftn.eObrazovanjee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.repository.PolaganjeIspitaRepository;
import com.ftn.eObrazovanjee.repository.StudentRepository;


@Service
public class PolaganjeIspitaService {

	@Autowired
	PolaganjeIspitaRepository repository;
	
	@Autowired
	StudentRepository studentRepository;
	
	
//	Drugi nacin
//	@Override
//	public List<PolozenIspitResponseDTO> polozeniIspitiZaStudenta(int idStudenta) throws Exception {
//		// TODO Auto-generated method stub
//		Optional<Student> studentOptional = studentRepository.findById(idStudenta);
//		if(!studentOptional.isPresent()) {
//			throw new Exception("Student sa prosledjenim id-om ne postoji");
//		}
//		List<Object[]> nativeResponse = ispitRepository.pronadjiPolozenePredmeteNative(idStudenta);
//		List<PolozenIspitResponseDTO> response = new ArrayList<PolozenIspitResponseDTO>();
//		for(Object[] obj:nativeResponse) {
//			PolozenIspitResponseDTO tmpObj = new PolozenIspitResponseDTO(obj[0].toString(),Integer.parseInt(obj[1].toString()), obj[2].toString());
//			response.add(tmpObj);
//		}
//		return response;
//	}
	
	public PolaganjeIspita findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	
	public List<PolaganjeIspita> findAll() {

		return repository.findAll();
	}
	
	
	public PolaganjeIspita save(PolaganjeIspita ispit) {
		return repository.save(ispit);
		
	}
	
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	
	public Page<PolaganjeIspita> findAll(Pageable page) {
		return repository.findAll(page);
	}
	
}
