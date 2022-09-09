package com.ftn.eObrazovanjee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;

@Repository
public interface PolaganjeIspitaRepository extends JpaRepository<PolaganjeIspita, Long>  {

	@Query(value = "select p.naziv, i.broj_osvojenih_bodova, pi.ispit_id, pi.student_id from polaganje_ispita as pi\r\n"
			+ "join ispit as i on i.id = pi.ispit_id\r\n"
			+ "join student as s on s.id = pi.student_id\r\n"
			+ "join predmet as p on p.id = i.predmet_instanca_id\r\n"
			+ "where i.broj_osvojenih_bodova > 50 and pi.student_id  = :idStudent" , nativeQuery = true)
	List<Object[]> pronadjiPolozenePredmeteNative(@Param("idStudent") int idStudenta);;
	
	@Query(value = "select p.naziv, i.broj_osvojenih_bodova, pi.ispit_id, pi.student_id from polaganje_ispita as pi\r\n"
			+ "join ispit as i on i.id = pi.ispit_id\r\n"
			+ "join student as s on s.id = pi.student_id\r\n"
			+ "join predmet as p on p.id = i.predmet_instanca_id\r\n"
			+ "where i.broj_osvojenih_bodova < 50 and pi.student_id  = :idStudent" , nativeQuery = true)
	List<Object[]> pronadjiNepolozenePredmeteNative(@Param("idStudent") int idStudenta);;
}
