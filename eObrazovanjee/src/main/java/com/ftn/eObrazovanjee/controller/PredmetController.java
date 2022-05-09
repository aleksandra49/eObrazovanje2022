package com.ftn.eObrazovanjee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.mapper.PredmetMapper;
import com.ftn.eObrazovanjee.model.Predmet;
import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.repository.PredmetRepository;
import com.ftn.eObrazovanjee.service.PredmetServiceImpl;
import com.ftn.eObrazovanjee.service.ProfesorServiceImpl;




@RestController
@RequestMapping(value="api/predmeti")
public class PredmetController {
	
	@Autowired
	private PredmetServiceImpl predmetService;
	
	@Autowired
	private PredmetRepository predmetRepository;
	
	@Autowired
	private ProfesorServiceImpl profesorService;
	
	//findAll
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<PredmetDTO>> getAllIspiti() {
		List<Predmet> ispiti = predmetService.findAll();
		//convert Ispits to DTOs
		List<PredmetDTO> ispitiDTO = new ArrayList<>();
		for (Predmet s : ispiti) {
			
			ispitiDTO.add(new PredmetMapper().modelToDto(s));
		}
		return new ResponseEntity<>(ispitiDTO, HttpStatus.OK);
	}
	
	
	//findAll + pagable
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PredmetDTO>> getCourses(Pageable pageable) {
		//int page = 0; int pageSize = 5;
		Page<Predmet> predmeti = predmetService.findAll(pageable);
		//konvertuje kurseve u DTOs
		List<PredmetDTO> predmetiDTO = new ArrayList<>();
		for (Predmet p : predmeti) {
			predmetiDTO.add(new PredmetMapper().modelToDto(p));
		}
		return new ResponseEntity<>(predmetiDTO, HttpStatus.OK);
	}
	
	
	//findOne
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PredmetDTO> getCourse(@PathVariable Long id){
		Predmet predmet = predmetService.findOne(id);
		if(predmet == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new PredmetMapper().modelToDto(predmet), HttpStatus.OK);
	}
	
    // Nastavnik izvodi odredjene predmete
    @GetMapping(value = "/profesor/{profesorId}")
    public ResponseEntity<List<Predmet>> getAllKojeNastavnikIzvodi(@PathVariable("profesorId") Long id) {
        Profesor profesor = profesorService.findOne(id);

        List<Predmet> predmeti =predmetRepository.getAllThatNastavnikIzvodi(profesor);

        System.out.println(predmeti);

        return new ResponseEntity<List<Predmet>>(predmeti, HttpStatus.OK);
    }
	

	
	

}
