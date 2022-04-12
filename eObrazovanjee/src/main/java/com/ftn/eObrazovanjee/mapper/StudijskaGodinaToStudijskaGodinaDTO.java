package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.StudijskaGodina;


@Component
public class StudijskaGodinaToStudijskaGodinaDTO {

	@Autowired
	private ModelMapper modelMapper;

	public StudijskaGodinaDTO konvertujEntityToDto(StudijskaGodina obj) {

		return modelMapper.map(obj, StudijskaGodinaDTO.class);
	}
}
