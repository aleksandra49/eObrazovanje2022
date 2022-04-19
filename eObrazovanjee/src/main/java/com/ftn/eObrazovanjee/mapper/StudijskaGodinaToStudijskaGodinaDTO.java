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
//
//	public StudijskaGodinaDTO konvertujEntityToDto(StudijskaGodina obj) {
//
//		return modelMapper.map(obj, StudijskaGodinaDTO.class);
//	}
	
	
	
	public StudijskaGodinaDTO konvertujEntityToDto(StudijskaGodina studijskaGodina) {
		StudijskaGodinaDTO studijskaGodinaDTO = new StudijskaGodinaDTO();

		studijskaGodinaDTO.setId(studijskaGodina.getId());
		studijskaGodinaDTO.setPocetakStudija(studijskaGodina.getPocetakStudija());
		studijskaGodinaDTO.setKrajStudija(studijskaGodina.getKrajStudija());
		studijskaGodinaDTO.setNacinFinansiranja(studijskaGodina.getNacin_finansiranja());
		studijskaGodinaDTO.setGodinaStudija(studijskaGodina.getGodinaStudija());
		studijskaGodinaDTO.setSkolskaGodina(studijskaGodina.getSkolskaGodina());

		return studijskaGodinaDTO;
	}
}
