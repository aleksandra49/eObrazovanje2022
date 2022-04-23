package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredavanjePredmetaDTO;
import com.ftn.eObrazovanjee.model.PredavanjePredmeta;
import com.ftn.eObrazovanjee.service.PredavanjePredmetaServiceImpl;


@Component
public class PredavanjePredmetaMapper {
	
	@Autowired
	private PredavanjePredmetaServiceImpl service;


	
	public PredavanjePredmetaDTO modelToDto(PredavanjePredmeta predavanjePredmeta) {
		PredavanjePredmetaDTO predavanjePredmetaDTO = new PredavanjePredmetaDTO();
			
		predavanjePredmetaDTO.setId(predavanjePredmeta.getId());
		predavanjePredmetaDTO.setProfesor(new ProfesorMapper().modelToDto(predavanjePredmeta.getProfesor()));
		predavanjePredmetaDTO.setPredmetInstanca(new PredmetInstancaMapper().modelToDto(predavanjePredmeta.getInstanca()));
		predavanjePredmetaDTO.setTipPredavaca(predavanjePredmeta.getTipPredavaca());


		return predavanjePredmetaDTO;
		
	}
	
	public Set<PredavanjePredmeta> listDtoToModel(ArrayList<PredavanjePredmetaDTO> listaDto) {
		Set<PredavanjePredmeta> listaModel = new HashSet<PredavanjePredmeta>();
		for (PredavanjePredmetaDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
		
	}
	
//	public PredavanjePredmeta konvertujDtoToEntity(PredavanjePredmetaDTO predavanjePredmetaDTO) {
//	
//	PredavanjePredmeta predavanjePredmeta = new PredavanjePredmeta();
//	
//	predavanjePredmeta.setId(predavanjePredmetaDTO.getId());
//
//	
//	
//	return predavanjePredmeta;
//}
}
