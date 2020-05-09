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
		User u = new User(friend, "pernambucano");
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
				u.setPassword(password);
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
		String name2 = "pro";
		try {
			tx.begin();
			User u = this.restrictedFriendList(user).get(0);
			System.out.println(u.getName());
			User u2 = this.restrictedFriendList(friend).get(0);
			System.out.println(u2.getName());
			List<User> li = new ArrayList<User>();
			//li = u.getFriend();
			li.add(u2);
			System.out.println(li.get(0).getName());
			if(u!=null) {
				u.setFriend(li);
				u.setName(name);
				u2.setName(name2);
				Query q = pm.newQuery(User.class);
				pm.makePersistent(u);
				tx.commit();
				tx.begin();
				this.editName(name, user);
				this.editName(name2, friend);
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
	public boolean deleteFriends(String friend) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getFriends(User u) {
		// TODO Auto-generated method stub
		return u.getFriend();
	}

	@Override
	public boolean editFriendList(String user, List<User> flist) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean ret = true;
		try {
			tx.begin();
			User u = this.restrictedFriendList(user).get(0);
			if(u!=null) {
				u.setFriend(flist);
				delUser(user);
				delUser(flist.get(0).getName());
				System.out.println(u.getFriend().get(0).getName());
				Query q = pm.newQuery(User.class);
				System.out.println(u.getFriend().get(0).getName());
				pm.makePersistent(u);
				System.out.println(u.getFriend().get(0).getName());
				tx.commit();
			}
			System.out.println(u.getFriend().get(0).getName());
		} finally {
			if (tx.isActive()) {
				tx.rollback();
				ret = false;
			}
			System.out.println(this.restrictedFriendList(user).get(0).getFriend());
			pm.close();
		} 
		System.out.println(this.restrictedFriendList(user).get(0).getFriend());
		return ret;
	}

}
	

