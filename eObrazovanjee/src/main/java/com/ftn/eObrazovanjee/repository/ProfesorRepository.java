package com.ftn.eObrazovanjee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.Profesor;



public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

	Profesor findByKorisnik(Korisnik korisnik);
}
