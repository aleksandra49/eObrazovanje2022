package com.ftn.eObrazovanjee.dto;

import com.ftn.eObrazovanjee.model.NacinFinansiranja;

public class AddStudijskaGodina {

	private NacinFinansiranja nacinFinansiranja;
	private int godinaStudija;
	private Long studentId;
	
	public AddStudijskaGodina() {
		super();
	}

	public AddStudijskaGodina(NacinFinansiranja nacinFinansiranja, int godinaStudija, Long studentId) {
		super();
		this.nacinFinansiranja = nacinFinansiranja;
		this.godinaStudija = godinaStudija;
		this.studentId = studentId;
	}

	public NacinFinansiranja getNacinFinansiranja() {
		return nacinFinansiranja;
	}

	public void setNacinFinansiranja(NacinFinansiranja nacinFinansiranja) {
		this.nacinFinansiranja = nacinFinansiranja;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	
	
}
