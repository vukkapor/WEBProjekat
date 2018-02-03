package model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
@JsonAutoDetect
public class Komentar {
	private String komentar;
	private Date datum;
	private User korisnik;
	private String id;
	
	public Komentar(String id, String komentar, Date datum, User korisnik) {
		super();
		this.id = id;
		this.komentar = komentar;
		this.datum = datum;
		this.korisnik = korisnik;
	}
	public Komentar() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKomentar() {
		return komentar;
	}
	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public User getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(User korisnik) {
		this.korisnik = korisnik;
	}
	@Override
	public String toString() {
		return "Komentar [komentar=" + komentar + ", datum=" + datum + ", korisnik=" + korisnik + ", id=" + id + "]";
	}
	
	
}
