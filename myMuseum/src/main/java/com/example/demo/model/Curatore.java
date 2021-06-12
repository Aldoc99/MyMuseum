package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Curatore {

	@Id
	private Long matricola;
	
	private String nome;
	private String cognome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascita;
	
	private String luogoNascita;
	private String email;
	private int numeroTelefono;

	@OneToMany(mappedBy = "curatore", cascade=CascadeType.ALL)
	private List<Collezione> collezioni;
	

	public Curatore() {
		this.collezioni= new ArrayList<>();
	}
	
	public Curatore(Long matricola, String nome, String cognome, LocalDate dataNascita, String luogoNascita,
			String email, int numeroTelefono) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.email = email;
		this.numeroTelefono = numeroTelefono;

		this.collezioni= new ArrayList<>();
	}
	
	
	
	
}
