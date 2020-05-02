package DaoPersistence;

import java.io.IOException;

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

		Assert.assertEquals(0, user.getFriends().size());
		Assert.assertEquals(0, user.getMaps().size());
	    Assert.assertTrue(user.addFriends("nouvelle"));
	    Assert.assertTrue(user.addMap("nouvelle"));	    
		Assert.assertEquals(1, user.getMaps().size());
		Assert.assertEquals(1, user.getFriends().size());
		Assert.assertSame("nouvelle",user.restrictedFriendList("nouvelle").get(0).getName());
		Assert.assertTrue(user.deleteFriends("nouvelle"));
		Assert.assertEquals(0, user.getFriends().size());
	    Assert.assertTrue(user.addFriends("nouvelle"));
		Assert.assertTrue(user.editName("nouvelle","nouveau"));
		Assert.assertEquals(1, user.getFriends().size());
	}
	
}
