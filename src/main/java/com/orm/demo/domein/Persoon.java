package com.orm.demo.domein;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private byte[] datafoto;
	
	
	public byte[] getDatafoto() {
		return datafoto;
	}
	public void setDatafoto(byte[] datafoto) {
		this.datafoto = datafoto;
	}

	@ManyToOne
	@JoinColumn( name = "afdeling_id", referencedColumnName = "id" )
	@JsonBackReference
	private Afdeling afdeling;

	@OneToOne
	@JoinColumn( name = "telefoon_id" )
	private Telefoon telefoon;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="gekregen_opdrachten",
		joinColumns = @JoinColumn(name = "persoon_id"),
		inverseJoinColumns = @ JoinColumn(name = "opdracht_id"))
	private List<Opdracht> opdrachten = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="maand_id")
	private List<Maand> maand = new ArrayList<>();
	
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
	
    public List<Opdracht> getOpdrachtBezig() {
		return opdrachten;
	}
	
	public void setOpdracht(Opdracht opdracht) {
		this.opdrachten.add(opdracht);
	}
	
	public List<Maand> getMaand() {
		return maand;
	}

	public void addMaand(Maand maand) {
        this.maand.add(maand);
    }

}
