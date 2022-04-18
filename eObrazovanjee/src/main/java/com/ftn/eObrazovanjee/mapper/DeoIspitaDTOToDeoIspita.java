package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ftn.eObrazovanjee.dto.DeoIspitaDTO;
import com.ftn.eObrazovanjee.model.DeoIspita;



@Component
public class DeoIspitaDTOToDeoIspita {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DeoIspita konvertujDtoToEntity(DeoIspitaDTO deoIspitaDTO) {
		
		DeoIspita deoIspita = modelMapper.map(deoIspitaDTO, DeoIspita.class);
		return deoIspita;
	}
	
	public List<DeoIspita> konvertujListuIzDTO(Set<DeoIspitaDTO> deloviIspitaDTO) {
		List<DeoIspita> listaDelova = new ArrayList<DeoIspita>();
		for (DeoIspitaDTO polaganjeDTO : deloviIspitaDTO) {
			listaDelova.add(konvertujDtoToEntity(polaganjeDTO));
		}
		return listaDelova;
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
