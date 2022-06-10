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
import com.ftn.eObrazovanjee.dto.PredavanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.PredmetInstancaDTO;
import com.ftn.eObrazovanjee.dto.ProfesorDTO;
import com.ftn.eObrazovanjee.mapper.IspitMapper;
import com.ftn.eObrazovanjee.mapper.PredavanjePredmetaMapper;
import com.ftn.eObrazovanjee.mapper.PredmetInstancaMapper;
import com.ftn.eObrazovanjee.mapper.ProfesorMapper;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.PredavanjePredmeta;
import com.ftn.eObrazovanjee.service.PredavanjePredmetaServiceImpl;
import com.ftn.eObrazovanjee.service.PredmetInstancaServiceImpl;
import com.ftn.eObrazovanjee.service.ProfesorServiceImpl;




@RestController
@RequestMapping(value="api/predavanjePredmeta")
public class PredavanjePredmetaController {

	@Autowired
	private PredavanjePredmetaServiceImpl predavanjePredmetaServiceImpl;
	@Autowired
	private ProfesorServiceImpl profesorServiceImpl;
	@Autowired
	private PredmetInstancaServiceImpl predmetInstancaServiceImpl;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<PredavanjePredmetaDTO>> getAllPredavanja() {
		List<PredavanjePredmeta> predavanjePred = predavanjePredmetaServiceImpl.findAll();
		
		List<PredavanjePredmetaDTO> predavanjePredDTO = new ArrayList<>();
		for (PredavanjePredmeta obj : predavanjePred) {
			PredavanjePredmetaDTO predavanje = new PredavanjePredmetaMapper().modelToDto(obj);
			predavanje.setProfesor(getProfesorIzPredavanjePredmeta(predavanje.getId()));
			predavanje.setPredmetInstanca(getPredmetInstancaIzPredavanjePredmeta(predavanje.getId()));
			predavanjePredDTO.add(predavanje);
		}
		return new ResponseEntity<>(predavanjePredDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PredavanjePredmetaDTO>> getPredavanjaPage(Pageable page) {
		Page<PredavanjePredmeta> predavanjePred = predavanjePredmetaServiceImpl.findAll(page);
		
		
		List<PredavanjePredmetaDTO> predavanjePredDTO = new ArrayList<>();
		for (PredavanjePredmeta obj : predavanjePred) {
			PredavanjePredmetaDTO predavanje = new PredavanjePredmetaMapper().modelToDto(obj);
			predavanje.setProfesor(getProfesorIzPredavanjePredmeta(predavanje.getId()));
			predavanje.setPredmetInstanca(getPredmetInstancaIzPredavanjePredmeta(predavanje.getId()));
			predavanjePredDTO.add(predavanje);
		}
		return new ResponseEntity<>(predavanjePredDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PredavanjePredmetaDTO> getPredavanjePredmeta(@PathVariable Long id){
		PredavanjePredmeta predavanjePredmeta = predavanjePredmetaServiceImpl.findOne(id);
		if(predavanjePredmeta == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		PredavanjePredmetaDTO predavanjePredmetaDTO = new PredavanjePredmetaMapper().modelToDto(predavanjePredmeta);
		predavanjePredmetaDTO.setProfesor(getProfesorIzPredavanjePredmeta(predavanjePredmeta.getId()));
		predavanjePredmetaDTO.setPredmetInstanca(getPredmetInstancaIzPredavanjePredmeta(predavanjePredmeta.getId()));
		
		return new ResponseEntity<>(predavanjePredmetaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PredavanjePredmetaDTO> savePredavanjePredmeta(@RequestBody PredavanjePredmetaDTO predavanjePredmetaDTO){		
		PredavanjePredmeta predavanjePredmeta = new PredavanjePredmeta();
		
		
		predavanjePredmeta.setProfesor(profesorServiceImpl.findOne(predavanjePredmetaDTO.getProfesor().getId()));
		predavanjePredmeta.setInstanca(predmetInstancaServiceImpl.findOne(predavanjePredmetaDTO.getPredmetInstanca().getId()));
		predavanjePredmeta.setTipPredavaca(predavanjePredmetaDTO.getTipPredavaca());
		
		predavanjePredmeta = predavanjePredmetaServiceImpl.save(predavanjePredmeta);
		return new ResponseEntity<>(new PredavanjePredmetaMapper().modelToDto(predavanjePredmeta), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PredavanjePredmetaDTO> updatePredavanjePredmeta(@RequestBody PredavanjePredmetaDTO predavanjePredmetaDTO){
		
		PredavanjePredmeta predavanjePredmeta = predavanjePredmetaServiceImpl.findOne(predavanjePredmetaDTO.getId()); 
		if (predavanjePredmeta == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		predavanjePredmeta.setProfesor(profesorServiceImpl.findOne(predavanjePredmetaDTO.getProfesor().getId()));
		predavanjePredmeta.setInstanca(predmetInstancaServiceImpl.findOne(predavanjePredmetaDTO.getPredmetInstanca().getId()));
		predavanjePredmeta.setTipPredavaca(predavanjePredmetaDTO.getTipPredavaca());
		
		predavanjePredmeta = predavanjePredmetaServiceImpl.save(predavanjePredmeta);
		return new ResponseEntity<>(new PredavanjePredmetaMapper().modelToDto(predavanjePredmeta), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePredavanjePredmeta(@PathVariable Long id){
		PredavanjePredmeta predavanjePredmeta = predavanjePredmetaServiceImpl.findOne(id);
		if (predavanjePredmeta != null){
			predavanjePredmetaServiceImpl.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//veza profa i predavanje
	//@RequestMapping(value="/profesorIzPredavanjePredmeta/{id}", method=RequestMethod.GET)
	public ProfesorDTO getProfesorIzPredavanjePredmeta(@PathVariable Long id){
		PredavanjePredmeta predavanje = predavanjePredmetaServiceImpl.findOne(id);
		if(predavanje == null){
			return null;
		}
		return new ProfesorMapper().modelToDto(predavanje.getProfesor());
	}
	
	//instanca predmet i predavanje
	//@RequestMapping(value="/predmetInstancaIzPredavanjePredmeta/{id}", method=RequestMethod.GET)
	public PredmetInstancaDTO getPredmetInstancaIzPredavanjePredmeta(@PathVariable Long id){
		PredavanjePredmeta predavanje = predavanjePredmetaServiceImpl.findOne(id);
		if(predavanje == null){
			return null;
		}
		return new  PredmetInstancaMapper().modelToDto(predavanje.getInstanca());
	}
	
}
