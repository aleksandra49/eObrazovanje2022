package com.ftn.eObrazovanjee.mapper;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.DeoIspitaDTO;
import com.ftn.eObrazovanjee.dto.StudijskaGodinaDTO;
import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.model.StudijskaGodina;

@Component
public class DeoIspitaDTOToDeoIspita {
	
	public DeoIspita konvertujDtoToEntity(DeoIspitaDTO deoIspitaDTO) {
		
		DeoIspita deoIspita = new DeoIspita();
		
		deoIspita.setId(deoIspitaDTO.getId());
		deoIspita.setNaziv(deoIspitaDTO.getNaziv());
		deoIspita.setBrojOsvojenihBodova(deoIspitaDTO.getBrojOsvojenihBodova());
		deoIspita.setMinBodova(deoIspitaDTO.getMinBodova());
		deoIspita.setPolozio(deoIspitaDTO.isPolozio());
		
		
		
		return deoIspita;
	}

}
