package com.ftn.eObrazovanjee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.eObrazovanjee.model.Transakcija;

@Repository
public interface TransakcijaRepository  extends JpaRepository<Transakcija, Long> {

	@Query(value = "SELECT t.id, t.datum, t.promena_stanja, t.svrha, f.personalni_broj, f.racun_fakulteta, f.trenutno_stanje from finansijska_kartica_transakcije as ft\r\n"
			+ "join finansijska_kartica as f on f.id = ft.finansijska_kartica_id\r\n"
			+ "join transakcija as t on t.id = ft.transakcije_id\r\n"
			+ "where ft.finansijska_kartica_id = :studentId" , nativeQuery = true)
	List<Object[]> IstorijaTransakcijaNative(@Param("studentId") int studentId);;
	
	@Transactional
	@Query(value = "INSERT INTO `eobrazovanjee`.`finansijska_kartica_transakcije` (`finansijska_kartica_id`, `transakcije_id`)\r\n"
            + "VALUES (:studentId, :transakcijaId)", nativeQuery = true )
	@Modifying
	void FinansijskaKarticaTransakcijeNative(@Param("studentId") Long studentId,@Param("transakcijaId") Long transakcijaId);;
	
}
