package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.dto.IspitniRokDTO;
import com.ftn.eObrazovanjee.model.IspitniRok;
import com.ftn.eObrazovanjee.service.IspitniRokService;

@Component
public class IspitniRokMapper {

	@Autowired
	private IspitniRokService service;
	
	public IspitniRokDTO modelToDto(IspitniRok object) {
		IspitniRokDTO objectDTO = new IspitniRokDTO();
		
		objectDTO.setId(object.getId());
		object.setNazivRoka(objectDTO.getNazivRoka());
		object.setPocetakRoka(objectDTO.getPocetakRoka());
		object.setKrajRoka(objectDTO.getKrajRoka());
//		objectDTO.setIspiti(new ArrayList<IspitDTO>());
		
		return objectDTO;
	}
	
	public Set<IspitniRok> listDtoToModel(ArrayList<IspitniRokDTO> listaDto) {
		Set<IspitniRok> listaModel = new HashSet<IspitniRok>();
		for (IspitniRokDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
	}
	
}

