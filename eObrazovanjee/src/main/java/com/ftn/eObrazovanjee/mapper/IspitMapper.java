package com.ftn.eObrazovanjee.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.IspitDTO;
import com.ftn.eObrazovanjee.model.Ispit;

@Component
public class IspitMapper {

	public Ispit dtoToModel(IspitDTO objectDTO) {
		Ispit object = new Ispit();
		
		object.setNaziv(objectDTO.getNaziv());
		object.setDatumVreme(objectDTO.getDatumVreme());
		object.setBrojOsvojenihBodova(objectDTO.getBrojOsvojenihBodova());
		
		return object;
	}
	
	public IspitDTO modelToDto(Ispit object) {
		IspitDTO objectDTO = new IspitDTO();
		
		objectDTO.setNaziv(object.getNaziv());
		objectDTO.setDatumVreme(object.getDatumVreme());
		objectDTO.setBrojOsvojenihBodova(object.getBrojOsvojenihBodova());
		
		return objectDTO;
	}
	
	public Set<Ispit> listDtoToModel(Set<IspitDTO> listaDto) {
		Set<Ispit> listaModel = new HashSet<Ispit>();
		for (IspitDTO objectDTO : listaDto) {
			listaModel.add(dtoToModel(objectDTO));
		}
		return listaModel;
	}
	
}

//this.id = id;
//this.naziv = naziv;
//this.datumVreme = datumVreme;
//this.BrojOsvojenihBodova = brojOsvojenihBodova;
//this.polaganjeIspita = polaganjeIspita;
//this.ispitniRok = ispitniRok;
//this.deoIspita = deoIspita;
//this.predmetInstanca = predmetInstanca;