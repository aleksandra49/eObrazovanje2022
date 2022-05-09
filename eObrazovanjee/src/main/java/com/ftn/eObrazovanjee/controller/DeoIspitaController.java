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

import com.ftn.eObrazovanjee.dto.DeoIspitaDTO;
import com.ftn.eObrazovanjee.mapper.DeoIspitaMapper;
import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.service.DeoIspitaService;
import com.ftn.eObrazovanjee.service.IspitService;



@RestController
@RequestMapping(value="api/deoIspita")
public class DeoIspitaController {
	
	@Autowired
    private DeoIspitaService deoIspitaService;
	@Autowired
	private IspitService ispitService;
	
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<DeoIspitaDTO>> getAllDeoloviIspita() {
		List<DeoIspita> deloviIspita = deoIspitaService.findAll();
		
		List<DeoIspitaDTO> deloviIspitaDTO = new ArrayList<>();
		for (DeoIspita obj : deloviIspita) {
			deloviIspitaDTO.add(new DeoIspitaMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(deloviIspitaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DeoIspitaDTO>> getDeloviIspitaPage(Pageable page) {
		Page<DeoIspita> deloviIspita = deoIspitaService.findAll(page);
		
		
		List<DeoIspitaDTO> deloviIspitaDTO = new ArrayList<>();
		for (DeoIspita obj : deloviIspita) {
			deloviIspitaDTO.add(new DeoIspitaMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(deloviIspitaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<DeoIspitaDTO> getDeoIspita(@PathVariable Long id){
		DeoIspita deoIspita = deoIspitaService.findOne(id);
		if(deoIspita == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new DeoIspitaMapper().modelToDto(deoIspita), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<DeoIspitaDTO> saveDeoIspita(@RequestBody DeoIspitaDTO deoIspitaDTO){		
		DeoIspita deoIspita = new DeoIspita();
		deoIspita.setNaziv(deoIspitaDTO.getNaziv());
		deoIspita.setBrojOsvojenihBodova(deoIspitaDTO.getBrojOsvojenihBodova());
		deoIspita.setMinBodova(deoIspitaDTO.getMinBodova());
		deoIspita.setPolozio(deoIspitaDTO.isPolozio());

		deoIspita.setIspit(ispitService.findOne(deoIspitaDTO.getIspitDTO().getId()));
		
		deoIspita = deoIspitaService.save(deoIspita);
		return new ResponseEntity<>(new DeoIspitaMapper().modelToDto(deoIspita), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<DeoIspitaDTO> updateDeoIspita(@RequestBody DeoIspitaDTO deoIspitaDTO){
		
		DeoIspita deoIspita = deoIspitaService.findOne(deoIspitaDTO.getId()); 
		if (deoIspita == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		deoIspita.setNaziv(deoIspitaDTO.getNaziv());
		deoIspita.setBrojOsvojenihBodova(deoIspitaDTO.getBrojOsvojenihBodova());
		deoIspita.setMinBodova(deoIspitaDTO.getMinBodova());
		deoIspita.setPolozio(deoIspitaDTO.isPolozio());

		deoIspita.setIspit(ispitService.findOne(deoIspitaDTO.getIspitDTO().getId()));
		
		deoIspita = deoIspitaService.save(deoIspita);
		return new ResponseEntity<>(new DeoIspitaMapper().modelToDto(deoIspita), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDeoIspita(@PathVariable Long id){
		DeoIspita deoIspita = deoIspitaService.findOne(id);
		if (deoIspita != null){
			deoIspitaService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
