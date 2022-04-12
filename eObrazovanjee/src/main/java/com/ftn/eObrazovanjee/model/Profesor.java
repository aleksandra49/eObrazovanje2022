package com.ftn.eObrazovanjee.model;


import org.hibernate.annotations.Where;



import javax.persistence.*;


@Entity
@Table(name = "profesori")
public class Profesor {

	
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;
    
    @Column(name = "email")
    private String email;
    
    
    

    /*   
    @OneToOne
    @JoinColumn(name = "korisnik", referencedColumnName = "id")
    private Korisnik korisnik;
*/
    
	public Profesor() {
		super();
	}

	public Profesor(Long id, String ime, String prezime, String email) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

  
    
    

}
