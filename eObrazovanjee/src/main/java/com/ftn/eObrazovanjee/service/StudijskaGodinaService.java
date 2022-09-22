package com.ftn.eObrazovanjee.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.dto.IstorijaTransakcijaDTO;
import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.NacinFinansiranja;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.model.StudijskaGodina;
import com.ftn.eObrazovanjee.repository.StudentRepository;
import com.ftn.eObrazovanjee.repository.StudijskaGodinaRepository;

@Service
public class StudijskaGodinaService {
	
	@Autowired
	StudijskaGodinaRepository studijskaGodinaRepository;
	
	@Autowired
	public StudentRepository studentRepository;


	public StudijskaGodina findOne(Long id) {
		return studijskaGodinaRepository.findById(id).orElse(null);
	}

	public List<StudijskaGodina> findAll() {
		return studijskaGodinaRepository.findAll();
	}

	public StudijskaGodina save(StudijskaGodina studijskaGodina) {
		return studijskaGodinaRepository.save(studijskaGodina);
	}
	
	public void remove(Long id){
		studijskaGodinaRepository.deleteById(id);
	}
	
	public Page<StudijskaGodina> findAll(Pageable page) {
		return studijskaGodinaRepository.findAll(page);
	}
	
	
//	public List<StudijskaGodinaDTO> StudijskaGodinaStudentaNative(int studentId) throws Exception {
//		//public List<StudijskaGodinaDTO> StudijskaGodinaStudentaNative(Long studentId) throws Exception {
//		
//		Optional<Student> studentOptional = studentRepository.findById((long) studentId);
//		if(!studentOptional.isPresent()) {
//			throw new Exception("Student sa prosledjenim id-om ne postoji");
//		}
//		List<Object[]> nativeResponse = studijskaGodinaRepository.StudijskaGodinaStudentaNative(studentId);
//		List<StudijskaGodinaDTO> response = new ArrayList<StudijskaGodinaDTO>();
//		for(Object[] obj:nativeResponse) {
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//			
//			StudijskaGodinaDTO tmpObj = new StudijskaGodinaDTO(Long.parseLong(obj[0].toString()),formatter.parse(obj[1].toString()),
//					formatter.parse(obj[2].toString()) , NacinFinansiranja.valueOf(obj[3].toString()),
//					Integer.parseInt(obj[4].toString()), Integer.parseInt(obj[5].toString())) ;
//			System.out.println(Long.parseLong(obj[0].toString()));
//			response.add(tmpObj);
//		}
//
//		/*List<StudijskaGodina> studentskeGodine = studijskaGodinaRepository.findStudijskaGodinasByStudentId(studentId);
//		List<StudijskaGodinaDTO> studentskeGodineDto = new ArrayList<>();
//		for(StudijskaGodina sg:studentskeGodine) {
//			studentskeGodineDto.add(new StudijskaGodinaDTO(
//					sg.getId(),
//					sg.getPocetakStudija(),
//					sg.getKrajStudija(),
//					sg.getNacin_finansiranja(),
//					sg.getGodinaStudija(),
//					sg.getSkolskaGodina()
//			));
//		}
//
//		return studentskeGodineDto;*/
//		return response;
//	}
	
	
	//AKO IMA LOCALDATETIME ZA DATUME I DA SE CUVA TAKO STUDGODINA
	
	
	public List<StudijskaGodinaDTO> StudijskaGodinaStudentaNative(Long studentId) throws Exception {
		
		Optional<Student> studentOptional = studentRepository.findById((long) studentId);
		if(!studentOptional.isPresent()) {
			throw new Exception("Student sa prosledjenim id-om ne postoji");
		}
		System.out.println("Postoji student");
		List<Object[]> nativeResponse = studijskaGodinaRepository.StudijskaGodinaStudentaNative(studentId);
		List<StudijskaGodinaDTO> response = new ArrayList<StudijskaGodinaDTO>();
		for(Object[] obj:nativeResponse) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
System.out.println("OVDE UDJE");
			/*StudijskaGodinaDTO tmpObj = new StudijskaGodinaDTO(Long.parseLong(obj[0].toString()), formatter.parse(obj[1].toString()),
					formatter.parse(obj[1].toString()) , NacinFinansiranja.valueOf(obj[3].toString()),
					Integer.parseInt(obj[4].toString()), Integer.parseInt(obj[5].toString())) ;
			System.out.println(Long.parseLong(obj[0].toString()));
			response.add(tmpObj);*/

			//AKO IMA LOCALDATETIME UMESTO SAMO DATE IDA OVAKO
			StudijskaGodinaDTO tmpObj = new StudijskaGodinaDTO(Long.parseLong(obj[0].toString()), LocalDateTime.parse(obj[1].toString()),
					LocalDateTime.parse(obj[2].toString()) , NacinFinansiranja.valueOf(obj[3].toString()),
					Integer.parseInt(obj[4].toString()), Integer.parseInt(obj[5].toString())) ;
			System.out.println("++++++++++++++");
			System.out.println(Long.parseLong(obj[0].toString()));
			System.out.println();
			response.add(tmpObj);
		}

	/*	List<StudijskaGodina> studentskeGodine = studijskaGodinaRepository.findStudijskaGodinasByStudentId(studentId);
		List<StudijskaGodinaDTO> studentskeGodineDto = new ArrayList<>();
		for(StudijskaGodina sg:studentskeGodine) {
			studentskeGodineDto.add(new StudijskaGodinaDTO(
					sg.getId(),
					sg.getPocetakStudija(),
					sg.getKrajStudija(),
					sg.getNacin_finansiranja(),
					sg.getGodinaStudija(),
					sg.getSkolskaGodina()
			));
		}
		return studentskeGodineDto;
	 */

		return response;
	}


}
