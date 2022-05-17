package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.DokumentDTO;
import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.StudentDTO;
import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.service.StudentService;

@Component
public class StudentMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private StudentService service;

	/*public StudentDTO konvertujEntityToDto(Student student) {

		return modelMapper.map(student, StudentDTO.class);
	}*/
	
	
	public StudentDTO modelToDto(Student object) {
		
		StudentDTO objectDTO = new StudentDTO();
		
		objectDTO.setId(object.getId());
		objectDTO.setIme(object.getIme());
		objectDTO.setPrezime(object.getPrezime());
		objectDTO.setIndeks(object.getIndeks());
		objectDTO.setEmail(object.getEmail());
		objectDTO.setActive(object.isActive());
		
		//zakomentarisana fina kartica jer izaziva beskoancnu petlju
		objectDTO.setStudijskeGodineDTO(new ArrayList<StudijskaGodinaDTO>());
		objectDTO.setDokumentiDTO(new ArrayList<DokumentDTO>());
		//objectDTO.setFinansijskaKarticaDTO(new FinansijskaKarticaMapper().modelToDto(object.getFinansijskaKartica()));
		objectDTO.setPohadjanjaPredmetaDTO(new ArrayList<PohadjanjePredmetaDTO>());
		//objectDTO.setKorisnikDTO(new KorisnikMapper().modelToDto(object.getKorisnik()));
		
		return objectDTO;
	}
	
	public Set<Student> listDtoToModel(ArrayList<StudentDTO> listaDto) {
		Set<Student> listaModel = new HashSet<Student>();
		for (StudentDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
	}
	
	
//	public Student dtoToModel(StudentDTO objectDTO) {
//		
//		Student object = new Student();
//		
//		object.setId(objectDTO.getId());
//		object.setIme(objectDTO.getIme());
//		object.setPrezime(objectDTO.getPrezime());
//		object.setIndeks(objectDTO.getIndeks());
//		object.setEmail(objectDTO.getEmail());
//		object.setActive(objectDTO.isActive());
//		
//		//studgodina
//		//dokument
//		//finankartica
//		//pohadjanjepredmeta
//		//korisnik
//		
//		return object;
//	}

}
