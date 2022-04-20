package com.ftn.eObrazovanjee.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.dto.ProfesorDTO;
import com.ftn.eObrazovanjee.model.Predmet;
import com.ftn.eObrazovanjee.model.Profesor;

@Component
public class ProfesorMapper {

	public Profesor konvertujDtoToEntity(ProfesorDTO profesorDTO) {
		
		Profesor profesor = new Profesor();
		
		profesor.setId(profesorDTO.getId());
		profesor.setEmail(profesorDTO.getEmail());
		profesor.setIme(profesorDTO.getIme());
		profesor.setPrezime(profesorDTO.getPrezime());
		
//		profesor.setPredavanja(profesorDTO.getPredavanja());
//		profesor.setKorisnik(profesorDTO.getKorisnik());
		
		return profesor;
	}
	
	public ProfesorDTO konvertujEntityToDto(Profesor profesor) {
		ProfesorDTO profesorDTO = new ProfesorDTO();
			
		profesorDTO.setId(profesor.getId());
		profesorDTO.setEmail(profesor.getEmail());
		profesorDTO.setIme(profesor.getIme());
		profesorDTO.setPrezime(profesor.getPrezime());
			
		
		return profesorDTO;
		
	}
	
	public Set<Profesor> listDtoToModel(Set<ProfesorDTO> listaDto) {
		Set<Profesor> listaModel = new HashSet<Profesor>();
		for (ProfesorDTO objectDTO : listaDto) {
			listaModel.add(konvertujDtoToEntity(objectDTO));
		}
		return listaModel;
		
	}
}
