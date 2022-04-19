package com.ftn.eObrazovanjee.dto;

import java.util.Date;
import java.util.List;

public class PohadjanjePredmetaDTO {
	
	private Long id;
	private Date pocetak;
	private Date kraj;
	private boolean polozen;
	
	private StudentDTO studnetDTO;
	private PredmetInstancaDTO predmetInstanca;
	//private List<PredmetInstancaDTO> predmetInstancaDTO;
	//private List<IspitDTO> ispitDTO;

	public PohadjanjePredmetaDTO() {
		super();
	}
	
	
	public PohadjanjePredmetaDTO(Long id, Date pocetak, Date kraj, boolean polozen, StudentDTO studnetDTO,
			PredmetInstancaDTO predmetInstanca) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.polozen = polozen;
		this.studnetDTO = studnetDTO;
		this.predmetInstanca = predmetInstanca;
	}


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

	public boolean isPolozen() {
		return polozen;
	}

	public void setPolozen(boolean polozen) {
		this.polozen = polozen;
	}


	public StudentDTO getStudnetDTO() {
		return studnetDTO;
	}


	public void setStudnetDTO(StudentDTO studnetDTO) {
		this.studnetDTO = studnetDTO;
	}


	public PredmetInstancaDTO getPredmetInstanca() {
		return predmetInstanca;
	}


	public void setPredmetInstanca(PredmetInstancaDTO predmetInstanca) {
		this.predmetInstanca = predmetInstanca;
	}

	/*public List<StudentDTO> getStudnetDTO() {
		return studnetDTO;
	}

	public void setStudnetDTO(List<StudentDTO> studnetDTO) {
		this.studnetDTO = studnetDTO;
	}*/
	
	
	
	

}
