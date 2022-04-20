package com.ftn.eObrazovanjee.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity()
@Table(name = "predmetinstanca")
public class PredmetInstanca {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "pocetak")
    private Date pocetak;

    @Temporal(TemporalType.DATE)
    @Column(name = "kraj")
    private Date kraj;

    @ManyToOne
    @JoinColumn(name = "predmet_id", referencedColumnName = "id")
    private Predmet predmet;
    
    @JsonIgnore
    @OneToMany(mappedBy = "predmetInstanca", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Set<PredavanjePredmeta> predavanja = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "predmetInstanca", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Set<PohadjanjePredmeta> pohadjanja = new HashSet<>();
    
    @OneToMany(mappedBy = "predmetInstanca", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Ispit> ispit = new HashSet<Ispit>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPocetak() {
		return pocetak;
	}

	public void setPocetak(Date pocetak) {
		this.pocetak = pocetak;
	}

	public Date getKraj() {
		return kraj;
	}

	public void setKraj(Date kraj) {
		this.kraj = kraj;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}


	public Set<PredavanjePredmeta> getPredavanja() {
		return predavanja;
	}

	public void setPredavanja(Set<PredavanjePredmeta> predavanja) {
		this.predavanja = predavanja;
	}

	public Set<PohadjanjePredmeta> getPohadjanja() {
		return pohadjanja;
	}

	public void setPohadjanja(Set<PohadjanjePredmeta> pohadjanja) {
		this.pohadjanja = pohadjanja;
	}

	public PredmetInstanca() {
		super();
	}

	public PredmetInstanca(Long id, Date pocetak, Date kraj, Predmet predmet, Set<PredavanjePredmeta> predavanja,
			Set<PohadjanjePredmeta> pohadjanja, Set<Ispit> ispit) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.predmet = predmet;
		this.predavanja = predavanja;
		this.pohadjanja = pohadjanja;
		this.ispit = ispit;
	}

	public Set<Ispit> getIspit() {
		return ispit;
	}

	public void setIspit(Set<Ispit> ispit) {
		this.ispit = ispit;
	}


    
    

}
