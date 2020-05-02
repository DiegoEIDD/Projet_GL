package DaoPersistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.example.datanucleus.DAO_Class.Maps;
import com.example.datanucleus.DAO_Class.User;
import com.example.datanucleus.DAO_Class.actionUser;

public class UserPers implements actionUser{
	
	private PersistenceManagerFactory pmf;

	public UserPers(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@Override
	public String getName(User u) {
		// TODO Auto-generated method stub
		return u.getName();
	}

	@Override
	public User getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Maps> getMaps() {
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
	public List<Maps> getAcess() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMap(String mapname){
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Maps u = new Maps(mapname,1);
		try {
			tx.begin();
			pm.makePersistent(u);
			tx.commit();
		}
		finally {
			if (tx.isActive()) {
				tx.rollback();

			}
			pm.close();
		}
		return true;
	}

	@Override
	public boolean deleteMap(String map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyMapName(Maps map, String newName) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<Maps> restrictedMapList(String search) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings({"unchecked","finally"})
	@Override
	public boolean addFriends(String friend) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		User u = new User(friend, "pernambucano",1);
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
			System.out.println(u.getName());
		}
		return ret;
	}

	@Override
	public boolean deleteFriends(String friend) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean ret = true;
		try {
			tx.begin();
			User u = this.restrictedFriendList(friend).get(0);
			int userid = u.getId();
			if(u!=null) {
				Query q = pm.newQuery(User.class);
				q.declareParameters("Integer userid");
				q.setFilter("id == userid");
				q.deletePersistentAll(userid);
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
	
	@SuppressWarnings({"unchecked","finally"})
	@Override
	public List<User> getFriends() {
		// TODO Auto-generated method stub
		List<User> users = null;
		List<User> detached = new ArrayList<User>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(User.class);
			users = (List<User>) q.execute("");
			detached = (List<User>) pm.detachCopyAll(users);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			return detached;
		}
	}
	
	@SuppressWarnings({"unchecked","finally"})
	@Override
	public List<User> restrictedFriendList(String search) {
		// TODO Auto-generated method stub
		List<User> map = null;
		List<User> detached = new ArrayList<User>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(User.class);
            q.declareParameters("String search");
            q.setFilter("name.startsWith(search)");
            map = (List<User>) q.execute(search);
			detached = (List<User>) pm.detachCopyAll(map);
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
	public boolean editName(String current ,String newName) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean ret = true;
		try {
			tx.begin();
			User u = this.restrictedFriendList(current).get(0);
			if(u!=null) {
				u.setName(newName);
				this.deleteFriends(current);
				Query q = pm.newQuery(User.class);
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
	

