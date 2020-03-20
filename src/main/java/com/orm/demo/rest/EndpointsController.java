package com.orm.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orm.demo.controller.AfdelingService;
import com.orm.demo.controller.PersoonService;
import com.orm.demo.domein.*;


@RestController
@RequestMapping
public class EndpointsController {
	
	@Autowired
	PersoonService ps;
	@Autowired
	AfdelingService as;
	
	@PostMapping("/persoon")
	public Persoon toevoegenPersoon(@RequestBody Persoon persoon) {
		return ps.addPersoon(persoon);
		
	}
	
	@PostMapping("/persoon/{1}")
	public Persoon toevoegenPersoon2(@RequestBody Persoon persoon) {
		
		return ps.addPersoon(persoon);
		
	}
	
	@PostMapping("/afdeling")
	public Afdeling toevoegenAfdeling(@RequestBody Afdeling afdeling) {
		return as.addAfdeling(afdeling);
		
	}
	

}
