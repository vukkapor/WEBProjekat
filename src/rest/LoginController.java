package rest;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.TeritorijE;
import model.Teritorija;
import model.User;
import model.Users;

import ss.Util;

@Path("/users")
public class LoginController {

	@Context
	ServletContext ctx;
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User login(@Context HttpServletRequest request, HashMap<String, String> mapa) {
		Users users = (Users) ctx.getAttribute("user");
		if(users == null) {
			Users u = Util.citajUsere(ctx.getRealPath(""));
			ctx.setAttribute("user", u);
			users = (Users) ctx.getAttribute("user");
		}
		
		String korisnicko = mapa.get("korisnickoSlanje");
		String lozinka = mapa.get("lozinkaSlanje");
		System.out.println(lozinka+ korisnicko);
		
		
		if(users.getUser(korisnicko) != null) {
			if(users.getUser(korisnicko).getLozinka().equals(lozinka)) {
				request.getSession().setAttribute("user", users.getUser(korisnicko));
				return users.getUser(korisnicko);
				
			}
		}
		return null;
	}

	@POST
	@Path("/logout")
	public void logout(@Context HttpServletRequest request) {
		request.getSession().invalidate();
	}
	

	@GET
	@Path("/getTeritorije")
	@Produces(MediaType.APPLICATION_JSON)
	public TeritorijE getTeritorije(@Context HttpServletRequest request) {
		TeritorijE ter = (TeritorijE) ctx.getAttribute("teritorije");
		if (ter == null) {
			ter = Util.citajTeritorije(ctx.getRealPath(""));
			ctx.setAttribute("teritorije", ter);
		}
		return (TeritorijE) ctx.getAttribute("teritorije");
	}
	
	private boolean korisnikPostoji(String korisnicko) {
		Users users = (Users) ctx.getAttribute("user");
		if(users == null) {
			try {
				Users u = Util.citajUsere(ctx.getRealPath(""));
				ctx.setAttribute("user", u);
				users = (Users) ctx.getAttribute("user");
			} catch (Exception e) {
				users = new Users();
				ctx.setAttribute("user", users);
			}
		}
		return users.korisnikPostoji(korisnicko);
	}
	
	

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean register(@Context HttpServletRequest request, HashMap<String, String> mapa) {
		
		TeritorijE terr = (TeritorijE) ctx.getAttribute("teritorije");
		Teritorija teritorija = terr.getTeritorija(mapa.get("teritorija"));


		User user = new User(
				mapa.get("korisnicko"),
				mapa.get("lozinka"),
				mapa.get("ime"),
				mapa.get("prezime"),
				mapa.get("telefon"),
				mapa.get("email"),
				teritorija,
				"Aktivno",
				mapa.get("korisnicko") + ".jpg");
		System.out.println(user);
		if(korisnikPostoji(user.getKorisnicko())) {
			return false;
		}
		dodajUsera(user);
		request.getSession().setAttribute("slika", user.getKorisnicko() + ".jpg");
		return true;
		

	}
	
	@POST
	@Path("/uploadImage")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadSlike(@Context HttpServletRequest request, InputStream is) throws IOException {
		String imageName = (String) request.getSession().getAttribute("image");
		int read;
		byte[] bytes = new byte[1024];
		File f = new File(ctx.getRealPath("") + File.separator + imageName);
		//f.createNewFile();
		OutputStream os = new FileOutputStream(f);
		
		while((read = is.read(bytes)) != -1)
			os.write(bytes, 0, read);
		
		os.flush();
		os.close();
	}
	@GET
	@Path("/getImage")
	@Produces(MediaType.APPLICATION_JSON)
	public String getImagePath(@Context HttpServletRequest request) {
		return ctx.getRealPath("") + File.separator;
	}
	

	private void dodajUsera(User u) {
		Users users = (Users) ctx.getAttribute("user");
		if(users == null) {
			Users us = Util.citajUsere(ctx.getRealPath(""));
			ctx.setAttribute("user", us);
			users = (Users) ctx.getAttribute("user");
			System.out.println(ctx.getRealPath(""));
		}
		users.dodajUsera(u);
		Util.pisiUsere(ctx.getRealPath(""), users);
	}

	@POST
	@Path("/guestLogin")
	@Produces(MediaType.APPLICATION_JSON)
	public User createGuest(@Context HttpServletRequest request) {
		User u = new User("korisnicko", "lozinka", "ime",
				"prezime", "telefon", "email",
				new Teritorija(), "", "guest.jpg");
		request.getSession().setAttribute("user", u);
		return u;
	}
	
	
	@GET
	@Path("/loggedUser")
	@Produces(MediaType.APPLICATION_JSON)
	public User getLoggedUser(@Context HttpServletRequest request) {
		User u = (User)request.getSession().getAttribute("user");
		return u;
	}
	
	@POST
	@Path("/registrujTeritoriju")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void registerTerritory(@Context HttpServletRequest request, HashMap<String, String> mapa) {
		Teritorija teritorija = new Teritorija(
				mapa.get("naziv"), 
				Integer.parseInt(mapa.get("povrsina")), 
				Integer.parseInt(mapa.get("stanovnika")));
		
		addTeritoriju(teritorija);
	}
	
	private void addTeritoriju(Teritorija teritorija) {
		TeritorijE terr = ((TeritorijE) ctx.getAttribute("teritorije"));
		if (terr == null) {
			terr = Util.citajTeritorije(ctx.getRealPath(""));
			ctx.setAttribute("teritorije", terr);
		}
		
		terr.dodajTeritoriju(teritorija);
		Util.pisiTeritorije(ctx.getRealPath(""), terr);
	}


	
}
