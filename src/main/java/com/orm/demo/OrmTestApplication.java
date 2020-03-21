package com.orm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrmTestApplication.class, args);
		System.out.println("ORM test runt");
	}

}

/*
 * opzet ORM test:
 * ManyToOne OneToMany -> Meerdere medewerkers 1 afdeling
 * OneToOne -> 1 medewerker 1 telefoon
 * ManyToMany -> Meerdere medewerkers met meerdere opdrachten
 */

/* 
 * Wat Moet de app kunnen?
 * ManyToOne stappen:
 * stap 1 Medewerker aanmaken in html,js html (KLAAR)
 * 			nodig:
 * 			medewerker @Entity (KLAAR)
 * 			medewerker repository (KLAAR)
 * 			medewerker service (KLAAR)
 * 			medewerker endpoint (KLAAR)
 * 			HTML form richting endpoint
 * stap 2 Afdeling aanmaken in html,js
 * stap 3 Bestaande medewerker koppelen aan bestaande afdeling in html,js (KLAAR)
 * stap 4 Nieuwe medewerker direct koppelen aan bestaande afdeling in html,js (KLAAR)
 * 
 * OneToOne stappen:
 * stap 1 Telefoon aanmaken in html,js
 * stap 2 Bestaande Medewerker koppen aan bestaande telefoon html,js
 * stap 3 Nieuwe medewerker aanmaken met een nieuwe telefoon in 1 form
 * 
 * ManyToMany stappen:
 * stap 1 Opdrachten aanmaken html,js
 * stap 2 Opdrachten koppelen aan Medewerkers
 */