package com.ftn.eObrazovanjee.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String nacinFinansiranja;
	private int godinaStudija;
	private int skolskaGodina;
	
	//student
	
	
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
	public String getNacinFinansiranja() {
		return nacinFinansiranja;
	}
	public void setNacinFinansiranja(String nacinFinansiranja) {
		this.nacinFinansiranja = nacinFinansiranja;
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
	
	
	
	
	
	

}
