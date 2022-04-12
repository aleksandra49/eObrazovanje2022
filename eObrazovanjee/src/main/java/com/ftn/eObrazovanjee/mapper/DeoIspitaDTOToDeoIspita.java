package com.ftn.eObrazovanjee.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.DeoIspitaDTO;
import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.model.StudijskaGodina;

@Component
public class DeoIspitaDTOToDeoIspita {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DeoIspita konvertujDtoToEntity(DeoIspitaDTO deoIspitaDTO) {
		
		DeoIspita deoIspita = modelMapper.map(deoIspitaDTO, DeoIspita.class);
		return deoIspita;
	}
	
//	public DeoIspita konvertujDtoToEntity(DeoIspitaDTO deoIspitaDTO) {
//		
//		DeoIspita deoIspita = new DeoIspita();
//		
//		deoIspita.setId(deoIspitaDTO.getId());
//		deoIspita.setNaziv(deoIspitaDTO.getNaziv());
//		deoIspita.setBrojOsvojenihBodova(deoIspitaDTO.getBrojOsvojenihBodova());
//		deoIspita.setMinBodova(deoIspitaDTO.getMinBodova());
//		deoIspita.setPolozio(deoIspitaDTO.isPolozio());
//		
//		
//		return deoIspita;
//	}

}
