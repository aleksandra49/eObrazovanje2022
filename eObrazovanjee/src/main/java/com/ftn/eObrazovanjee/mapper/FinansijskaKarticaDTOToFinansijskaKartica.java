package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ftn.eObrazovanjee.dto.FinansijskaKarticaDTO;
import com.ftn.eObrazovanjee.model.FinansijskaKartica;

public class FinansijskaKarticaDTOToFinansijskaKartica {

	@Autowired
	private ModelMapper modelMapper;
	
	public FinansijskaKartica konvertujDtoToEntity(FinansijskaKarticaDTO objDTO) {
		
		FinansijskaKartica obj = modelMapper.map(objDTO, FinansijskaKartica.class);
		return obj;
	}
}
