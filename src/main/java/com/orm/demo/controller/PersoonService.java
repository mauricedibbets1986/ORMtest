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
	PersoonRepository pr;
	
	@Autowired
	AfdelingService as;
	
	public Persoon addPersoon(Persoon persoon) {
		System.out.println("persson aangemaakt in database");
		pr.save(persoon);
		return persoon;		
	}

	public Persoon addPersoon(Persoon persoon, long afdelingId) {
		System.out.println("persson aangemaakt in database");
		pr.save(persoon);
		persoon.setAfdeling(as.findById(afdelingId));
		return persoon;	
	}


}
