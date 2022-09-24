package com.ftn.eObrazovanjee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.eObrazovanjee.model.Predmet;
import com.ftn.eObrazovanjee.model.Profesor;



public interface PredmetRepository extends JpaRepository<Predmet, Long> {

	@Transactional
	@Query(value = "INSERT INTO `eobrazovanjee`.`predavanja` (`tip_predavaca`, `predmet_instanca_id`, `profesor_id`)"
			+ " VALUES ('PROFESOR', :predmetId, :profesorId)", nativeQuery = true )
	@Modifying
	void dodavanjeProfesoraNaPredmet(@Param("predmetId") Long predmetId, @Param("profesorId") Long profesorId);;
}
