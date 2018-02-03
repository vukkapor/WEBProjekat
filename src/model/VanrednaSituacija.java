package model;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
@JsonAutoDetect
public class VanrednaSituacija {
	private String id;
	private String naziv;
	private String opstina;
	private String opis;
	private Date datum;
	private String lokacija;
	private Teritorija teritorija;
	private String hitnost;
	private String slika;
	private String stanje;
	private User volonter;
	private HashMap<String, Komentar> komentari;
	
	
	public VanrednaSituacija(String naziv, String opstina, String opis, Date datum, String lokacija,
			Teritorija teritorija, String hitnost, String slika, String stanje, User volonter,
			HashMap<String, Komentar> komenatari) {
		super();
		this.naziv = naziv;
		this.opstina = opstina;
		this.opis = opis;
		this.datum = datum;
		this.lokacija = lokacija;
		this.teritorija = teritorija;
		this.hitnost = hitnost;
		this.slika = slika;
		this.stanje = stanje;
		this.komentari = komenatari;
	}

	public VanrednaSituacija() {
		super();
		this.komentari = new HashMap<>();
	}
	
	
	public HashMap<String, Komentar> getKomenatari() {
		return komentari;
	}

	public void setKomenatari(HashMap<String, Komentar> komenatari) {
		this.komentari = komenatari;
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
	public String getOpstina() {
		return opstina;
	}
	public void setOpstina(String opstina) {
		this.opstina = opstina;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public String getLokacija() {
		return lokacija;
	}
	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}
	public Teritorija getTeritorija() {
		return teritorija;
	}
	public void setTeritorija(Teritorija teritorija) {
		this.teritorija = teritorija;
	}
	public String getHitnost() {
		return hitnost;
	}
	public void setHitnost(String hitnost) {
		this.hitnost = hitnost;
	}
	public String getSlika() {
		return slika;
	}
	public void setSlika(String slika) {
		this.slika = slika;
	}
	public String getStanje() {
		return stanje;
	}
	public void setStanje(String stanje) {
		this.stanje = stanje;
	}
	public User getVolonter() {
		return volonter;
	}
	public void setVolonter(User volonter) {
		this.volonter = volonter;
	}

	@Override
	public String toString() {
		return "VanrednaSituacija [id=" + id + ", naziv=" + naziv + ", opstina=" + opstina + ", opis=" + opis
				+ ", datum=" + datum + ", lokacija=" + lokacija + ", teritorija=" + teritorija + ", hitnost=" + hitnost
				+ ", slika=" + slika + ", stanje=" + stanje + ", volonter=" + volonter + ", komenatari=" + komentari
				+ "]";
	}
	
	public void dodajKomentar(Komentar komentar)	{
		komentar.setId(UUID.randomUUID().toString());
		this.komentari.put(komentar.getId(), komentar);
	}


	
	
	
	
}
