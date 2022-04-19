package com.ftn.eObrazovanjee.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PolaganjeIspitaDTO;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;

@Component
public class PolaganjeIspitaMapper {

	public PolaganjeIspita dtoToModel(PolaganjeIspitaDTO objectDTO) {
		PolaganjeIspita object = new PolaganjeIspita();
		
//		atributi su ispit i student
		
		return object;
	}
	
	public PolaganjeIspitaDTO modelToDto(PolaganjeIspita object) {
		PolaganjeIspitaDTO objectDTO = new PolaganjeIspitaDTO();
		
//		atributi su ispit i student
		
		return objectDTO;
	}
	
	public Set<PolaganjeIspita> listDtoToModel(Set<PolaganjeIspitaDTO> listaDto) {
		Set<PolaganjeIspita> listaModel = new HashSet<PolaganjeIspita>();
		for (PolaganjeIspitaDTO objectDTO : listaDto) {
			listaModel.add(dtoToModel(objectDTO));
		}
		return listaModel;
	}
	
}

//this.id = id;
//this.PolaganjeIspita = PolaganjeIspita;
//this.student = student;