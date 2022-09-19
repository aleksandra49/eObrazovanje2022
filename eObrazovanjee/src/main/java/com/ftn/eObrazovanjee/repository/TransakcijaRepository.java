package com.ftn.eObrazovanjee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftn.eObrazovanjee.model.Transakcija;

@Repository
public interface TransakcijaRepository  extends JpaRepository<Transakcija, Long> {

	@Query(value = "SELECT t.id, t.datum, t.promena_stanja, t.svrha from finansijska_kartica_transakcije as ft\r\n"
			+ "join finansijska_kartica as f on f.id = ft.finansijska_kartica_id\r\n"
			+ "join transakcija as t on t.id = ft.transakcije_id\r\n"
			+ "where ft.finansijska_kartica_id = :studentId" , nativeQuery = true)
	List<Object[]> IstorijaTransakcijaNative(@Param("studentId") int studentId);;
	
}
