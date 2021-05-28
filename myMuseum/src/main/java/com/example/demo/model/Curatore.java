package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Curatore {

	@Id
	private int matricola;
	
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String luogoNascita;
	private String email;
	private int numeroTelefono;

	@OneToMany(mappedBy = "curatore")
	private List<Collezione> collezioni;
	

	public Curatore() {
		this.collezioni= new ArrayList<>();
	}
	
	public Curatore(int matricola, String nome, String cognome, LocalDate dataNascita, String luogoNascita,
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
