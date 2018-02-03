package model;

import java.util.HashMap;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
@JsonAutoDetect

public class TeritorijE {
	private HashMap<String, Teritorija> teritorije;

	public TeritorijE(HashMap<String, Teritorija> teritorije) {
		super();
		this.teritorije = teritorije;
	}

	public TeritorijE() {
		super();
		this.teritorije = new HashMap<String, Teritorija>();

	}

	public HashMap<String, Teritorija> getTeritorije() {
		return teritorije;
	}

	public void setTeritorije(HashMap<String, Teritorija> teritorije) {
		this.teritorije = teritorije;
	}

	@Override
	public String toString() {
		return "TeritorijE [teritorije=" + teritorije + "]";
	}
	
	
	public void dodajTeritoriju(Teritorija teritorija) {
		if(teritorija.getId() == null)
			teritorija.setId(UUID.randomUUID().toString());
		this.teritorije.put(teritorija.getId(), teritorija);
	}
	
	public Teritorija getTeritorija(String teritorijaID) {
		return this.teritorije.get(teritorijaID);
	}
	
	
	public void izbrisiTeritoriju(Teritorija teritorija) {
		this.teritorije.remove(teritorija.getId());
	}
	

	
}
