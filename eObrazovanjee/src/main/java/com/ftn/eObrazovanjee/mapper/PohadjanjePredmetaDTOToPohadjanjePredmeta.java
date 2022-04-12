package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.IspitniRokDTO;
import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.PohadjanjePredmeta;

@Component
public class PohadjanjePredmetaDTOToPohadjanjePredmeta {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PohadjanjePredmeta konvertujDtoToEntity(PohadjanjePredmetaDTO pohadjanjePredmetaDTO) {
		
		PohadjanjePredmeta pohadjanjePredmeta = modelMapper.map(pohadjanjePredmetaDTO, PohadjanjePredmeta.class);
		return pohadjanjePredmeta;
	}
	
//	public PohadjanjePredmeta konvertujDtoToEntity(PohadjanjePredmetaDTO pohadjanjePredmetaDTO) {
//		
//		PohadjanjePredmeta pohadjanjePredmeta = new PohadjanjePredmeta();
//		
//		pohadjanjePredmeta.setId(pohadjanjePredmetaDTO.getId());
//		pohadjanjePredmeta.setPocetak(pohadjanjePredmetaDTO.getPocetak());
//		//nastavi
//
//		
//		
//		
//		return pohadjanjePredmeta;
//	}

}
