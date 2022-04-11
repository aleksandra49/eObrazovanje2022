package com.ftn.eObrazovanjee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ftn.eObrazovanjee.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>  {

}
