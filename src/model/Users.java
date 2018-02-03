package model;

import java.util.HashMap;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Users {
	private HashMap<String, User> users;

	public Users(HashMap<String, User> users) {
		super();
		this.users = users;
	}

	public Users() {
		super();
		this.users = new HashMap<>();
	}

	public HashMap<String, User> getUser() {
		return users;
	}

	public void setUser(HashMap<String, User> user) {
		this.users = user;
	}

	@Override
	public String toString() {
		return "Users [users=" + users + "]";
	}
	
	public void dodajUsera(User user) {
		this.users.put(user.getKorisnicko(), user);
	}
	
	public boolean korisnikPostoji(String korisnik) {
		return users.get(korisnik) != null;
	}

	
	public boolean proveraUsera(String korisnicko) {
		if(users.get(korisnicko) != null) {
			return true;
		}else {
			return false;
		}
		
	}
	public User getUser(String username) {
		return users.get(username);
	}
	
	
	
}
