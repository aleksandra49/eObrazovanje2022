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
import com.ftn.eObrazovanjee.dto.FinansijskaKarticaDTO;
import com.ftn.eObrazovanjee.dto.KorisnikDTO;
import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.StudentDTO;
import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.mapper.DokumentMapper;
import com.ftn.eObrazovanjee.mapper.FinansijskaKarticaMapper;
import com.ftn.eObrazovanjee.mapper.KorisnikMapper;
import com.ftn.eObrazovanjee.mapper.PohadjanjePredmetaMapper;
import com.ftn.eObrazovanjee.mapper.StudentMapper;
import com.ftn.eObrazovanjee.mapper.StudijskaGodinaMapper;
import com.ftn.eObrazovanjee.model.Dokument;
import com.ftn.eObrazovanjee.model.PohadjanjePredmeta;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.model.StudijskaGodina;
import com.ftn.eObrazovanjee.service.DokumentService;
import com.ftn.eObrazovanjee.service.FinansijskaKarticaService;
import com.ftn.eObrazovanjee.service.KorisnikService;
import com.ftn.eObrazovanjee.service.PohadjanjePredmetaService;
import com.ftn.eObrazovanjee.service.StudentService;
import com.ftn.eObrazovanjee.service.StudijskaGodinaService;



@RestController
@RequestMapping(value="api/student")
public class StudentController {
	
	@Autowired
    private StudentService studentService;
	@Autowired
    private StudijskaGodinaService studijskaGodinaService ;
	@Autowired
    private DokumentService dokumentService;
	@Autowired
	private FinansijskaKarticaService finansijskaKarticaService;
	@Autowired
    private PohadjanjePredmetaService pohadjanjePredmetaService;
	@Autowired
    private KorisnikService korisnikService;
	
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAllStudenti() {
		List<Student> studenti = studentService.findAll();
		
		List<StudentDTO> studentiDTO = new ArrayList<>();
		for (Student obj : studenti) {
			studentiDTO.add(new StudentMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(studentiDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getStudentiPage(Pageable page) {
		Page<Student> studenti = studentService.findAll(page);
		
		
		List<StudentDTO> studentiDTO = new ArrayList<>();
		for (Student obj : studenti) {
			studentiDTO.add(new StudentMapper().modelToDto(obj));
		}
		return new ResponseEntity<>(studentiDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new StudentMapper().modelToDto(student), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){		
		Student student = new Student();
		
		student.setIme(studentDTO.getIme());
		student.setPrezime(studentDTO.getPrezime());
		student.setIndeks(studentDTO.getIndeks());
		student.setEmail(studentDTO.getEmail());
		student.setActive(studentDTO.isActive());
		
		
		
		student.setStudijskaGodina(new HashSet<>(new StudijskaGodinaMapper().listDtoToModel(studentDTO.getStudijskeGodineDTO())));
		student.setDokumenti(new HashSet<>(new DokumentMapper().listDtoToModel(studentDTO.getDokumentiDTO())));
		student.setFinansijskaKartica(finansijskaKarticaService.findOne(studentDTO.getFinansijskaKarticaDTO().getId()));
		student.setPohadjanjePredmeta(new HashSet<>(new PohadjanjePredmetaMapper().listDtoToModel(studentDTO.getPohadjanjaPredmetaDTO())));
		student.setKorisnik(korisnikService.findOne(studentDTO.getKorisnikDTO().getId()));

		
		
		
		student = studentService.save(student);
		return new ResponseEntity<>(new StudentMapper().modelToDto(student), HttpStatus.CREATED);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO){
		
		Student student = studentService.findOne(studentDTO.getId()); 
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		student.setIme(studentDTO.getIme());
		student.setPrezime(studentDTO.getPrezime());
		student.setIndeks(studentDTO.getIndeks());
		student.setEmail(studentDTO.getEmail());
		student.setActive(studentDTO.isActive());
		
		
		
		student.setStudijskaGodina(new HashSet<>(new StudijskaGodinaMapper().listDtoToModel(studentDTO.getStudijskeGodineDTO())));
		student.setDokumenti(new HashSet<>(new DokumentMapper().listDtoToModel(studentDTO.getDokumentiDTO())));
		student.setFinansijskaKartica(finansijskaKarticaService.findOne(studentDTO.getFinansijskaKarticaDTO().getId()));
		student.setPohadjanjePredmeta(new HashSet<>(new PohadjanjePredmetaMapper().listDtoToModel(studentDTO.getPohadjanjaPredmetaDTO())));
		student.setKorisnik(korisnikService.findOne(studentDTO.getKorisnikDTO().getId()));
		
		student = studentService.save(student);
		return new ResponseEntity<>(new StudentMapper().modelToDto(student), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if (student != null){
			studentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//veza za studgodina za student
	@RequestMapping(value="/studijskeGodIzStudenta/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<StudijskaGodinaDTO>> getStudijskeGodIzStudenta(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<StudijskaGodinaDTO> listaStudGodina = new ArrayList<>();
		for(StudijskaGodina godine : student.getStudijskaGodina()) {
			listaStudGodina.add(new StudijskaGodinaMapper().modelToDto(godine));
		}		
		return new ResponseEntity<>(listaStudGodina, HttpStatus.OK);
	}
	
	
	//veza za dokument  za student
	@RequestMapping(value="/dokumentiIzStudenta/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<DokumentDTO>> getDokumentiIzStudenta(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<DokumentDTO> listaDokumenata = new ArrayList<>();
		for(Dokument dokumenti : student.getDokumenti()) {
			listaDokumenata.add(new DokumentMapper().modelToDto(dokumenti));
		}		
		return new ResponseEntity<>(listaDokumenata, HttpStatus.OK);
	}
	
	//veza za finan kartica za student
	@RequestMapping(value="/finansijskaKarticaIzStudenta/{id}", method=RequestMethod.GET)
	public ResponseEntity<FinansijskaKarticaDTO> getFinansijskaKarticaIzStudenta(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new FinansijskaKarticaMapper().modelToDto(student.getFinansijskaKartica()), HttpStatus.OK);
	}
	
	
	//veza za pohadjanje  za student
	@RequestMapping(value="/pohadjanjaIzStudenta/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<PohadjanjePredmetaDTO>> getPohadjanjaIzStudenta(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<PohadjanjePredmetaDTO> listaPohadjanja = new ArrayList<>();
		for(PohadjanjePredmeta pohadjanje : student.getPohadjanjePredmeta()) {
			listaPohadjanja.add(new PohadjanjePredmetaMapper().modelToDto(pohadjanje));
		}		
		return new ResponseEntity<>(listaPohadjanja, HttpStatus.OK);
	}
	
	
	//veza za korisnik za student
	@RequestMapping(value="/korisnikIzStudenta/{id}", method=RequestMethod.GET)
	public ResponseEntity<KorisnikDTO> getKorisnikIzStudenta(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new KorisnikMapper().modelToDto(student.getKorisnik()), HttpStatus.OK);
	}

}
