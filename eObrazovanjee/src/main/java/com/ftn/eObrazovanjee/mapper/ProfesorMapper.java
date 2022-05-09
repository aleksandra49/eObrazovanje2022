package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredavanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.dto.ProfesorDTO;
import com.ftn.eObrazovanjee.model.Predmet;
import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.service.ProfesorServiceImpl;

@Component
public class ProfesorMapper {

	@Autowired
	private ProfesorServiceImpl service;
	
	public ProfesorDTO modelToDto(Profesor profesor) {
		ProfesorDTO profesorDTO = new ProfesorDTO();
			
		profesorDTO.setId(profesor.getId());
		profesorDTO.setEmail(profesor.getEmail());
		profesorDTO.setIme(profesor.getIme());
		profesorDTO.setPrezime(profesor.getPrezime());	
		profesorDTO.setKorisnik(new KorisnikMapper().modelToDto(profesor.getKorisnik()));
		profesorDTO.setPredavanja(new ArrayList<PredavanjePredmetaDTO>());
		
		return profesorDTO;
		
	}
	
	public Set<Profesor> listDtoToModel(ArrayList<ProfesorDTO> listaDto) {
		Set<Profesor> listaModel = new HashSet<Profesor>();
		for (ProfesorDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
		
	}
	
//	public Profesor konvertujDtoToEntity(ProfesorDTO profesorDTO) {
//		
//		Profesor profesor = new Profesor();
//		
//		profesor.setId(profesorDTO.getId());
//		profesor.setEmail(profesorDTO.getEmail());
//		profesor.setIme(profesorDTO.getIme());
//		profesor.setPrezime(profesorDTO.getPrezime());
//		
////		profesor.setPredavanja(profesorDTO.getPredavanja());
////		profesor.setKorisnik(profesorDTO.getKorisnik());
//		
//		return profesor;
//	}
}