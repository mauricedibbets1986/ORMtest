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
	AfdelingService afdelingService;
	
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
		Afdeling afdeling = afdelingRepository.findById(afdelingId);
		persoon.setAfdeling(afdeling);
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
}
