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

import com.ftn.eObrazovanjee.dto.FinansijskaKarticaDTO;
import com.ftn.eObrazovanjee.dto.StudentDTO;
import com.ftn.eObrazovanjee.dto.TransakcijaDTO;
import com.ftn.eObrazovanjee.mapper.FinansijskaKarticaMapper;
import com.ftn.eObrazovanjee.mapper.StudentMapper;
import com.ftn.eObrazovanjee.mapper.TransakcijaMapper;
import com.ftn.eObrazovanjee.model.FinansijskaKartica;
import com.ftn.eObrazovanjee.model.Transakcija;
import com.ftn.eObrazovanjee.service.FinansijskaKarticaService;
import com.ftn.eObrazovanjee.service.StudentService;
import com.ftn.eObrazovanjee.service.TransakcijaService;


@RestController
@RequestMapping(value="api/finansijskaKartica")
public class FinansijskaKarticaController {

	@Autowired
	private FinansijskaKarticaService finansijskaKarticaService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TransakcijaService transakcijaService;
	
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<FinansijskaKarticaDTO>> getAllFinansijskeKartice() {
		List<FinansijskaKartica> finansijskeKartice = finansijskaKarticaService.findAll();
		
		List<FinansijskaKarticaDTO> finansijskeKarticeDTO = new ArrayList<>();
		for (FinansijskaKartica obj : finansijskeKartice) {
			FinansijskaKarticaDTO finansijskaKartica = new FinansijskaKarticaMapper().modelToDto(obj);
			finansijskaKartica.setStudentDto(getStudentIFinansijskaKartica(finansijskaKartica.getId()));
			finansijskaKartica.setTransakcijaDTO(getTransakcijaIzFinansijskaKartica(finansijskaKartica.getId()));
			finansijskeKarticeDTO.add(finansijskaKartica);
		}
		
		return new ResponseEntity<>(finansijskeKarticeDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FinansijskaKarticaDTO>> getFinansijskeKarticePage(Pageable page) {
		Page<FinansijskaKartica> finansijskeKartice = finansijskaKarticaService.findAll(page);
		
		
		List<FinansijskaKarticaDTO> finansijskeKarticeDTO = new ArrayList<>();
		for (FinansijskaKartica obj : finansijskeKartice) {
			FinansijskaKarticaDTO finansijskaKartica = new FinansijskaKarticaMapper().modelToDto(obj);
			finansijskaKartica.setStudentDto(getStudentIFinansijskaKartica(finansijskaKartica.getId()));
			finansijskaKartica.setTransakcijaDTO(getTransakcijaIzFinansijskaKartica(finansijskaKartica.getId()));
			finansijskeKarticeDTO.add(finansijskaKartica);
		}
		return new ResponseEntity<>(finansijskeKarticeDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<FinansijskaKarticaDTO> getFinansijskaKartica(@PathVariable Long id){
		FinansijskaKartica finansijskaKartica = finansijskaKarticaService.findOne(id);
		if(finansijskaKartica == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		FinansijskaKarticaDTO finansijskaKarticaDTO = new FinansijskaKarticaMapper().modelToDto(finansijskaKartica);
		finansijskaKarticaDTO.setStudentDto(getStudentIFinansijskaKartica(finansijskaKartica.getId()));
		finansijskaKarticaDTO.setTransakcijaDTO(getTransakcijaIzFinansijskaKartica(finansijskaKartica.getId()));
		
		return new ResponseEntity<>(finansijskaKarticaDTO, HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<FinansijskaKarticaDTO> saveFinansijskaKartica(@RequestBody FinansijskaKarticaDTO finansijskaKarticaDTO){		
		FinansijskaKartica finansijskaKartica = new FinansijskaKartica();
		
		finansijskaKartica.setPersonalniBroj(finansijskaKarticaDTO.getPersonalniBroj());
		finansijskaKartica.setTrenutnoStanje(finansijskaKarticaDTO.getTrenutnoStanje());
		finansijskaKartica.setRacunFakulteta(finansijskaKarticaDTO.getRacunFakulteta());

		finansijskaKartica.setStudent(studentService.findOne(finansijskaKarticaDTO.getStudentDto().getId()));
		finansijskaKartica.setTransakcije(new HashSet<>(new TransakcijaMapper().listDtoToModel(finansijskaKarticaDTO.getTransakcijaDTO())));
		
		finansijskaKartica = finansijskaKarticaService.save(finansijskaKartica);
		return new ResponseEntity<>(new FinansijskaKarticaMapper().modelToDto(finansijskaKartica), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<FinansijskaKarticaDTO> updateFinansijskaKartica(@RequestBody FinansijskaKarticaDTO finansijskaKarticaDTO){
		
		FinansijskaKartica finansijskaKartica = finansijskaKarticaService.findOne(finansijskaKarticaDTO.getId()); 
		if (finansijskaKartica == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		finansijskaKartica.setPersonalniBroj(finansijskaKarticaDTO.getPersonalniBroj());
		finansijskaKartica.setTrenutnoStanje(finansijskaKarticaDTO.getTrenutnoStanje());
		finansijskaKartica.setRacunFakulteta(finansijskaKarticaDTO.getRacunFakulteta());

		finansijskaKartica.setStudent(studentService.findOne(finansijskaKarticaDTO.getStudentDto().getId()));
		finansijskaKartica.setTransakcije(new HashSet<>(new TransakcijaMapper().listDtoToModel(finansijskaKarticaDTO.getTransakcijaDTO())));
		
		finansijskaKartica = finansijskaKarticaService.save(finansijskaKartica);
		return new ResponseEntity<>(new FinansijskaKarticaMapper().modelToDto(finansijskaKartica), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteFinansijskaKartica(@PathVariable Long id){
		FinansijskaKartica finansijskaKartica = finansijskaKarticaService.findOne(id);
		if (finansijskaKartica != null){
			
			for(Transakcija trans : finansijskaKartica.getTransakcije()) {
				deleteTransakcija(trans.getId());
			}
			
			finansijskaKarticaService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	public Void deleteTransakcija(Long id){
		Transakcija transakcija = transakcijaService.findOne(id);
		if (transakcija != null){
			transakcijaService.delete(id);
			return null;
		} else {		
			return null;
		}
	}
	
	//veza studenta sa fina karticom
		public StudentDTO getStudentIFinansijskaKartica(Long id){
			FinansijskaKartica finansijskaKartica = finansijskaKarticaService.findOne(id);
			if(finansijskaKartica == null){
				return null;
			}
			return new StudentMapper().modelToDto(finansijskaKartica.getStudent());
		}
		
		//veza transakcija i fina kartica
		public ArrayList<TransakcijaDTO> getTransakcijaIzFinansijskaKartica(Long id){
			FinansijskaKartica finansijskaKartica = finansijskaKarticaService.findOne(id);
			if(finansijskaKartica == null){
				return null;
			}
			ArrayList<TransakcijaDTO> listaTransakcija = new ArrayList<>();
			for(Transakcija transakcije : finansijskaKartica.getTransakcije()) { // jed trans jed fins
				listaTransakcija.add(new TransakcijaMapper().modelToDto(transakcije));
			}		
			return listaTransakcija;
		}
}
