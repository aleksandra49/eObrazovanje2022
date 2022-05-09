package com.ftn.eObrazovanjee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ftn.eObrazovanjee.model.Predmet;
import com.ftn.eObrazovanjee.model.Profesor;



public interface PredmetRepository extends JpaRepository<Predmet, Long> {

	//query
	 public List<Predmet> getAllThatNastavnikIzvodi(@Param("profesor") Profesor profesor);
}
