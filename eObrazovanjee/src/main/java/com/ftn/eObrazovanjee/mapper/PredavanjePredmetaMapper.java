package com.ftn.eObrazovanjee.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredavanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.model.PredavanjePredmeta;
import com.ftn.eObrazovanjee.model.Predmet;


@Component
public class PredavanjePredmetaMapper {

	public PredavanjePredmeta konvertujDtoToEntity(PredavanjePredmetaDTO predavanjePredmetaDTO) {
		
		PredavanjePredmeta predavanjePredmeta = new PredavanjePredmeta();
		
		predavanjePredmeta.setId(predavanjePredmetaDTO.getId());

		
		
		return predavanjePredmeta;
	}
	
	public PredavanjePredmetaDTO konvertujEntityToDto(PredavanjePredmeta predavanjePredmeta) {
		PredavanjePredmetaDTO predavanjePredmetaDTO = new PredavanjePredmetaDTO();
			
		predavanjePredmetaDTO.setId(predavanjePredmeta.getId());

		//predmetInstanca
			
		
		return predavanjePredmetaDTO;
		
	}
	
	public Set<PredavanjePredmeta> listDtoToModel(Set<PredavanjePredmetaDTO> listaDto) {
		Set<PredavanjePredmeta> listaModel = new HashSet<PredavanjePredmeta>();
		for (PredavanjePredmetaDTO objectDTO : listaDto) {
			listaModel.add(konvertujDtoToEntity(objectDTO));
		}
		return listaModel;
		
	}
}
