package com.ftn.eObrazovanjee.mapper;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.StudijskaGodina;
import com.ftn.eObrazovanjee.service.StudijskaGodinaService;


@Component
public class StudijskaGodinaMapper {

	@Autowired
	private StudijskaGodinaService service;
	
	@Autowired
	private ModelMapper modelMapper;
//
//	public StudijskaGodinaDTO konvertujEntityToDto(StudijskaGodina obj) {
//
//		return modelMapper.map(obj, StudijskaGodinaDTO.class);
//	}
	
	
	//modelToDto konvertujEntityToDto
	public StudijskaGodinaDTO modelToDto(StudijskaGodina studijskaGodina) {
		
		StudijskaGodinaDTO studijskaGodinaDTO = new StudijskaGodinaDTO();

		studijskaGodinaDTO.setId(studijskaGodina.getId());
		studijskaGodinaDTO.setPocetakStudija(studijskaGodina.getPocetakStudija());
		studijskaGodinaDTO.setKrajStudija(studijskaGodina.getKrajStudija());
		studijskaGodinaDTO.setNacinFinansiranja(studijskaGodina.getNacin_finansiranja());
		studijskaGodinaDTO.setGodinaStudija(studijskaGodina.getGodinaStudija());
		studijskaGodinaDTO.setSkolskaGodina(studijskaGodina.getSkolskaGodina());
		
		studijskaGodinaDTO.setStudnetDTO(new StudentMapper().modelToDto(studijskaGodina.getStudent()));

		return studijskaGodinaDTO;
	}
	
	//dtoToModel
//	public StudijskaGodina konvertujDtoToEntity(StudijskaGodinaDTO studijskaGodinaDTO) {
//
//		StudijskaGodina studijskaGodina = new StudijskaGodina();
//
//		studijskaGodina.setId(studijskaGodinaDTO.getId());
//		studijskaGodina.setPocetakStudija(studijskaGodinaDTO.getPocetakStudija());
//		studijskaGodina.setKrajStudija(studijskaGodinaDTO.getKrajStudija());
//		studijskaGodina.setNacin_finansiranja(studijskaGodinaDTO.getNacinFinansiranja());
//		studijskaGodina.setGodinaStudija(studijskaGodinaDTO.getGodinaStudija());
//		studijskaGodina.setSkolskaGodina(studijskaGodinaDTO.getSkolskaGodina());
//		
//		//resiti za studenta to sto ne valjda da ispise i njegov id
//		//studijskaGodina.setStudent(studijskaGodinaDTO.getStudent());
//		
//		return studijskaGodina;
//
//	}
	
	
//	public Set<StudijskaGodina> listDtoToModel(Set<StudijskaGodinaDTO> listaDto) {
//		Set<StudijskaGodina> listaModel = new HashSet<StudijskaGodina>();
//		for (StudijskaGodinaDTO objectDTO : listaDto) {
//			listaModel.add(konvertujDtoToEntity(objectDTO));
//		}
//		return listaModel;
//	}
	
	public Set<StudijskaGodina> listDtoToModel(Set<StudijskaGodinaDTO> listaDto) {
		Set<StudijskaGodina> listaModel = new HashSet<StudijskaGodina>();
		for (StudijskaGodinaDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
	}
	
	
}
