package com.example.datanucleus.stub;

import java.util.ArrayList;
import java.util.List;

import com.example.datanucleus.DAO_Class.Access;
import com.example.datanucleus.DAO_Class.Duration;
import com.example.datanucleus.DAO_Class.Event;
import com.example.datanucleus.DAO_Class.Maps;
import com.example.datanucleus.DAO_Class.Marker;
import com.example.datanucleus.DAO_Class.Position;
import com.example.datanucleus.DAO_Class.User;


public class StubActionMaps implements com.example.datanucleus.DAO_Class.actionMaps {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		String name = "a";
		return name;
	}

	@Override
	public List<Marker> getMarker() {
		// TODO Auto-generated method stub
    	Position pos = new Position(1,2);
		Marker mark1 = new Marker("Mark1", pos);
		Marker mark2 = new Marker("Mark2", pos);
		List <Marker> lMark = new ArrayList<>();
		lMark.add(mark1);
		lMark.add(mark2);
		return lMark;
	}

	@Override
	public List<User> getAcess() {
		// TODO Auto-generated method stub
		Access a = new Access();
		User user1 = new User("Bruno","Guimaraes",a);
		User user2 = new User("Moussa","Dembele",a);
		List <User> lUser = new ArrayList<>();
		lUser.add(user1);
		lUser.add(user2);
		return lUser;
    }
    
    @Override
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
    
    @Override
    public void printMap() {
		//actionMaps.getInstance().printMap();
		//System.out.println(Image);
		//Image img1 = ImageIO.read(new File("../../../../../../../../1.PNG"));
    }
    
    @Override
    public void shareMap(Maps m, User u) {
		//actionMaps.getInstance().shareMap(m,u);
		//m.access.add(u);
    }
    
    @Override
    public void unshareMap(Maps m, User u) {
		//actionMaps.getInstance().unshareMap(m,u);
		//m.access.remove(u);
	}

	@Override
	public void addMarker(String name, Position localisation) {
		//actionMaps.getInstance().addMarker(name, localisation);
		//mark.add();
	}

	@Override
	public void deleteMarker(Marker point) {
		//actionMaps.getInstance().deleteMarker(point);
		//mark.remove(point);
	}

	@Override
	public void addEvent(String name, Position localisation, Duration time) {
		//actionMaps.getInstance().addMarker(name, localisation, time);
		//ev.add();
	}

	@Override
	public void deleteEvent(Event evt) {
		//actionMaps.getInstance().deleteEvent(evt);
		//ev.remove(evt);
	}

}
