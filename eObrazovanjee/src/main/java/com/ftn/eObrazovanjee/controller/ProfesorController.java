package com.ftn.eObrazovanjee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.eObrazovanjee.dto.ProfesorDTO;
import com.ftn.eObrazovanjee.mapper.ProfesorMapper;
import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.service.ProfesorServiceImpl;



@RestController
@RequestMapping(value="api/profesori")
public class ProfesorController {
	
	@Autowired ProfesorServiceImpl profesorService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<ProfesorDTO>> getAllProfesori() {
		List<Profesor> profesori = profesorService.findAll();
		List<ProfesorDTO> profesoriDTO = new ArrayList<>();
		
		for (Profesor p : profesori) {
			profesoriDTO.add(new ProfesorMapper().modelToDto(p));
		}
		return new ResponseEntity<>(profesoriDTO, HttpStatus.OK);
		
	}
	// dodati funkciju sa paglabe za all
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProfesorDTO> getOne(@PathVariable("id") Long id) {
		Profesor profesor = profesorService.findOne(id);
		if(profesor == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new ProfesorMapper().modelToDto(profesor), HttpStatus.OK);
	}
	
	 @DeleteMapping(value = {"/{id}"})
	 public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		 Profesor profesor = profesorService.findOne(id);
			if (profesor != null){
				profesorService.remove(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {		
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	 }
	

}
