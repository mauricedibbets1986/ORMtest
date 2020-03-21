
package com.orm.demo.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orm.demo.domein.Afdeling;


@Service
@Transactional
public class AfdelingService  {
	
	@Autowired
	AfdelingRepository ar;
	
	public Afdeling addAfdeling(Afdeling afdeling) {
		System.out.println("afdeling aangemaakt in database");
		ar.save(afdeling);
		return afdeling;		
	}

	public Afdeling findById(long afdelingId) {
		return (Afdeling) ar.findById(afdelingId);
	}
	

}
