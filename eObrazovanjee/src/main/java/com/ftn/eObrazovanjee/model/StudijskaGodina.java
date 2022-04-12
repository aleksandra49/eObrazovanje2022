package com.ftn.eObrazovanjee.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
@Entity
public class StudijskaGodina {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "pocetak_studija")
	private Date pocetakStudija;
	
	@Column(name = "kraj_studija")
	private Date krajStudija;
	
	//private String nacinFinansiranja;
	//@Enumerated(EnumType.STRING)
    @Column(name = "nacin_finansiranja", nullable = false)
    private NacinFinansiranja nacin_finansiranja;
	
    @Column(name = "godina_studija")
	private int godinaStudija;
    
    @Column(name = "skolska_godina")
	private int skolskaGodina;
	
	//student
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "student", referencedColumnName = "id", nullable = false)
    private Student student;

	public StudijskaGodina() {
		super();
	}

	public StudijskaGodina(Long id, Date pocetakStudija, Date krajStudija, NacinFinansiranja nacin_finansiranja,
			int godinaStudija, int skolskaGodina, Student student) {
		super();
		this.id = id;
		this.pocetakStudija = pocetakStudija;
		this.krajStudija = krajStudija;
		this.nacin_finansiranja = nacin_finansiranja;
		this.godinaStudija = godinaStudija;
		this.skolskaGodina = skolskaGodina;
		this.student = student;
	}
	
	

	public StudijskaGodina(Date pocetakStudija, Date krajStudija, NacinFinansiranja nacin_finansiranja,
			int godinaStudija, int skolskaGodina, Student student) {
		super();
		this.pocetakStudija = pocetakStudija;
		this.krajStudija = krajStudija;
		this.nacin_finansiranja = nacin_finansiranja;
		this.godinaStudija = godinaStudija;
		this.skolskaGodina = skolskaGodina;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPocetakStudija() {
		return pocetakStudija;
	}

	public void setPocetakStudija(Date pocetakStudija) {
		this.pocetakStudija = pocetakStudija;
	}

	public Date getKrajStudija() {
		return krajStudija;
	}

	public void setKrajStudija(Date krajStudija) {
		this.krajStudija = krajStudija;
	}

	public NacinFinansiranja getNacin_finansiranja() {
		return nacin_finansiranja;
	}

	public void setNacin_finansiranja(NacinFinansiranja nacin_finansiranja) {
		this.nacin_finansiranja = nacin_finansiranja;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public int getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(int skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
	
	
	
	

}
