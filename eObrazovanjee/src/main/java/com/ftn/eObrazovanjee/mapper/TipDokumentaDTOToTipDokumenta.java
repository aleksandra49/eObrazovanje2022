package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.TipDokumentaDTO;
import com.ftn.eObrazovanjee.model.TipDokumenta;


@Component
public class TipDokumentaDTOToTipDokumenta {

	@Autowired
	private ModelMapper modelMapper;
	
	public TipDokumenta konvertujDtoToEntity(TipDokumentaDTO objDTO) {
		
		TipDokumenta obj = modelMapper.map(objDTO, TipDokumenta.class);
		return obj;
	}
}
