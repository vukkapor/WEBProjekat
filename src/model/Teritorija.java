package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Teritorija {
	private String id;
	private String naziv;
	private int povrsina;
	private int stanovnika;
	
	public Teritorija(String naziv, int povrsina, int stanovnika) {
		super();
		this.naziv = naziv;
		this.povrsina = povrsina;
		this.stanovnika = stanovnika;
	}

	public Teritorija() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getPovrsina() {
		return povrsina;
	}

	public void setPovrsina(int povrsina) {
		this.povrsina = povrsina;
	}

	public int getStanovnika() {
		return stanovnika;
	}

	public void setStanovnika(int stanovnika) {
		this.stanovnika = stanovnika;
	}

	@Override
	public String toString() {
		return "Teritorija [id=" + id + ", naziv=" + naziv + ", povrsina=" + povrsina + ", stanovnika=" + stanovnika
				+ "]";
	}

	
	
	
	
}
