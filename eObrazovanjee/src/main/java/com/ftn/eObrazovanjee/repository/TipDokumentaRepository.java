package com.ftn.eObrazovanjee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.eObrazovanjee.model.DeoIspita;
import com.ftn.eObrazovanjee.model.TipDokumenta;

@Repository
public interface TipDokumentaRepository  extends JpaRepository<TipDokumenta, Long> {

}
