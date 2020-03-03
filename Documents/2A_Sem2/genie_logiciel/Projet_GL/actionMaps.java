import java.util.List;

public interface actionMaps {
	
	/**
	 * @return the name of the map
	 * */
	String getName();
	/**
	 * @return the list of markers on the map
	 * */
	List<Marker> getMarker();
	/**
	 * @return the list of events on the map
	 * */
	List<Event> getEvent();
	/**
	 * @return the list of people who have access to the map
	 * */
	List<User> getAcess();
	
	/**
	 * Print the image of the map on the screen
	 * */
	void printMap();
	/**
	 * @param friend of type User
	 * Give map access to the friend
	 * */
	void shareMap(User friend);
	/**
	 * @param "friend" of type User
	 * Stop giving map access to the friend
	 * */
	void unshareMap(User friend);
	/**
	 * @param name of type String
	 * @param localisation of type Position
	 * Add a marker to the map
	 * */
	void addMarker(String name, Position localisation);
	/**
	 * @param point of type marker
	 * Delete a marker from the map
	 * */
	void deleteMarker(Marker point);
	/**
	 * @param name of type String
	 * @param localisation of type Position
	 * @param time of type Duration
	 * Add an event to the map
	 * */
	void addEvent(String name, Position localisation, Duration time);
	/**
	 * @param ev of type Event
	 * Delete an event from the map
	 * */
	void deleteEvent(Event ev);
}
