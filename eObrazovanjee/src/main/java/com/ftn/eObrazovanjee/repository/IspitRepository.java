package com.ftn.eObrazovanjee.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.Student;


@Repository
public interface IspitRepository extends JpaRepository<Ispit, Long>  {

	@Query(value = "select i.id, i.naziv, i.datum_vreme, ir.naziv_roka from ispitni_rok as ir\r\n"
			+ "join ispit as i on i.ispitni_rok_id = ir.id\r\n"
			+ "where ir.id = :idIspitnogRoka" , nativeQuery = true)
	List<Object[]> pronadjiIspiteIzIspitnogRokaNative(@Param("idIspitnogRoka") int idIspitnogRoka);;

	@Transactional
	@Query(value = "INSERT INTO  `eobrazovanjee`.`polaganje_ispita` (`ispit_id`, `student_id`)"
            + " VALUES ( :ispitId, :studentId)", nativeQuery = true )
	@Modifying
	void prijaviIspitNative(@Param("ispitId") Long ispitId, @Param("studentId") Long studentId);;

	@Query(value = "select pi.id, i.naziv, i.datum_vreme from polaganje_ispita as pi\r\n"
			+ "join ispit as i on i.id = pi.ispit_id\r\n"
			+ "join student as s on s.id = pi.student_id\r\n"
			+ "where pi.student_id = :studentId" , nativeQuery = true)
	List<Object[]> pronadjiPrijavljeneIspiteNative(@Param("studentId") int studentId);;

	//DELETE FROM `eobrazovanjee`.`polaganje_ispita` WHERE (`id` = '10');

	@Transactional
	@Query(value = "DELETE FROM `eobrazovanjee`.`polaganje_ispita` WHERE (`id` = :prijavljenIspitId)", nativeQuery = true )
	
	@Modifying
	void odjaviIspitNative(@Param("prijavljenIspitId") Long prijavljenIspitId);;

}
