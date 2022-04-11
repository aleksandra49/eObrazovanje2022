package com.ftn.eObrazovanjee.dto;

import com.ftn.eObrazovanjee.model.Ispit;
import com.ftn.eObrazovanjee.model.Student;

public class PolaganjeIspitaDTO {

	private Long id;
	private IspitDTO ispit;
	private StudentDTO student;
	
	public PolaganjeIspitaDTO(Long id, IspitDTO ispit, StudentDTO student) {
		super();
		this.id = id;
		this.ispit = ispit;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public IspitDTO getIspit() {
		return ispit;
	}

	public void setIspit(IspitDTO ispit) {
		this.ispit = ispit;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	
	
	
}
