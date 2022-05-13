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

import com.ftn.eObrazovanjee.dto.TipDokumentaDTO;
import com.ftn.eObrazovanjee.mapper.TipDokumentaMapper;
import com.ftn.eObrazovanjee.model.TipDokumenta;
import com.ftn.eObrazovanjee.service.DokumentService;
import com.ftn.eObrazovanjee.service.TipDokumentaService;



@RestController
@RequestMapping(value="api/tipDokumenta")
public class TipDokumentaController {
	
	@Autowired
	private TipDokumentaService tipDokumentaService;
	@Autowired
	private DokumentService dokumentService;
	
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<TipDokumentaDTO>> getAllTipoviDokumenta() {
		List<TipDokumenta> tipoviDokumenta = tipDokumentaService.findAll();
		
		List<TipDokumentaDTO> tipoviDokumentaDTO = new ArrayList<>();
		for (TipDokumenta obj : tipoviDokumenta) {
			tipoviDokumentaDTO.add(new TipDokumentaMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(tipoviDokumentaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TipDokumentaDTO>> getTipoviDokumentaPage(Pageable page) {
		Page<TipDokumenta> tipoviDokumenta = tipDokumentaService.findAll(page);
		
		
		List<TipDokumentaDTO> tipoviDokumentaDTO = new ArrayList<>();
		for (TipDokumenta obj : tipoviDokumenta) {
			tipoviDokumentaDTO.add(new TipDokumentaMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(tipoviDokumentaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TipDokumentaDTO> getTipDokumenta(@PathVariable Long id){
		TipDokumenta tipDokumenta = tipDokumentaService.findOne(id);
		if(tipDokumenta == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new TipDokumentaMapper().modelToDto(tipDokumenta), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<TipDokumentaDTO> saveTipDokumenta(@RequestBody TipDokumentaDTO tipDokumentaDTO){		
		TipDokumenta tipDokumenta = new TipDokumenta();
		
		tipDokumenta.setNazivDokumenta(tipDokumentaDTO.getNazivDokumenta());
		
		tipDokumenta.setDokument(dokumentService.findOne(tipDokumentaDTO.getDokumentDTO().getId()));
		
		tipDokumenta = tipDokumentaService.save(tipDokumenta);
		return new ResponseEntity<>(new TipDokumentaMapper().modelToDto(tipDokumenta), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<TipDokumentaDTO> updateTipDokumenta(@RequestBody TipDokumentaDTO tipDokumentaDTO){
		
		TipDokumenta tipDokumenta = tipDokumentaService.findOne(tipDokumentaDTO.getId()); 
		if (tipDokumenta == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		tipDokumenta.setNazivDokumenta(tipDokumentaDTO.getNazivDokumenta());
		
		tipDokumenta.setDokument(dokumentService.findOne(tipDokumentaDTO.getDokumentDTO().getId()));
		
		tipDokumenta = tipDokumentaService.save(tipDokumenta);
		return new ResponseEntity<>(new TipDokumentaMapper().modelToDto(tipDokumenta), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTipDokumenta(@PathVariable Long id){
		TipDokumenta tipDokumenta = tipDokumentaService.findOne(id);
		if (tipDokumenta != null){
			tipDokumentaService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
