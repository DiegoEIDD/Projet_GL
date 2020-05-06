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

		Assert.assertEquals(0, user.getUser().size());
	    Assert.assertTrue(user.createUser("nouveau"));	    
		Assert.assertEquals(1, user.getUser().size());
		Assert.assertSame("nouveau",user.restrictedFriendList("nouveau").get(0).getName());
		Assert.assertTrue(user.delUser("nouveau"));
		Assert.assertEquals(0, user.getUser().size());
	    Assert.assertTrue(user.createUser("nouvelle"));
		Assert.assertTrue(user.editName("nouvelle","nouveau"));
	    Assert.assertEquals(1, user.getUser().size());
	    Assert.assertTrue(user.createUser("nouvelle"));
		Assert.assertEquals(2,user.getUser().size());
		Assert.assertTrue(user.editPassword("nouvelle","mdp"));
		Assert.assertEquals(2,user.getUser().size());
		//Assert.assertTrue(user.addFriends("nouveau","nouvelle"));
		//Assert.assertEquals(2,user.getUser().size());
	}
	
}
