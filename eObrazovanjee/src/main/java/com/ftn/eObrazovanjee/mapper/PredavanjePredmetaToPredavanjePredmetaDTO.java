package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredavanjePredmetaDTO;
import com.ftn.eObrazovanjee.model.PredavanjePredmeta;


@Component
public class PredavanjePredmetaToPredavanjePredmetaDTO {

	@Autowired
	private ModelMapper modelMapper;

	public PredavanjePredmetaDTO konvertujEntityToDto(PredavanjePredmeta predavanjePredmeta) {

		return modelMapper.map(predavanjePredmeta, PredavanjePredmetaDTO.class);
	}

	public List<PredavanjePredmetaDTO> konvertujEntityToDto(List<PredavanjePredmeta> predavanjaPredmeta) {
		List<PredavanjePredmetaDTO> listaPredavanjePredmeta = new ArrayList<PredavanjePredmetaDTO>();
		for (PredavanjePredmeta predavanjePredmeta : predavanjaPredmeta) {
			listaPredavanjePredmeta.add(konvertujEntityToDto(predavanjePredmeta));
		}
		return listaPredavanjePredmeta;
	}
}
