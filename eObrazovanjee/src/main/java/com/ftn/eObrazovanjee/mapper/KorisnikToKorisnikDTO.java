package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.KorisnikDTO;
import com.ftn.eObrazovanjee.model.Korisnik;

@Component
public class KorisnikToKorisnikDTO {


	@Autowired
	private ModelMapper modelMapper;

	public KorisnikDTO konvertujEntityToDto(Korisnik obj) {

		return modelMapper.map(obj, KorisnikDTO.class);
	}
	
}
