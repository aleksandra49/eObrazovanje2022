package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.KorisnikDTO;
import com.ftn.eObrazovanjee.model.Korisnik;


@Component
public class KorisnikDTOToKorisnik {
		
	@Autowired
	private ModelMapper modelMapper;
	
	public Korisnik konvertujDtoToEntity(KorisnikDTO objDTO) {
		
		Korisnik obj = modelMapper.map(objDTO, Korisnik.class);
		return obj;
	}
	
	
//		Korisnik korisnik = new Korisnik();
//		
//		korisnik.setId(korisnikDTO.getId());
//		korisnik.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
//		korisnik.setLozinka(korisnikDTO.getLozinka());
//		korisnik.setUloga(korisnikDTO.getUloga());
//		
//		
//		return korisnik;
//	}
	
	
}
