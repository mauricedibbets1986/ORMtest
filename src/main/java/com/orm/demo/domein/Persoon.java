package com.orm.demo.domein;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.orm.demo.domein.*;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;

@Entity
public class Persoon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String naam;
	private String lievelingskleur;
	
	@ManyToOne
	@JoinColumn( name = "persoon_id" )
	private Afdeling afdeling;

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
	public String getLievelingskleur() {
		return lievelingskleur;
	}
	public void setLievelingskleur(String lievelingskleur) {
		this.lievelingskleur = lievelingskleur;
	}
	public void setAfdeling(Afdeling afdeling) {
		this.afdeling = afdeling;	
	}
}
