package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Artista{
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String cognome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascita;
	
	private String luogoNascita;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataMorte;
	
	private String luogoMorte;
	private String nazione;
	
	@Column(length=1000)
	private String biografia;
	
	@OneToMany(mappedBy= "artista", cascade=CascadeType.ALL)
	private List<Opera> opere;
	
	public Artista() {
		opere=new ArrayList<>();
	}

	public Artista(String nome, String cognome, LocalDate dataNascita, String luogoNascita, String nazione, String biografia) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.nazione = nazione;
		this.biografia=biografia;
		
		opere=new ArrayList<>();
	}


	
}
