
package com.orm.demo.controller;

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
		System.out.println("afdeling aangemaakt in database");
		afdelingRepository.save(afdeling);
		return afdeling;		
	}

	public Afdeling findById(long afdelingId) {
		return (Afdeling) afdelingRepository.findById(afdelingId);
	}
	

}
