package com.ftn.eObrazovanjee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.Profesor;



public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

	Profesor findByKorisnik(Korisnik korisnik);
	
	@Query(value = "select p.oznaka, p.naziv, p.espb from predavanja as pr\r\n"
			+ "join predmetinstanca as pi on pi.id = pr.predmet_instanca_id\r\n"
			+ "join predmet as p on pi.predmet_id = p.id\r\n"
			+ "join profesori as prof on prof.id = :idProfesora" , nativeQuery = true)
	List<Object[]> pronadjiPredmeteNative(@Param("idProfesora") int idStudenta);;
	
}
