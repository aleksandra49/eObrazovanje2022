package com.ftn.eObrazovanjee.mapper;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.StudentDTO;
import com.ftn.eObrazovanjee.model.Student;

@Component
public class StudentMapper {
	
	@Autowired
    private ModelMapper modelMapper;

//    public StudentDTO convertToDto(Student student) {
//        return modelMapper.map(student, StudentDTO.class);
//    }
//
//    /*public Set<StudentDTO> convertToDtos(Page<Student> studentPage) {
//        return studentPage.stream().map(this::convertToDto).collect(Collectors.toSet());
//    }*/
//
//    public Student convertToEntity(StudentDTO studentDTO) {
//        return modelMapper.map(studentDTO, Student.class);
//    }
//
//    public Set<Student> convertToEntities(Collection<StudentDTO> studentDTOS) {
//        return studentDTOS
//                .stream()
//                .map(this::convertToEntity)
//                .collect(Collectors.toSet());
//    }

}
