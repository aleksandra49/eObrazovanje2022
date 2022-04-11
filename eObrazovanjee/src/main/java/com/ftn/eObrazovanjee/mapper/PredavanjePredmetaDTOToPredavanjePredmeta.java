package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredavanjePredmetaDTO;
import com.ftn.eObrazovanjee.model.PredavanjePredmeta;



@Component
public class PredavanjePredmetaDTOToPredavanjePredmeta {

	@Autowired
	private ModelMapper modelMapper;
	
	public PredavanjePredmeta konvertujDtoToEntity(PredavanjePredmetaDTO predavanjePredmetaDTO) {
		
		PredavanjePredmeta predavanjePredmeta = modelMapper.map(predavanjePredmetaDTO, PredavanjePredmeta.class);
		return predavanjePredmeta;
	}
}
