package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ftn.eObrazovanjee.dto.FinansjskaKarticaDTO;
import com.ftn.eObrazovanjee.model.FinansijskaKartica;


public class FinansijskaKarticaToFinansijskaKarticaDTO {
	
	@Autowired
	private ModelMapper modelMapper;

	public FinansjskaKarticaDTO konvertujEntityToDto(FinansijskaKartica obj) {

		return modelMapper.map(obj, FinansjskaKarticaDTO.class);
	}

}
