package DAO_Class;

import com.example.datanucleus.DAO_Class.actionUser;
import DaoPersistence.UserPers;

public class DAO{
	static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("proj");

	public static actionUser getName(){
		return new UserPers(pmf);
	}
}