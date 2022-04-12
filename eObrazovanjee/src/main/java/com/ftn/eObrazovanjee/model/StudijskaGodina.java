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
	
	private Date pocetakStudija;
	private Date krajStudija;
	//mozda enum
	//private String nacinFinansiranja;
	@Enumerated(EnumType.STRING)
    @Column(name = "nacin_finansiranja", nullable = false)
    private NacinFinansiranja nacin_finansiranja;
	
	private int godinaStudija;
	private int skolskaGodina;
	
	//student
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "student", referencedColumnName = "student_id", nullable = false)
    private Student student;
	
	
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
	/*public String getNacinFinansiranja() {
		return nacinFinansiranja;
	}
	public void setNacinFinansiranja(String nacinFinansiranja) {
		this.nacinFinansiranja = nacinFinansiranja;
	}*/
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
	
	
	
	
	
	

}
