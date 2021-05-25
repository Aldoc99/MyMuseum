package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Opera {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String titolo;
	private int anno;
	private String descrizione;

	@ManyToOne
	private Artista artista;
	
	@ManyToOne
	private Collezione collezione;

	public Opera() {
		
	}
	
	public Opera(String titolo, int anno, String descrizione) {
		this.titolo = titolo;
		this.anno = anno;
		this.descrizione = descrizione;
	}
	
	
	
}