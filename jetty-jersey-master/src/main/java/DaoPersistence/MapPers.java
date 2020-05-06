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
	public String getName(String name) {
		// TODO Auto-generated method stub
		Maps m = getRestrictedMap(name).get(0);
		return m.getName();
	}
	

	@Override
	public List<Marker> getMarker(String map) {
		Maps m = getRestrictedMap(map).get(0);
		return m.getMark();
	}

	@Override
	public List<Event> getEvent(String map) {
		Maps m = getRestrictedMap(map).get(0);
		return m.getEv();
	}

	@Override
	public List<User> getAcess(String map) {
		// TODO Auto-generated method stub
		Maps m = getRestrictedMap(map).get(0);
		return m.getAccess();
	}

	@Override
	public boolean printMap() {
		// TODO Auto-generated method stub
		//� faire en JS
		return false;
	}

	@Override
	public boolean shareMap(Maps m, User friend) {
		// TODO Auto-generated method stub
		//� faire en JS
		return false;
	}

	@Override
	public boolean unshareMap(Maps m, User friend) {
		// TODO Auto-generated method stub
		//� faire en JS
		return false;
	}

	@Override
	public boolean addMarker(String name, Position localisation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMarker(String mark) {
		return false;
	}

	@Override
	public boolean addEvent(String name, Position localisation, Duration time) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEvent(String evt) {
		return false;
	}




	@Override
	public boolean createMap(String name) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		int i = this.getMap().size();
		Maps u = new Maps(name, i);
		boolean ret = true;
		try {
			tx.begin();
			pm.makePersistent(u);
			tx.commit();
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
	public boolean editMapName(String current,String newName) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean ret = true;
		try {
			tx.begin();
			Maps u = this.getRestrictedMap(current).get(0);
			if(u!=null) {
				u.setName(newName);
				this.delMap(current);
				Query q = pm.newQuery(Maps.class);
				pm.makePersistent(u);
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
	public boolean editMapId(String user, int id) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean ret = true;
		try {
			tx.begin();
			Maps u = this.getRestrictedMap(user).get(0);
			if(u!=null) {
				u.setId(id);
				this.delMap(user);
				Query q = pm.newQuery(Maps.class);
				pm.makePersistent(u);
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
	public List<Maps> getMap() {
		// TODO Auto-generated method stub
		List<Maps> users = null;
		List<Maps> detached = new ArrayList<Maps>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(User.class);
			users = (List<Maps>) q.execute("");
			detached = (List<Maps>) pm.detachCopyAll(users);
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
	public List<Maps> getRestrictedMap(String search) {
		// TODO Auto-generated method stub
		List<Maps> map = null;
		List<Maps> detached = new ArrayList<Maps>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(User.class);
            q.declareParameters("String search");
            q.setFilter("name.startsWith(search)");
            map = (List<Maps>) q.execute(search);
			detached = (List<Maps>) pm.detachCopyAll(map);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			return detached;
		}
	}

	@Override
	public boolean delMap(String map) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean ret = true;
		try {
			tx.begin();
			Maps u = this.getRestrictedMap(map).get(0);
			int mapid = u.getId();
			if(u!=null) {
				Query q = pm.newQuery(Maps.class);
				q.declareParameters("Integer userid");
				q.setFilter("id == userid");
				q.deletePersistentAll(mapid);
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
