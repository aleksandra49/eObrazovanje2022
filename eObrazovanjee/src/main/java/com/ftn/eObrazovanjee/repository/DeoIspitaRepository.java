package com.ftn.eObrazovanjee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.eObrazovanjee.model.DeoIspita;

@Repository
public interface DeoIspitaRepository extends JpaRepository<DeoIspita, Long> {

}
