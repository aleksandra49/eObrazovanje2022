package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.DokumentDTO;
import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.model.Dokument;
import com.ftn.eObrazovanjee.model.Ispit;

@Component
public class DokumentToDokumentDTO {

	@Autowired
	private ModelMapper modelMapper;

	public DokumentDTO konvertujEntityToDto(Dokument obj) {

		return modelMapper.map(obj, DokumentDTO.class);
	}
	
}
