package com.ftn.eObrazovanjee.dto;

public class TipDokumentaDTO {
	
	private Long id;
	private String nazivDokumenta;
	private DokumentDTO dokumentDTO;
	
	
	
	public TipDokumentaDTO() {
		super();
	}

	public TipDokumentaDTO(Long id, String nazivDokumenta) {
		super();
		this.id = id;
		this.nazivDokumenta = nazivDokumenta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivDokumenta() {
		return nazivDokumenta;
	}

	public void setNazivDokumenta(String nazivDokumenta) {
		this.nazivDokumenta = nazivDokumenta;
	}

	public DokumentDTO getDokumentDTO() {
		return dokumentDTO;
	}

	public void setDokumentDTO(DokumentDTO dokumentDTO) {
		this.dokumentDTO = dokumentDTO;
	}
	
	
	
	

}
