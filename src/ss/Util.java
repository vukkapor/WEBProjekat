package ss;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.VanredneSituacije;
import model.TeritorijE;
import model.Users;

public class Util {

	public static VanredneSituacije citajSituacije(String putanja) {
		ObjectMapper om = new ObjectMapper();
		VanredneSituacije situacije = null;
		try {
			situacije = om.readValue(new File(putanja + File.separator + "vanredne.json"), VanredneSituacije.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return situacije;
	}
	
	public static void pisiSituacije(String putanja, VanredneSituacije situacije) {
		ObjectMapper om = new ObjectMapper();
		try {
			om.writeValue(new File(putanja + File.separator + "vanredne.json"), situacije);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static TeritorijE citajTeritorije(String putanja) {
		ObjectMapper om = new ObjectMapper();
		TeritorijE teritorije = null;
		try {
			teritorije = om.readValue(new File(putanja + File.separator + "teritorije.json"), TeritorijE.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return teritorije;
	}
	
	public static void pisiTeritorije(String putanja, TeritorijE teritorije) {
		ObjectMapper om = new ObjectMapper();
		try {
			om.writeValue(new File(putanja + File.separator + "teritorije.json"), teritorije);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Users citajUsere(String putanja) {
		System.out.println(putanja);
		ObjectMapper om = new ObjectMapper();
		Users users = null;
		try {
			users = om.readValue(new File(putanja + File.separator + "korisnici.json"), Users.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	public static void pisiUsere(String putanja, Users users) {
		ObjectMapper om = new ObjectMapper();
		try {
			om.writeValue(new File(putanja + File.separator + "korisnici.json"), users);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
