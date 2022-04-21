package com.ftn.eObrazovanjee.mapper;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;
import com.ftn.eObrazovanjee.model.PohadjanjePredmeta;
import com.ftn.eObrazovanjee.service.PohadjanjePredmetaService;

@Component
public class PohadjanjePredmetaMapper {
	
	@Autowired
	private PohadjanjePredmetaService service;
	
	@Autowired
	private ModelMapper modelMapper;

	/*public PohadjanjePredmetaDTO konvertujEntityToDto(PohadjanjePredmetaDTO pohadjanjePredmeta) {

		return modelMapper.map(pohadjanjePredmeta, PohadjanjePredmetaDTO.class);
	}*/
	
//	public PohadjanjePredmeta dtoToModel(PohadjanjePredmetaDTO objectDTO) {
//		
//		PohadjanjePredmeta object = new PohadjanjePredmeta();
//		
//		object.setId(objectDTO.getId());
//		object.setPocetak(objectDTO.getPocetak());
//		object.setKraj(objectDTO.getKraj());
//		object.setPolozen(objectDTO.isPolozen());
//		object.setStudnetDTO(new StudentMapper().modelToDto(objectDTO.getStudent()));
//		object.setPredmetInstanca(new PredmetInstancaMapper().modelToDto(objectDTO.getPredmetInstanca()));
//		
//		return object;
//	}
	
	public PohadjanjePredmetaDTO modelToDto(PohadjanjePredmeta object) {
		
		PohadjanjePredmetaDTO objectDTO = new PohadjanjePredmetaDTO();
		
		objectDTO.setId(object.getId());
		objectDTO.setPocetak(object.getPocetak());
		objectDTO.setKraj(object.getKraj());
		objectDTO.setPolozen(object.isPolozen());
		objectDTO.setStudnetDTO(new StudentMapper().modelToDto(object.getStudent()));
		objectDTO.setPredmetInstanca(new PredmetInstancaMapper().modelToDto(object.getPredmetInstanca()));
		
		return objectDTO;
	}
	
	//ERROR
//	public Set<PohadjanjePredmeta> listDtoToModel(Set<PohadjanjePredmetaDTO> listaDto) {
//		Set<PohadjanjePredmeta> listaModel = new HashSet<PohadjanjePredmeta>();
//		for (PohadjanjePredmeta objectDTO : listaDto) {
//			listaModel.add(service.findOne(objectDTO.getId()));
//		}
//		return listaModel;
//	}

}
