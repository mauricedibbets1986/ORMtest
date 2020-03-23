package com.orm.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orm.demo.domein.*;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;

@Service
public class DagService {

	@Autowired
	private DagRepository dagRepository;
	
	public Dag addDag(Dag dag) {
		System.out.println("Dag aangemaakt in database");
		dagRepository.save(dag);
		return dag;		
	}

	public Dag updateDag(long dagId, Dag dagDetails) {
		System.out.println("Dag aangepast in database");
		Dag dag = dagRepository.findById(dagId).get();
		dag.setAantalUrenGewerkt(dagDetails.getAantalUrenGewerkt());
		return dagRepository.save(dag);
	}

	
}
