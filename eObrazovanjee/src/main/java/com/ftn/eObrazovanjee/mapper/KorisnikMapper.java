package com.ftn.eObrazovanjee.mapper;

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
		KorisnikDTO objectDTO = new KorisnikDTO();
		
		objectDTO.setId(object.getId());
		object.setKorisnickoIme(objectDTO.getKorisnickoIme());
		object.setLozinka(objectDTO.getLozinka());
		object.setUloga(objectDTO.getUloga());
		objectDTO.setProfesor(new ProfesorMapper().modelToDto(object.getProfesor()));
		objectDTO.setStudent(new StudentMapper().modelToDto(object.getStudent()));
		
		return objectDTO;
	}
	
	public Set<Korisnik> listDtoToModel(Set<KorisnikDTO> listaDto) {
		Set<Korisnik> listaModel = new HashSet<Korisnik>();
		for (KorisnikDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
	}
	
}
