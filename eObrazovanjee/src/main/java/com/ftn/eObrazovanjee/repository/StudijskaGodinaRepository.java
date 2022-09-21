package com.ftn.eObrazovanjee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftn.eObrazovanjee.model.StudijskaGodina;


@Repository
public interface StudijskaGodinaRepository extends JpaRepository<StudijskaGodina, Long> {

	
	@Query(value = "SELECT sg.id, sg.pocetak_studija, sg.kraj_studija, sg.nacin_finansiranja, sg.godina_studija,\r\n" +
			" sg.skolska_godina from student_studijska_godina as ssg\r\n" 
			+ "join studijska_godina as sg on sg.id = ssg.studijska_godina_id\r\n"  
			+ "join student as s on s.id = ssg.student_id\r\n"  
			+ "where ssg.student_id = :studentId"  , nativeQuery = true)
	List<Object[]> StudijskaGodinaStudentaNative(@Param("studentId") int studentId);
	//List<Object[]> StudijskaGodinaStudentaNative(@Param("studentId") Long studentId);

	//List<StudijskaGodina> findStudijskaGodinasByStudentId(Long studentId);
	
	


}
