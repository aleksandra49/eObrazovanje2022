package com.ftn.eObrazovanjee.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.model.Predmet;



@Component
public class PredmetMapper {

	public Predmet konvertujDtoToEntity(PredmetDTO predmetDTO) {
		
		Predmet predmet = new Predmet();
		
		predmet.setId(predmetDTO.getId());
		predmet.setEspb(predmetDTO.getEspb());
		predmet.setNaziv(predmetDTO.getNaziv());
		predmet.setOznaka(predmetDTO.getOznaka());
		//deoIspita.setPolozio(deoIspitaDTO.isPolozio());
		
		
		return predmet;
	}
		
	public PredmetDTO konvertujEntityToDto(Predmet predmet) {
		PredmetDTO predmetDTO = new PredmetDTO();
			
		predmetDTO.setId(predmet.getId());
		predmetDTO.setEspb(predmet.getEspb());
		predmetDTO.setNaziv(predmet.getNaziv());
		predmetDTO.setOznaka(predmet.getOznaka());
		//predmetInstanca
			
		
		return predmetDTO;
		
	}
	
	public Set<Predmet> listDtoToModel(Set<PredmetDTO> listaDto) {
		Set<Predmet> listaModel = new HashSet<Predmet>();
		for (PredmetDTO objectDTO : listaDto) {
			listaModel.add(konvertujDtoToEntity(objectDTO));
		}
		return listaModel;
		
	}
	


}
