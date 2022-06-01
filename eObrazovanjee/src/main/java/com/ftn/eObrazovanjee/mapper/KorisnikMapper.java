package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.KorisnikDTO;
import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.service.KorisnikService;

@Component
public class KorisnikMapper {

	@Autowired
	private KorisnikService service;
	
	public KorisnikDTO modelToDto(Korisnik object) {
		
		/*
		//kada je prazan entitet u bazi ovako proverimo
		if (object == null)
			return null;
			*/
		
		KorisnikDTO objectDTO = new KorisnikDTO();
		
		objectDTO.setId(object.getId());
		objectDTO.setKorisnickoIme(object.getKorisnickoIme());
		objectDTO.setLozinka(object.getLozinka());
		objectDTO.setUloga(object.getUloga());
	//	objectDTO.setProfesor(new ProfesorMapper().modelToDto(object.getProfesor()));
	//	objectDTO.setStudent(new StudentMapper().modelToDto(object.getStudent()));
		
		return objectDTO;
	}
	
	public Set<Korisnik> listDtoToModel(ArrayList<KorisnikDTO> listaDto) {
		Set<Korisnik> listaModel = new HashSet<Korisnik>();
		for (KorisnikDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
	}
	
}
