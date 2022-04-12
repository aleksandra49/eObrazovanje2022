package com.ftn.eObrazovanjee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.eObrazovanjee.model.Dokument;

@Repository
public interface DokumentRepository extends JpaRepository<Dokument, Long> {

}
