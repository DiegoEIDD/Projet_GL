package com.example.datanucleus.DAO_Class;

import java.io.IOException;
import java.util.List;
import javax.jdo.annotations.PersistenceCapable;

public interface actionUser {

	/**
	 * @return the name of the user
	 * */
	String getName(User u);
	/**
	 * @return the password of the user
	 * */
		User getPassword();
	/**
	 * 
	 * @return return true if edit work
	 */
	boolean editName(String current, String newName);
	/**
	 * @return the list of maps belonging to the User
	 * */
	List<Maps> getMaps();
	/**
	 * @return the list of maps the user have access
	 * */
	List<Maps> getAcess();
	
	/**
	 * @param map of type Maps
	 * Add a map to the user's list of map
	 * @throws IOException 
	 * */
	boolean addMap(String map);
	/**
	 * @param map of type Maps
	 * Delete a map from the user's list of map
	 * */
	boolean deleteMap(String map);
	/**
	 * @param a map of type Maps
	 * @param a new name of type String
	 * Modify the name of a map
	 * */
	boolean modifyMapName(Maps map, String newName);
	/**
	 * @return the list of maps of the user restricted by the search toolbar
	 * */
	List<Maps> restrictedMapList(String search);
	/**
	 * @param friend of type User
	 * Add a friend to the user's list of friends
	 * */
	boolean addFriends(String friend);
	/**
	 * @param friend of type User
	 * Delete a friend from the user's list of friends
	 * */
	boolean deleteFriends(String friend);
	/**
	 * @return the list of friends of the User
	 * */
	List<User> getFriends();
	/**
	 * @return the list of friends of the user restricted by the search toolbar
	 * */
	List<User> restrictedFriendList(String search);
}
