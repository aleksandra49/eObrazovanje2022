package com.ftn.eObrazovanjee.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.dto.PolozenPredmetDTO;
import com.ftn.eObrazovanjee.dto.ProfesorPredmetDTO;
import com.ftn.eObrazovanjee.dto.UlogovaniProfesorDTO;
import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.PredmetInstanca;
import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.repository.KorisnikRepository;
import com.ftn.eObrazovanjee.repository.ProfesorRepository;



@Service
public class ProfesorServiceImpl  {
	
	@Autowired
	ProfesorRepository repository;
	@Autowired
	KorisnikRepository korisnikRepository;
	

	public Profesor findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Profesor> findAll() {

		List<Profesor> profesori = repository.findAll();
		return profesori;
	}
	
	public Profesor save(Profesor profesor) {
		return repository.save(profesor);
		
	}
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	
	public Page<Profesor> findAll(Pageable page) {
		return repository.findAll(page);
	}
	
	public List<ProfesorPredmetDTO> predavanjePredmeta(int idProfesora) throws Exception {
		// TODO Auto-generated method stub
		Optional<Profesor> profesorOptional = repository.findById((long) idProfesora);
		if(!profesorOptional.isPresent()) {
			throw new Exception("Profesor sa prosledjenim id-om ne postoji");
		}
		List<Object[]> nativeResponse = repository.pronadjiPredmeteNative(idProfesora);
		List<ProfesorPredmetDTO> response = new ArrayList<ProfesorPredmetDTO>();
		for(Object[] obj:nativeResponse) {
			ProfesorPredmetDTO tmpObj = new ProfesorPredmetDTO(obj[0].toString(), obj[1].toString(),
					Integer.parseInt(obj[2].toString()));
			
			response.add(tmpObj);
		}
		System.out.println(response);
		return response;
		
	}
}
