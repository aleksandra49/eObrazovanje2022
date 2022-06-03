package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.DeoIspitaDTO;
import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.dto.PolaganjeIspitaDTO;
import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;
import com.ftn.eObrazovanjee.service.IspitService;

@Component
public class IspitMapper {

	@Autowired
	private IspitService service;
	
	public IspitDTO modelToDto(Ispit object) {
		IspitDTO objectDTO = new IspitDTO();
		
		objectDTO.setId(object.getId());
		objectDTO.setNaziv(object.getNaziv());
		objectDTO.setDatumVreme(object.getDatumVreme());
		objectDTO.setBrojOsvojenihBodova(object.getBrojOsvojenihBodova());
//		objectDTO.setPolaganjeIspita(new ArrayList<PolaganjeIspitaDTO>());
//		objectDTO.setIspitniRok(new IspitniRokMapper().modelToDto(object.getIspitniRok()));
//		objectDTO.setDeoIspitaDTO(new ArrayList<DeoIspitaDTO>());
//		objectDTO.setPredmetInstanca(new PredmetInstancaMapper().modelToDto(object.getPredmetInstanca()));
		
		return objectDTO;
	}
	
	public Set<Ispit> listDtoToModel(ArrayList<IspitDTO> listaDto) {
		Set<Ispit> listaModel = new HashSet<Ispit>();
		for (IspitDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
	}
	
}
