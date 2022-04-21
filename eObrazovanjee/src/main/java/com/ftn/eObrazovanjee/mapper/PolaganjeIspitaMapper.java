package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PolaganjeIspitaDTO;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.service.PolaganjeIspitaService;

@Component
public class PolaganjeIspitaMapper {
	
	@Autowired
	private PolaganjeIspitaService service;
	
	public PolaganjeIspitaDTO modelToDto(PolaganjeIspita object) {
		PolaganjeIspitaDTO objectDTO = new PolaganjeIspitaDTO();
		
		objectDTO.setId(object.getId());
		objectDTO.setIspit(new IspitMapper().modelToDto(object.getIspit()));
		objectDTO.setStudent(new StudentMapper().modelToDto(object.getStudent()));
		
		return objectDTO;
	}
	
	public Set<PolaganjeIspita> listDtoToModel(ArrayList<PolaganjeIspitaDTO> listaDto) {
		Set<PolaganjeIspita> listaModel = new HashSet<PolaganjeIspita>();
		for (PolaganjeIspitaDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
	}
	
}

