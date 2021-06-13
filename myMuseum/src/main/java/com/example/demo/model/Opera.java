package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Entity
public class Opera {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String titolo;
	private int anno;
	
	@Column(length=1000)
	private String descrizione;

	@ManyToOne
	private Artista artista;
	
	@ManyToOne
	private Collezione collezione;

	
	@Lob
	private Byte[] image;
	
	public Opera() {
		
	}
	
	public Opera(String titolo, int anno, String descrizione) {
		this.titolo = titolo;
		this.anno = anno;
		this.descrizione = descrizione;
	}
	
	
	
}
