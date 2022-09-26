package com.ftn.eObrazovanjee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.eObrazovanjee.model.FinansijskaKartica;
import com.ftn.eObrazovanjee.model.Student;

@Repository
public interface FinansijskaKarticaRepository  extends JpaRepository<FinansijskaKartica, Long>{

	@Transactional
	void deleteByStudent(Student student);

}
