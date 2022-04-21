package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.DeoIspitaDTO;
import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.service.DeoIspitaService;

@Component
public class DeoIspitaMapper {
	
	@Autowired
	private DeoIspitaService service;
	
	@Autowired
	private ModelMapper modelMapper;

	/*public DeoIspitaDTO konvertujEntityToDto(DeoIspita deoIspita) {

		return modelMapper.map(deoIspita, DeoIspitaDTO.class);
	}*/
	
	
	//modelToDto konvertujEntityToDto
	public DeoIspitaDTO modelToDto(DeoIspita deoIspita) {
		
		DeoIspitaDTO deoIspitaDTO = new DeoIspitaDTO();
		
		deoIspitaDTO.setId(deoIspita.getId());
		deoIspitaDTO.setNaziv(deoIspita.getNaziv());
		deoIspitaDTO.setBrojOsvojenihBodova(deoIspita.getBrojOsvojenihBodova());
		deoIspitaDTO.setMinBodova(deoIspita.getMinBodova());
		deoIspitaDTO.setPolozio(deoIspita.isPolozio());
		
		deoIspitaDTO.setIspitDTO(new IspitMapper().modelToDto(deoIspita.getIspit()));
		
		return deoIspitaDTO;
	}
	
//	//dtoToModel
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
//		//ispit
//		
//		
//		return deoIspita;
//	}
	
	
	public Set<DeoIspita> listDtoToModel(Set<DeoIspitaDTO> listaDto) {
		Set<DeoIspita> listaModel = new HashSet<DeoIspita>();
		for (DeoIspitaDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
	}

}
