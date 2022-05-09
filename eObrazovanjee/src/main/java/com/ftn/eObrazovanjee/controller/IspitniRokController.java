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
import com.ftn.eObrazovanjee.mapper.DeoIspitaMapper;
import com.ftn.eObrazovanjee.mapper.IspitMapper;
import com.ftn.eObrazovanjee.mapper.IspitniRokMapper;
import com.ftn.eObrazovanjee.mapper.PolaganjeIspitaMapper;
import com.ftn.eObrazovanjee.model.IspitniRok;
import com.ftn.eObrazovanjee.service.IspitService;
import com.ftn.eObrazovanjee.service.IspitniRokService;

@RestController
@RequestMapping(value="api/ispitni_rok")
public class IspitniRokController {

	@Autowired
	private IspitService ispitService;
	
	@Autowired
	private IspitniRokService ispitniRokService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<IspitniRokDTO>> getAllIspitniRokovi() {
		List<IspitniRok> ispiti = ispitniRokService.findAll();
		
		List<IspitniRokDTO> ispitiDTO = new ArrayList<>();
		for (IspitniRok obj : ispiti) {
			ispitiDTO.add(new IspitniRokMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(ispitiDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<IspitniRokDTO>> getIspitniRokoviPage(Pageable page) {
		Page<IspitniRok> ispiti = ispitniRokService.findAll(page);
		
		
		List<IspitniRokDTO> ispitiDTO = new ArrayList<>();
		for (IspitniRok obj : ispiti) {
			ispitiDTO.add(new IspitniRokMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(ispitiDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<IspitniRokDTO> getIspit(@PathVariable Long id){
		IspitniRok ispitniRok = ispitniRokService.findOne(id);
		if(ispitniRok == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new IspitniRokMapper().modelToDto(ispitniRok), HttpStatus.OK);
	}
	
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<IspitniRokDTO> saveIspitniRok(@RequestBody IspitniRokDTO ispitniRokDTO){		
		IspitniRok ispitniRok = new IspitniRok();

		ispitniRok.setNazivRoka(ispitniRokDTO.getNazivRoka());
		ispitniRok.setPocetakRoka(ispitniRokDTO.getPocetakRoka());
		ispitniRok.setKrajRoka(ispitniRokDTO.getKrajRoka());
		ispitniRok.setIspit(new HashSet<>(new IspitMapper().listDtoToModel(ispitniRokDTO.getIspiti())));
		
		ispitniRok = ispitniRokService.save(ispitniRok);
		return new ResponseEntity<>(new IspitniRokMapper().modelToDto(ispitniRok), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<IspitniRokDTO> updateIspitniRok(@RequestBody IspitniRokDTO ispitniRokDTO){
		
		IspitniRok ispitniRok = ispitniRokService.findOne(ispitniRokDTO.getId()); 
		if (ispitniRok == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		ispitniRok.setNazivRoka(ispitniRokDTO.getNazivRoka());
		ispitniRok.setPocetakRoka(ispitniRokDTO.getPocetakRoka());
		ispitniRok.setKrajRoka(ispitniRokDTO.getKrajRoka());
		ispitniRok.setIspit(new HashSet<>(new IspitMapper().listDtoToModel(ispitniRokDTO.getIspiti())));
		
		ispitniRok = ispitniRokService.save(ispitniRok);
		return new ResponseEntity<>(new IspitniRokMapper().modelToDto(ispitniRok), HttpStatus.OK);	
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteIspitniRok(@PathVariable Long id){
		IspitniRok ispitniRok = ispitniRokService.findOne(id);
		if (ispitniRok != null){
			ispitService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
