package DaoPersistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import org.junit.jupiter.api.Test;

import com.example.datanucleus.DAO_Class.User;

import org.junit.*;

public class ActionUserTest {
	
	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("proj");
		UserPers user = new UserPers(pmf);
		List <User>flist = new ArrayList<User>(); 
		User u = new User("nouveau", "msp");
		User u1 = new User("nouvelle", "msp");
		MapPers m = new MapPers(pmf);
		MarkerPers mark = new MarkerPers(pmf);

		Assert.assertEquals(0, user.getUser().size());
	    Assert.assertTrue(user.createUser(u));	    
		Assert.assertEquals(1, user.getUser().size());
		Assert.assertSame("nouveau",user.restrictedFriendList("nouveau").get(0).getName());
		Assert.assertTrue(user.delUser("nouveau"));
		Assert.assertEquals(0, user.getUser().size());
	    Assert.assertTrue(user.createUser(u1));
		Assert.assertTrue(user.editName("nouvelle","nou"));
	    Assert.assertEquals(1, user.getUser().size());
	    Assert.assertTrue(user.createUser(u));
		Assert.assertEquals(2,user.getUser().size());
		Assert.assertTrue(user.editPassword("nou","mdp"));

		Assert.assertEquals(0, m.getMap().size());
	    Assert.assertTrue(m.createMap("map"));	    
		Assert.assertEquals(1, m.getMap().size());
		
		Assert.assertEquals(0, mark.getMarker().size());
		Assert.assertTrue(mark.createMarker("m"));
		Assert.assertEquals(1, mark.getMarker().size());



	}
	
}
