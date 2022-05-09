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

import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.dto.PolaganjeIspitaDTO;
import com.ftn.eObrazovanjee.mapper.DeoIspitaMapper;
import com.ftn.eObrazovanjee.mapper.IspitMapper;
import com.ftn.eObrazovanjee.mapper.PolaganjeIspitaMapper;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.service.IspitService;
import com.ftn.eObrazovanjee.service.PolaganjeIspitaService;
import com.ftn.eObrazovanjee.service.StudentService;

@RestController
@RequestMapping(value="api/polaganje_ispita")
public class PolaganjeIspitaController {

	@Autowired
	private PolaganjeIspitaService polaganjeIspitaService;

	@Autowired
	private IspitService ispitService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<PolaganjeIspitaDTO>> getAllPolaganjeIspita() {
		List<PolaganjeIspita> polaganja = polaganjeIspitaService.findAll();
		
		List<PolaganjeIspitaDTO> polaganjaDTO = new ArrayList<>();
		for (PolaganjeIspita obj : polaganja) {
			polaganjaDTO.add(new PolaganjeIspitaMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(polaganjaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PolaganjeIspitaDTO>> getAllPolaganjeIspitaPage(Pageable page) {
		 
		Page<PolaganjeIspita> polaganja = polaganjeIspitaService.findAll(page);
		
		List<PolaganjeIspitaDTO> polaganjaDTO = new ArrayList<>();
		for (PolaganjeIspita obj : polaganja) {
			polaganjaDTO.add(new PolaganjeIspitaMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(polaganjaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PolaganjeIspitaDTO> getPolaganjeIspita(@PathVariable Long id){
		PolaganjeIspita polaganjeIspita = polaganjeIspitaService.findOne(id);
		if(polaganjeIspita == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PolaganjeIspitaMapper().modelToDto(polaganjeIspita), HttpStatus.OK);
	}
	
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PolaganjeIspitaDTO> saveIspit(@RequestBody PolaganjeIspitaDTO polaganjeIspitaDTO){		
		PolaganjeIspita polaganjeIspita = new PolaganjeIspita();
		
		polaganjeIspita.setIspit(ispitService.findOne(polaganjeIspitaDTO.getIspit().getId()));
		polaganjeIspita.setStudent(studentService.findOne(polaganjeIspitaDTO.getStudent().getId()));
		
		polaganjeIspita = polaganjeIspitaService.save(polaganjeIspita);
		return new ResponseEntity<>(new PolaganjeIspitaMapper().modelToDto(polaganjeIspita), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PolaganjeIspitaDTO> updateIspit(@RequestBody PolaganjeIspitaDTO polaganjeIspitaDTO){
		
		PolaganjeIspita polaganjeIspita = polaganjeIspitaService.findOne(polaganjeIspitaDTO.getId()); 
		if (polaganjeIspita == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		polaganjeIspita.setIspit(ispitService.findOne(polaganjeIspitaDTO.getIspit().getId()));
		polaganjeIspita.setStudent(studentService.findOne(polaganjeIspitaDTO.getStudent().getId()));
		
		polaganjeIspita = polaganjeIspitaService.save(polaganjeIspita);
		return new ResponseEntity<>(new PolaganjeIspitaMapper().modelToDto(polaganjeIspita), HttpStatus.OK);	
	}
	
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePolaganjeIspita(@PathVariable Long id){
		PolaganjeIspita polaganjeIspita = polaganjeIspitaService.findOne(id);
		if (polaganjeIspita != null){
			polaganjeIspitaService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
