package com.ftn.eObrazovanjee.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.dto.ProfesorPredmetDTO;
import com.ftn.eObrazovanjee.model.NacinFinansiranja;
import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.model.StudijskaGodina;
import com.ftn.eObrazovanjee.repository.StudentRepository;
import com.ftn.eObrazovanjee.repository.StudijskaGodinaRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudijskaGodinaRepository studijskaGodinaRepository;

	public Student findOne(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	/*public Student save(Student student) {
		return studentRepository.save(student);
	}*/
	
	//druga metoda gde sacuvamo i stud godinu ali ne sacuva i student id valjda.....
	public Student save(Student student) {

	StudijskaGodina sg = new StudijskaGodina(
			LocalDate.now(),
			LocalDate.now().plusYears(4),
			NacinFinansiranja.budzet,
			1,
			2022,
			//LocalDateTime.now().getYear(),
			student
	);

	student.getStudijskaGodina().add(sg);

	student = studentRepository.save(student);
	studijskaGodinaRepository.save(sg);

	return student;
}
	public List<ProfesorPredmetDTO> pohadjanjePredmeta(int idStudenta) throws Exception {
		// TODO Auto-generated method stub
		Optional<Student> profesorOptional = studentRepository.findById((long) idStudenta);
		if(!profesorOptional.isPresent()) {
			throw new Exception("Student sa prosledjenim id-om ne postoji");
		}
		List<Object[]> nativeResponse = studentRepository.pronadjiPredmeteKojeStudentPohadjaNative(idStudenta);
		List<ProfesorPredmetDTO> response = new ArrayList<ProfesorPredmetDTO>();
		for(Object[] obj:nativeResponse) {
			ProfesorPredmetDTO tmpObj = new ProfesorPredmetDTO(obj[0].toString(), obj[1].toString(),
					Integer.parseInt(obj[2].toString()));
			
			response.add(tmpObj);
		}
		System.out.println(response);
		return response;
		
	}

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
