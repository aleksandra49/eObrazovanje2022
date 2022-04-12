package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.dto.TransakcijaDTO;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.Transakcija;

@Component
public class TransakcijaToTransakcijaDTO {

	@Autowired
	private ModelMapper modelMapper;

	public TransakcijaDTO konvertujEntityToDto(Transakcija obj) {

		return modelMapper.map(obj, TransakcijaDTO.class);
	}
}
