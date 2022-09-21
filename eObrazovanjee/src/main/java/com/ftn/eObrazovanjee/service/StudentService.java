package com.ftn.eObrazovanjee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	//druga metoda gde sacuvamo i stud godinu ali ne sacuva i student id valjda.....
	/*public Student save(Student student) {

	StudijskaGodina sg = new StudijskaGodina(
			LocalDateTime.now(),
			LocalDateTime.now().plusYears(4),
			NacinFinansiranja.budzet,
			1,
			LocalDateTime.now().getYear(),
			student
	);

	student.getStudijskaGodina().add(sg);

	student = studentRepository.save(student);
	studijskaGodinaRepository.save(sg);

	return student;
}*/

	public void remove(Long id) {
		studentRepository.deleteById(id);
	}
	
	public Page<Student> findAll(Pageable page) {
		return studentRepository.findAll(page);
	}

//	public Student findByIndeks(String indeks) {
//		return studentRepository.findOneByIndeks(indeks);
//	}

//	public List<Student> findByKorisnickoIme(String korisnickoIme) {
//		return studentRepository.findAllByKorisnickoIme(korisnickoIme);
//	}

}
