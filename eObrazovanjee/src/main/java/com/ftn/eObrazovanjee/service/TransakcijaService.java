package com.ftn.eObrazovanjee.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.dto.IstorijaTransakcijaDTO;
import com.ftn.eObrazovanjee.dto.PrijavljeniIspitiDTO;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.model.Transakcija;
import com.ftn.eObrazovanjee.repository.StudentRepository;
import com.ftn.eObrazovanjee.repository.TransakcijaRepository;

@Service
public class TransakcijaService {
	
	@Autowired
	public TransakcijaRepository transakcijaRepository;
	

	@Autowired
	public StudentRepository studentRepository;

	public List<Transakcija> findAll() {
		return transakcijaRepository.findAll();
	}
	
	public Transakcija findOne(Long id) {
		return transakcijaRepository.findById(id).orElse(null);
	}
	
	public Transakcija save(Transakcija transakcija) {
		return transakcijaRepository.save(transakcija);
	}
	
	public Page<Transakcija> findAll(Pageable page) {
		return transakcijaRepository.findAll(page);
	}

	public void delete (Long id) {
		transakcijaRepository.deleteById(id);
	}
	
	
	public List<IstorijaTransakcijaDTO> istorijaTransakcijaNative(int studentId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Student> studentOptional = studentRepository.findById((long) studentId);
		if(!studentOptional.isPresent()) {
			throw new Exception("Student sa prosledjenim id-om ne postoji");
		}
		List<Object[]> nativeResponse = transakcijaRepository.IstorijaTransakcijaNative(studentId);
		List<IstorijaTransakcijaDTO> response = new ArrayList<IstorijaTransakcijaDTO>();
		for(Object[] obj:nativeResponse) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			IstorijaTransakcijaDTO tmpObj = new IstorijaTransakcijaDTO(Long.parseLong(obj[0].toString()),formatter.parse(obj[1].toString()),
					Double.parseDouble(obj[2].toString()) ,obj[3].toString(), obj[4].toString(), obj[5].toString(), Double.parseDouble(obj[6].toString())) ;
			System.out.println(Long.parseLong(obj[0].toString()));
			response.add(tmpObj);
		}
		return response;
	}
}
