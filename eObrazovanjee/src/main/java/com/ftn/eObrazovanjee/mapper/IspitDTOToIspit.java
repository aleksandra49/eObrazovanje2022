package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.model.Ispit;

@Component
public class IspitDTOToIspit {

	@Autowired
	private ModelMapper modelMapper;
	
	public Ispit konvertujDtoToEntity(IspitDTO objDTO) {
		
		Ispit obj = modelMapper.map(objDTO, Ispit.class);
		return obj;
	}
	
}
