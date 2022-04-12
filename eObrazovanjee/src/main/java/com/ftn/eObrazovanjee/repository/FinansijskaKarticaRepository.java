package com.ftn.eObrazovanjee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.eObrazovanjee.model.FinansijskaKartica;

@Repository
public interface FinansijskaKarticaRepository  extends JpaRepository<FinansijskaKartica, Long>{

}
