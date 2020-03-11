
package com.example.jetty_jersey.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.datanucleus.DAO_Class.User;
import com.example.datanucleus.DAO_Class.Access;
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
	public User getName() {
		// actionUser.getInstance().getName();
		Access a = new Access();
		User u = new User("juninho", "pernambucano",a);
		return u;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/password")
	public String getPassword() {
		// actionUser.getInstance().getPassword();
		String pas = "password";
		return pas;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addMap")
	public boolean addMaps(/*String m*/) {
		//List maps;
		//actionUser.getInstance().addMaps(m);
		//maps.add(m);
		return true;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("names")
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
	/*
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("friend_map/{Friend}")
	public void addFriends(User u) {
		//List friends;
		//actionUser.getInstance().addFriends(u);
		//friends.add(u);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("friend_map/{Friend}")
	public void deleteFriends(User u) {
		//List friends;
		//actionUser.getInstance().deleteFriends(u);
		//friends.remove(u);
	}
	*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/map")
	public List<Maps> getMaps() {
		//return actionUser.getInstance().getMaps();
		Maps map1 = new Maps("Jason");
		Maps map2 = new Maps("Anthony");
		List <Maps> lMaps = new ArrayList<>();
		lMaps.add(map1);
		lMaps.add(map2);
		return lMaps;
	}
	/*
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("friend_map/{Map}")
	public void deleteMap(Maps m) {
		//List maps;
		//actionUser.getInstance().deleteMap(m);
		//maps.remove(m);
	}
*/	
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/RMap")
	public List<Maps> restrictedMapList(String search) {
		//return actionUser.getInstance().restrictedMapList();
		Stream<Maps> sm = actionUser.getMaps().stream();
		List<Maps> restricted = sm.map(m -> m.getName())
		  .filter(m -> ifCharsEqual())
		  .collect(toList());
		return restricted;
		Maps map1 = new Maps("Carl");
		Maps map2 = new Maps("Houssem");
		List <Maps> lMaps = new ArrayList<>();
		lMaps.add(map1);
		lMaps.add(map2);
		return lMaps;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("friend_map/{Friend}")
	public List<String> restrictedFriendList(String search) {
		//return actionUser.getInstance().restrictedFriendList();
		Stream<User> sf = actionUser.getFriends().stream();
		List<Maps> restricted = sf.map(f -> f.getName())
		  .filter(m -> ifCharsEqual())
		  .collect(toList());
		return restricted;
		String s1= "Leo";
		String s2 = "Jason";
		List <String> lString = new ArrayList<>();
		lString.add(s1);
		lString.add(s2);
		return lString;
    }
*/
}
