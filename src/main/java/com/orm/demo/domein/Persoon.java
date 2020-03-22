package com.orm.demo.domein;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.orm.demo.domein.*;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;

@Entity
@Table(name = "persoon")
public class Persoon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String naam;
	
	@ManyToOne
	@JoinColumn( name = "afdeling_id", referencedColumnName = "id" )
	private Afdeling afdeling;

	@OneToOne
	@JoinColumn( name = "telefoon_id" )
	private Telefoon telefoon;
	
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
	
	public Afdeling getAfdeling() {
		return afdeling;
	}
	public void setAfdeling(Afdeling afdeling) {
		this.afdeling = afdeling;	
	}
	public Telefoon getTelefoon() {
		return telefoon;
	}
	public void setTelefoon(Telefoon telefoon) {
		this.telefoon = telefoon;
	}
}
