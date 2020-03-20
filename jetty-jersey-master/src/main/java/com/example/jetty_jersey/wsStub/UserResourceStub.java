
package com.example.jetty_jersey.wsStub;

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
import javax.ws.rs.QueryParam;
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
import com.example.datanucleus.stub.StubActionUser;

@Path("/user")
public class UserResourceStub{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/name")
	public User getName() {
		StubActionUser u = new StubActionUser();
		return u.getName();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/password")
	public User getPassword() {
		// actionUser.getInstance().getPassword();
		StubActionUser u = new StubActionUser();
		String pas = "password";
		return u.getName();
	}

	public static class Toto {
		public Integer value;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addMap")
	public boolean addMaps(/*Toto toto Maps map*/) {
		/*System.out.println(toto.value);*/
		StubActionUser u = new StubActionUser();
		//List maps;
		//actionUser.getInstance().addMaps(m);
		//maps.add(m);
		Maps map = new Maps(null);
		return u.addMap(map);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/modNames")
	public boolean modifyMapName(/*Maps m, String newName*/) {
		StubActionUser u = new StubActionUser();
		//actionUser.getInstance().modifyMapName(m,newName);
		//m.name = newName;
		Maps map = new Maps(null);
		return u.modifyMapName(map, "newName");
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/friend")
	public List<String> getFriends() {
		//return actionUser.getInstance().getFriends();
		StubActionUser u = new StubActionUser();
		return u.getFriends();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addF")
	public boolean addFriends(/*User f*/) {
		//List friends;
		//actionUser.getInstance().addFriends(u);
		//friends.add(u);
		User f = new User(null, null, null);
		StubActionUser u = new StubActionUser();
		return u.addFriends(f);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteF")
	public boolean deleteFriends(/*User friend*/) {
		//List friends;
		//actionUser.getInstance().deleteFriends(u);
		//friends.remove(u);
		User f = new User(null, null, null);
		StubActionUser u = new StubActionUser();
		return u.deleteFriends(f);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/maps")
	public List<Maps> getMaps() {
		//return actionUser.getInstance().getMaps();
		StubActionUser u = new StubActionUser();
		return u.getMaps();
	}
	
	@DELETE
	@Path("/deleteMap")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean deleteMap(/*@QueryParam("Map") String mapId*/) {
		//List maps;
		//actionUser.getInstance().deleteMap(m);
		//maps.remove(m);
		Maps map = new Maps(null);
		StubActionUser u = new StubActionUser();
		return u.deleteMap(map);
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

}
