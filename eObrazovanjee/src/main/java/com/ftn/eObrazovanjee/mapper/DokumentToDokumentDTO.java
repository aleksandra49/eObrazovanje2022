package com.ftn.eObrazovanjee.mapper;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.DokumentDTO;
import com.ftn.eObrazovanjee.model.Dokument;

@Component
public class DokumentToDokumentDTO {

	public DokumentDTO konvertujEntityToDto (Dokument dokument) {
		DokumentDTO dokumentDTO = new DokumentDTO() ;
		
		dokumentDTO.setId(dokument.getId());
		dokumentDTO.setNaziv(dokument.getNaziv());
		dokumentDTO.setUri(dokument.getUri());
		
		return dokumentDTO;
		
	}

}
