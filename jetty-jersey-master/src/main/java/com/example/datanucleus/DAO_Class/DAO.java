package com.example.datanucleus.DAO_Class;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import com.example.datanucleus.DAO_Class.actionUser;
import DaoPersistence.UserPers;

public class DAO{
	static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("proj");

	public static actionUser getName(){
		return new UserPers(pmf);
	}
}