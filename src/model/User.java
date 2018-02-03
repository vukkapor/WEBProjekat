package model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect

public class User {
	private String korisnicko;
	private String lozinka;
	private String ime;
	private String prezime;
	private String telefon;
	private String email;
	private Teritorija teritorija;
	private String stanje;
	private String slika;


	public User(String korisnicko, String lozinka, String ime, String prezime, String telefon, String email,
			Teritorija teritorija, String stanje, String slika) {
		super();
		this.korisnicko = korisnicko;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.email = email;
		this.teritorija = teritorija;
		this.stanje = stanje;
		this.slika = slika;
	}
	public User(User u) {
		this.korisnicko = u.getKorisnicko();
		this.lozinka = u.getLozinka();
		this.ime = u.getIme();
		this.prezime = u.getPrezime();
		this.telefon = u.getTelefon();
		this.email = u.getEmail();
		this.teritorija = u.getTeritorija();
		this.slika = u.getSlika();
		this.stanje = u.getStanje();

	}
	
	
	public User() {
		super();
	}


	public String getKorisnicko() {
		return korisnicko;
	}

	public void setKorisnicko(String korisnicko) {
		this.korisnicko = korisnicko;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Teritorija getTeritorija() {
		return teritorija;
	}

	public void setTeritorija(Teritorija teritorija) {
		this.teritorija = teritorija;
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

	@Override
	public String toString() {
		return "Useri [korisnicko=" + korisnicko + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime=" + prezime
				+ ", telefon=" + telefon + ", email=" + email + ", teritorija=" + teritorija + ", slika=" + slika
				+ ", stanje=" + stanje + "]";
	}
}
