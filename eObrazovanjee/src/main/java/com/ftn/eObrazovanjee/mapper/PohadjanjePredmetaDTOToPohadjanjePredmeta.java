package com.ftn.eObrazovanjee.mapper;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.PohadjanjePredmeta;
import com.ftn.eObrazovanjee.model.StudijskaGodina;

@Component
public class PohadjanjePredmetaDTOToPohadjanjePredmeta {
	
	public PohadjanjePredmeta konvertujDtoToEntity(PohadjanjePredmetaDTO pohadjanjePredmetaDTO) {
		
		PohadjanjePredmeta pohadjanjePredmeta = new PohadjanjePredmeta();
		
		pohadjanjePredmeta.setId(pohadjanjePredmetaDTO.getId());
		pohadjanjePredmeta.setPocetak(pohadjanjePredmetaDTO.getPocetak());
		//nastavi

		
		
		
		return pohadjanjePredmeta;
	}

}
