package com.ftn.eObrazovanjee.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.StudentDTO;
import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.model.StudijskaGodina;


@Component
public class StudijskaGodinaDTOToStudijskaGodina {
	

	@Autowired
	private ModelMapper modelMapper;
	
//	public StudijskaGodina konvertujDtoToEntity(StudijskaGodinaDTO objDTO) {
//		
//		StudijskaGodina obj = modelMapper.map(objDTO, StudijskaGodina.class);
//		return obj;
//	}
	
	
	public StudijskaGodina konvertujDtoToEntity(StudijskaGodinaDTO studijskaGodinaDTO) {

		StudijskaGodina studijskaGodina = new StudijskaGodina();

		studijskaGodina.setId(studijskaGodinaDTO.getId());
		studijskaGodina.setPocetakStudija(studijskaGodinaDTO.getPocetakStudija());
		studijskaGodina.setKrajStudija(studijskaGodinaDTO.getKrajStudija());
		studijskaGodina.setNacin_finansiranja(studijskaGodinaDTO.getNacinFinansiranja());
		studijskaGodina.setGodinaStudija(studijskaGodinaDTO.getGodinaStudija());
		studijskaGodina.setSkolskaGodina(studijskaGodinaDTO.getSkolskaGodina());
		
		return studijskaGodina;

	}
	
	
	

}
