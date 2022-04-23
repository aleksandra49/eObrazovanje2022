package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.DokumentDTO;
import com.ftn.eObrazovanjee.dto.PolaganjeIspitaDTO;
import com.ftn.eObrazovanjee.dto.PredavanjePredmetaDTO;
import com.ftn.eObrazovanjee.dto.PredmetInstancaDTO;
import com.ftn.eObrazovanjee.dto.ProfesorDTO;
import com.ftn.eObrazovanjee.dto.TipDokumentaDTO;
import com.ftn.eObrazovanjee.model.Dokument;
import com.ftn.eObrazovanjee.model.Profesor;
import com.ftn.eObrazovanjee.model.TipDokumenta;
import com.ftn.eObrazovanjee.service.DokumentService;
import com.ftn.eObrazovanjee.service.ProfesorServiceImpl;


@Component
public class DokumentMapper {

	@Autowired
	private DokumentService service;
	
	public DokumentDTO modelToDto(Dokument dokument) {
		DokumentDTO dokumentDTO = new DokumentDTO();
			
		dokumentDTO.setId(dokument.getId());
		dokumentDTO.setNaziv(dokument.getNaziv());
		dokumentDTO.setUri(dokument.getUri());
		dokumentDTO.setStudentDto(new StudentMapper().modelToDto(dokument.getStudent()));		
		dokumentDTO.setTipDokumentaDTOs(new ArrayList<TipDokumentaDTO>());

		
		return dokumentDTO;
		
	}
	
	public Set<Dokument> listDtoToModel(ArrayList<DokumentDTO> listaDto) {
		Set<Dokument> listaModel = new HashSet<Dokument>();
		for (DokumentDTO dokumentDTO : listaDto) {
			listaModel.add(service.findOne(dokumentDTO.getId()));
		}
		return listaModel;
		
	}
}