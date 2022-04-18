package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PredmetDTO;
import com.ftn.eObrazovanjee.model.Predmet;

@Component
public class PredmetDTOToPredmet {

	@Autowired
	private ModelMapper modelMapper;
	
	public Predmet konvertujDtoToEntity(PredmetDTO deoIspitaDTO) {
		
		Predmet deoIspita = new Predmet();
		
		deoIspita.setId(deoIspitaDTO.getId());
		deoIspita.setEspb(deoIspitaDTO.getEspb());
		deoIspita.setNaziv(deoIspitaDTO.getNaziv());
		deoIspita.setOznaka(deoIspitaDTO.getOznaka());
		//deoIspita.setPolozio(deoIspitaDTO.isPolozio());
		
		
		return deoIspita;
	}
	
	/*public Predmet konvertujDtoToEntity(PredmetDTO predmetDTO) {
		
		Predmet predmet = modelMapper.map(predmetDTO, Predmet.class);
		return predmet;
	}*/
}
