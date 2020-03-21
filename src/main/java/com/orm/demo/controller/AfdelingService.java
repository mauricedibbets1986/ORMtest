
package com.orm.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orm.demo.domein.*;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;


@Service
public class AfdelingService  {
	
	@Autowired
	private AfdelingRepository afdelingRepository;
	
	public Afdeling addAfdeling(Afdeling afdeling) {
		System.out.println("Afdeling aangemaakt in database");
		afdelingRepository.save(afdeling);
		return afdeling;		
	}

	public Afdeling findById(long afdelingId) {
		System.out.println("Afdeling gevonden in database");
		return (Afdeling) afdelingRepository.findById(afdelingId);
	}
	

}
