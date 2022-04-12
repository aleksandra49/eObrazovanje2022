package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;

@Component
public class PohadjanjePredmetaToPohadjanjePredmetaDTO {
	
	@Autowired
	private ModelMapper modelMapper;

	public PohadjanjePredmetaDTO konvertujEntityToDto(PohadjanjePredmetaDTO pohadjanjePredmeta) {

		return modelMapper.map(pohadjanjePredmeta, PohadjanjePredmetaDTO.class);
	}

}
