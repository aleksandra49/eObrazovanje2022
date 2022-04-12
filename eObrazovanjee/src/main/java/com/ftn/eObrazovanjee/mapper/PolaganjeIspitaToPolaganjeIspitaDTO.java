package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PolaganjeIspitaDTO;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;

@Component
public class PolaganjeIspitaToPolaganjeIspitaDTO {

	@Autowired
	private ModelMapper modelMapper;

	public PolaganjeIspitaDTO konvertujEntityToDto(PolaganjeIspita obj) {

		return modelMapper.map(obj, PolaganjeIspitaDTO.class);
	}
	
}
