package com.ftn.eObrazovanjee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.model.Student;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>  {
	
	Optional<Korisnik> findBykorisnickoIme(String korisnickoIme);

	@Transactional
	void deleteByStudent(Student student);

}
