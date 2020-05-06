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
	public String getName(String u) {
		// TODO Auto-generated method stub
		User u1 = restrictedFriendList(u).get(0);
		return u1.getName();
	}

	@Override
	public String getPassword(String u) {
		// TODO Auto-generated method stub
		User u1 = restrictedFriendList(u).get(0);
		return u1.getPassword();
	}

	@Override
	public List<Maps> getMaps(User u) {
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
	public List<Maps> getAcess(User u) {
		// TODO Auto-generated method stub
		return u.getMap();
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
	public boolean createUser(String friend) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		int i = this.getUser().size();
		User u = new User(friend, "pernambucano",i+1);
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
	public boolean delUser(String friend) {
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
	public List<User> getUser() {
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
				this.delUser(current);
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
	
	@Override
	public boolean editPassword(String user ,String password) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean ret = true;
		try {
			tx.begin();
			User u = this.restrictedFriendList(user).get(0);
			if(u!=null) {
				u.setPassword(password);;
				this.delUser(user);
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

	@Override
	public boolean addFriends(String friend, String user) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean ret = true;
		String name = "new";
		try {
			tx.begin();
			User u = this.restrictedFriendList(user).get(0);
			System.out.println(u.getName());
			User u2 = this.restrictedFriendList(friend).get(0);
			System.out.println(u2.getName());
			List<User> li = new ArrayList<User>();
			//li = u.getFriend();
			li.add(u2);
			if(u!=null) {
				u.setFriend(li);
				u.setName(name);
				u2.setName("pro");
				Query q = pm.newQuery(User.class);
				pm.makePersistent(u);
				System.out.println("sas"+u.getFriend().get(0).getName());
				//delUser(friend);
				//delUser(user);
				tx.commit();
				for(int i=0;i<this.getUser().size();i++){
					System.out.println(this.getUser().get(i).getName());
				}
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
	public boolean deleteFriends(String friend) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getFriends(User u) {
		// TODO Auto-generated method stub
		return u.getFriend();
	}

}
	

