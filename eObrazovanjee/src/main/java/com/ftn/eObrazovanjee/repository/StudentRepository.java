package com.ftn.eObrazovanjee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.eObrazovanjee.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public Student findOne(Long id);
	public List<Student> findAll();
	Student findOneByIndeks(String indeks);
    List<Student> findAllByPrezime(String prezime);
    List<Student> findAllByKorisnickoIme(String korisnickoIme);
}
