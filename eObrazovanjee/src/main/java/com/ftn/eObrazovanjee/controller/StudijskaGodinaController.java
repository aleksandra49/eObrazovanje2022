package com.ftn.eObrazovanjee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.mapper.PredmetToPredmetDTO;
import com.ftn.eObrazovanjee.mapper.StudijskaGodinaToStudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.Predmet;
import com.ftn.eObrazovanjee.model.StudijskaGodina;
import com.ftn.eObrazovanjee.service.StudijskaGodinaService;





@RestController
@RequestMapping(value="api/studijskaGodina")
public class StudijskaGodinaController {
	
	@Autowired
    private StudijskaGodinaService studijskaGodinaService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<StudijskaGodinaDTO>> getAllSGodine() {
		List<StudijskaGodina> studijskeGodine = studijskaGodinaService.findAll();
		//convert studijskeGodine to DTOs
		List<StudijskaGodinaDTO> studijskeGodineDTO = new ArrayList<>();
		for (StudijskaGodina s : studijskeGodine) {
			studijskeGodineDTO.add(new StudijskaGodinaToStudijskaGodinaDTO().konvertujEntityToDto(s));
		}
		return new ResponseEntity<>(studijskeGodineDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudijskaGodinaDTO>> getStudijskeGodine() {
		List<StudijskaGodina> studijskeGodine = studijskaGodinaService.findAll();
		//convert studijskeGodine to DTOs
		List<StudijskaGodinaDTO> studijskeGodineDTO = new ArrayList<>();
		for (StudijskaGodina sg : studijskeGodine) {
			studijskeGodineDTO.add(new StudijskaGodinaToStudijskaGodinaDTO().konvertujEntityToDto(sg));
		}
		return new ResponseEntity<>(studijskeGodineDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudijskaGodinaDTO> getStudijskaGodina(@PathVariable Long id){
		StudijskaGodina sg = studijskaGodinaService.findOne(id);
		if(sg == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new StudijskaGodinaToStudijskaGodinaDTO().konvertujEntityToDto(sg), HttpStatus.OK);
	}

}
