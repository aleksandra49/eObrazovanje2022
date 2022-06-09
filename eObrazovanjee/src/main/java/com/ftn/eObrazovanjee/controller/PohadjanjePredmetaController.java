package com.ftn.eObrazovanjee.controller;

import java.util.ArrayList;
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

import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.PredmetInstancaDTO;
import com.ftn.eObrazovanjee.dto.StudentDTO;
import com.ftn.eObrazovanjee.mapper.IspitMapper;
import com.ftn.eObrazovanjee.mapper.PohadjanjePredmetaMapper;
import com.ftn.eObrazovanjee.mapper.PredmetInstancaMapper;
import com.ftn.eObrazovanjee.mapper.StudentMapper;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.PohadjanjePredmeta;
import com.ftn.eObrazovanjee.service.PohadjanjePredmetaService;
import com.ftn.eObrazovanjee.service.PredmetInstancaServiceImpl;
import com.ftn.eObrazovanjee.service.StudentService;



@RestController
@RequestMapping(value="api/pohadjanje")
public class PohadjanjePredmetaController {
	
	@Autowired
    private PohadjanjePredmetaService pohadjanjePredmetaService;
	@Autowired
    private StudentService studentService ;
	@Autowired
	private PredmetInstancaServiceImpl predmetInstancaServiceImpl;
	
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<PohadjanjePredmetaDTO>> getAllPohadjanja() {
		List<PohadjanjePredmeta> pohadjanjaPredmeta = pohadjanjePredmetaService.findAll();
		
		List<PohadjanjePredmetaDTO> pohadjanjaPredmetaDTO = new ArrayList<>();
		for (PohadjanjePredmeta obj : pohadjanjaPredmeta) {
			PohadjanjePredmetaDTO pohadjanje = new PohadjanjePredmetaMapper().modelToDto(obj);
			pohadjanje.setStudnetDTO(getStudentIzPohadjanje(pohadjanje.getId()));
			pohadjanje.setPredmetInstanca(getPredmetInstancaIzPohadjanje(pohadjanje.getId()));
			pohadjanjaPredmetaDTO.add(pohadjanje);
		}
		return new ResponseEntity<>(pohadjanjaPredmetaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PohadjanjePredmetaDTO>> getPohadjanjaPage(Pageable page) {
		Page<PohadjanjePredmeta> pohadjanjaPredmeta = pohadjanjePredmetaService.findAll(page);
		
		
		List<PohadjanjePredmetaDTO> pohadjanjaPredmetaDTO = new ArrayList<>();
		for (PohadjanjePredmeta obj : pohadjanjaPredmeta) {
			PohadjanjePredmetaDTO pohadjanja = new PohadjanjePredmetaMapper().modelToDto(obj);
			pohadjanja.setStudnetDTO(getStudentIzPohadjanje(pohadjanja.getId()));
			pohadjanja.setPredmetInstanca(getPredmetInstancaIzPohadjanje(pohadjanja.getId()));
			pohadjanjaPredmetaDTO.add(pohadjanja);
			
		}
		return new ResponseEntity<>(pohadjanjaPredmetaDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PohadjanjePredmetaDTO> getPohadjanjePredmeta(@PathVariable Long id){
		PohadjanjePredmeta pohadjanjePredmeta = pohadjanjePredmetaService.findOne(id);
		if(pohadjanjePredmeta == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		PohadjanjePredmetaDTO pohadjanjeDTO = new PohadjanjePredmetaMapper().modelToDto(pohadjanjePredmeta);
		pohadjanjeDTO.setStudnetDTO(getStudentIzPohadjanje(pohadjanjePredmeta.getId()));
		pohadjanjeDTO.setPredmetInstanca(getPredmetInstancaIzPohadjanje(pohadjanjePredmeta.getId()));
		
		return new ResponseEntity<>(pohadjanjeDTO, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PohadjanjePredmetaDTO> savePohadjanja(@RequestBody PohadjanjePredmetaDTO pohadjanjePredmetaDTO){		
		PohadjanjePredmeta pohadjanjePredmeta = new PohadjanjePredmeta();
		
		pohadjanjePredmeta.setPocetak(pohadjanjePredmetaDTO.getPocetak());
		pohadjanjePredmeta.setKraj(pohadjanjePredmetaDTO.getKraj());
		pohadjanjePredmeta.setPolozen(pohadjanjePredmetaDTO.isPolozen());

		pohadjanjePredmeta.setStudent(studentService.findOne(pohadjanjePredmetaDTO.getStudnetDTO().getId()));
		pohadjanjePredmeta.setPredmetInstanca(predmetInstancaServiceImpl.findOne(pohadjanjePredmetaDTO.getPredmetInstanca().getId()));
		
		pohadjanjePredmeta = pohadjanjePredmetaService.save(pohadjanjePredmeta);
		return new ResponseEntity<>(new PohadjanjePredmetaMapper().modelToDto(pohadjanjePredmeta), HttpStatus.CREATED);	
	}
	
	
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PohadjanjePredmetaDTO> updatePohadjanjePredmeta(@RequestBody PohadjanjePredmetaDTO pohadjanjePredmetaDTO){
		
		PohadjanjePredmeta pohadjanjePredmeta = pohadjanjePredmetaService.findOne(pohadjanjePredmetaDTO.getId()); 
		if (pohadjanjePredmeta == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		pohadjanjePredmeta.setPocetak(pohadjanjePredmetaDTO.getPocetak());
		pohadjanjePredmeta.setKraj(pohadjanjePredmetaDTO.getKraj());
		pohadjanjePredmeta.setPolozen(pohadjanjePredmetaDTO.isPolozen());

		pohadjanjePredmeta.setStudent(studentService.findOne(pohadjanjePredmetaDTO.getStudnetDTO().getId()));
		pohadjanjePredmeta.setPredmetInstanca(predmetInstancaServiceImpl.findOne(pohadjanjePredmetaDTO.getPredmetInstanca().getId()));
		
		pohadjanjePredmeta = pohadjanjePredmetaService.save(pohadjanjePredmeta);
		return new ResponseEntity<>(new PohadjanjePredmetaMapper().modelToDto(pohadjanjePredmeta), HttpStatus.OK);	
	}
	
	
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePohadjanja(@PathVariable Long id){
		PohadjanjePredmeta pohadjanjePredmeta = pohadjanjePredmetaService.findOne(id);
		if (pohadjanjePredmeta != null){
			pohadjanjePredmetaService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//veza za studenta u pohadjanju
	//@RequestMapping(value="/studentIzPohadjanje/{id}", method=RequestMethod.GET)
	public StudentDTO getStudentIzPohadjanje(@PathVariable Long id){
		PohadjanjePredmeta pohadjanjePredmeta = pohadjanjePredmetaService.findOne(id);
		if(pohadjanjePredmeta == null){
			return null;
		}
		return new StudentMapper().modelToDto(pohadjanjePredmeta.getStudent());
	}
	
	//veza za predmet instancu za pohadjanje
	//@RequestMapping(value="/predmetInstancaIzPohadjanje/{id}", method=RequestMethod.GET)
	public PredmetInstancaDTO getPredmetInstancaIzPohadjanje(@PathVariable Long id){
		PohadjanjePredmeta pohadjanjePredmeta = pohadjanjePredmetaService.findOne(id);
		if(pohadjanjePredmeta == null){
			return null;
		}
		return new PredmetInstancaMapper().modelToDto(pohadjanjePredmeta.getPredmetInstanca());
	}

}
