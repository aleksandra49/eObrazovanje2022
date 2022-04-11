package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.model.Predmet;

@Component
public class PredmetToPredmetDTO {

	@Autowired
	private ModelMapper modelMapper;

	public PredmetDTO konvertujEntityToDto(Predmet predmet) {

		return modelMapper.map(predmet, PredmetDTO.class);
	}

	public List<PredmetDTO> konvertujEntityToDto(List<Predmet> predmet) {
		List<PredmetDTO> listaPredmeta = new ArrayList<PredmetDTO>();
		for (Predmet predmeti : predmet) {
			listaPredmeta.add(konvertujEntityToDto(predmeti));
		}
		return listaPredmeta;
	}
}
