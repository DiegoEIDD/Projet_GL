import java.util.List;

public interface actionUser {
	
	/**
	 * @return the name of the user
	 * */
	String getName();
	/**
	 * @return the password of the user
	 * */
	String getPassword();
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
	 * */
	void addMap(Maps map);
	/**
	 * @param map of type Maps
	 * Delete a map from the user's list of map
	 * */
	void deleteMap(Maps map);
	/**
	 * @return the list of maps of the user restricted by the search toolbar
	 * */
	List<Maps> restrictedMapList();
	/**
	 * @param friend of type User
	 * Add a friend to the user's list of friends
	 * */
	void addFriends(User friend);
	/**
	 * @param friend of type User
	 * Delete a friend from the user's list of friends
	 * */
	void deleteFriends(User friend);
	/**
	 * @return the list of friends of the User
	 * */
	List<String> getFriendList();
	/**
	 * @return the list of friends of the user restricted by the search toolbar
	 * */
	List<String> restrictedFriendList();
}
