package com.ftn.eObrazovanjee.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.eObrazovanjee.dto.IspitniRokDTO;
import com.ftn.eObrazovanjee.dto.KorisnikDTO;
import com.ftn.eObrazovanjee.dto.ProfesorDTO;
import com.ftn.eObrazovanjee.dto.StudentDTO;
import com.ftn.eObrazovanjee.mapper.DeoIspitaMapper;
import com.ftn.eObrazovanjee.mapper.IspitniRokMapper;
import com.ftn.eObrazovanjee.mapper.KorisnikMapper;
import com.ftn.eObrazovanjee.mapper.PolaganjeIspitaMapper;
import com.ftn.eObrazovanjee.mapper.ProfesorMapper;
import com.ftn.eObrazovanjee.mapper.StudentMapper;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.service.KorisnikService;
import com.ftn.eObrazovanjee.service.ProfesorServiceImpl;
import com.ftn.eObrazovanjee.service.StudentService;




@RestController
@RequestMapping(value="api/korisnik")
public class KorisnikController {
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private ProfesorServiceImpl profesorService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<KorisnikDTO>> getAllKorisnici() {
		List<Korisnik> korisnici = korisnikService.findAll();
		
		List<KorisnikDTO> korisniciDTO = new ArrayList<>();
		for (Korisnik obj : korisnici) {
			KorisnikDTO korisnik = new KorisnikMapper().modelToDto(obj);
			korisnik.setProfesor(getProfesorIzKorisnika(korisnik.getId()));
			korisnik.setStudent(getStudentIzKorisnika(korisnik.getId()));
			korisniciDTO.add(korisnik);
		}
		return new ResponseEntity<>(korisniciDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<KorisnikDTO>> getKorisnikPage(Pageable page) {
		Page<Korisnik> korisnici = korisnikService.findAll(page);
		
		
		List<KorisnikDTO> korisniciDTO = new ArrayList<>();
		for (Korisnik obj : korisnici) {
			KorisnikDTO korisnik = new KorisnikMapper().modelToDto(obj);
			korisnik.setProfesor(getProfesorIzKorisnika(korisnik.getId()));
			korisnik.setStudent(getStudentIzKorisnika(korisnik.getId()));
			korisniciDTO.add(korisnik);
		}
		return new ResponseEntity<>(korisniciDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<KorisnikDTO> getKorisnik(@PathVariable Long id){
		Korisnik korisnik = korisnikService.findOne(id);
		if(korisnik == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		KorisnikDTO korisnikDTO = new KorisnikMapper().modelToDto(korisnik);
		korisnikDTO.setProfesor(getProfesorIzKorisnika(korisnik.getId()));
		korisnikDTO.setStudent(getStudentIzKorisnika(korisnik.getId()));
		
		return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
	}
	
//	>>>>>>>>>>>>>>>>>>>>>>>>>
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<KorisnikDTO> saveKorisnik(@RequestBody KorisnikDTO korisnikDTO){		
		Korisnik korisnik = new Korisnik();

		korisnik.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
		korisnik.setLozinka(korisnikDTO.getLozinka());
		korisnik.setUloga(korisnikDTO.getUloga());
		korisnik.setStudent(studentService.findOne(korisnikDTO.getStudent().getId()));
		korisnik.setProfesor(profesorService.findOne(korisnikDTO.getProfesor().getId()));
		
		korisnik = korisnikService.save(korisnik);
		return new ResponseEntity<>(new KorisnikMapper().modelToDto(korisnik), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<KorisnikDTO> updateKorisnik(@RequestBody KorisnikDTO korisnikDTO){
		
		Korisnik korisnik = korisnikService.findOne(korisnikDTO.getId()); 
		if (korisnik == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		korisnik.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
		korisnik.setLozinka(korisnikDTO.getLozinka());
		korisnik.setUloga(korisnikDTO.getUloga());
		korisnik.setStudent(studentService.findOne(korisnikDTO.getStudent().getId()));
		korisnik.setProfesor(profesorService.findOne(korisnikDTO.getProfesor().getId()));
		
		korisnik = korisnikService.save(korisnik);
		return new ResponseEntity<>(new KorisnikMapper().modelToDto(korisnik), HttpStatus.OK);	
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteKorisnik(@PathVariable Long id){
		Korisnik korisnik = korisnikService.findOne(id);
		if (korisnik != null){
			korisnikService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@RequestMapping(value="/getStudentIzKorisnika/{id}", method=RequestMethod.GET)
	public StudentDTO getStudentIzKorisnika(Long id){
		Korisnik korisnik = korisnikService.findOne(id);
		if(korisnik == null){
			return null;
		}
		return new StudentMapper().modelToDto(korisnik.getStudent());
	}

//	@RequestMapping(value="/getProfesorIzKorisnika/{id}", method=RequestMethod.GET)
	public ProfesorDTO getProfesorIzKorisnika(Long id){
		Korisnik korisnik = korisnikService.findOne(id);
		if(korisnik == null){
			return null;
		}
		return new ProfesorMapper().modelToDto(korisnik.getProfesor());
	}
	
}
