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
import com.ftn.eObrazovanjee.dto.IspitniRokDTO;
import com.ftn.eObrazovanjee.dto.PolaganjeIspitaDTO;
import com.ftn.eObrazovanjee.dto.PredmetInstancaDTO;
import com.ftn.eObrazovanjee.mapper.DeoIspitaMapper;
import com.ftn.eObrazovanjee.mapper.IspitMapper;
import com.ftn.eObrazovanjee.mapper.IspitniRokMapper;
import com.ftn.eObrazovanjee.mapper.PolaganjeIspitaMapper;
import com.ftn.eObrazovanjee.mapper.PredmetInstancaMapper;
import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.service.IspitService;
import com.ftn.eObrazovanjee.service.IspitniRokService;
import com.ftn.eObrazovanjee.service.PolaganjeIspitaService;
import com.ftn.eObrazovanjee.service.PredmetInstancaServiceImpl;


@RestController
@RequestMapping(value="api/ispit")
public class IspitController {

	@Autowired
	private IspitService ispitService;
	@Autowired
	private IspitniRokService ispitniRokService;
	@Autowired
	private PredmetInstancaServiceImpl predmetInstancaServiceImpl;
	@Autowired
	private PolaganjeIspitaService polaganjeIspitaService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<IspitDTO>> getAllIspiti() {
		List<Ispit> ispiti = ispitService.findAll();
		
		List<IspitDTO> ispitiDTO = new ArrayList<>();
		for (Ispit obj : ispiti) {
			ispitiDTO.add(new IspitMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(ispitiDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<IspitDTO>> getIspitiPage(Pageable page) {
		Page<Ispit> ispiti = ispitService.findAll(page);
		
		
		List<IspitDTO> ispitiDTO = new ArrayList<>();
		for (Ispit obj : ispiti) {
			ispitiDTO.add(new IspitMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(ispitiDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<IspitDTO> getIspit(@PathVariable Long id){
		Ispit ispit = ispitService.findOne(id);
		if(ispit == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new IspitMapper().modelToDto(ispit), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<IspitDTO> saveIspit(@RequestBody IspitDTO ispitDTO){		
		Ispit ispit = new Ispit();
		ispit.setNaziv(ispitDTO.getNaziv());
		ispit.setDatumVreme(ispitDTO.getDatumVreme());
		ispit.setBrojOsvojenihBodova(ispitDTO.getBrojOsvojenihBodova());

		ispit.setPolaganjeIspita(new HashSet<>(new PolaganjeIspitaMapper().listDtoToModel(ispitDTO.getPolaganjeIspita())));
		ispit.setIspitniRok(ispitniRokService.findOne(ispitDTO.getIspitniRok().getId()));
		ispit.setDeoIspita(new HashSet<>(new DeoIspitaMapper().listDtoToModel(ispitDTO.getDeoIspitaDTO())));
		ispit.setPredmetInstanca(predmetInstancaServiceImpl.findOne(ispitDTO.getPredmetInstanca().getId()));
		
		ispit = ispitService.save(ispit);
		return new ResponseEntity<>(new IspitMapper().modelToDto(ispit), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<IspitDTO> updateIspit(@RequestBody IspitDTO ispitDTO){
		
		Ispit ispit = ispitService.findOne(ispitDTO.getId()); 
		if (ispit == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		ispit.setNaziv(ispitDTO.getNaziv());
		ispit.setDatumVreme(ispitDTO.getDatumVreme());
		ispit.setBrojOsvojenihBodova(ispitDTO.getBrojOsvojenihBodova());

		ispit.setPolaganjeIspita(new HashSet<>(new PolaganjeIspitaMapper().listDtoToModel(ispitDTO.getPolaganjeIspita())));
		ispit.setIspitniRok(ispitniRokService.findOne(ispitDTO.getIspitniRok().getId()));
		ispit.setDeoIspita(new HashSet<>(new DeoIspitaMapper().listDtoToModel(ispitDTO.getDeoIspitaDTO())));
		ispit.setPredmetInstanca(predmetInstancaServiceImpl.findOne(ispitDTO.getPredmetInstanca().getId()));
		
		ispit = ispitService.save(ispit);
		return new ResponseEntity<>(new IspitMapper().modelToDto(ispit), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteIspit(@PathVariable Long id){
		Ispit ispit = ispitService.findOne(id);
		if (ispit != null){
			ispitService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/getPolaganjeIspitaIzIspita/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<PolaganjeIspitaDTO>> getPolaganjeIspitaIzIspita(@PathVariable Long id){
		Ispit ispit = ispitService.findOne(id);
		if(ispit == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<PolaganjeIspitaDTO> listaPolaganja = new ArrayList<>();
		for(PolaganjeIspita polaganje : ispit.getPolaganjeIspita()) {
			listaPolaganja.add(new PolaganjeIspitaMapper().modelToDto(polaganje));
		}		
		return new ResponseEntity<>(listaPolaganja, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getDeoIspitaIzIspita/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<DeoIspitaDTO>> getDeoIspitaIzIspita(@PathVariable Long id){
		Ispit ispit = ispitService.findOne(id);
		if(ispit == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<DeoIspitaDTO> listaDelova = new ArrayList<>();
		for(DeoIspita polaganje : ispit.getDeoIspita()) {
			listaDelova.add(new DeoIspitaMapper().modelToDto(polaganje));
		}		
		return new ResponseEntity<>(listaDelova, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getIspitniRokIzIspita/{id}", method=RequestMethod.GET)
	public ResponseEntity<IspitniRokDTO> getIspitniRokIzIspita(@PathVariable Long id){
		Ispit ispit = ispitService.findOne(id);
		if(ispit == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new IspitniRokMapper().modelToDto(ispit.getIspitniRok()), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getPredmetInstancaIzIspita/{id}", method=RequestMethod.GET)
	public ResponseEntity<PredmetInstancaDTO> getPredmetInstancaIzIspita(@PathVariable Long id){
		Ispit ispit = ispitService.findOne(id);
		if(ispit == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new PredmetInstancaMapper().modelToDto(ispit.getPredmetInstanca()), HttpStatus.OK);
	}
	
}
