package com.ftn.eObrazovanjee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.eObrazovanjee.dto.ProfesorDTO;
import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.Profesor;



public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

	Profesor findByKorisnik(Korisnik korisnik);
	
	@Query(value = "select p.oznaka, p.naziv, p.espb from predavanja as pr\r\n"
			+ "join predmetinstanca as pi on pi.id = pr.predmet_instanca_id\r\n"
			+ "join predmet as p on pi.predmet_id = p.id\r\n"
			+ "join profesori as prof on prof.id = :idProfesora" , nativeQuery = true)
	List<Object[]> pronadjiPredmeteNative(@Param("idProfesora") int idStudenta);;
	
	
//	UPDATE `eobrazovanjee`.`profesori` SET `email` = 'marko@gmail.com', `ime` = 'Milan', `prezime` = 'Milosevic' 
//			WHERE (`id` = '2');
	
	@Transactional
	@Query(value = "UPDATE `eobrazovanjee`.`profesori` SET `email` = :email, `ime` = :ime, `prezime` = :prezime"
            + " WHERE (`id` = :profesorId)", nativeQuery = true )
	@Modifying
	void izmenaProfesora(@Param("email") String email, @Param("ime") String ime,@Param("prezime") String prezime,
			@Param("profesorId") Long profesorId);;
	
}
