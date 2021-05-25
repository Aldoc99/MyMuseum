package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Artista{
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String luogoNascita;
	private LocalDate dataMorte;
	private String luogoMorte;
	private String nazione;
	
	@OneToMany(mappedBy= "artista")
	private List<Opera> opere;
	
	public Artista() {
		opere=new ArrayList<>();
	}

	public Artista(String nome, String cognome, LocalDate dataNascita, String luogoNascita, String nazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.nazione = nazione;
		
		opere=new ArrayList<>();
	}


	
}
