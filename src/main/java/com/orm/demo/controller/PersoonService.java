package com.orm.demo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orm.demo.domein.Afdeling;
import com.orm.demo.domein.Persoon;

@Service
@Transactional
public class PersoonService {
	
	@Autowired
	PersoonRepository pr;
	
	public Persoon addPersoon(Persoon persoon) {
		
		System.out.println("persson aangemaakt in database");
		pr.save(persoon);
		return persoon;		
	}
}
