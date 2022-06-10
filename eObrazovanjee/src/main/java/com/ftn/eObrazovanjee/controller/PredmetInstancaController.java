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
import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.PredavanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.dto.PredmetInstancaDTO;
import com.ftn.eObrazovanjee.mapper.DeoIspitaMapper;
import com.ftn.eObrazovanjee.mapper.IspitMapper;
import com.ftn.eObrazovanjee.mapper.PohadjanjePredmetaMapper;
import com.ftn.eObrazovanjee.mapper.PredavanjePredmetaMapper;
import com.ftn.eObrazovanjee.mapper.PredmetInstancaMapper;
import com.ftn.eObrazovanjee.mapper.PredmetMapper;
import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.PohadjanjePredmeta;
import com.ftn.eObrazovanjee.model.PredavanjePredmeta;
import com.ftn.eObrazovanjee.model.PredmetInstanca;
import com.ftn.eObrazovanjee.service.PohadjanjePredmetaService;
import com.ftn.eObrazovanjee.service.PredavanjePredmetaServiceImpl;
import com.ftn.eObrazovanjee.service.PredmetInstancaServiceImpl;
import com.ftn.eObrazovanjee.service.PredmetServiceImpl;



@RestController
@RequestMapping(value="api/predmetInstanca")
public class PredmetInstancaController {
	
