package com.orm.demo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orm.demo.domein.*;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;


@Service
@Transactional
public class PersoonService {
	
	@Autowired
	PersoonRepository persoonRepository;
	@Autowired
	AfdelingRepository afdelingRepository;
	@Autowired
	TelefoonRepository telefoonRepository;
	@Autowired
	OpdrachtRepository opdrachtRepository;
	
	@Autowired
	AfdelingService afdelingService;
	@Autowired
	OpdrachtService opdrachtService;
	
	public Persoon addPersoon(Persoon persoon) {
		System.out.println("Persoon aangemaakt in database");
		persoonRepository.save(persoon);
		return persoon;		
	}

	public Persoon addPersoon(Persoon persoon, long afdelingId) {
		System.out.println("Persoon aangemaakt in database");
		persoonRepository.save(persoon);
		System.out.println("Persoon gekoppeld aan afdeling");
		persoon.setAfdeling(afdelingService.findById(afdelingId));
		return persoon;	
	}

	public Iterable<Persoon> getAllPersonen() {
		System.out.println("Alle personen gevonden in Database");
		return persoonRepository.findAll();
	}

	public Persoon getPersoonById(long persoonId) {
		System.out.println("Persoon gevonden in Database");
		return persoonRepository.findById(persoonId).get();
	}

	public Persoon updateGebruikerAfdeling(long persoonId, long afdelingId) {
		System.out.println("Persoon gekoppeld aan afdeling");
		Persoon persoon = persoonRepository.findById(persoonId).get();
		Afdeling afdeling = afdelingRepository.findById(afdelingId).get();
		persoon.setAfdeling(afdeling);
		afdeling.addPersoon(persoon);
		return persoon;
	}

	public Persoon updateGebruikerTelefoon(long persoonId, long telefoonId) {
		System.out.println("Persoon gekoppeld aan telefoon");
		Persoon persoon = persoonRepository.findById(persoonId).get();
		Telefoon telefoon = telefoonRepository.findById(telefoonId).get();
		persoon.setTelefoon(telefoon);
		telefoon.setPersoon(persoon);
		return persoon;
	}

	public Persoon updateGebruikerOpdracht(long persoonId, long opdrachtId) {
		System.out.println("Persoon gekoppeld aan telefoon");
		Persoon persoon = persoonRepository.findById(persoonId).get();
		Opdracht opdracht = opdrachtRepository.findById(opdrachtId).get();
		persoon.setOpdracht(opdracht);
		opdracht.addPersoon(persoon);
		return persoon;
	}

	public Persoon savePersoon(Persoon zonderafbeelding) {
		return persoonRepository.save(zonderafbeelding);
	}


}
