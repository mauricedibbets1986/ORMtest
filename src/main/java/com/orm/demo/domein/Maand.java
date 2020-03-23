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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "maand")
public class Maand {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String deMaand;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="dag_id")
	private List<Dag> dag = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeMaand() {
		return deMaand;
	}

	public void setDeMaand(String deMaand) {
		this.deMaand = deMaand;
	}

	public List<Dag> getDag() {
		return dag;
	}

	public void addDag(Dag dag) {
		this.dag.add(dag);
		}
	

	
	
	
}
