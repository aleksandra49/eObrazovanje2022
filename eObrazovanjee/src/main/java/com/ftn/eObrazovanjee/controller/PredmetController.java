package com.ftn.eObrazovanjee.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.eObrazovanjee.dto.DeoIspitaDTO;
import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.dto.PredmetInstancaDTO;
import com.ftn.eObrazovanjee.dto.PredmetInstancaPredmetDTO;
import com.ftn.eObrazovanjee.mapper.DeoIspitaMapper;
import com.ftn.eObrazovanjee.mapper.PredmetInstancaMapper;
import com.ftn.eObrazovanjee.mapper.PredmetMapper;
import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.Predmet;
import com.ftn.eObrazovanjee.model.PredmetInstanca;
import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.repository.PredmetRepository;
import com.ftn.eObrazovanjee.service.PredmetInstancaServiceImpl;
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
	PredmetInstancaMapper predmetInstancaMapper;
	
	@Autowired
	private ProfesorServiceImpl profesorService;
	
	@Autowired
	private PredmetInstancaServiceImpl predmetInstancaServiceImpl;
	
	@Autowired
	private PredmetInstancaServiceImpl predmetInstancaService;
	
	
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PredmetDTO> savePredmet(@RequestBody PredmetInstancaPredmetDTO predmetInstancaPredmetDTO){		
		Predmet predmet = new Predmet();
		PredmetInstanca predmetInstanca = new PredmetInstanca();
		
		
		predmet.setNaziv(predmetInstancaPredmetDTO.getNaziv());
		predmet.setEspb(predmetInstancaPredmetDTO.getEspb());
		predmet.setOznaka(predmetInstancaPredmetDTO.getOznaka());
		
		predmet = predmetService.save(predmet);
		System.out.println(predmetInstancaPredmetDTO.getPocetak());
		predmetInstanca.setPocetak(predmetInstancaPredmetDTO.getPocetak());
		predmetInstanca.setKraj(predmetInstancaPredmetDTO.getKraj());
		predmetInstanca.setPredmet(predmet);
		predmetInstanca = predmetInstancaService.save(predmetInstanca);
		
		
		
		
		return new ResponseEntity<>(new PredmetMapper().modelToDto(predmet), HttpStatus.CREATED);	
	}
	
	@RequestMapping(value ="/dodavanjeProfesora", method=RequestMethod.POST)
	public ResponseEntity<?> DodavanjePNaPredmet(@RequestParam Long predmetId, @RequestParam Long profesorId){
		try {
			Predmet predmet = predmetService.findOne((long) predmetId);
			Profesor profesor = profesorService.findOne((long) profesorId);

			predmetRepository.dodavanjeProfesoraNaPredmet(predmetId,profesorId);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value ="/dodavanjeStudenta", method=RequestMethod.POST)
	public ResponseEntity<?> DodavanjeSNaPredmet(@RequestParam Long predmetId, @RequestParam Long studentId){
		try {
			Predmet predmet = predmetService.findOne((long) predmetId);

			predmetRepository.dodavanjeStudentaNaPredmet(predmetId, studentId);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<PredmetDTO> updatePredmet(@RequestBody PredmetDTO predmetDTO){
		
		Predmet predmet = predmetService.findOne(predmetDTO.getId()); 
		if (predmet == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		predmet.setNaziv(predmetDTO.getNaziv());
		predmet.setEspb(predmetDTO.getEspb());
		predmet.setOznaka(predmetDTO.getOznaka());

		predmet.setPredmetInstanca(new HashSet<>(new PredmetInstancaMapper().listDtoToModel(predmetDTO.getPredmetInstancaDTO())));
		
		predmet = predmetService.save(predmet);
		return new ResponseEntity<>(new PredmetMapper().modelToDto(predmet), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePredmet(@PathVariable Long id){
		Predmet predmet = predmetService.findOne(id);
		if (predmet != null){
			
			for(PredmetInstanca inst : predmet.getPredmetInstanca()) {
				deletePredmetInstanca(inst.getId());
			}
			
			predmetService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	public Void deletePredmetInstanca(Long id){
		PredmetInstanca predmetInstanca = predmetInstancaService.findOne(id);
		if (predmetInstanca != null){
			predmetInstancaService.remove(id);
			return null;
		} else {		
			return null;
		}
	}
	
	//findAll
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<PredmetDTO>> getAllPredmeti() {
		List<Predmet> predmeti = predmetService.findAll();
		//convert predmeti to DTOs
		List<PredmetDTO> predmetiDTO = new ArrayList<>();
		for (Predmet s : predmeti) {
			
			PredmetDTO predmet = new PredmetMapper().modelToDto(s);
			predmet.setPredmetInstancaDTO(getPredmetInstancaIzPredmet(predmet.getId()));
			predmetiDTO.add(predmet);
		}
		return new ResponseEntity<>(predmetiDTO, HttpStatus.OK);
	}
	
	
	//findAll + pagable
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PredmetDTO>> getPredmetiPage(Pageable pageable) {
		//int page = 0; int pageSize = 5;
		Page<Predmet> predmeti = predmetService.findAll(pageable);
		//konvertuje kurseve u DTOs
		List<PredmetDTO> predmetiDTO = new ArrayList<>();
		for (Predmet p : predmeti) {
			PredmetDTO predmet = new PredmetMapper().modelToDto(p);
			predmet.setPredmetInstancaDTO(getPredmetInstancaIzPredmet(predmet.getId()));
			predmetiDTO.add(predmet);
		}
		return new ResponseEntity<>(predmetiDTO, HttpStatus.OK);
	}
	
	
	//findOne
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PredmetDTO> getPredmet(@PathVariable Long id){
		Predmet predmet = predmetService.findOne(id);
		if(predmet == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		PredmetDTO predmetDTO = new PredmetMapper().modelToDto(predmet);
		predmetDTO.setPredmetInstancaDTO(getPredmetInstancaIzPredmet(predmet.getId()));
		
		return new ResponseEntity<>(predmetDTO, HttpStatus.OK);
		
	}
	
    // Nastavnik izvodi odredjene predmete
/*    @GetMapping(value = "/profesor/{profesorId}")
    public ResponseEntity<List<Predmet>> getAllKojeNastavnikIzvodi(@PathVariable("profesorId") Long id) {
        Profesor profesor = profesorService.findOne(id);

        List<Predmet> predmeti =predmetRepository.getAllThatNastavnikIzvodi(profesor);

        System.out.println(predmeti);

        return new ResponseEntity<List<Predmet>>(predmeti, HttpStatus.OK);
    }
	
*/
	
	//veza instanca sa predmetom
	//@RequestMapping(value="/predmetInstancaIzPredmet/{id}", method=RequestMethod.GET)
	public ArrayList<PredmetInstancaDTO> getPredmetInstancaIzPredmet(@PathVariable Long id){
		Predmet predmet = predmetService.findOne(id);
		if(predmet == null){
			return null;
		}
		ArrayList<PredmetInstancaDTO> listaInstanci = new ArrayList<>();
		for(PredmetInstanca instance : predmet.getPredmetInstanca()) {
			listaInstanci.add(new PredmetInstancaMapper().modelToDto(instance));
		}		
		return listaInstanci;
	}
	

}
