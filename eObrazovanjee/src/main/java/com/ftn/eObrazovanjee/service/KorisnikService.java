package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.model.Uloga;
import com.ftn.eObrazovanjee.repository.KorisnikRepository;
import com.ftn.eObrazovanjee.repository.ProfesorRepository;
import com.ftn.eObrazovanjee.repository.StudentRepository;


@Service
public class KorisnikService {

	@Autowired
	KorisnikRepository repository;
	
	@Autowired
	ProfesorRepository profesorRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	public Korisnik findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	
	public Korisnik findBykorisnickoIme(String korisnickoIme) {
		Korisnik korisnik = repository.findBykorisnickoIme(korisnickoIme).orElse(null);
		if(korisnik.getUloga().equals(Uloga.PROFESOR)) {
			System.out.println("Profesor je");
			Profesor profesor = profesorRepository.findByKorisnik(korisnik);
			
			korisnik.setProfesor(profesor);
		}else if(korisnik.getUloga().equals(Uloga.STUDENT)){
			Student student = studentRepository.findByKorisnik(korisnik);
			korisnik.setStudent(student);
		}
		return korisnik;
	}
	
	public List<Korisnik> findAll() {

		return repository.findAll();
	}
	
	
	public Korisnik save(Korisnik ispit) {
		return repository.save(ispit);
		
	}
	
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	
	public Page<Korisnik> findAll(Pageable page) {
		return repository.findAll(page);
	}
	
	
}
