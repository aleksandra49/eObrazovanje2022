package com.ftn.eObrazovanjee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.Student;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>  {
	
	Optional<Korisnik> findBykorisnickoIme(String korisnickoIme);

	@Transactional
	void deleteByStudent(Student student);

//	@Transactional
//	@Query(value = "UPDATE `eobrazovanjee`.`korisnik` SET `korisnicko_ime` = :korisnickoIme, `lozinka` = :lozinka"
//            + "  WHERE (`id` = :IdZaIzmenu)", nativeQuery = true )
//	@Modifying
//	void izmenaKorisnika(@Param("korisnickoIme") String korisnickoIme, @Param("ime") String lozinka, @Param("IdZaIzmenu") Long IdZaIzmenu);;
}
