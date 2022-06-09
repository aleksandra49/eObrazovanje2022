package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.dto.PredmetInstancaDTO;
import com.ftn.eObrazovanjee.model.Predmet;
import com.ftn.eObrazovanjee.service.PredmetServiceImpl;



@Component
public class PredmetMapper {

	@Autowired
	private PredmetServiceImpl service;
		
	public PredmetDTO modelToDto(Predmet predmet) {
		PredmetDTO predmetDTO = new PredmetDTO();
			
		predmetDTO.setId(predmet.getId());
		predmetDTO.setNaziv(predmet.getNaziv());
		predmetDTO.setEspb(predmet.getEspb());
		predmetDTO.setOznaka(predmet.getOznaka());
		//predmetDTO.setPredmetInstancaDTO(new ArrayList<PredmetInstancaDTO>());
			
		
		return predmetDTO;
		
	}
	
	public Set<Predmet> listDtoToModel(ArrayList<PredmetDTO> listaDto) {
		Set<Predmet> listaModel = new HashSet<Predmet>();
		for (PredmetDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
		
	}
	
//	public Predmet konvertujDtoToEntity(PredmetDTO predmetDTO) {
//		
//		Predmet predmet = new Predmet();
//		
//		predmet.setId(predmetDTO.getId());
//		predmet.setEspb(predmetDTO.getEspb());
//		predmet.setNaziv(predmetDTO.getNaziv());
//		predmet.setOznaka(predmetDTO.getOznaka());
//		//deoIspita.setPolozio(deoIspitaDTO.isPolozio());
//		
//		
//		return predmet;
//	}
	


}
