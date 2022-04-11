package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredmetInstancaDTO;
import com.ftn.eObrazovanjee.model.PredmetInstanca;

@Component
public class PredmetInstancaToPredmetInstancaDTO {
	@Autowired
	private ModelMapper modelMapper;

	public PredmetInstancaDTO konvertujEntityToDto(PredmetInstanca predmetInstanca) {

		return modelMapper.map(predmetInstanca, PredmetInstancaDTO.class);
	}

	public List<PredmetInstancaDTO> konvertujEntityToDto(List<PredmetInstanca> predmetInstanca) {
		List<PredmetInstancaDTO> listaPredmetInstanca = new ArrayList<PredmetInstancaDTO>();
		for (PredmetInstanca predmetInstance : predmetInstanca) {
			listaPredmetInstanca.add(konvertujEntityToDto(predmetInstance));
		}
		return listaPredmetInstanca;
	}
}
