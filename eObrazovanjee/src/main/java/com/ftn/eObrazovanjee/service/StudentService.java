package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.repository.StudentRepository;



@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student findOne(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void obrisi(Long id) {
		studentRepository.deleteById(id);
	}
	
	public Student findByIndeks(String indeks) {
		return studentRepository.findOneByIndeks(indeks);
	}
	
	public List<Student> findByKorisnickoIme(String korisnickoIme) {
		return studentRepository.findAllByKorisnickoIme(korisnickoIme);
	}

}
