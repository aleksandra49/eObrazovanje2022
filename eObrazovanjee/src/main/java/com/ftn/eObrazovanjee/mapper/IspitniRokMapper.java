package com.ftn.eObrazovanjee.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.IspitniRokDTO;
import com.ftn.eObrazovanjee.model.IspitniRok;

@Component
public class IspitniRokMapper {

	public IspitniRok dtoToModel(IspitniRokDTO objectDTO) {
		IspitniRok object = new IspitniRok();
		
		object.setNazivRoka(objectDTO.getNazivRoka());
		object.setPocetakRoka(objectDTO.getPocetakRoka());
		object.setKrajRoka(objectDTO.getKrajRoka());
		
		return object;
	}
	
	public IspitniRokDTO modelToDto(IspitniRok object) {
		IspitniRokDTO objectDTO = new IspitniRokDTO();
		
		object.setNazivRoka(objectDTO.getNazivRoka());
		object.setPocetakRoka(objectDTO.getPocetakRoka());
		object.setKrajRoka(objectDTO.getKrajRoka());
		
		return objectDTO;
	}
	
	public Set<IspitniRok> listDtoToModel(Set<IspitniRokDTO> listaDto) {
		Set<IspitniRok> listaModel = new HashSet<IspitniRok>();
		for (IspitniRokDTO objectDTO : listaDto) {
			listaModel.add(dtoToModel(objectDTO));
		}
		return listaModel;
	}
	
}

//this.id = id;
//this.nazivRoka = nazivRoka;
//this.pocetakRoka = pocetakRoka;
//this.krajRoka = krajRoka;
//this.ispit = ispit;