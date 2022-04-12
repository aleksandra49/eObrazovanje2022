package com.ftn.eObrazovanjee.mapper;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.StudijskaGodina;

@Component
public class StudijskaGodinaToStudijskaGodinaDTO {
	
	public StudijskaGodinaDTO konvertujEntityToDto(StudijskaGodina studijskaGodina) {
		StudijskaGodinaDTO studijskaGodinaDTO = new StudijskaGodinaDTO();
		
		studijskaGodinaDTO.setPocetakStudija(studijskaGodina.getPocetakStudija());
		studijskaGodinaDTO.setKrajStudija(studijskaGodina.getKrajStudija());
		//studijskaGodinaDTO.setNacinFinansiranja(studijskaGodina.getNacinFinansiranja());
		studijskaGodinaDTO.setGodinaStudija(studijskaGodina.getGodinaStudija());
		studijskaGodinaDTO.setSkolskaGodina(studijskaGodina.getSkolskaGodina());
	
		return studijskaGodinaDTO;
	}
	
	//student

}
