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
import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.dto.KorisnikDTO;
import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.StudentDTO;
import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.mapper.DokumentMapper;
import com.ftn.eObrazovanjee.mapper.FinansijskaKarticaMapper;
import com.ftn.eObrazovanjee.mapper.IspitMapper;
import com.ftn.eObrazovanjee.mapper.KorisnikMapper;
import com.ftn.eObrazovanjee.mapper.PohadjanjePredmetaMapper;
import com.ftn.eObrazovanjee.mapper.StudentMapper;
import com.ftn.eObrazovanjee.mapper.StudijskaGodinaMapper;
import com.ftn.eObrazovanjee.model.Dokument;
import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.PohadjanjePredmeta;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.model.StudijskaGodina;
import com.ftn.eObrazovanjee.model.Uloga;
import com.ftn.eObrazovanjee.security.SecurityConfiguration;
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
	@Autowired
	SecurityConfiguration configuration;
	
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAllStudenti() {
		List<Student> studenti = studentService.findAll();
		
		List<StudentDTO> studentiDTO = new ArrayList<>();
		for (Student obj : studenti) {
			StudentDTO student = new StudentMapper().modelToDto(obj);
			student.setStudijskeGodineDTO(getStudijskeGodIzStudenta(student.getId()));
			student.setDokumentiDTO(getDokumentiIzStudenta(student.getId()));
			student.setFinansijskaKarticaDTO(getFinansijskaKarticaIzStudenta(student.getId()));
			student.setPohadjanjaPredmetaDTO(getPohadjanjaIzStudenta(student.getId()));
			student.setKorisnikDTO(getKorisnikIzStudenta(student.getId()));
			studentiDTO.add(student);
		}
		return new ResponseEntity<>(studentiDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getStudentiPage(Pageable page) {
		Page<Student> studenti = studentService.findAll(page);
		
		
		List<StudentDTO> studentiDTO = new ArrayList<>();
		for (Student obj : studenti) {
			StudentDTO student = new StudentMapper().modelToDto(obj);
			student.setStudijskeGodineDTO(getStudijskeGodIzStudenta(student.getId()));
			student.setDokumentiDTO(getDokumentiIzStudenta(student.getId()));
			student.setFinansijskaKarticaDTO(getFinansijskaKarticaIzStudenta(student.getId()));
			student.setPohadjanjaPredmetaDTO(getPohadjanjaIzStudenta(student.getId()));
			student.setKorisnikDTO(getKorisnikIzStudenta(student.getId()));
			studentiDTO.add(student);
		}
		return new ResponseEntity<>(studentiDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		StudentDTO studentDTO = new StudentMapper().modelToDto(student);
		studentDTO.setStudijskeGodineDTO(getStudijskeGodIzStudenta(student.getId()));
		studentDTO.setDokumentiDTO(getDokumentiIzStudenta(student.getId()));
		studentDTO.setFinansijskaKarticaDTO(getFinansijskaKarticaIzStudenta(student.getId()));
		studentDTO.setPohadjanjaPredmetaDTO(getPohadjanjaIzStudenta(student.getId()));
		studentDTO.setKorisnikDTO(getKorisnikIzStudenta(student.getId()));
		
		return new ResponseEntity<>(studentDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){		
		Student student = new Student();
		Korisnik korisnik = new Korisnik();
		
		Korisnik korisnik1 = new Korisnik();
		
		if(studentDTO == null) {
			System.out.println("student null");
		}
		
		if(studentDTO.getKorisnikDTO() == null) {
			System.out.println(studentDTO.getIme());
			System.out.println("korisnik null");
		}
		
		korisnik1.setKorisnickoIme(studentDTO.getKorisnikDTO().getKorisnickoIme());
		korisnik1.setLozinka(configuration.passwordEncoder().encode(studentDTO.getKorisnikDTO().getLozinka()));
		korisnik1.setUloga(Uloga.STUDENT);
		System.out.println(korisnik);
		
		student.setIme(studentDTO.getIme());
		student.setPrezime(studentDTO.getPrezime());
		student.setIndeks(studentDTO.getIndeks());
		student.setEmail(studentDTO.getEmail());
		student.setActive(studentDTO.isActive());
		student.setKorisnik(korisnik1);
		
		
		
		//student.setStudijskaGodina(new HashSet<>(new StudijskaGodinaMapper().listDtoToModel(studentDTO.getStudijskeGodineDTO())));
		//student.setDokumenti(new HashSet<>(new DokumentMapper().listDtoToModel(studentDTO.getDokumentiDTO())));
		//student.setFinansijskaKartica(finansijskaKarticaService.findOne(studentDTO.getFinansijskaKarticaDTO().getId()));
		//student.setPohadjanjePredmeta(new HashSet<>(new PohadjanjePredmetaMapper().listDtoToModel(studentDTO.getPohadjanjaPredmetaDTO())));
		//student.setKorisnik(korisnikService.findOne(studentDTO.getKorisnikDTO().getId()));

		
		
		
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
	//@RequestMapping(value="/studijskeGodIzStudenta/{id}", method=RequestMethod.GET)
	public ArrayList<StudijskaGodinaDTO> getStudijskeGodIzStudenta(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return null;
		}
		ArrayList<StudijskaGodinaDTO> listaStudGodina = new ArrayList<>();
		for(StudijskaGodina godine : student.getStudijskaGodina()) {
			listaStudGodina.add(new StudijskaGodinaMapper().modelToDto(godine));
		}		
		return listaStudGodina;
	}
	
	
	//veza za dokument  za student
	//@RequestMapping(value="/dokumentiIzStudenta/{id}", method=RequestMethod.GET)
	public ArrayList<DokumentDTO> getDokumentiIzStudenta(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return null;
		}
		ArrayList<DokumentDTO> listaDokumenata = new ArrayList<>();
		for(Dokument dokumenti : student.getDokumenti()) {
			listaDokumenata.add(new DokumentMapper().modelToDto(dokumenti));
		}		
		return listaDokumenata;
	}
	
	//veza za finan kartica za student
	//@RequestMapping(value="/finansijskaKarticaIzStudenta/{id}", method=RequestMethod.GET)
	public FinansijskaKarticaDTO getFinansijskaKarticaIzStudenta(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return  null;
		}
		return new FinansijskaKarticaMapper().modelToDto(student.getFinansijskaKartica());
	}
	
	
	//veza za pohadjanje  za student
	//@RequestMapping(value="/pohadjanjaIzStudenta/{id}", method=RequestMethod.GET)
	public ArrayList<PohadjanjePredmetaDTO> getPohadjanjaIzStudenta(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return null;
		}
		ArrayList<PohadjanjePredmetaDTO> listaPohadjanja = new ArrayList<>();
		for(PohadjanjePredmeta pohadjanje : student.getPohadjanjePredmeta()) {
			listaPohadjanja.add(new PohadjanjePredmetaMapper().modelToDto(pohadjanje));
		}		
		return listaPohadjanja;
	}
	
	
	//veza za korisnik za student
	//@RequestMapping(value="/korisnikIzStudenta/{id}", method=RequestMethod.GET)
	public KorisnikDTO getKorisnikIzStudenta(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return null;
		}
		return new KorisnikMapper().modelToDto(student.getKorisnik());
	}

}
