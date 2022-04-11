package com.ftn.eObrazovanjee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ftn.eObrazovanjee.model.IspitniRok;

@Repository
public interface IspitniRokRepository extends JpaRepository<IspitniRok, Long>  {

}
