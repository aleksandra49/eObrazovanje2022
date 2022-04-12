package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.IspitniRokDTO;
import com.ftn.eObrazovanjee.model.IspitniRok;

@Component
public class IspitniRokToIspitniRokDTO {

	@Autowired
	private ModelMapper modelMapper;

	public IspitniRokDTO konvertujEntityToDto(IspitniRok obj) {

		return modelMapper.map(obj, IspitniRokDTO.class);
	}
	
}
