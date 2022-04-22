package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.TransakcijaDTO;
import com.ftn.eObrazovanjee.model.Transakcija;
import com.ftn.eObrazovanjee.service.TransakcijaService;

@Component
public class TransakcijaMapper {

	@Autowired
	private TransakcijaService service;
	
	public TransakcijaDTO modelToDto(Transakcija object) {
		TransakcijaDTO objectDTO = new TransakcijaDTO();
		
		objectDTO.setId(object.getId());
		objectDTO.setDatum(object.getDatum());
		objectDTO.setSvrha(object.getSvrha());
		objectDTO.setPromenaStanja(object.getPromenaStanja());
		objectDTO.setFinansijskaKarticaDTO(new FinansijskaKarticaMapper().modelToDto(object.getFinansijskaKartica()));
		
		return objectDTO;
	}
	
	public Set<Transakcija> listDtoToModel(ArrayList<TransakcijaDTO> listaDto) {
		Set<Transakcija> listaModel = new HashSet<Transakcija>();
		for (TransakcijaDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
	}
}
