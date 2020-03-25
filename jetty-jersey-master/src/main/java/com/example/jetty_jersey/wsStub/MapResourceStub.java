package com.example.jetty_jersey.wsStub;

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
import com.example.datanucleus.stub.StubActionMaps;
import com.example.datanucleus.stub.StubActionMarker;

@Path("/map")
public class MapResourceStub{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/names")
	public User getName() {
		// actionMaps.getInstance().getName();
		StubActionMaps map = new StubActionMaps();
		return map.getName();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/access")
	public List<User> getAccess() {
		//return actionMaps.getInstance().getAcess();
		StubActionMaps map = new StubActionMaps();
		return map.getAcess();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/share")
	public boolean shareMap(/*Maps m, User u*/) {
		//actionMaps.getInstance().shareMap(m,u);
		//m.access.add(u);
		/*Maps m = new Maps("map");
		Access a = new Access();
		User u = new User("juninho", "pernambucano",a);*/
		//StubActionMaps map = new StubActionMaps();
		//return map.shareMap(m, u);
		return true;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/markers")
	public List<Marker> getMarker() {
		//return actionMaps.getInstance().getMarker();
		//return m.mark;
		StubActionMaps map = new StubActionMaps();
		return map.getMarker();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/unshare")
	public boolean unshareMap(/*Maps m, User u*/) {
		//actionMaps.getInstance().unshareMap(m,u);
		//m.access.remove(u);
		Maps m = new Maps("map");
		Access a = new Access();
		User u = new User("juninho", "pernambucano",a);
		StubActionMaps map = new StubActionMaps();
		return map.unshareMap(m, u);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/event")
	public List<Event> getEvent() {
		//return actionMaps.getInstance().getEvent(m);
		//return m.ev;
		StubActionMaps map = new StubActionMaps();
		return map.getEvent();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addMark")
	public boolean addMarker(/*String name, Position localisation*/) {
		//actionMaps.getInstance().addMarker(name, localisation);
		//mark.add();
		//Position pos = new Position(1,2);
		//StubActionMaps map = new StubActionMaps();
		//map.addMarker("test", pos);
		return true;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addEvt")
	public boolean addEvent(/*String name, Position localisation, Duration time*/) {
		//actionMaps.getInstance().addMarker(name, localisation, time);
		//ev.add();
		StubActionMaps map = new StubActionMaps();
		Position pos = new Position(1,2);
		Duration dur = new Duration(9,3,2020,10);
		map.addEvent("test", pos, dur);
		return true;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/print")
	public boolean printMap() {
		//actionMaps.getInstance().printMap();
		//System.out.println(Image);
		//Image img1 = ImageIO.read(new File("../../../../../../../../1.PNG"));
		StubActionMaps map = new StubActionMaps();
		return map.printMap();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delMark")
	public boolean deleteMarker(/*Marker point*/) {
		//actionMaps.getInstance().deleteMarker(point);
		//mark.remove(point);
		StubActionMaps map = new StubActionMaps();
		Marker m = new Marker(null, null);
		return map.deleteMarker(m);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delEvt")
	public boolean deleteEvent(/*Event evt*/) {
		//actionMaps.getInstance().deleteEvent(evt);
		//ev.remove(evt);
		StubActionMaps map = new StubActionMaps();
		Event e = new Event(null, null, null);
		return map.deleteEvent(e);
	}

}