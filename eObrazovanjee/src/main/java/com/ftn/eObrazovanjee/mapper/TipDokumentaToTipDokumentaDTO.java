package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.TipDokumentaDTO;
import com.ftn.eObrazovanjee.model.TipDokumenta;


@Component
public class TipDokumentaToTipDokumentaDTO {

	@Autowired
	private ModelMapper modelMapper;

	public TipDokumentaDTO konvertujEntityToDto(TipDokumenta obj) {

		return modelMapper.map(obj, TipDokumentaDTO.class);
	}
}
