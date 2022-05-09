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

import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;
import com.ftn.eObrazovanjee.mapper.DeoIspitaMapper;
import com.ftn.eObrazovanjee.mapper.PohadjanjePredmetaMapper;
import com.ftn.eObrazovanjee.mapper.PolaganjeIspitaMapper;
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
			pohadjanjaPredmetaDTO.add(new PohadjanjePredmetaMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(pohadjanjaPredmetaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PohadjanjePredmetaDTO>> getPohadjanjaPage(Pageable page) {
		Page<PohadjanjePredmeta> pohadjanjaPredmeta = pohadjanjePredmetaService.findAll(page);
		
		
		List<PohadjanjePredmetaDTO> pohadjanjaPredmetaDTO = new ArrayList<>();
		for (PohadjanjePredmeta obj : pohadjanjaPredmeta) {
			pohadjanjaPredmetaDTO.add(new PohadjanjePredmetaMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(pohadjanjaPredmetaDTO, HttpStatus.OK);
	}
	
	//id
	
	
	
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
	
	
	//put
	
	
	
	
	
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

}
