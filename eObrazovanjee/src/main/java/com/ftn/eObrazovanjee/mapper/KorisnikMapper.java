package com.ftn.eObrazovanjee.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.KorisnikDTO;
import com.ftn.eObrazovanjee.model.Korisnik;

@Component
public class KorisnikMapper {

	public Korisnik dtoToModel(KorisnikDTO objectDTO) {
		Korisnik object = new Korisnik();
		
		object.setKorisnickoIme(objectDTO.getKorisnickoIme());
		object.setLozinka(objectDTO.getLozinka());
		object.setUloga(objectDTO.getUloga());
		
		return object;
	}
	
	public KorisnikDTO modelToDto(Korisnik object) {
		KorisnikDTO objectDTO = new KorisnikDTO();
		
		object.setKorisnickoIme(objectDTO.getKorisnickoIme());
		object.setLozinka(objectDTO.getLozinka());
		object.setUloga(objectDTO.getUloga());
		
		return objectDTO;
	}
	
	public Set<Korisnik> listDtoToModel(Set<KorisnikDTO> listaDto) {
		Set<Korisnik> listaModel = new HashSet<Korisnik>();
		for (KorisnikDTO objectDTO : listaDto) {
			listaModel.add(dtoToModel(objectDTO));
		}
		return listaModel;
	}
	
}

//this.id = id;
//this.korisnickoIme = korisnickoIme;
//this.lozinka = lozinka;
//this.uloga = uloga;