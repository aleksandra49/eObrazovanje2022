package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredmetInstancaDTO;
import com.ftn.eObrazovanjee.model.PredmetInstanca;

@Component
public class PredmetInstancaDTOToPredmetInstanca {
	@Autowired
	private ModelMapper modelMapper;
	
	public PredmetInstanca konvertujDtoToEntity(PredmetInstancaDTO predmetInstancaDTO) {
		
		PredmetInstanca predmetInstanca = modelMapper.map(predmetInstancaDTO, PredmetInstanca.class);
		return predmetInstanca;
	}
}
