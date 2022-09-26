package com.ftn.eObrazovanjee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.eObrazovanjee.model.Student;
import com.ftn.eObrazovanjee.model.StudijskaGodina;


@Repository
public interface StudijskaGodinaRepository extends JpaRepository<StudijskaGodina, Long> {

	
	@Query(value = "SELECT sg.id, sg.pocetak_studija, sg.kraj_studija, sg.nacin_finansiranja, sg.godina_studija, \r\n"
			+ "sg.skolska_godina from studijska_godina as sg\r\n"
			+ "join student as s on sg.id = s.id\r\n"
			+ "where sg.student = :studentId"  , nativeQuery = true)
	List<Object[]> StudijskaGodinaStudentaNative(@Param("studentId") Long studentId);
	//List<Object[]> StudijskaGodinaStudentaNative(@Param("studentId") Long studentId);

	List<StudijskaGodina> findStudijskaGodinasByStudentId(Long studentId);

	@Transactional
	void deleteByStudent(Student student);
	
	


}
