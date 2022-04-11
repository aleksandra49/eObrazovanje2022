package com.ftn.eObrazovanjee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ftn.eObrazovanjee.model.PolaganjeIspita;

@Repository
public interface PolaganjeIspitaRepository extends JpaRepository<PolaganjeIspita, Long>  {

}
