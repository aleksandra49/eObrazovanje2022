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

import com.ftn.eObrazovanjee.dto.TransakcijaDTO;
import com.ftn.eObrazovanjee.mapper.TransakcijaMapper;
import com.ftn.eObrazovanjee.model.Transakcija;
import com.ftn.eObrazovanjee.service.FinansijskaKarticaService;
import com.ftn.eObrazovanjee.service.TransakcijaService;

@RestController
@RequestMapping(value="api/transakcija")
public class TransakcijaController {
	
	@Autowired
	private TransakcijaService transakcijaService;
	@Autowired
	private FinansijskaKarticaService finansijskaKarticaService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<TransakcijaDTO>> getAllTransakcije() {
		List<Transakcija> transakcije = transakcijaService.findAll();
		
		List<TransakcijaDTO> transakcijeDTO = new ArrayList<>();
		for (Transakcija obj : transakcije) {
			transakcijeDTO.add(new TransakcijaMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(transakcijeDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TransakcijaDTO>> getTransakcijePage(Pageable page) {
		Page<Transakcija> transakcije = transakcijaService.findAll(page);
		
		
		List<TransakcijaDTO> transakcijeDTO = new ArrayList<>();
		for (Transakcija obj : transakcije) {
			transakcijeDTO.add(new TransakcijaMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(transakcijeDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TransakcijaDTO> getTransakcija(@PathVariable Long id){
		Transakcija transakcija = transakcijaService.findOne(id);
		if(transakcija == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new TransakcijaMapper().modelToDto(transakcija), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<TransakcijaDTO> saveTransakcija(@RequestBody TransakcijaDTO transakcijaDTO){		
		Transakcija transakcija = new Transakcija();
		
		transakcija.setDatum(transakcijaDTO.getDatum());
		transakcija.setSvrha(transakcijaDTO.getSvrha());
		transakcija.setPromenaStanja(transakcijaDTO.getPromenaStanja());

		transakcija.setFinansijskaKartica(finansijskaKarticaService.findOne(transakcijaDTO.getFinansijskaKarticaDTO().getId()));
		
		transakcija = transakcijaService.save(transakcija);
		return new ResponseEntity<>(new TransakcijaMapper().modelToDto(transakcija), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<TransakcijaDTO> updateTransakcija(@RequestBody TransakcijaDTO transakcijaDTO){
		
		Transakcija transakcija = transakcijaService.findOne(transakcijaDTO.getId()); 
		if (transakcija == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		transakcija.setDatum(transakcijaDTO.getDatum());
		transakcija.setSvrha(transakcijaDTO.getSvrha());
		transakcija.setPromenaStanja(transakcijaDTO.getPromenaStanja());

		transakcija.setFinansijskaKartica(finansijskaKarticaService.findOne(transakcijaDTO.getFinansijskaKarticaDTO().getId()));
		
		transakcija = transakcijaService.save(transakcija);
		return new ResponseEntity<>(new TransakcijaMapper().modelToDto(transakcija), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTransakcija(@PathVariable Long id){
		Transakcija transakcija = transakcijaService.findOne(id);
		if (transakcija != null){
			transakcijaService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
