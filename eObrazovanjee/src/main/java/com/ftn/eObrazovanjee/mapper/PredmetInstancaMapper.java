package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.PredavanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.dto.PredmetInstancaDTO;
import com.ftn.eObrazovanjee.model.Predmet;
import com.ftn.eObrazovanjee.model.PredmetInstanca;
import com.ftn.eObrazovanjee.service.PredmetInstancaServiceImpl;

@Component
public class PredmetInstancaMapper {


	@Autowired
	private PredmetInstancaServiceImpl service;
	
	public PredmetInstancaDTO modelToDto(PredmetInstanca predmetInstanca) {
		PredmetInstancaDTO predmetInstancaDTO = new PredmetInstancaDTO();
			

		predmetInstancaDTO.setId(predmetInstanca.getId());
		predmetInstancaDTO.setPocetak(predmetInstanca.getPocetak());
		predmetInstancaDTO.setKraj(predmetInstanca.getKraj());
		predmetInstancaDTO.setPredmet(new PredmetMapper().modelToDto(predmetInstanca.getPredmet()));
		predmetInstancaDTO.setPredavanjePredmetaDTO(new ArrayList<PredavanjePredmetaDTO>());
		predmetInstancaDTO.setPohadjanjePredmetaDTO(new ArrayList<PohadjanjePredmetaDTO>());
		predmetInstancaDTO.setIspit(new ArrayList<IspitDTO>());
		
		return predmetInstancaDTO;
		
	}
	
	public Set<PredmetInstanca> listDtoToModel(Set<PredmetInstancaDTO> listaDto) {
		Set<PredmetInstanca> listaModel = new HashSet<PredmetInstanca>();
		for (PredmetInstancaDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
		
	}
	
//	public PredmetInstanca konvertujDtoToEntity(PredmetInstancaDTO predmetInstancaDTO) {
//	
//	PredmetInstanca predmetInstanca = new PredmetInstanca();
//	
//	predmetInstanca.setId(predmetInstancaDTO.getId());
//	predmetInstanca.setPocetak(predmetInstancaDTO.getPocetak());
//	predmetInstanca.setKraj(predmetInstancaDTO.getKraj());
//	
////	predmetInstanca.setIspit(predmetInstancaDTO.getIspit());
////	predmetInstanca.setPohadjanja(predmetInstancaDTO.getPohadjanjePredmetaDTO());
////	predmetInstanca.setPredavanja(predmetInstancaDTO.getPredavanjePredmetaDTO());
////	predmetInstanca.setPredmet(predmetInstancaDTO.getPredmet());
//	
//	
//	return predmetInstanca;
//}
}
