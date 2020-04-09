package com.orm.demo.domein;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.orm.demo.domein.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;

@Entity
@Table(name = "afdeling")
public class Afdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String naam;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="persoon_id")
	private List<Persoon> persoon = new ArrayList<>();
	
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
	
    public void addPersoon(Persoon persoon) {
        this.persoon.add(persoon);
    }

}
