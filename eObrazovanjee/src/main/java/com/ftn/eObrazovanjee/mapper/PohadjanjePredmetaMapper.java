package com.ftn.eObrazovanjee.mapper;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.ftn.eObrazovanjee.dto.PohadjanjePredmetaDTO;
import com.ftn.eObrazovanjee.model.PohadjanjePredmeta;



@Component
public class PohadjanjePredmetaMapper {
	
	@Autowired
    private ModelMapper modelMapper;

    

}
