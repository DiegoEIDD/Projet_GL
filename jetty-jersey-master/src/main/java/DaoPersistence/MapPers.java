package DaoPersistence;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.example.datanucleus.DAO_Class.Duration;
import com.example.datanucleus.DAO_Class.Event;
import com.example.datanucleus.DAO_Class.Maps;
import com.example.datanucleus.DAO_Class.Marker;
import com.example.datanucleus.DAO_Class.Position;
import com.example.datanucleus.DAO_Class.User;
import com.example.datanucleus.DAO_Class.actionMaps;

public class MapPers implements actionMaps {
	
	private PersistenceManagerFactory pmf;

	public MapPers(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@Override
	public String getName(Maps m) {
		// TODO Auto-generated method stub
		return m.getName();
	}
	

	@Override
	public List<Marker> getMarker() {

		List<Marker> markers = null;
		List<Marker> detached = new ArrayList<Marker>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(User.class);
			markers = (List<Marker>) q.execute("");
			detached = (List<Marker>) pm.detachCopyAll(markers);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			System.out.println(detached);
			return detached;
		}
	}

	@Override
	public List<Event> getEvent() {

		List<Event> events = null;
		List<Event> detached = new ArrayList<Event>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Event.class);
			markers = (List<Event>) q.execute("");
			detached = (List<Event>) pm.detachCopyAll(events);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			System.out.println(detached);
			return detached;
		}
	}

	@Override
	public List<User> getAcess() {
		// TODO Auto-generated method stub
		List<User> sharingUsers = null;
		List<User> detached = new ArrayList<User>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(User.class);
			sharingUsers = (List<User>) q.execute("");
			detached = (List<User>) pm.detachCopyAll(sharingUsers);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			System.out.println(detached);
			return detached;
		}
	}

	@Override
	public boolean printMap() {
		// TODO Auto-generated method stub
		//à faire en JS
		return false;
	}

	@Override
	public boolean shareMap(Maps m, User friend) {
		// TODO Auto-generated method stub
		//à faire en JS
		return false;
	}

	@Override
	public boolean unshareMap(Maps m, User friend) {
		// TODO Auto-generated method stub
		//à faire en JS
		return false;
	}

	@Override
	public boolean addMarker(String name, Position localisation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMarker(String mark) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean ret = true;
		try {
			tx.begin();
			Marker m = this.restrictedFriendList(mark).get(0);
			int userid = m.getId();
			if(m!=null) {
				Query q = pm.newQuery(Marker.class);
				q.declareParameters("Integer markerid");
				q.setFilter("id == markerid");
				q.deletePersistentAll(markerid);
				tx.commit();
			}
		} finally {
			if (tx.isActive()) {
				tx.rollback();
				ret = false;
			}
			pm.close();
		}
		return ret;
	}

	@Override
	public boolean addEvent(String name, Position localisation, Duration time) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEvent(String evt) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean ret = true;
		try {
			tx.begin();
			Event e = this.restrictedFriendList(evt).get(0);
			int userid = e.getId();
			if(e!=null) {
				Query q = pm.newQuery(Event.class);
				q.declareParameters("Integer eventid");
				q.setFilter("id == eventid");
				q.deletePersistentAll(eventid);
				tx.commit();
			}
		} finally {
			if (tx.isActive()) {
				tx.rollback();
				ret = false;
			}
			pm.close();
		}
		return ret;
	}

}
