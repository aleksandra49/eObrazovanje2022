package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.StudijskaGodina;


@Component
public class StudijskaGodinaDTOToStudijskaGodina {
	

	@Autowired
	private ModelMapper modelMapper;
	
	public StudijskaGodina konvertujDtoToEntity(StudijskaGodinaDTO objDTO) {
		
		StudijskaGodina obj = modelMapper.map(objDTO, StudijskaGodina.class);
		return obj;
	}
	

}
