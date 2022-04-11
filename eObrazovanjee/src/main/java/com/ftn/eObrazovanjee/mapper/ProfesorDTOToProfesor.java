package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.ProfesorDTO;
import com.ftn.eObrazovanjee.model.Profesor;

@Component
public class ProfesorDTOToProfesor {
	@Autowired
	private ModelMapper modelMapper;
	
	public Profesor konvertujDtoToEntity(ProfesorDTO profesorDTO) {
		
		Profesor profesor = modelMapper.map(profesorDTO, Profesor.class);
		return profesor;
	}
}
