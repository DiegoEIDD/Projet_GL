
package com.example.jetty_jersey.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.datanucleus.DAO_Class.User;
import com.example.datanucleus.DAO_Class.Access;
import com.example.datanucleus.DAO_Class.DAO;
import com.example.datanucleus.DAO_Class.Duration;
import com.example.datanucleus.DAO_Class.Event;
import com.example.datanucleus.DAO_Class.Maps;
import com.example.datanucleus.DAO_Class.Marker;
import com.example.datanucleus.DAO_Class.Position;
import com.example.datanucleus.DAO_Class.actionMarker;
import com.example.datanucleus.DAO_Class.actionUser;


@Path("/user")
public class UserResource{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/name")
	public String getName(User u2) {
		// actionUser.getInstance().getName();
		Access a = new Access();
		User u = new User("juninho", "pernambucano");
		return u.getName();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/password")
	public String getPassword(User u1) {
		// actionUser.getInstance().getPassword();
		Access a = new Access();
		User u = new User("juninho", "pernambucano");
		return u.getPassword();
	}

	public static class Toto {
		public Integer value;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addMap")
	public boolean addMaps(Toto toto) {
		System.out.println(toto.value);
		//List maps;
		//actionUser.getInstance().addMaps(m);
		//maps.add(m);
		return true;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/modNames")
	public boolean modifyMapName(/*Maps m, String newName*/) {
		//actionUser.getInstance().modifyMapName(m,newName);
		//m.name = newName;
		return true;
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/friend")
	public List<String> getFriends() {
		//return actionUser.getInstance().getFriends();
		String s1= "Martin";
		String s2 = "Lucas";
		List <String> lString = new ArrayList<>();
		lString.add(s1);
		lString.add(s2);
		return lString;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addF")
	public void addFriends(User u) {
		//List friends;
		//actionUser.getInstance().addFriends(u);
		//friends.add(u);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteF")
	public boolean deleteFriends(/*User u*/) {
		//List friends;
		//actionUser.getInstance().deleteFriends(u);
		//friends.remove(u);
		return true;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/maps")
	public List<Maps> getMaps() {
		//return actionUser.getInstance().getMaps();
		Maps map1 = new Maps("Jason");
		Maps map2 = new Maps("Anthony");
		List <Maps> lMaps = new ArrayList<>();
		lMaps.add(map1);
		lMaps.add(map2);
		return lMaps;
	}
	
	@DELETE
	@Path("/deleteMap")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteMap(@QueryParam("Map") String mapId) {
		//List maps;
		//actionUser.getInstance().deleteMap(m);
		//maps.remove(m);
	}

	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/RMap")
//	public List<Maps> restrictedMapList(String search) {
//		//return actionUser.getInstance().restrictedMapList();
//		Stream<Maps> sm = actionUser.getMaps().stream();
//		List<Maps> restricted = sm.map(m -> m.getName())
//		  .filter(m -> ifCharsEqual())
//		  .collect(toList());
//		return restricted;
//		Maps map1 = new Maps("Carl");
//		Maps map2 = new Maps("Houssem");
//		List <Maps> lMaps = new ArrayList<>();
//		lMaps.add(map1);
//		lMaps.add(map2);
//		return lMaps;
//	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/friend_map/RFriend")
//	public List<String> restrictedFriendList(String search) {
//		//return actionUser.getInstance().restrictedFriendList();
//		Stream<User> sf = actionUser.getFriends().stream();
//		List<Maps> restricted = sf.map(f -> f.getName())
//		  .filter(m -> ifCharsEqual())
//		  .collect(toList());
//		return restricted;
//		String s1= "Leo";
//		String s2 = "Jason";
//		List <String> lString = new ArrayList<>();
//		lString.add(s1);
//		lString.add(s2);
//		return lString;
//    }
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/login")
	public String login(@FormParam("username") String name,@FormParam("password") String mdp) {
		
		actionUser uAction = DAO.getName();
		User u = uAction.restrictedFriendList(name).get(0);
		//User u = uAction.getName(name);
		if(Objects.isNull(u)) {
			return "Invalid email or password";
		}
		else if(u.getPassword().equals(mdp)) {
			return "Connected";
		}
		else {
			return "Invalid email or password";
		}
	}
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/signUp")
	public String signUp(@FormParam("userSign") String name, @FormParam("email") String email,@FormParam("passSign") String mdp) {
		if(Objects.isNull(name) || Objects.isNull(email) || Objects.isNull(mdp)){
			return "All fields must be completed";
		}
		actionUser uAction = DAO.getName();
		if(uAction.restrictedFriendList(name).size()!=0){
			return "Username already exist";
		}
		User u = new User(name,mdp);
		//u.setName(name);
		u.setEmail(email);
		//u.setPassword(mdp);
		uAction.createUser(u);
		return "Sign Up completed";
	}

}
