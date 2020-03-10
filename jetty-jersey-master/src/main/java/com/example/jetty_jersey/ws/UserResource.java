package com.example.jetty_jersey.ws;

import java.util.ArrayList;
import java.util.List;

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

@Path("/map")
public class UserResource implements com.example.datanucleus.DAO_Class.actionUser{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public String getName() {
		// actionUser.getInstance().getName();
		String name = "name";
		return name;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public String getPassword() {
		// actionUser.getInstance().getPassword();
		String pas = "password";
		return pas;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public void addMaps(String m) {
		//List maps;
		//actionUser.getInstance().addMaps(m);
		//maps.add(m);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{names}")
	public void modifyMapName(Maps m, String newName) {
		//actionUser.getInstance().modifyMapName(m,newName);
		//m.name = newName;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("friend_map/{Friend}")
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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("friend_map/{Map}")
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
	@Produces(MediaType.APPLICATION_JSON)
	@Path("friend_map/{Map}")
	public void deleteMap(Maps m) {
		//List maps;
		//actionUser.getInstance().deleteMap(m);
		//maps.remove(m);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("friend_map/{Map}")
	public List<Maps> restrictedMapList(String search) {
		//return actionUser.getInstance().restrictedMapList();
		/*Stream<maps> sm = actionUser.getInstance().getMaps().stream();
		List<Maps> restricted = sm.map(m -> m.getName())
		  .filter(m -> ifCharsEqual())
		  .collect(toList());
		return restricted;*/
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
		/*Stream<Users> sf = actionUser.getInstance().getFriends().stream();
		List<Maps> restricted = sf.map(f -> f.getName())
		  .filter(m -> ifCharsEqual())
		  .collect(toList());
		return restricted;*/
		String s1= "Leo";
		String s2 = "Jason";
		List <String> lString = new ArrayList<>();
		lString.add(s1);
		lString.add(s2);
		return lString;
    }
	
}
