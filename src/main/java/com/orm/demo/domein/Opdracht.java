package com.orm.demo.domein;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.orm.demo.domein.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;

@Entity
@Table(name = "opdracht")
public class Opdracht {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String naam;

	@ManyToMany(mappedBy = "opdrachten")
	@JsonBackReference
	private List<Persoon> personen = new ArrayList<>();
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public List<Persoon> getPersoon() {
		return personen;
	}

	public void addPersoon(Persoon persoon) {
		this.personen.add(persoon);
	}
	
}
