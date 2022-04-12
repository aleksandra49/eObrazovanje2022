package com.ftn.eObrazovanjee.mapper;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.StudijskaGodina;

@Component
public class StudijskaGodinaDTOToStudijskaGodina {
	
	public StudijskaGodina konvertujDtoToEntity(StudijskaGodinaDTO studijskaGodinaDTO) {
		
		StudijskaGodina studijskaGodina = new StudijskaGodina();
		
		studijskaGodina.setId(studijskaGodinaDTO.getId());
		studijskaGodina.setPocetakStudija(studijskaGodinaDTO.getPocetakStudija());
		studijskaGodina.setKrajStudija(studijskaGodinaDTO.getKrajStudija());
		//studijskaGodina.setNacinFinansiranja(studijskaGodinaDTO.getNacinFinansiranja());
		studijskaGodina.setGodinaStudija(studijskaGodinaDTO.getGodinaStudija());
		studijskaGodina.setSkolskaGodina(studijskaGodinaDTO.getSkolskaGodina());
		
		
		
		return studijskaGodina;
	}
	
	


}
