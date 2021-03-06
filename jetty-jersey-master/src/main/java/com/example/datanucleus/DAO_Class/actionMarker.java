package com.example.datanucleus.DAO_Class;

import java.awt.Image;
import java.util.List;

public interface actionMarker {
	
	/**
	 * @return the name of the marker
	 * */
	Marker getName(String marker);
	/**
	 * @return the list of images from the marker
	 * */
	List<Image> getImages();
	/**
	 * @return the list of messages from the marker
	 * */
	List<String> getMessages();
	/**
	 * @return the position of the marker
	 * */
	Position getPosition();
	/**
	 * @return the time duration of the event
	 * */
	Duration getDuration();
	
	/**
	 * @param way of type String
	 * Add an image to the marker
	 * */
	boolean addImage(String way);
	/**
	 * @param img of type Image1
	 * Delete an image from the marker
	 * */
	boolean deleteImage(Image img);
	/**
	 * @param msg of type String
	 * Add a message to the marker
	 * */
	boolean addMessage(String msg);
	/**
	 * @param msg of type String
	 * Delete a message from the marker
	 * */
	boolean deleteMessage(String msg);
	/**
	 * @return true if a marker is created
	 */
	boolean createMarker(Marker m);
	/**
	 * @return true if a marker is deleted
	 */
	boolean delMarker(String name);
	/**
	 * @return true if a marker's name is edited
	 */
	boolean EditMarkerName(String current,String newName);
	/**
	 * @return true if a marker's position is edited
	 */
	boolean editPos(String name,int lat, int longi);
	/**
	 * @return all marker
	 */
	List<Marker> getMarker();
	/**
	 * @return a list of marker restricted by a name
	 */
	List<Marker> getRestrictedMarker(String search);
}
