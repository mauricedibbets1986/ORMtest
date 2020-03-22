package com.orm.demo.controller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orm.demo.domein.*;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;

@Service
@Transactional
public class OpdrachtService {

	@Autowired
	OpdrachtRepository opdrachtRepository;
	
	public Opdracht addOpdracht(Opdracht opdracht) {
		System.out.println("Opdracht aangemaakt in database");
		opdrachtRepository.save(opdracht);
		return opdracht;
	}

	public Iterable<Opdracht> getAllOpdrachten() {
		System.out.println("Alle opdrachten gevonden in Database");
		return opdrachtRepository.findAll();
	}

}
