package com.orm.demo.domein;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Afdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String naam;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="persoon_id")
	private List<Persoon> persoon = new ArrayList<>();;
	
	public List<Persoon> getPersoon() {
		return persoon;
	}

	public void setPersoon(List<Persoon> persoon) {
		this.persoon = persoon;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}


}
