package com.ftn.eObrazovanjee.mapper;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.DokumentDTO;
import com.ftn.eObrazovanjee.model.Dokument;

@Component
public class DokumentDTOToDokument {
	
public Dokument konvertujDtoToEntity(DokumentDTO dokumentDTO) {
		
	Dokument dokument = new Dokument();
		
	dokument.setId(dokumentDTO.getId());
	dokument.setNaziv(dokumentDTO.getNaziv());
	dokument.setUri(dokumentDTO.getUri());
		
	return dokument;
	}

}
