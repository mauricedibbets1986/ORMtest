package com.orm.demo.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dag")
public class Dag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String datum;
	private int dagnr;
	public long getId() {
		return id;
	}
	
	private int aantalUrenGewerkt;
	
	public void setId(long id) {
		this.id = id;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public int getDagnr() {
		return dagnr;
	}
	public void setDagnr(int dagnr) {
		this.dagnr = dagnr;
	}
	public int getAantalUrenGewerkt() {
		return aantalUrenGewerkt;
	}
	public void setAantalUrenGewerkt(int aantalUrenGewerkt) {
		this.aantalUrenGewerkt = aantalUrenGewerkt;
	}

}
