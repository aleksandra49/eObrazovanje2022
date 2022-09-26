package com.ftn.eObrazovanjee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByKorisnik(Korisnik korisnik);
//	public Student findOne(Long id);
//	public List<Student> findAll();
//	Student findOneByIndeks(String indeks);
    //List<Student> findAllByPrezime(String prezime);
    //List<Student> findAllByKorisnickoIme(String korisnickoIme);
	
	@Transactional
	@Query(value = "UPDATE `eobrazovanjee`.`student` SET `email` = :email, `ime` = :ime, `indeks` = :indeks, `prezime` = :prezime"
            + " WHERE (`id` = :studentId)", nativeQuery = true )
	@Modifying
	void izmenaStudenta(@Param("email") String email, @Param("ime") String ime,@Param("indeks") String indeks,
			@Param("prezime") String prezime,
			@Param("studentId") Long studentId);;
	
	
}
