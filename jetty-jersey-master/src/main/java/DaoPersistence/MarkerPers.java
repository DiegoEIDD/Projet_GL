package DaoPersistence;

import java.util.List;
import java.awt.Image;
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
import com.example.datanucleus.DAO_Class.actionMarker;

public class MarkerPers implements actionMarker {
	
	private PersistenceManagerFactory pmf;

	public MarkerPers(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@Override
	public Marker getName(String name) {
		// TODO Auto-generated method stub
		return this.getRestrictedMarker(name).get(0);
	}

	@Override
	public List<Image> getImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getMessages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Duration getDuration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addImage(String way) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteImage(Image img) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMessage(String msg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMessage(String msg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createMarker(Marker m) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
<<<<<<< Updated upstream
		Marker u = new Marker(name);
=======
		
>>>>>>> Stashed changes
		int id =0;
		if(this.getMarker().size()!=0) {
			for(int i = 0;i<this.getMarker().size();i++) {
				if(id<this.getMarker().get(i).getId()) {
					id=this.getMarker().get(i).getId();
				}
			
			}
		}
		boolean ret = true;
		try {
			tx.begin();
			pm.makePersistent(m);
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
	public boolean delMarker(String name) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean ret = true;
		try {
			tx.begin();
			Marker u = this.getRestrictedMarker(name).get(0);
			int markerid = u.getId();
			if(u!=null) {
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
	public boolean EditMarkerName(String current,String newName) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean ret = true;
		try {
			tx.begin();
			Marker u = this.getRestrictedMarker(current).get(0);
			if(u!=null) {
				u.setName(newName);
				this.delMarker(current);
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
	public List<Marker> getRestrictedMarker(String search) {
		// TODO Auto-generated method stub
		List<Marker> mark = null;
		List<Marker> detached = new ArrayList<Marker>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Marker.class);
            q.declareParameters("String search");
            q.setFilter("name.startsWith(search)");
            mark = (List<Marker>) q.execute(search);
			detached = (List<Marker>) pm.detachCopyAll(mark);
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
	public List<Marker> getMarker() {
		// TODO Auto-generated method stub
		List<Marker> s = null;
		List<Marker> detached = new ArrayList<Marker>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Marker.class);
			s = (List<Marker>) q.execute("");
			detached = (List<Marker>) pm.detachCopyAll(s);
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
	public boolean editPos(String name,int lat, int longi) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Position p = new Position(lat, longi);
		boolean ret = true;
		try {
			tx.begin();
			Marker u = this.getRestrictedMarker(name).get(0);
			if(u!=null) {
				u.setLat(lat);
				u.setLon(longi);
				this.delMarker(name);
				Query q = pm.newQuery(Marker.class);
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
	
}
