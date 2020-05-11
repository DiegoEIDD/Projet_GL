package com.example.datanucleus.DAO_Class;


import java.util.List;

public interface actionMaps {
	/**
	 * @return all map
	 */
	List<Maps> getMap();
	/**
	 * @return a list of map restricted by a string
	 */
	List<Maps> getRestrictedMap(String search);
	/**
	 * @return the name of the map
	 * */
	String getName(String map);
	/**
	 * @return the list of markers on the map
	 * */
	List<Marker> getMarker(String map);
	/**
	 * @return the list of events on the map
	 * */
	List<Event> getEvent(String map);
	/**
	 * @return the list of people who have access to the map
	 * */
	List<User> getAcess(String map);
	/**
	 * @return true if a map is created
	 */
	boolean createMap(String name);
	/**
	 * @return true if the map is deleted
	 */
	boolean delMap(String map);
	/**
	 * @return true if the map's name is edited
	 */
	boolean editMapName(String current, String newName);
	/**
	 * @return true if id is edited
	 */
	boolean editMapId(String name, int id );
	/**
	 * Print the image of the map on the screen
	 * */
	boolean printMap();
	/**
	 * @param map of type Maps
	 * @param friend of type User
	 * Give map access to the friend
	 * */
	boolean shareMap(Maps m, User friend);
	/**
	 * @param map of type Maps
	 * @param "friend" of type User
	 * Stop giving map access to the friend
	 * */
	boolean unshareMap(Maps m, User friend);
	/**
	 * @param name of type String
	 * @param localisation of type Position
	 * Add a marker to the map
	 * */
	boolean addMarker(String name, Position localisation);
	/**
	 * @param point of type marker
	 * Delete a marker from the map
	 * */
	boolean deleteMarker(String point);
	/**
	 * @param name of type String
	 * @param localisation of type Position
	 * @param time of type Duration
	 * Add an event to the map
	 * */
	boolean addEvent(String name, Position localisation, Duration time);
	/**
	 * @param ev of type Event
	 * Delete an event from the map
	 * */
	boolean deleteEvent(String evt);
}
