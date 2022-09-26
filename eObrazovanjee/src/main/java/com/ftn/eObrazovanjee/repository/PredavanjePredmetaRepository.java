package com.ftn.eObrazovanjee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.eObrazovanjee.model.PredavanjePredmeta;
import com.ftn.eObrazovanjee.model.Profesor;

public interface PredavanjePredmetaRepository extends JpaRepository<PredavanjePredmeta, Long> {

	PredavanjePredmeta findPredavanjePredmetaByProfesor(Profesor profesor);

	void deleteByProfesor(Profesor profesor);
}
