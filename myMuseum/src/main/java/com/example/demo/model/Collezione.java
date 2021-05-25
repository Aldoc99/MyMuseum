package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Collezione {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String descrizione;
	
	@OneToMany(mappedBy= "collezione", 
			cascade = CascadeType.ALL)
	private List<Opera> opere;
	
	@ManyToOne
	private Curatore curatore;
	


	public Collezione() {
		this.opere= new ArrayList<>();
	}

	public Collezione(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
		
		this.opere= new ArrayList<>();
	}
	
	
}
