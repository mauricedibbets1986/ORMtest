package com.orm.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orm.demo.domein.*;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;

@Service
public class MaandService {

	@Autowired
	private MaandRepository maandRepository;
	@Autowired
	private PersoonRepository persoonRepository;
	@Autowired
	private DagService dagService;
	@Autowired
	private PersoonService persoonService;
	
	public Iterable<Maand> getAllmaanden() {
		System.out.println("Alle maanden gevonden in Database");
		return maandRepository.findAll();
	}

	public Maand addMaand(Maand maand, int maandNr, Persoon persoon) {
		System.out.println("Maand aangemaakt in database");
		switch(maandNr) {
		case 2:
			for (int x = 0; x < 29; x++) {
				Dag dag = new Dag();
				dag.setDagnr(x+1);
				maand.addDag(dag);
				dagService.addDag(dag);
			}
			break;
		case 4: case 6: case 9: case 11:
			for (int x = 0; x < 30; x++) {
				Dag dag = new Dag();
				dag.setDagnr(x+1);
				maand.addDag(dag);
				dagService.addDag(dag);
			}
			break;
		default:
			for (int x = 0; x < 31; x++) {
				Dag dag = new Dag();
				dag.setDagnr(x+1);
				maand.addDag(dag);
				dagService.addDag(dag);
			}
			break;
		}
		maandRepository.save(maand);
		persoon.addMaand(maand);
		return maand;
	}
	
}
