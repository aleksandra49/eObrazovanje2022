package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.model.Ispit;

@Component
public class IspitToIspitDTO {

	@Autowired
	private ModelMapper modelMapper;

	public IspitDTO konvertujEntityToDto(Ispit obj) {

		return modelMapper.map(obj, IspitDTO.class);
	}
	
}
