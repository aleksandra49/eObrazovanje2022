package com.ftn.eObrazovanjee.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.eObrazovanjee.dto.KorisnikDTO;
import com.ftn.eObrazovanjee.dto.PolozenPredmetDTO;
import com.ftn.eObrazovanjee.dto.PredavanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.ProfesorDTO;
import com.ftn.eObrazovanjee.dto.ProfesorPredmetDTO;
import com.ftn.eObrazovanjee.dto.UlogovaniProfesorDTO;
import com.ftn.eObrazovanjee.mapper.KorisnikMapper;
import com.ftn.eObrazovanjee.mapper.PredavanjePredmetaMapper;
import com.ftn.eObrazovanjee.mapper.ProfesorMapper;
import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.PredavanjePredmeta;
import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.model.Uloga;
import com.ftn.eObrazovanjee.repository.KorisnikRepository;
import com.ftn.eObrazovanjee.repository.ProfesorRepository;
import com.ftn.eObrazovanjee.security.SecurityConfiguration;
import com.ftn.eObrazovanjee.service.KorisnikService;
import com.ftn.eObrazovanjee.service.PredavanjePredmetaServiceImpl;
import com.ftn.eObrazovanjee.service.ProfesorServiceImpl;



@RestController
@RequestMapping(value="api/profesori")
public class ProfesorController {
	
	@Autowired ProfesorServiceImpl profesorService;
	
	@Autowired
	SecurityConfiguration configuration;
	
	@Autowired
	private KorisnikService korisnikService;
	
	
	@Autowired
	private ProfesorRepository repository;
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private KorisnikMapper korisnikMapper;
	
	@Autowired
	private PredavanjePredmetaServiceImpl predavanjePredmetaService;
	//page
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProfesorDTO>> getProfesoriPage(Pageable page) {
		List<Profesor> profesori = profesorService.findAll();
		
		
		List<ProfesorDTO> profesoriDTO = new ArrayList<>();
		for (Profesor obj : profesori) {
			ProfesorDTO profesor = new ProfesorMapper().modelToDto(obj);
			profesor.setKorisnik(korisnikMapper.modelFromProfesorToDto(obj.getKorisnik()));
			profesor.setPredavanja(getPredavanjePredmetaIzProfesora(profesor.getId()));
			profesoriDTO.add(profesor);
		}
		return new ResponseEntity<>(profesoriDTO, HttpStatus.OK);
	}
	
