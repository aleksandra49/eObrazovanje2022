package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.IspitniRokDTO;
import com.ftn.eObrazovanjee.model.IspitniRok;

@Component
public class IspitniRokDTOToIspitniRok {

	@Autowired
	private ModelMapper modelMapper;
	
	public IspitniRok konvertujDtoToEntity(IspitniRokDTO objDTO) {
		
		IspitniRok obj = modelMapper.map(objDTO, IspitniRok.class);
		return obj;
	}
	
}
