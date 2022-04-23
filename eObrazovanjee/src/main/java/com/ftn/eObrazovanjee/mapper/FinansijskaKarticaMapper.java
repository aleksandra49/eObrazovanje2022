package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.FinansijskaKarticaDTO;
import com.ftn.eObrazovanjee.dto.TransakcijaDTO;
import com.ftn.eObrazovanjee.model.FinansijskaKartica;
import com.ftn.eObrazovanjee.service.FinansijskaKarticaService;

@Component
public class FinansijskaKarticaMapper {

	@Autowired
	private FinansijskaKarticaService service;
		
	public FinansijskaKarticaDTO modelToDto(FinansijskaKartica finansijskaKartica) {
		FinansijskaKarticaDTO finansijskaKarticaDTO = new FinansijskaKarticaDTO();
			
		finansijskaKarticaDTO.setId(finansijskaKartica.getId());
		finansijskaKarticaDTO.setPersonalniBroj(finansijskaKartica.getPersonalniBroj());
		finansijskaKarticaDTO.setTrenutnoStanje(finansijskaKartica.getTrenutnoStanje());
		finansijskaKarticaDTO.setRacunFakulteta(finansijskaKartica.getRacunFakulteta());
		finansijskaKarticaDTO.setStudentDto(new StudentMapper().modelToDto(finansijskaKartica.getStudent()));
		finansijskaKarticaDTO.setTransakcijaDTO(new ArrayList<TransakcijaDTO>());
			
		
		return finansijskaKarticaDTO;
		
	}
	
	public Set<FinansijskaKartica> listDtoToModel(ArrayList<FinansijskaKarticaDTO> listaDto) {
		Set<FinansijskaKartica> listaModel = new HashSet<FinansijskaKartica>();
		for (FinansijskaKarticaDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
		
	}
}
