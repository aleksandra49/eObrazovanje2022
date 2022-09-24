package com.ftn.eObrazovanjee.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.eObrazovanjee.dto.DokumentDTO;
import com.ftn.eObrazovanjee.dto.FinansijskaKarticaDTO;
import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.dto.KorisnikDTO;
import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.PolaganjeIspitaDTO;
import com.ftn.eObrazovanjee.dto.ProfesorDTO;
import com.ftn.eObrazovanjee.dto.StudentDTO;
import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.mapper.DeoIspitaMapper;
import com.ftn.eObrazovanjee.mapper.DokumentMapper;
import com.ftn.eObrazovanjee.mapper.FinansijskaKarticaMapper;
import com.ftn.eObrazovanjee.mapper.IspitMapper;
import com.ftn.eObrazovanjee.mapper.KorisnikMapper;
import com.ftn.eObrazovanjee.mapper.PohadjanjePredmetaMapper;
import com.ftn.eObrazovanjee.mapper.PolaganjeIspitaMapper;
import com.ftn.eObrazovanjee.mapper.ProfesorMapper;
import com.ftn.eObrazovanjee.mapper.StudentMapper;
import com.ftn.eObrazovanjee.mapper.StudijskaGodinaMapper;
import com.ftn.eObrazovanjee.model.Dokument;
import com.ftn.eObrazovanjee.model.FinansijskaKartica;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.PohadjanjePredmeta;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.model.StudijskaGodina;
import com.ftn.eObrazovanjee.model.Uloga;
import com.ftn.eObrazovanjee.security.SecurityConfiguration;
import com.ftn.eObrazovanjee.service.DokumentService;
import com.ftn.eObrazovanjee.service.FinansijskaKarticaService;
import com.ftn.eObrazovanjee.service.IspitService;
import com.ftn.eObrazovanjee.service.KorisnikService;
import com.ftn.eObrazovanjee.service.PohadjanjePredmetaService;
import com.ftn.eObrazovanjee.service.PolaganjeIspitaService;
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
    private PolaganjeIspitaService polaganjeService;
	@Autowired
	private FinansijskaKarticaService finansijskaKarticaService;
	@Autowired
    private PohadjanjePredmetaService pohadjanjePredmetaService;
	@Autowired
    private KorisnikService korisnikService;
	@Autowired
	private IspitService ispitService;
	@Autowired
	SecurityConfiguration configuration;
	@Autowired
	FinansijskaKarticaMapper finMapper;
	
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAllStudenti() {
		List<Student> studenti = studentService.findAll();
		
		List<StudentDTO> studentiDTO = new ArrayList<>();
		for (Student obj : studenti) {
			StudentDTO student = new StudentMapper().modelToDto(obj);
			student.setStudijskeGodineDTO(getStudijskeGodIzStudenta(obj.getId()));
			student.setDokumentiDTO(getDokumentiIzStudenta(obj.getId()));
			student.setFinansijskaKarticaDTO(getFinansijskaKarticaIzStudenta(obj.getId()));
			student.setPohadjanjaPredmetaDTO(getPohadjanjaIzStudenta(obj.getId()));
			student.setKorisnik(getKorisnikIzStudenta(obj.getId()));
			student.setPolaganjeIspita(getPolaganjaIzStudenta(obj.getId()));
			studentiDTO.add(student);
		}
		return new ResponseEntity<>(studentiDTO, HttpStatus.OK);
	}
	
	@PostMapping("/check_username")
	public ResponseEntity<Boolean> createAuthenticationToken(@RequestBody String username) {
		
		List<Korisnik> korisnici = korisnikService.findAll();
		Boolean slobodan = true;
		for(Korisnik kor : korisnici) {
			if(kor.getUsername().equals(username)) {
				slobodan = false;
			}
		}
		
		if(slobodan == false) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>(slobodan, HttpStatus.OK);
		}
		
		
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
			student.setKorisnik(getKorisnikIzStudenta(student.getId()));
			student.setPolaganjeIspita(getPolaganjaIzStudenta(student.getId()));
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
		studentDTO.setKorisnik(getKorisnikIzStudenta(student.getId()));
		studentDTO.setPolaganjeIspita(getPolaganjaIzStudenta(student.getId()));
		
		return new ResponseEntity<>(studentDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/profil", method=RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudentProfil(@RequestParam Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		StudentDTO studentDTO = new StudentMapper().modelToDto(student);
		studentDTO.setStudijskeGodineDTO(getStudijskeGodIzStudenta(student.getId()));
		studentDTO.setDokumentiDTO(getDokumentiIzStudenta(student.getId()));
		studentDTO.setFinansijskaKarticaDTO(getFinansijskaKarticaIzStudenta(student.getId()));
		studentDTO.setPohadjanjaPredmetaDTO(getPohadjanjaIzStudenta(student.getId()));
		studentDTO.setKorisnik(getKorisnikIzStudenta(student.getId()));
		studentDTO.setPolaganjeIspita(getPolaganjaIzStudenta(student.getId()));
		
		return new ResponseEntity<>(studentDTO, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO){		
		Student student = new Student();
		Korisnik korisnik = new Korisnik();
		Korisnik korisnikProba = new Korisnik();
		FinansijskaKartica finansijskaKartica = new FinansijskaKartica();
		
//		Korisnik korisnik1 = new Korisnik();
//		korisnik1.setId(1L);
		Korisnik korisnik1 = new Korisnik();
		korisnik1.setKorisnickoIme(studentDTO.getKorisnik().getKorisnickoIme());
		korisnik1.setLozinka(configuration.passwordEncoder().encode(studentDTO.getKorisnik().getLozinka()));
		korisnik1.setUloga(Uloga.STUDENT);
		
		FinansijskaKartica finKartica = new FinansijskaKartica();
		//napraviti metodu da napravi random personalni broj
		//ne radi funkcija 178 linija
		//String personalniBroj = UUID.randomUUID().toString();
		//String personalniBroj = "1234";
		
		String personalniBroj = personalniBroj();

		String racunFakulteta = "840-1710666-12";
		int trenutnoStanje = 600;
		finKartica.setPersonalniBroj(personalniBroj);
		finKartica.setRacunFakulteta(racunFakulteta);
		finKartica.setTrenutnoStanje(trenutnoStanje);
		finKartica.setId(studentDTO.getId());

		
		student.setIme(studentDTO.getIme());
		student.setPrezime(studentDTO.getPrezime());
		student.setEmail(studentDTO.getEmail());
		student.setIndeks(studentDTO.getIndeks());
		student.setActive(studentDTO.isActive());
		student.setKorisnik(korisnik1);
		student.setFinansijskaKartica(finKartica);
		
		// profesor.setKorisnik(korisnik1);
		
		//	profesor.setPredavanja(new HashSet<>(new PredavanjePredmetaMapper().listDtoToModel(profesorDTO.getPredavanja())));
		
		korisnik = korisnikService.save(korisnik1);
	//	finansijskaKartica = finansijskaKarticaService.save(finKartica);
		
		
//		korisnikProba = korisnikService.findOne(korisnik1.getId());
		System.out.println(korisnik);
		
		student = studentService.save(student);
		finansijskaKartica = finansijskaKarticaService.save(finKartica);
		
		System.out.println(finKartica.getId());
		return new ResponseEntity<>(new StudentMapper().modelToDto(student), HttpStatus.CREATED);
	}
	
//	finansijskaKarticaService
	//treba da je string a ne integer
	public String personalniBroj(){
		List<FinansijskaKartica> kartice = finansijskaKarticaService.findAll();
		long najveci = Long.parseLong(kartice.get(0).getPersonalniBroj());
		
		for (FinansijskaKartica fin : kartice) {
			if(Long.parseLong(fin.getPersonalniBroj()) > najveci){
				najveci = Long.parseLong(fin.getPersonalniBroj());
			}
		}
		najveci = najveci + 77;
		String najveciString = String.valueOf(najveci);
		return najveciString;	
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
		
		if(studentDTO.getPolaganjeIspita() == null) {
			System.out.println("Polaganje je null");
			studentDTO.setPolaganjeIspita(new ArrayList<PolaganjeIspitaDTO>());
		}
		
		
		
		System.out.println(studentDTO.getFinansijskaKarticaDTO().getId());
		
		student.setStudijskaGodina(new HashSet<>(new StudijskaGodinaMapper().listDtoToModel(studentDTO.getStudijskeGodineDTO())));
		student.setDokumenti(new HashSet<>(new DokumentMapper().listDtoToModel(studentDTO.getDokumentiDTO())));
		student.setFinansijskaKartica(finansijskaKarticaService.findOne(studentDTO.getFinansijskaKarticaDTO().getId()));
		student.setPohadjanjePredmeta(new HashSet<>(new PohadjanjePredmetaMapper().listDtoToModel(studentDTO.getPohadjanjaPredmetaDTO())));
		student.setKorisnik(korisnikService.findOne(studentDTO.getKorisnik().getId()));
		student.setPolaganjeIspita(new HashSet<>(new PolaganjeIspitaMapper().listDtoToModel(studentDTO.getPolaganjeIspita())));
		
		student = studentService.save(student);
		return new ResponseEntity<>(new StudentMapper().modelToDto(student), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
		Student student = studentService.findOne(id);
		if (student != null){
			studentService.remove(id);
			deleteFinansijskaKartica(student.getFinansijskaKartica().getId());
			deleteKorisnik(student.getKorisnik().getId());
			
			
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public Void deleteKorisnik(Long id){
		Korisnik korisnik = korisnikService.findOne(id);
		if (korisnik != null){
			korisnikService.remove(id);
			return null;
		} else {		
			return null;
		}
	}
	
	public Void deleteFinansijskaKartica(Long id){
		FinansijskaKartica finansijskaKartica = finansijskaKarticaService.findOne(id);
		if (finansijskaKartica != null){
			finansijskaKarticaService.delete(id);
			return null;
		} else {		
			return null;
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
	public ArrayList<DokumentDTO> getDokumentiIzStudenta(Long id){
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
	public FinansijskaKarticaDTO getFinansijskaKarticaIzStudenta(Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return  null;
		}
		return new FinansijskaKarticaMapper().modelToDto(student.getFinansijskaKartica());
	}
	
	
	//veza za pohadjanje  za student
	//@RequestMapping(value="/pohadjanjaIzStudenta/{id}", method=RequestMethod.GET)
	public ArrayList<PohadjanjePredmetaDTO> getPohadjanjaIzStudenta(Long id){
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
	public KorisnikDTO getKorisnikIzStudenta( Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return null;
		}
		return new KorisnikMapper().modelFromStudentToDto(student.getKorisnik());
	}
	
	public ArrayList<PolaganjeIspitaDTO> getPolaganjaIzStudenta(Long id){
		Student student = studentService.findOne(id);
		if(student == null){
			return null;
		}
		ArrayList<PolaganjeIspitaDTO> listaPolaganja = new ArrayList<>();
		for(PolaganjeIspita polaganje : student.getPolaganjeIspita()) {
			listaPolaganja.add(new PolaganjeIspitaMapper().modelToDto(polaganje));
		}		
		return listaPolaganja;
	}

	
	
}
