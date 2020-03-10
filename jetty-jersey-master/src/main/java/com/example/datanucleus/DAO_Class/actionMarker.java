package com.example.datanucleus.DAO_Class;

import java.awt.Image;
import java.util.List;

public interface actionMarker {
	
	/**
	 * @return the name of the marker
	 * */
	String getName();
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
	void addImage(String way);
	/**
	 * @param img of type Image
	 * Delete an image from the marker
	 * */
	void deleteImage(Image img);
	/**
	 * @param msg of type String
	 * Add a message to the marker
	 * */
	void addMessage(String msg);
	/**
	 * @param msg of type String
	 * Delete a message from the marker
	 * */
	void deleteMessage(String msg);
}
