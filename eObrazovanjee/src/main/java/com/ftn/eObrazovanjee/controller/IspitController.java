package com.ftn.eObrazovanjee.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.dto.IspitDodavanje;
import com.ftn.eObrazovanjee.dto.IspitIspitniRokDTO;
import com.ftn.eObrazovanjee.dto.IspitiZaOcenjivanjeDTO;
import com.ftn.eObrazovanjee.dto.IspitniRokDTO;
import com.ftn.eObrazovanjee.dto.IstorijaPolaganjaDTO;
import com.ftn.eObrazovanjee.dto.PolaganjeIspitaDTO;
import com.ftn.eObrazovanjee.dto.PolozenPredmetDTO;
import com.ftn.eObrazovanjee.dto.PredmetInstancaDTO;
import com.ftn.eObrazovanjee.dto.PrijavljeniIspitiDTO;
import com.ftn.eObrazovanjee.mapper.DeoIspitaMapper;
import com.ftn.eObrazovanjee.mapper.IspitMapper;
import com.ftn.eObrazovanjee.mapper.IspitniRokMapper;
import com.ftn.eObrazovanjee.mapper.PolaganjeIspitaMapper;
import com.ftn.eObrazovanjee.mapper.PredmetInstancaMapper;
import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.model.FinansijskaKartica;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.IspitniRok;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.model.Transakcija;
import com.ftn.eObrazovanjee.repository.IspitRepository;
import com.ftn.eObrazovanjee.repository.TransakcijaRepository;
import com.ftn.eObrazovanjee.service.DeoIspitaService;
import com.ftn.eObrazovanjee.service.FinansijskaKarticaService;
import com.ftn.eObrazovanjee.service.IspitService;
import com.ftn.eObrazovanjee.service.IspitniRokService;
import com.ftn.eObrazovanjee.service.PolaganjeIspitaService;
import com.ftn.eObrazovanjee.service.PredmetInstancaServiceImpl;
import com.ftn.eObrazovanjee.service.StudentService;
import com.ftn.eObrazovanjee.service.TransakcijaService;


