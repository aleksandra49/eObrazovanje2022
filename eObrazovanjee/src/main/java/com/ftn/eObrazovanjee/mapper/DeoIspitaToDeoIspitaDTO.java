package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.DeoIspitaDTO;
import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.model.StudijskaGodina;

@Component
public class DeoIspitaToDeoIspitaDTO {
	
	@Autowired
	private ModelMapper modelMapper;

	/*public DeoIspitaDTO konvertujEntityToDto(DeoIspita deoIspita) {

		return modelMapper.map(deoIspita, DeoIspitaDTO.class);
	}*/
	
	public DeoIspitaDTO konvertujEntityToDto(DeoIspita deoIspita) {
		
		DeoIspitaDTO deoIspitaDTO = new DeoIspitaDTO();
		
		deoIspitaDTO.setId(deoIspita.getId());
		deoIspitaDTO.setNaziv(deoIspita.getNaziv());
		deoIspitaDTO.setBrojOsvojenihBodova(deoIspita.getBrojOsvojenihBodova());
		deoIspitaDTO.setMinBodova(deoIspita.getMinBodova());
		deoIspitaDTO.setPolozio(deoIspita.isPolozio());
		
	//ispit
		
		return deoIspitaDTO;
	}
	
	
	public DeoIspita konvertujDtoToEntity(DeoIspitaDTO deoIspitaDTO) {
		
		DeoIspita deoIspita = new DeoIspita();
		
		deoIspita.setId(deoIspitaDTO.getId());
		deoIspita.setNaziv(deoIspitaDTO.getNaziv());
		deoIspita.setBrojOsvojenihBodova(deoIspitaDTO.getBrojOsvojenihBodova());
		deoIspita.setMinBodova(deoIspitaDTO.getMinBodova());
		deoIspita.setPolozio(deoIspitaDTO.isPolozio());
		
		//ispit
		
		
		return deoIspita;
	}

}
