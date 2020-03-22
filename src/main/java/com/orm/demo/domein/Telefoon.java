package com.orm.demo.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefoon")
public class Telefoon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String telefoonNummer;
	private String puckCode;
	
	@OneToOne(mappedBy = "telefoon")
	private Persoon persoon;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefoonNummer() {
		return telefoonNummer;
	}

	public void setTelefoonNummer(String telefoonNummer) {
		this.telefoonNummer = telefoonNummer;
	}

	public String getPuckCode() {
		return puckCode;
	}

	public void setPuckCode(String puckCode) {
		this.puckCode = puckCode;
	}

	public Persoon getPersoon() {
		return persoon;
	}

	public void setPersoon(Persoon persoon) {
		this.persoon = persoon;
	}

	
}
