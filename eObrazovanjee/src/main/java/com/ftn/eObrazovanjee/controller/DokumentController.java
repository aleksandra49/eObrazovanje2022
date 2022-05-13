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

import com.ftn.eObrazovanjee.dto.DokumentDTO;
import com.ftn.eObrazovanjee.mapper.DokumentMapper;
import com.ftn.eObrazovanjee.mapper.TipDokumentaMapper;
import com.ftn.eObrazovanjee.model.Dokument;
import com.ftn.eObrazovanjee.service.DokumentService;
import com.ftn.eObrazovanjee.service.StudentService;
import com.ftn.eObrazovanjee.service.TipDokumentaService;


@RestController
@RequestMapping(value="api/dokument")
public class DokumentController {
	
	@Autowired
	private DokumentService dokumentService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TipDokumentaService tipDokumentaService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<DokumentDTO>> getAllDokumenti() {
		List<Dokument> dokumenti = dokumentService.findAll();
		
		List<DokumentDTO> dokumentiDTO = new ArrayList<>();
		for (Dokument obj : dokumenti) {
			dokumentiDTO.add(new DokumentMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(dokumentiDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DokumentDTO>> getDokumentiPage(Pageable page) {
		Page<Dokument> dokumenti = dokumentService.findAll(page);
		
		
		List<DokumentDTO> dokumentiDTO = new ArrayList<>();
		for (Dokument obj : dokumenti) {
			dokumentiDTO.add(new DokumentMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(dokumentiDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<DokumentDTO> getDokument(@PathVariable Long id){
		Dokument dokument = dokumentService.findOne(id);
		if(dokument == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new DokumentMapper().modelToDto(dokument), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<DokumentDTO> saveDokument(@RequestBody DokumentDTO dokumentDTO){		
		Dokument dokument = new Dokument();
		
		dokument.setNaziv(dokumentDTO.getNaziv());
		dokument.setUri(dokumentDTO.getUri());

		dokument.setStudent(studentService.findOne(dokumentDTO.getStudentDto().getId()));
		dokument.setTipDokumenta(new HashSet<>(new TipDokumentaMapper().listDtoToModel(dokumentDTO.getTipDokumentaDTOs())));
		
		dokument = dokumentService.save(dokument);
		return new ResponseEntity<>(new DokumentMapper().modelToDto(dokument), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<DokumentDTO> updateDokument(@RequestBody DokumentDTO dokumentDTO){
		
		Dokument dokument = dokumentService.findOne(dokumentDTO.getId()); 
		if (dokument == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		dokument.setNaziv(dokumentDTO.getNaziv());
		dokument.setUri(dokumentDTO.getUri());

		dokument.setStudent(studentService.findOne(dokumentDTO.getStudentDto().getId()));
		dokument.setTipDokumenta(new HashSet<>(new TipDokumentaMapper().listDtoToModel(dokumentDTO.getTipDokumentaDTOs())));
		
		dokument = dokumentService.save(dokument);
		return new ResponseEntity<>(new DokumentMapper().modelToDto(dokument), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDokument(@PathVariable Long id){
		Dokument dokument = dokumentService.findOne(id);
		if (dokument != null){
			dokumentService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
