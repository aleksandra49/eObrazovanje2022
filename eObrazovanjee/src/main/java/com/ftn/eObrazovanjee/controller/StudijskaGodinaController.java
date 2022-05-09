package com.ftn.eObrazovanjee.controller;

import java.util.ArrayList;
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

import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.mapper.StudijskaGodinaMapper;
import com.ftn.eObrazovanjee.model.StudijskaGodina;
import com.ftn.eObrazovanjee.service.StudentService;
import com.ftn.eObrazovanjee.service.StudijskaGodinaService;


@RestController
@RequestMapping(value="api/studijskaGodina")
public class StudijskaGodinaController {
	
	@Autowired
    private StudijskaGodinaService studijskaGodinaService;
	@Autowired
    private StudentService studentService;
	
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<StudijskaGodinaDTO>> getAllSGodine() {
		List<StudijskaGodina> studijskeGodine = studijskaGodinaService.findAll();
		//convert studijskeGodine to DTOs
		List<StudijskaGodinaDTO> studijskeGodineDTO = new ArrayList<>();
		for (StudijskaGodina s : studijskeGodine) {
			studijskeGodineDTO.add(new StudijskaGodinaMapper().modelToDto(s));
		}
		return new ResponseEntity<>(studijskeGodineDTO, HttpStatus.OK);
	}
	
	//see this if i need it!
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudijskaGodinaDTO>> getStudijskeGodine() {
		List<StudijskaGodina> studijskeGodine = studijskaGodinaService.findAll();
		
		List<StudijskaGodinaDTO> studijskeGodineDTO = new ArrayList<>();
		for (StudijskaGodina sg : studijskeGodine) {
			studijskeGodineDTO.add(new StudijskaGodinaMapper().modelToDto(sg));
		}
		return new ResponseEntity<>(studijskeGodineDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudijskaGodinaDTO>> getStudijskeGodinePage(Pageable page) {
		Page<StudijskaGodina> studijskeGodine = studijskaGodinaService.findAll(page);
		
		List<StudijskaGodinaDTO> studijskeGodineDTO = new ArrayList<>();
		for (StudijskaGodina sg : studijskeGodine) {
			studijskeGodineDTO.add(new StudijskaGodinaMapper().modelToDto(sg));
		}
		return new ResponseEntity<>(studijskeGodineDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudijskaGodinaDTO> getStudijskaGodina(@PathVariable Long id){
		StudijskaGodina sg = studijskaGodinaService.findOne(id);
		
		if(sg == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new StudijskaGodinaMapper().modelToDto(sg), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StudijskaGodinaDTO> saveStudijskaGodina(@RequestBody StudijskaGodinaDTO studijskaGodinaDTO){		
		StudijskaGodina studijskaGodina = new StudijskaGodina();
		
		studijskaGodina.setPocetakStudija(studijskaGodinaDTO.getPocetakStudija());
		studijskaGodina.setKrajStudija(studijskaGodinaDTO.getKrajStudija());
		studijskaGodina.setNacin_finansiranja(studijskaGodinaDTO.getNacinFinansiranja());
		studijskaGodina.setGodinaStudija(studijskaGodinaDTO.getGodinaStudija());
		studijskaGodina.setSkolskaGodina(studijskaGodinaDTO.getSkolskaGodina());
		

		studijskaGodina.setStudent(studentService.findOne(studijskaGodinaDTO.getStudnetDTO().getId()));
		
		studijskaGodina = studijskaGodinaService.save(studijskaGodina);
		return new ResponseEntity<>(new StudijskaGodinaMapper().modelToDto(studijskaGodina), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<StudijskaGodinaDTO> updateStudijskaGodina(@RequestBody StudijskaGodinaDTO studijskaGodinaDTO){
		
		StudijskaGodina studijskaGodina = studijskaGodinaService.findOne(studijskaGodinaDTO.getId()); 
		if (studijskaGodina == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		studijskaGodina.setPocetakStudija(studijskaGodinaDTO.getPocetakStudija());
		studijskaGodina.setKrajStudija(studijskaGodinaDTO.getKrajStudija());
		studijskaGodina.setNacin_finansiranja(studijskaGodinaDTO.getNacinFinansiranja());
		studijskaGodina.setGodinaStudija(studijskaGodinaDTO.getGodinaStudija());
		studijskaGodina.setSkolskaGodina(studijskaGodinaDTO.getSkolskaGodina());
		

		studijskaGodina.setStudent(studentService.findOne(studijskaGodinaDTO.getStudnetDTO().getId()));
		
		studijskaGodina = studijskaGodinaService.save(studijskaGodina);
		return new ResponseEntity<>(new StudijskaGodinaMapper().modelToDto(studijskaGodina), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudijskaGodina(@PathVariable Long id){
		StudijskaGodina studijskaGodina = studijskaGodinaService.findOne(id);
		if (studijskaGodina != null){
			studijskaGodinaService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
