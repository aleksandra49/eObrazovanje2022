package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.StudentDTO;
import com.ftn.eObrazovanjee.model.Student;

@Component
public class StudentDTOToStudent {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Student konvertujDtoToEntity(StudentDTO studentDTO) {
		
		Student student = modelMapper.map(studentDTO, Student.class);
		return student;
	}

}