	@Autowired
	private PredmetInstancaServiceImpl predmetInstancaService;
	@Autowired
	private PredmetServiceImpl predmetService;
	@Autowired
	private PredavanjePredmetaServiceImpl predavanjePredmetaServiceImpl;
	@Autowired
	private PohadjanjePredmetaService pohadjanjePredmetaService;
	@Autowired
	private com.ftn.eObrazovanjee.service.IspitService IspitService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<PredmetInstancaDTO>> getAllPredmetiInstance() {
		List<PredmetInstanca> predmetiInstanca = predmetInstancaService.findAll();
		
		List<PredmetInstancaDTO> predmetiInstancaDTO = new ArrayList<>();
		for (PredmetInstanca obj : predmetiInstanca) {
			PredmetInstancaDTO predmetI = new PredmetInstancaMapper().modelToDto(obj);
			predmetI.setPredmet(getPredmetIzPredmetInstanca(predmetI.getId()));
			predmetI.setPredavanjePredmetaDTO(getPredavanjaIzPredmetInstanca(predmetI.getId()));
			predmetI.setPohadjanjePredmetaDTO(getPohadjanjaIzPredmetInstanca(predmetI.getId()));
			predmetI.setIspit(getIspitIzPredmetInstanca(predmetI.getId()));
			predmetiInstancaDTO.add(predmetI);
		}
		return new ResponseEntity<>(predmetiInstancaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PredmetInstancaDTO>> getPredmetiInstancePage(Pageable page) {
		Page<PredmetInstanca> predmetiInstanca = predmetInstancaService.findAll(page);
		
		
		List<PredmetInstancaDTO> predmetiInstancaDTO = new ArrayList<>();
		for (PredmetInstanca obj : predmetiInstanca) {
			PredmetInstancaDTO predmetI = new PredmetInstancaMapper().modelToDto(obj);
			predmetI.setPredmet(getPredmetIzPredmetInstanca(predmetI.getId()));
			predmetI.setPredavanjePredmetaDTO(getPredavanjaIzPredmetInstanca(predmetI.getId()));
			predmetI.setPohadjanjePredmetaDTO(getPohadjanjaIzPredmetInstanca(predmetI.getId()));
			predmetI.setIspit(getIspitIzPredmetInstanca(predmetI.getId()));
			predmetiInstancaDTO.add(predmetI);
		}
		return new ResponseEntity<>(predmetiInstancaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PredmetInstancaDTO> getPredmetInstanca(@PathVariable Long id){
		PredmetInstanca predmetInstanca = predmetInstancaService.findOne(id);
		if(predmetInstanca == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		PredmetInstancaDTO predmetInstancaDTO = new PredmetInstancaMapper().modelToDto(predmetInstanca);
		predmetInstancaDTO.setPredmet(getPredmetIzPredmetInstanca(predmetInstanca.getId()));
		predmetInstancaDTO.setPredavanjePredmetaDTO(getPredavanjaIzPredmetInstanca(predmetInstanca.getId()));
		predmetInstancaDTO.setPohadjanjePredmetaDTO(getPohadjanjaIzPredmetInstanca(predmetInstanca.getId()));
		predmetInstancaDTO.setIspit(getIspitIzPredmetInstanca(predmetInstanca.getId()));
		
		return new ResponseEntity<>(predmetInstancaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PredmetInstancaDTO> savePredmetInstanca(@RequestBody PredmetInstancaDTO predmetInstancaDTO){		
		PredmetInstanca predmetInstanca = new PredmetInstanca();
		
		predmetInstanca.setPocetak(predmetInstancaDTO.getPocetak());
		predmetInstanca.setKraj(predmetInstancaDTO.getKraj());

		predmetInstanca.setPredmet(predmetService.findOne(predmetInstancaDTO.getPredmet().getId()));
		predmetInstanca.setPredavanja(new HashSet<>(new PredavanjePredmetaMapper().listDtoToModel(predmetInstancaDTO.getPredavanjePredmetaDTO())));
		predmetInstanca.setPohadjanja(new HashSet<>(new PohadjanjePredmetaMapper().listDtoToModel(predmetInstancaDTO.getPohadjanjePredmetaDTO())));
		predmetInstanca.setIspit(new HashSet<>(new IspitMapper().listDtoToModel(predmetInstancaDTO.getIspit())));
		
		predmetInstanca = predmetInstancaService.save(predmetInstanca);
		return new ResponseEntity<>(new PredmetInstancaMapper().modelToDto(predmetInstanca), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PredmetInstancaDTO> updatePredmetInstanca(@RequestBody PredmetInstancaDTO predmetInstancaDTO){
		
		PredmetInstanca predmetInstanca = predmetInstancaService.findOne(predmetInstancaDTO.getId()); 
		if (predmetInstanca == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		predmetInstanca.setPocetak(predmetInstancaDTO.getPocetak());
		predmetInstanca.setKraj(predmetInstancaDTO.getKraj());

		predmetInstanca.setPredmet(predmetService.findOne(predmetInstancaDTO.getPredmet().getId()));
		predmetInstanca.setPredavanja(new HashSet<>(new PredavanjePredmetaMapper().listDtoToModel(predmetInstancaDTO.getPredavanjePredmetaDTO())));
		predmetInstanca.setPohadjanja(new HashSet<>(new PohadjanjePredmetaMapper().listDtoToModel(predmetInstancaDTO.getPohadjanjePredmetaDTO())));
		predmetInstanca.setIspit(new HashSet<>(new IspitMapper().listDtoToModel(predmetInstancaDTO.getIspit())));
		
		predmetInstanca = predmetInstancaService.save(predmetInstanca);
		return new ResponseEntity<>(new PredmetInstancaMapper().modelToDto(predmetInstanca), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePredmetInstanca(@PathVariable Long id){
		PredmetInstanca predmetInstanca = predmetInstancaService.findOne(id);
		if (predmetInstanca != null){
			predmetInstancaService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//veza predmet
	//@RequestMapping(value="/predmetIzPredmetInstanca/{id}", method=RequestMethod.GET)
	public PredmetDTO getPredmetIzPredmetInstanca(@PathVariable Long id){
		PredmetInstanca instanca = predmetInstancaService.findOne(id);
		if(instanca == null){
			return null;
		}
		return new PredmetMapper().modelToDto(instanca.getPredmet());
	}
	
	
	// veza pedavanja
	//@RequestMapping(value="/predavanjaIzPredmetInstanca/{id}", method=RequestMethod.GET)
	public ArrayList<PredavanjePredmetaDTO> getPredavanjaIzPredmetInstanca(@PathVariable Long id){
		PredmetInstanca instanca = predmetInstancaService.findOne(id);
		if(instanca == null){
			return null;
		}
		ArrayList<PredavanjePredmetaDTO> listaPredavanja = new ArrayList<>();
		for(PredavanjePredmeta predavanja : instanca.getPredavanja()) {
			listaPredavanja.add(new PredavanjePredmetaMapper().modelToDto(predavanja));
		}		
		return listaPredavanja;
	}
	
	
	
	//pohadnja
	//@RequestMapping(value="/pohadjanjaIzPredmetInstanca/{id}", method=RequestMethod.GET)
	public ArrayList<PohadjanjePredmetaDTO> getPohadjanjaIzPredmetInstanca(@PathVariable Long id){
		PredmetInstanca instanca = predmetInstancaService.findOne(id);
		if(instanca == null){
			return null;
		}
		ArrayList<PohadjanjePredmetaDTO> listPohadjanja = new ArrayList<>();
		for(PohadjanjePredmeta pohadjanja : instanca.getPohadjanja()) {
			listPohadjanja.add(new PohadjanjePredmetaMapper().modelToDto(pohadjanja));
		}		
		return listPohadjanja;
	}
	
	
	
	//ispit
	//@RequestMapping(value="/ispitIzPredmetInstanca/{id}", method=RequestMethod.GET)
	public ArrayList<IspitDTO> getIspitIzPredmetInstanca(@PathVariable Long id){
		PredmetInstanca instanca = predmetInstancaService.findOne(id);
		if(instanca == null){
			return null;
		}
		ArrayList<IspitDTO> listaIspita = new ArrayList<>();
		for(Ispit ispiti : instanca.getIspit()) {
			listaIspita.add(new IspitMapper().modelToDto(ispiti));
		}		
		return listaIspita;
	}
	
	
	

}
