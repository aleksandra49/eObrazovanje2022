package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.StudijskaGodina;


@Component
public class StudijskaGodinaMapper {

	@Autowired
	private ModelMapper modelMapper;
//
//	public StudijskaGodinaDTO konvertujEntityToDto(StudijskaGodina obj) {
//
//		return modelMapper.map(obj, StudijskaGodinaDTO.class);
//	}
	
	
	//modelToDto
	public StudijskaGodinaDTO konvertujEntityToDto(StudijskaGodina studijskaGodina) {
		
		StudijskaGodinaDTO studijskaGodinaDTO = new StudijskaGodinaDTO();

		studijskaGodinaDTO.setId(studijskaGodina.getId());
		studijskaGodinaDTO.setPocetakStudija(studijskaGodina.getPocetakStudija());
		studijskaGodinaDTO.setKrajStudija(studijskaGodina.getKrajStudija());
		studijskaGodinaDTO.setNacinFinansiranja(studijskaGodina.getNacin_finansiranja());
		studijskaGodinaDTO.setGodinaStudija(studijskaGodina.getGodinaStudija());
		studijskaGodinaDTO.setSkolskaGodina(studijskaGodina.getSkolskaGodina());
		
		//veza za studenta

		return studijskaGodinaDTO;
	}
	
	//dtoToModel
	public StudijskaGodina konvertujDtoToEntity(StudijskaGodinaDTO studijskaGodinaDTO) {

		StudijskaGodina studijskaGodina = new StudijskaGodina();

		studijskaGodina.setId(studijskaGodinaDTO.getId());
		studijskaGodina.setPocetakStudija(studijskaGodinaDTO.getPocetakStudija());
		studijskaGodina.setKrajStudija(studijskaGodinaDTO.getKrajStudija());
		studijskaGodina.setNacin_finansiranja(studijskaGodinaDTO.getNacinFinansiranja());
		studijskaGodina.setGodinaStudija(studijskaGodinaDTO.getGodinaStudija());
		studijskaGodina.setSkolskaGodina(studijskaGodinaDTO.getSkolskaGodina());
		
		//resiti za studenta to sto ne valjda da ispise i njegov id
		//studijskaGodina.setStudent(studijskaGodinaDTO.getStudent());
		
		return studijskaGodina;

	}
	
}