	@PostMapping("/check_username")
	public ResponseEntity<Boolean> createAuthenticationToken(@RequestBody String username) {
		
		List<Korisnik> korisnici = korisnikService.findAll();
		Boolean slobodan = true;
		for(Korisnik kor : korisnici) {
			System.err.println(kor.getUsername());
			System.err.println(username);
			if(kor.getUsername().equals(username)) {
			
//			if(kor.getUsername() == username) {
				System.err.println("falsed");
				slobodan = false;
			}
		}
		
		if(slobodan == false) {
			System.err.println("nije slobodan");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			System.err.println("slobodan");
			return new ResponseEntity<>(slobodan, HttpStatus.OK);
		}
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ProfesorDTO> saveProfesor(@RequestBody ProfesorDTO profesorDTO){		
		Profesor profesor = new Profesor();
		Korisnik korisnik = new Korisnik();
		Korisnik korisnikProba = new Korisnik();
		
//		Korisnik korisnik1 = new Korisnik();
//		korisnik1.setId(1L);
		Korisnik korisnik1 = new Korisnik();
		korisnik1.setKorisnickoIme(profesorDTO.getKorisnik().getKorisnickoIme());
		korisnik1.setLozinka(configuration.passwordEncoder().encode(profesorDTO.getKorisnik().getLozinka()));
		korisnik1.setUloga(Uloga.PROFESOR);
		System.out.println(korisnik);
		
		profesor.setIme(profesorDTO.getIme());
		profesor.setPrezime(profesorDTO.getPrezime());
		profesor.setEmail(profesorDTO.getEmail());
		profesor.setKorisnik(korisnik1);
		
		// profesor.setKorisnik(korisnik1);
		
		//	profesor.setPredavanja(new HashSet<>(new PredavanjePredmetaMapper().listDtoToModel(profesorDTO.getPredavanja())));
		List<Korisnik> korisnici = korisnikService.findAll();
		Boolean slobodan = true;
		for(Korisnik kor : korisnici) {
			System.err.println(kor.getUsername());
			System.err.println(profesorDTO.getKorisnik().getKorisnickoIme());
			if(kor.getUsername().equals(profesorDTO.getKorisnik().getKorisnickoIme())) {
			
//			if(kor.getUsername() == username) {
				System.err.println("falsed");
				slobodan = false;
			}
		}
		
		if(slobodan == false) {
			System.err.println("nije slobodan");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			System.err.println("slobodan");
		
		}
		korisnik = korisnikService.save(korisnik1);
		
//		korisnikProba = korisnikService.findOne(korisnik1.getId());
		System.out.println(korisnik);
		
		profesor = profesorService.save(profesor);
		return new ResponseEntity<>(new ProfesorMapper().modelToDto(profesor), HttpStatus.CREATED);	
	}
	
//	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
//	public ResponseEntity<ProfesorDTO> updateProfesor(@RequestBody ProfesorDTO profesorDTO){
//		System.out.println("udje u metodu");
//		
//		Korisnik korisnik = new Korisnik();
//		Profesor profesor = repository.getById(profesorDTO.getId()); 
//		if (profesor == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		System.out.println("nadje profesora");
//		profesor.setIme(profesorDTO.getIme());
//		profesor.setPrezime(profesorDTO.getPrezime());
//		profesor.setEmail(profesorDTO.getEmail());
//
//		Korisnik korisnik1 = new Korisnik();
//		korisnik1.setKorisnickoIme(profesorDTO.getKorisnik().getKorisnickoIme());
//		korisnik1.setLozinka(configuration.passwordEncoder().encode(profesorDTO.getKorisnik().getLozinka()));
//		korisnik1.setUloga(Uloga.PROFESOR);
//		
//		profesor.setKorisnik(korisnik1);
//		profesor.setPredavanja(new HashSet<>(new PredavanjePredmetaMapper().listDtoToModel(profesorDTO.getPredavanja())));
//		System.out.println("nadjeni korisnik je ======" + profesor);
//		
//		Long korisnikId = profesorDTO.getKorisnik().getId();
//		Long profesorId = profesorDTO.getId();
//		
//		profesorService.remove(profesorId);
//		korisnikService.remove(korisnikId);
//
//		
//		korisnik = korisnikService.save(korisnik1);
//		profesor = profesorService.save(profesor);
//		return new ResponseEntity<>(new ProfesorMapper().modelToDto(profesor), HttpStatus.OK);	
//	}
	
//	Korisnik korisnik = korisnikService.findOne(korisnikDTO.getId()); 
//	if (korisnik == null) {
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	}
//	
//	korisnik.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
//	korisnik.setLozinka(korisnikDTO.getLozinka());
//	korisnik.setUloga(korisnikDTO.getUloga());
//	korisnik.setStudent(studentService.findOne(korisnikDTO.getStudent().getId()));
//	korisnik.setProfesor(profesorService.findOne(korisnikDTO.getProfesor().getId()));
//	
//	korisnik = korisnikService.save(korisnik);
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<ProfesorDTO> updateProfesor(@RequestBody ProfesorDTO profesorDTO){
	
		repository.izmenaProfesora(profesorDTO.getEmail(),profesorDTO.getIme(), profesorDTO.getPrezime(),profesorDTO.getId());
	//	korisnikRepository.izmenaKorisnika(profesorDTO.getKorisnik().getKorisnickoIme(), profesorDTO.getKorisnik().getLozinka(), profesorDTO.getKorisnik().getId());
		Korisnik korisnik = korisnikService.findOne(profesorDTO.getKorisnik().getId());
		if (korisnik == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		korisnik.setKorisnickoIme(profesorDTO.getKorisnik().getKorisnickoIme());
		korisnik.setLozinka(profesorDTO.getKorisnik().getLozinka());
		korisnik.setUloga(Uloga.PROFESOR);
//		korisnik.setStudent(studentService.findOne(korisnikDTO.getStudent().getId()));
		korisnik.setProfesor(profesorService.findOne(profesorDTO.getId()));
		
		korisnik = korisnikService.save(korisnik);
		
		return new ResponseEntity<>(profesorDTO, HttpStatus.OK);
	}
	
	//all
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<ProfesorDTO>> getAllProfesori() {
		List<Profesor> profesori = profesorService.findAll();
		List<ProfesorDTO> profesoriDTO = new ArrayList<>();
		
		for (Profesor p : profesori) {
			ProfesorDTO profesor = new ProfesorMapper().modelToDto(p);
			profesor.setKorisnik(getKorisnikaIzProfesora(profesor.getId()));
			profesor.setPredavanja(getPredavanjePredmetaIzProfesora(profesor.getId()));
			profesoriDTO.add(profesor);
		}
		return new ResponseEntity<>(profesoriDTO, HttpStatus.OK);
		
	}
	// dodati funkciju sa paglabe za all
	//id one
	@RequestMapping(value = "/{id}" , method=RequestMethod.GET)//vidid taj id
	public ResponseEntity<ProfesorDTO> getProfesor(@PathVariable("id") Long id) {
		Profesor profesor = profesorService.findOne(id);
		if(profesor == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ProfesorDTO profesorDTO = new ProfesorMapper().modelToDto(profesor);
		profesorDTO.setKorisnik(getKorisnikaIzProfesora(profesor.getId()));
		profesorDTO.setPredavanja(getPredavanjePredmetaIzProfesora(profesor.getId()));
		
		return new ResponseEntity<>(profesorDTO, HttpStatus.OK);
	}
	
	

	//delete
	 @DeleteMapping(value = {"/{id}"})
	 public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		 Profesor profesor = profesorService.findOne(id);
			if (profesor != null){
				predavanjePredmetaService.deleteProfesor(profesor);
				profesorService.remove(id);
				deleteKorisnik(profesor.getKorisnik().getId());
				
				
				return new ResponseEntity<>(HttpStatus.OK);
			} else {		
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	 }
	 

		public Void deleteKorisnik(Long id){
			Korisnik korisnik = korisnikService.findOne(id);
			if (korisnik != null){
				korisnikService.remove(id);
				return null;
			} else {		
				return null;
			}
		}
		
		@GetMapping("/predavanje")
		public ResponseEntity<?> Predavanje(@RequestParam("idProfesora") int idProfesora){
			try {
				List<ProfesorPredmetDTO> response = profesorService.predavanjePredmeta(idProfesora);
				return new ResponseEntity<List<ProfesorPredmetDTO>>(response, HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
	 
	 //veza izmedju korisnika i profesora
	// @RequestMapping(value="/korisnikIzProfesora/{id}", method=RequestMethod.GET)
		public KorisnikDTO getKorisnikaIzProfesora(@PathVariable Long id){
		 Profesor profesor = profesorService.findOne(id);
			if(profesor == null){
				return null;
			}
			return new KorisnikMapper().modelFromProfesorToDto(profesor.getKorisnik());
		}
	

	 //veza izmedju predavanja predmeta i profe
	 //@RequestMapping(value="/predavanjePredmetaIzProfesora/{id}", method=Req)uestMethod.GET)
		public ArrayList<PredavanjePredmetaDTO> getPredavanjePredmetaIzProfesora(@PathVariable Long id){
		 Profesor profesor = profesorService.findOne(id);
			if(profesor == null){
				return null;
			}
			ArrayList<PredavanjePredmetaDTO> listaPredavanja = new ArrayList<>();
			for(PredavanjePredmeta predavanja : profesor.getPredavanja()) {
				listaPredavanja.add(new PredavanjePredmetaMapper().modelToDto(predavanja));
			}		
			return listaPredavanja;
		}
}
