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

import com.example.datanucleus.DAO_Class.Access;
import com.example.datanucleus.DAO_Class.Duration;
import com.example.datanucleus.DAO_Class.Event;
import com.example.datanucleus.DAO_Class.Maps;
import com.example.datanucleus.DAO_Class.Marker;
import com.example.datanucleus.DAO_Class.Position;
import com.example.datanucleus.DAO_Class.User;
import com.example.datanucleus.DAO_Class.actionMaps;

@Path("/map")
public class MapResource implements actionMaps{
	
	public String getName() {
		// actionMaps.getInstance().getName();
		String name = "name";
		return name;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{friend}")
	public void shareMap(Maps m, User u) {
		//actionMaps.getInstance().shareMap(m,u);
		//m.access.add(u);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{friend}")
	public void unshareMap(Maps m, User u) {
		//actionMaps.getInstance().unshareMap(m,u);
		//m.access.remove(u);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("tools/{sharedWith}")
	public List<User> getAccess() {
		//return actionMaps.getInstance().getAcess();
		Access a = new Access();
		User user1 = new User("Bruno","Guimaraes",a);
		User user2 = new User("Moussa","Dembele",a);
		List <User> lUser = new ArrayList<>();
		lUser.add(user1);
		lUser.add(user2);
		return lUser;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("tools/{places}")
	public List<Marker> getMarker() {
		//return actionMaps.getInstance().getMarker();
		//return m.mark;
		Position pos = new Position(1,2);
		Marker mark1 = new Marker("Mark1", pos);
		Marker mark2 = new Marker("Mark2", pos);
		List <Marker> lMark = new ArrayList<>();
		lMark.add(mark1);
		lMark.add(mark2);
		return lMark;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("tools/{event}")
	public List<Event> getEvent() {
		//return actionMaps.getInstance().getEvent(m);
		//return m.ev;
		Duration dur = new Duration(9,3,2020,10);
    	Position pos = new Position(1,2);
		Event ev1 = new Event(dur,"Event1",pos);
		Event ev2 = new Event(dur,"Event2",pos);
		List <Event> lEvent = new ArrayList<>();
		lEvent.add(ev1);
		lEvent.add(ev2);
		return lEvent;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public void printMap() {
		//actionMaps.getInstance().printMap();
		//System.out.println(Image);
		//Image img1 = ImageIO.read(new File("../../../../../../../../1.PNG"));
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public void addMarker(String name, Position localisation) {
		//actionMaps.getInstance().addMarker(name, localisation);
		//mark.add();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public void addEvent(String name, Position localisation, Duration time) {
		//actionMaps.getInstance().addMarker(name, localisation, time);
		//ev.add();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public void deleteMarker(Marker point) {
		//actionMaps.getInstance().deleteMarker(point);
		//mark.remove(point);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public void deleteEvent(Event evt) {
		//actionMaps.getInstance().deleteEvent(evt);
		//ev.remove(evt);
	}
	
}
