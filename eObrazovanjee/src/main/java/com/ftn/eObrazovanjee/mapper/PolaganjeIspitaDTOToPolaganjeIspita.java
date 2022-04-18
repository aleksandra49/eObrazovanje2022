package com.ftn.eObrazovanjee.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PolaganjeIspitaDTO;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;

@Component
public class PolaganjeIspitaDTOToPolaganjeIspita {

	@Autowired
	private ModelMapper modelMapper;
	
	public PolaganjeIspita konvertujDtoToEntity(PolaganjeIspitaDTO objDTO) {
		
		PolaganjeIspita obj = modelMapper.map(objDTO, PolaganjeIspita.class);
		return obj;
	}
	
	public List<PolaganjeIspita> konvertujListuIzDTO(Set<PolaganjeIspitaDTO> polaganjaDTO) {
		List<PolaganjeIspita> listaPolaganja = new ArrayList<PolaganjeIspita>();
		for (PolaganjeIspitaDTO polaganjeDTO : polaganjaDTO) {
			listaPolaganja.add(konvertujDtoToEntity(polaganjeDTO));
		}
		return listaPolaganja;
	}
	
}
