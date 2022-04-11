package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.ProfesorDTO;
import com.ftn.eObrazovanjee.model.Profesor;

@Component
public class ProfesorToProfesorDTO {
	@Autowired
	private ModelMapper modelMapper;

	public ProfesorDTO konvertujEntityToDto(Profesor profesor) {

		return modelMapper.map(profesor, ProfesorDTO.class);
	}

	public List<ProfesorDTO> konvertujEntityToDto(List<Profesor> profesor) {
		List<ProfesorDTO> listaProfesora = new ArrayList<ProfesorDTO>();
		for (Profesor profesori : profesor) {
			listaProfesora.add(konvertujEntityToDto(profesori));
		}
		return listaProfesora;
	}
}
