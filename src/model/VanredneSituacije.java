package model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class VanredneSituacije {
	private HashMap<String, VanrednaSituacija> vanredne;

	public VanredneSituacije(HashMap<String, VanrednaSituacija> vanredne) {
		super();
		this.vanredne = vanredne;
	}

	public VanredneSituacije() {
		super();
		this.vanredne = new HashMap<>();
	}

	public HashMap<String, VanrednaSituacija> getVanredne() {
		return vanredne;
	}

	public void setVanredne(HashMap<String, VanrednaSituacija> vanredne) {
		this.vanredne = vanredne;
	}

	@Override
	public String toString() {
		return "VanredneSituacije [vanredne=" + vanredne + "]";
	}
	
	public void dodajVanrednu(VanrednaSituacija vanredna) {
		this.vanredne.put(vanredna.getId(), vanredna);
	}
	public VanrednaSituacija getVanredna(String vanrednaID) {
		return this.vanredne.get(vanrednaID);
	}
}
