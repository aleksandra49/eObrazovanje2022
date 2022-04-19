package com.ftn.eObrazovanjee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.eObrazovanjee.service.DeoIspitaService;



@RestController
@RequestMapping(value="api/deoIspita")
public class DeoIspitaController {
	
	@Autowired
    private DeoIspitaService deoIspitaService;

}
