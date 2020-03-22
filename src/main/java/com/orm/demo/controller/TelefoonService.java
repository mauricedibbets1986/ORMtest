package com.orm.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orm.demo.domein.*;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;


@Service
public class TelefoonService  {
	
	@Autowired
	private TelefoonRepository telefoonRepository;
	
	public Telefoon addTelefoon(Telefoon telefoon) {
		System.out.println("Telefoon aangemaakt in database");
		telefoonRepository.save(telefoon);
		return telefoon;		
	}

	public Telefoon findTelefoonById(long telefoonId) {
		System.out.println("Telefoon gevonden in database");
		return telefoonRepository.findById(telefoonId).get();
	}

	public Iterable<Telefoon> getAllTelefoons() {
		System.out.println("Alle telefoons gevonden in Database");
		return telefoonRepository.findAll();
	}
	
}