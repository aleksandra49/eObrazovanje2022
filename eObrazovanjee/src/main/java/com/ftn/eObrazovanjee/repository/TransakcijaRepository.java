package com.ftn.eObrazovanjee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.eObrazovanjee.model.Transakcija;

@Repository
public interface TransakcijaRepository  extends JpaRepository<Transakcija, Long> {

}
