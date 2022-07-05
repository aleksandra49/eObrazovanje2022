package com.ftn.eObrazovanjee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ftn.eObrazovanjee.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>  {
	
	Optional<Korisnik> findBykorisnickoIme(String korisnickoIme);

}
