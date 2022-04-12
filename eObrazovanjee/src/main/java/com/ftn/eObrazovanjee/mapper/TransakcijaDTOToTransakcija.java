package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.TransakcijaDTO;
import com.ftn.eObrazovanjee.model.Transakcija;


@Component
public class TransakcijaDTOToTransakcija {

	@Autowired
	private ModelMapper modelMapper;
	
	public Transakcija konvertujDtoToEntity(TransakcijaDTO objDTO) {
		
		Transakcija obj = modelMapper.map(objDTO, Transakcija.class);
		return obj;
	}
}
