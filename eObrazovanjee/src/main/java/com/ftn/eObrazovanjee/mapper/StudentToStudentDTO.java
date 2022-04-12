package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.StudentDTO;
import com.ftn.eObrazovanjee.model.Student;

@Component
public class StudentToStudentDTO {
	
	@Autowired
	private ModelMapper modelMapper;

	public StudentDTO konvertujEntityToDto(Student student) {

		return modelMapper.map(student, StudentDTO.class);
	}

}
