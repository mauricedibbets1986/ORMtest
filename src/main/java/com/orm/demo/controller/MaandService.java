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

	public Maand maakMaand(Maand maand, int maandNr) {
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
		return maand;
	}
	
	public void koppelMaand(Maand maand, int maandNr) {
		Maand nieuwemaand = maakMaand(maand, maandNr);
		System.out.println("koppelmaand:maandgemaakt");
		for (Persoon persoon: persoonRepository.findAll()) {
			persoon.addMaand3(nieuwemaand);
			persoonRepository.save(persoon);
			System.out.println("koppelmaand: maand gekoppeld");
		}
	}
	
	public Maand saveMaand2(Maand maand) {
		maandRepository.save(maand);
		return maand;
	}
	
}
