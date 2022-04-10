package com.ftn.eObrazovanjee.mapper;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.DeoIspitaDTO;
import com.ftn.eObrazovanjee.model.DeoIspita;




@Component
public class DeoIspitaMapper {
	
	@Autowired
    private ModelMapper modelMapper;

//    public DeoIspitaDTO convertToDto(DeoIspita deoIspita) {
//        return modelMapper.map(deoIspita, DeoIspitaDTO.class);
//    }
//
//    /*public Set<DeoIspitaDTO> convertToDtos(Page<DeoIspita> deoIspitaPage) {
//        return deoIspitaPage.stream().map(this::convertToDto).collect(Collectors.toSet());
//    }*/
//    
//    public Set<DeoIspitaDTO> convertToDtosSet(Set<DeoIspita> deoIspita) {
//        return deoIspita.stream().map(this::convertToDto).collect(Collectors.toSet());
//    }
//
//
//    public DeoIspita convertToEntity(DeoIspitaDTO deoIspitaDTO) {
//        return modelMapper.map(deoIspitaDTO, DeoIspita.class);
//    }
//
//    public Set<DeoIspita> convertToEntities(Collection<DeoIspitaDTO> deoIspitaDTOS) {
//        return deoIspitaDTOS
//                .stream()
//                .map(this::convertToEntity)
//                .collect(Collectors.toSet());
//    }

}
