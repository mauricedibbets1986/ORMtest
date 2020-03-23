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
	@Autowired
	OpdrachtService opdrachtService;
	@Autowired
	MaandService maandService;
	@Autowired
	DagService dagService;
	
	@Autowired
	PersoonRepository persoonRepository;
	
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
	@RequestBody Persoon persoon) {
		return persoonService.updateGebruikerAfdeling(Long.parseLong(persoonId), Long.parseLong(afdelingId));
	}
	
	@PutMapping("/persoon/telefoon/{persoonId}/{telefoonId}")
	public Persoon updatePersoonTelefoon(@PathVariable(value = "persoonId") String persoonId, 
	@PathVariable(value = "telefoonId") String telefoonId, 
	@RequestBody Persoon persoon) {
		return persoonService.updateGebruikerTelefoon(Long.parseLong(persoonId), Long.parseLong(telefoonId));
	}
	
	@PutMapping("/persoon/opdracht/{persoonId}/{opdrachtId}")
	public Persoon updatePersoonOpdracht(@PathVariable(value = "persoonId") String persoonId, 
	@PathVariable(value = "opdrachtId") String opdrachtId, 
	@RequestBody Persoon persoon) {
		return persoonService.updateGebruikerOpdracht(Long.parseLong(persoonId), Long.parseLong(opdrachtId));
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
	
	@GetMapping("/afdeling")
	public Iterable<Afdeling> getAfdelingen() {
		return afdelingService.getAllAfdelingen();
	}
	
	
	// TELEFOON ENDPOINTS
	@PostMapping("/telefoon")
	public Telefoon addTelefoon(@RequestBody Telefoon telefoon) {
		return telefoonService.addTelefoon(telefoon);
	}
	
	@GetMapping("/telefoon")
	public Iterable<Telefoon> getTelefoon() {
		return telefoonService.getAllTelefoons();
	}
	
	// OPDRACHT ENDPOINTS
	@PostMapping("/opdracht")
	public Opdracht addOpdracht(@RequestBody Opdracht opdracht) {
		return opdrachtService.addOpdracht(opdracht);
	}
	
	@GetMapping("/opdracht")
	public Iterable<Opdracht> getOpdracht() {
		return opdrachtService.getAllOpdrachten();
	}
	
	// MAAND ENDPOINTS
	@PostMapping("/maand/{maandNr}")
	public Maand addMaand(@PathVariable(value = "maandNr") int maandNr, @RequestBody Maand maand){
		maandService.koppelMaand(maand, maandNr);
//		for (Persoon persoon: persoonRepository.findAll()) {
//			maandService.addMaand(maand, maandNr, persoon);
//		}
		return maand;
	}
	
	@PostMapping("/maand")
	public Maand addMaand2(@RequestBody Maand maand) {
		maandService.saveMaand2(maand);
		return maand;
	}
	
	@GetMapping("/maand")
	public Iterable<Maand> getMaand() {
		return maandService.getAllmaanden();
	}
	
	// DAG ENDPOINTS

	@PutMapping("/dag/{dagId}")
	public Dag updatePersoonOpdracht(@PathVariable(value = "dagId") String dagId,
	@RequestBody Dag dagDetails) {
		return dagService.updateDag(Long.parseLong(dagId), dagDetails);
	}

}
