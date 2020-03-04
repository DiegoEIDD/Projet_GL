package com.example.jetty_jersey.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import projet_gl.Maps;

@Path("/map")
public class MapResource {

	public static class MapClass {
		public String field;
	}
	
	static List<User> friends = new ArrayList<User>();
	static List<Maps> maps = new ArrayList<Maps>();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/map/friend&map/{Friend}")
	public List<User> getFriends() {
		return friends;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/map/friend&map/{Friend}")
	public void addFriends(User u) {
		friends.add(u);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/map/friend&map/{Friend}")
	public void deleteFriends(User u) {
		friends.remove(u);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/map/friend&map/{Map}")
	public List<Maps> getMaps() {
		return maps;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/map/friend&map/{Map}")
	public void addFriends(Maps m) {
		maps.add(m);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/map/friend&map/{Map}")
	public void deleteFriends(Maps m) {
		maps.remove(m);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/map/friend&map/{Map}")
	public List<Maps> getRestrictedMaps() {
		
		return maps;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/map")
	public void retrieveExample(ExampleClass instance) {
		System.out.println(instance.field);
	}

}
