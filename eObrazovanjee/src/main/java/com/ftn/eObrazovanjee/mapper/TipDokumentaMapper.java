package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.TipDokumentaDTO;
import com.ftn.eObrazovanjee.model.TipDokumenta;
import com.ftn.eObrazovanjee.service.TipDokumentaService;

@Component
public class TipDokumentaMapper {
	
	@Autowired
	private TipDokumentaService service;
	
	public TipDokumentaDTO modelToDto(TipDokumenta object) {
		TipDokumentaDTO objectDTO = new TipDokumentaDTO();
		
		objectDTO.setId(object.getId());
		objectDTO.setNazivDokumenta(object.getNazivDokumenta());
		objectDTO.setDokumentDTO(new DokumentMapper().modelToDto(object.getDokument()));
	
		return objectDTO;
	}
	
	public Set<TipDokumenta> listDtoToModel(ArrayList<TipDokumentaDTO> listaDto) {
		Set<TipDokumenta> listaModel = new HashSet<TipDokumenta>();
		for (TipDokumentaDTO objectDTO : listaDto) {
			listaModel.add(service.findOne(objectDTO.getId()));
		}
		return listaModel;
	}

}
