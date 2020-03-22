package com.orm.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orm.demo.domein.*;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;



@RestController
@RequestMapping
public class EndpointsController {
	
	@Autowired
	PersoonService persoonService;
	@Autowired
	AfdelingService afdelingService;
	@Autowired
	TelefoonService telefoonService;
	
	
	// PERSOON ENDPOINTS
	@PostMapping("/persoon")
	public Persoon addPersoon(@RequestBody Persoon persoon) {
		return persoonService.addPersoon(persoon);
	}
	
	@PostMapping("/persoon/{id}")
	public Persoon addPersoonMetAfdeling(@PathVariable(value = "id") String afdelingId,
	@RequestBody Persoon persoon) {
		return persoonService.addPersoon(persoon, (Long.parseLong(afdelingId)));
	}
	
	@PutMapping("/persoon/afdeling/{persoonId}/{afdelingId}")
	public Persoon updatePersoonAfdeling(@PathVariable(value = "persoonId") String persoonId, 
	@PathVariable(value = "afdelingId") String afdelingId, 
	@RequestBody Persoon gebruikerDetails) {
		return persoonService.updateGebruikerAfdeling(Long.parseLong(persoonId), Long.parseLong(afdelingId));
	}
	
	@PutMapping("/persoon/telefoon/{persoonId}/{telefoonId}")
	public Persoon updatePersoonTelefoon(@PathVariable(value = "persoonId") String persoonId, 
	@PathVariable(value = "telefoonId") String telefoonId, 
	@RequestBody Persoon gebruikerDetails) {
		return persoonService.updateGebruikerTelefoon(Long.parseLong(persoonId), Long.parseLong(telefoonId));
	}
	
	@GetMapping("/persoon")
	public Iterable<Persoon> getPersonen() {
		return persoonService.getAllPersonen();
	}
	
	@GetMapping("/persoon/{id}")
	public Persoon getPersonen(@PathVariable(value = "id") String persoonId) {
		return persoonService.getPersoonById(Long.parseLong(persoonId));
	}
	
	
	// AFDELING ENDPOINTS
	@PostMapping("/afdeling")
	public Afdeling addAfdeling(@RequestBody Afdeling afdeling) {
		return afdelingService.addAfdeling(afdeling);
		
	}
	
	
	// TELEFOON ENDPOINTS
	@PostMapping("/telefoon")
	public Telefoon addTelefoon(@RequestBody Telefoon telefoon) {
		return telefoonService.addTelefoon(telefoon);
	}

}
