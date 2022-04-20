package com.ftn.eObrazovanjee.dto;


public class ProfesorDTO {

    private Long id;
    private String ime;
    private String prezime;
    private String email;
    private KorisnikDTO korisnik;
    private PredavanjePredmetaDTO predavanja;
    
    
	public PredavanjePredmetaDTO getPredavanja() {
		return predavanja;
	}
	public void setPredavanja(PredavanjePredmetaDTO predavanja) {
		this.predavanja = predavanja;
	}
	public KorisnikDTO getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(KorisnikDTO korisnik) {
		this.korisnik = korisnik;
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

	public ProfesorDTO() {
		super();
	}
	public ProfesorDTO(Long id, String ime, String prezime, String email, KorisnikDTO korisnik,
			PredavanjePredmetaDTO predavanja) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.korisnik = korisnik;
		this.predavanja = predavanja;
	}


    
    
}
