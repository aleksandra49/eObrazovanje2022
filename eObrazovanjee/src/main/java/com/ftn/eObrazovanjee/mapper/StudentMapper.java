package com.ftn.eObrazovanjee.mapper;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.dto.StudentDTO;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.Student;

@Component
public class StudentMapper {
	
	@Autowired
	private ModelMapper modelMapper;

	/*public StudentDTO konvertujEntityToDto(Student student) {

		return modelMapper.map(student, StudentDTO.class);
	}*/
	
	
	public Student dtoToModel(StudentDTO objectDTO) {
		
		Student object = new Student();
		
		object.setId(objectDTO.getId());
		object.setIme(objectDTO.getIme());
		object.setPrezime(objectDTO.getPrezime());
		object.setIndeks(objectDTO.getIndeks());
		object.setEmail(objectDTO.getEmail());
		object.setActive(objectDTO.isActive());
		
		//studgodina
		//dokument
		//finankartica
		//pohadjanjepredmeta
		//korisnik
		
		return object;
	}
	
	public StudentDTO modelToDto(Student object) {
		
		StudentDTO objectDTO = new StudentDTO();
		
		object.setId(objectDTO.getId());
		objectDTO.setIme(object.getIme());
		objectDTO.setPrezime(object.getPrezime());
		objectDTO.setIndeks(object.getIndeks());
		object.setEmail(objectDTO.getEmail());
		objectDTO.setActive(object.isActive());
		
		//studgodina
		//dokument
		//finankartica
		//pohadjanjepredmeta
		//korisnik
		
		return objectDTO;
	}
	
	public Set<Student> listDtoToModel(Set<StudentDTO> listaDto) {
		Set<Student> listaModel = new HashSet<Student>();
		for (StudentDTO objectDTO : listaDto) {
			listaModel.add(dtoToModel(objectDTO));
		}
		return listaModel;
	}

}
