package com.ftn.eObrazovanjee.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.dto.PredmetInstancaDTO;
import com.ftn.eObrazovanjee.model.Predmet;
import com.ftn.eObrazovanjee.model.PredmetInstanca;

@Component
public class PredmetInstancaMapper {

	public PredmetInstanca konvertujDtoToEntity(PredmetInstancaDTO predmetInstancaDTO) {
		
		PredmetInstanca predmetInstanca = new PredmetInstanca();
		
		predmetInstanca.setId(predmetInstancaDTO.getId());
		predmetInstanca.setPocetak(predmetInstancaDTO.getPocetak());
		predmetInstanca.setKraj(predmetInstancaDTO.getKraj());
		
//		predmetInstanca.setIspit(predmetInstancaDTO.getIspit());
//		predmetInstanca.setPohadjanja(predmetInstancaDTO.getPohadjanjePredmetaDTO());
//		predmetInstanca.setPredavanja(predmetInstancaDTO.getPredavanjePredmetaDTO());
//		predmetInstanca.setPredmet(predmetInstancaDTO.getPredmet());
		
		
		return predmetInstanca;
	}
	
	public PredmetInstancaDTO konvertujEntityToDto(PredmetInstanca predmetInstanca) {
		PredmetInstancaDTO predmetInstancaDTO = new PredmetInstancaDTO();
			

		predmetInstancaDTO.setId(predmetInstanca.getId());
		predmetInstancaDTO.setPocetak(predmetInstanca.getPocetak());
		predmetInstancaDTO.setKraj(predmetInstanca.getKraj());
			
		
		return predmetInstancaDTO;
		
	}
	
	public Set<PredmetInstanca> listDtoToModel(Set<PredmetInstancaDTO> listaDto) {
		Set<PredmetInstanca> listaModel = new HashSet<PredmetInstanca>();
		for (PredmetInstancaDTO objectDTO : listaDto) {
			listaModel.add(konvertujDtoToEntity(objectDTO));
		}
		return listaModel;
		
	}
}