@RestController
@RequestMapping(value="api/ispit")
public class IspitController {

	
	@Autowired
	private StudentService studentService;
	@Autowired
	private IspitService ispitService;
	@Autowired
	private IspitniRokService ispitniRokService;
	@Autowired
	private IspitRepository ispitRepository;
	@Autowired
	private PredmetInstancaServiceImpl predmetInstancaServiceImpl;
	@Autowired
	private PolaganjeIspitaService polaganjeIspitaService;
	@Autowired
    private DeoIspitaService deoIspitaService;
	@Autowired
	private TransakcijaService transakcijaService;
	@Autowired
	private TransakcijaRepository transakcijaRepository;
	@Autowired
	private FinansijskaKarticaService finansijskaKarticaService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<IspitDTO>> getAllIspiti() {
		List<Ispit> ispiti = ispitService.findAll();
		
		List<IspitDTO> ispitiDTO = new ArrayList<>();
		for (Ispit obj : ispiti) {
			IspitDTO ispit = new IspitMapper().modelToDto(obj);
			ispit.setPredmetInstanca(getPredmetInstancaIzIspita(ispit.getId()));
			ispit.setDeoIspitaDTO(getDeoIspitaIzIspita(ispit.getId()));
			ispit.setIspitniRok(getIspitniRokIzIspita(ispit.getId()));
			ispit.setPolaganjeIspita(getPolaganjeIspitaIzIspita(ispit.getId()));
			ispitiDTO.add(ispit);
		}
		return new ResponseEntity<>(ispitiDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<IspitDTO>> getIspitiPage(Pageable page) {
		Page<Ispit> ispiti = ispitService.findAll(page);
		
		
		List<IspitDTO> ispitiDTO = new ArrayList<>();
		for (Ispit obj : ispiti) {
			IspitDTO ispit = new IspitMapper().modelToDto(obj);
			ispit.setPredmetInstanca(getPredmetInstancaIzIspita(ispit.getId()));
			ispit.setDeoIspitaDTO(getDeoIspitaIzIspita(ispit.getId()));
			ispit.setIspitniRok(getIspitniRokIzIspita(ispit.getId()));
			ispit.setPolaganjeIspita(getPolaganjeIspitaIzIspita(ispit.getId()));
			ispitiDTO.add(ispit);
		}
		return new ResponseEntity<>(ispitiDTO, HttpStatus.OK);
	}
	
	@GetMapping("/ispitniRok")
	public ResponseEntity<?> NepolozeniIspitiZaStudenta(@RequestParam("idIspitnogRoka") int idIspitnogRoka){
		try {
			List<IspitIspitniRokDTO> response = ispitService.pronadjiIspiteIzIspitnogRoka(idIspitnogRoka);
			return new ResponseEntity<List<IspitIspitniRokDTO>>(response, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value ="/prijavaIspita", method=RequestMethod.POST)
	public ResponseEntity<?> PrijavaIspita(@RequestParam Long ispitId, @RequestParam Long studentId){
		try {
			Ispit ispit = ispitService.findOne((long) ispitId);
			Student student = studentService.findOne((long) studentId);
			Boolean proveraNaplate = false;
			Boolean proveraPrijave = false;
			
			saveTransakcija(student.getFinansijskaKartica(), -200, student.getId());
			proveraNaplate = naplataPrijave(student);
			proveraPrijave = proveraPrijave(student, ispit);
			
			//pod ovim uslovom je promena stanja na kartici uspela i ispit nije vec prijavljen
			if(proveraNaplate == true && proveraPrijave == false) {
				ispitRepository.prijaviIspitNative(ispitId,studentId);
			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	

	public Transakcija saveTransakcija(FinansijskaKartica finansijskaKartica, int iznos, Long studentId ){		
		Transakcija transakcija = new Transakcija();
		
		transakcija.setDatum(new Date());
		transakcija.setSvrha("Prijava ispita");
		transakcija.setPromenaStanja(iznos);
		transakcija.setFinansijskaKartica(finansijskaKartica);
		
		transakcija = transakcijaService.save(transakcija);
		Long transakcijaId = transakcija.getId();
		transakcijaRepository.FinansijskaKarticaTransakcijeNative(studentId,transakcijaId);
		
		
		
		return transakcija;	
	}
	
	public Transakcija saveTransakcijaOdjava(FinansijskaKartica finansijskaKartica, int iznos, Long studentId ){		
		Transakcija transakcija = new Transakcija();
		
		transakcija.setDatum(new Date());
		transakcija.setSvrha("Odjava ispita");
		transakcija.setPromenaStanja(iznos);
		transakcija.setFinansijskaKartica(finansijskaKartica);
		
		transakcija = transakcijaService.save(transakcija);
		Long transakcijaId = transakcija.getId();
		transakcijaRepository.FinansijskaKarticaTransakcijeNative(studentId,transakcijaId);
		
		
		
		return transakcija;	
	}
	
	public Boolean naplataPrijave(Student student){		
		FinansijskaKartica finansijskaKartica = finansijskaKarticaService.findOne(student.getFinansijskaKartica().getId());
		
		finansijskaKartica.setTrenutnoStanje(finansijskaKartica.getTrenutnoStanje() - 200);
		
		finansijskaKartica = finansijskaKarticaService.save(finansijskaKartica);
		return true;	
	}
	
	public Boolean povracajOdjave(Student student){		
		FinansijskaKartica finansijskaKartica = finansijskaKarticaService.findOne(student.getFinansijskaKartica().getId());
		
		finansijskaKartica.setTrenutnoStanje(finansijskaKartica.getTrenutnoStanje() + 200);
		
		finansijskaKartica = finansijskaKarticaService.save(finansijskaKartica);
		return true;	
	}
	
	public Boolean proveraPrijave(Student student, Ispit ispit){		
		List<PolaganjeIspita> polaganja = polaganjeIspitaService.findAll();
		
		Boolean provera = false;
		
		for(PolaganjeIspita polaganje : polaganja) {
			if(polaganje.getIspit().getId() == ispit.getId() && polaganje.getStudent().getId() == student.getId()) {
				provera = true;
			}
		}
	
		return provera;	
	}

	
	@RequestMapping(value ="/ocenjivanjeIspita", method=RequestMethod.POST)
	public ResponseEntity<?> ocenjivanjeIspita(@RequestParam Long polozenIspitId, @RequestParam Long broj_bodova){
		try {

			ispitRepository.ocenjivanjeNative(polozenIspitId,broj_bodova);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value ="/odjavaIspita", method=RequestMethod.DELETE)
	public ResponseEntity<?> OdjavaIspita(@RequestParam Long prijavljenIspitId,@RequestParam Long idStudenta){
		try {			
			Student student = studentService.findOne(idStudenta);
			povracajOdjave(student);
			saveTransakcijaOdjava(student.getFinansijskaKartica(), +200, student.getId());
			
			ispitRepository.odjaviIspitNative(prijavljenIspitId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	//drugi nacin
	@GetMapping("/prijavljeniIspiti")
	public ResponseEntity<?> prijavljeniIspiti(@RequestParam("idStudenta") int idStudenta){
		try {
			List<PrijavljeniIspitiDTO> response = ispitService.pronadjiPrijavljeneIspiteNative(idStudenta);
			
			return new ResponseEntity<List<PrijavljeniIspitiDTO>>(response, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	//drugi nacin
	@GetMapping("/istorijaPolaganja")
	public ResponseEntity<?> istorijaPolaganja(@RequestParam("idStudenta") int idStudenta){
		try {
			List<IstorijaPolaganjaDTO> response = ispitService.istorijaPolaganjaNative(idStudenta);
			
			return new ResponseEntity<List<IstorijaPolaganjaDTO>>(response, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	//drugi nacin
//	@GetMapping("/ispitiZaOcenjivanje/{id}")
	@RequestMapping(value="/ispitiZaOcenjivanje/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> pronadjiIspiteZaOcenjivanje(@PathVariable Long id){
		try {
			List<IspitiZaOcenjivanjeDTO> response = ispitService.pronadjiIspiteZaOcenjivanjeNative(id);
			
			return new ResponseEntity<List<IspitiZaOcenjivanjeDTO>>(response, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<IspitDTO> getIspit(@PathVariable Long id){
		Ispit ispit = ispitService.findOne(id);
		if(ispit == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		IspitDTO ispitDTO = new IspitMapper().modelToDto(ispit);
		ispitDTO.setPredmetInstanca(getPredmetInstancaIzIspita(ispit.getId()));
		ispitDTO.setDeoIspitaDTO(getDeoIspitaIzIspita(ispit.getId()));
		ispitDTO.setIspitniRok(getIspitniRokIzIspita(ispit.getId()));
		ispitDTO.setPolaganjeIspita(getPolaganjeIspitaIzIspita(ispit.getId()));
		
		return new ResponseEntity<>(ispitDTO, HttpStatus.OK);
	}
	
//	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
//	public ResponseEntity<IspitDTO> saveIspit(@RequestBody IspitDTO ispitDTO){		
//		Ispit ispit = new Ispit();
//		ispit.setNaziv(ispitDTO.getNaziv());
//		ispit.setDatumVreme(ispitDTO.getDatumVreme());
//		ispit.setPolaganjeIspita(new HashSet<>(new PolaganjeIspitaMapper().listDtoToModel(ispitDTO.getPolaganjeIspita())));
//		ispit.setIspitniRok(ispitniRokService.findOne(ispitDTO.getIspitniRok().getId()));
//		ispit.setDeoIspita(new HashSet<>(new DeoIspitaMapper().listDtoToModel(ispitDTO.getDeoIspitaDTO())));
//		ispit.setPredmetInstanca(predmetInstancaServiceImpl.findOne(ispitDTO.getPredmetInstanca().getId()));
//		
//		ispit = ispitService.save(ispit);
//		return new ResponseEntity<>(new IspitMapper().modelToDto(ispit), HttpStatus.CREATED);	
//	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<IspitDodavanje> saveIspit(@RequestBody IspitDodavanje ispitDTO){		
		Ispit ispit = new Ispit();
		ispit.setNaziv(ispitDTO.getNaziv());
		
		ispit.setDatumVreme(ispitDTO.getDatumVreme());
		ispit.setIspitniRok(ispitniRokService.findOne(ispitDTO.getIspitniRokId()));
		ispit.setPredmetInstanca(predmetInstancaServiceImpl.findOne(ispitDTO.getPredmetId()));
		
		ispit = ispitService.save(ispit);
		return new ResponseEntity<>(HttpStatus.CREATED);	
	}
	
	
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<IspitDTO> updateIspit(@RequestBody IspitDTO ispitDTO){
		
		Ispit ispit = ispitService.findOne(ispitDTO.getId()); 
		if (ispit == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		ispit.setNaziv(ispitDTO.getNaziv());
		ispit.setDatumVreme(ispitDTO.getDatumVreme());
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
			
			for(DeoIspita deo : ispit.getDeoIspita()) {
				deleteDeoIspita(deo.getId());
			}
			for(PolaganjeIspita deo : ispit.getPolaganjeIspita()) {
				deletePolaganjeIspita(deo.getId());
			}
			
			ispitService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public Void deleteDeoIspita(Long id){
		DeoIspita deoIspita = deoIspitaService.findOne(id);
		if (deoIspita != null){
			deoIspitaService.remove(id);
		}
		return null;
	}
	
	public Void deletePolaganjeIspita(Long id){
		PolaganjeIspita deoIspita = polaganjeIspitaService.findOne(id);
		if (deoIspita != null){
			polaganjeIspitaService.remove(id);
		}
		return null;
	}
	
//	@RequestMapping(value="/getPolaganjeIspitaIzIspita/{id}", method=RequestMethod.GET)
	public ArrayList<PolaganjeIspitaDTO> getPolaganjeIspitaIzIspita(Long id){
		Ispit ispit = ispitService.findOne(id);
		if(ispit == null){
			return null;
		}
		ArrayList<PolaganjeIspitaDTO> listaPolaganja = new ArrayList<>();
		for(PolaganjeIspita polaganje : ispit.getPolaganjeIspita()) {
			listaPolaganja.add(new PolaganjeIspitaMapper().modelToDto(polaganje));
		}		
		return listaPolaganja;
	}
	
//	@RequestMapping(value="/getDeoIspitaIzIspita/{id}", method=RequestMethod.GET)
	public ArrayList<DeoIspitaDTO> getDeoIspitaIzIspita(Long id){
		Ispit ispit = ispitService.findOne(id);
		if(ispit == null){
			return null;
		}
		ArrayList<DeoIspitaDTO> listaDelova = new ArrayList<>();
		for(DeoIspita delovi : ispit.getDeoIspita()) {
			listaDelova.add(new DeoIspitaMapper().modelToDto(delovi));
		}		
		return listaDelova;
	}
	
//	@RequestMapping(value="/getIspitniRokIzIspita/{id}", method=RequestMethod.GET)
	public IspitniRokDTO getIspitniRokIzIspita(Long id){
		Ispit ispit = ispitService.findOne(id);
		if(ispit == null){
			return null;
		}
		return new IspitniRokMapper().modelToDto(ispit.getIspitniRok());
	}
	
//	@RequestMapping(value="/getPredmetInstancaIzIspita/{id}", method=RequestMethod.GET)
	public PredmetInstancaDTO getPredmetInstancaIzIspita(Long id){
		Ispit ispit = ispitService.findOne(id);
		if(ispit == null){
			return null;
		}
		return new PredmetInstancaMapper().modelToDto(ispit.getPredmetInstanca());
	}
	
}
