package com.ftn.eObrazovanjee.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.dto.IspitIspitniRokDTO;
import com.ftn.eObrazovanjee.dto.PolozenPredmetDTO;
import com.ftn.eObrazovanjee.dto.PrijavljeniIspitiDTO;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.IspitniRok;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.repository.IspitRepository;
import com.ftn.eObrazovanjee.repository.IspitniRokRepository;
import com.ftn.eObrazovanjee.repository.StudentRepository;

import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;



@Service
public class IspitService {

	@Autowired
	IspitRepository repository;
	
	@Autowired
	IspitniRokRepository ispitniRokRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentService studentService;
	
	public Ispit findOne(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	
	public List<Ispit> findAll() {

		return repository.findAll();
	}
	
	public List<IspitIspitniRokDTO> pronadjiIspiteIzIspitnogRoka(int idIspitnogRoka) throws Exception {
		// TODO Auto-generated method stub
		Optional<IspitniRok> studentOptional = ispitniRokRepository.findById((long) idIspitnogRoka);
		if(!studentOptional.isPresent()) {
			throw new Exception("Student sa prosledjenim id-om ne postoji");
		}
		List<Object[]> nativeResponse = repository.pronadjiIspiteIzIspitnogRokaNative(idIspitnogRoka);
		List<IspitIspitniRokDTO> response = new ArrayList<IspitIspitniRokDTO>();
		for(Object[] obj:nativeResponse) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			IspitIspitniRokDTO tmpObj = new IspitIspitniRokDTO(Integer.parseInt(obj[0].toString()),obj[1].toString(),formatter.parse(obj[2].toString()),
					obj[3].toString());
			response.add(tmpObj);
		}
		return response;
	}
	
	public List<PrijavljeniIspitiDTO> pronadjiPrijavljeneIspiteNative(int studentId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Student> studentOptional = studentRepository.findById((long) studentId);
		if(!studentOptional.isPresent()) {
			throw new Exception("Student sa prosledjenim id-om ne postoji");
		}
		List<Object[]> nativeResponse = repository.pronadjiPrijavljeneIspiteNative(studentId);
		List<PrijavljeniIspitiDTO> response = new ArrayList<PrijavljeniIspitiDTO>();
		for(Object[] obj:nativeResponse) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			PrijavljeniIspitiDTO tmpObj = new PrijavljeniIspitiDTO(Long.parseLong(obj[0].toString()),obj[1].toString(),
					formatter.parse(obj[2].toString()));
			System.out.println(Long.parseLong(obj[0].toString()));
			response.add(tmpObj);
		}
		return response;
	}
	

	
	public Ispit save(Ispit ispit) {
		return repository.save(ispit);
		
	}
	
	
	public void remove(Long id){
		repository.deleteById(id);
	}
	
	public Page<Ispit> findAll(Pageable page) {
		return repository.findAll(page);
	}
	
}
