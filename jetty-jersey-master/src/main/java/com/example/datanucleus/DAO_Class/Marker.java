/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datanucleus.DAO_Class;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.PersistenceCapable;

/**
 *
 * @author Groupe3
 */
@PersistenceCapable
public class Marker{
    private String name;
    //private List<Image> picture;
    private List <String> message;
    private float lat;
    private float lon;
    private int id;
    
    public Marker(String n, float a, float b) {
    	this.name = n;
    	this.lat=a;
    	this.lon=b;
    	//this.picture = new ArrayList<>();
    	this.message = new ArrayList<>();
    }
    public Marker(String n) {
    	this.name = n;
    	//this.picture = new ArrayList<>();
    	this.message = new ArrayList<>();
    }

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
	public List<Image> getPicture() {
		return picture;
	}

	public void setPicture(List<Image> picture) {
		this.picture = picture;
	}
*/
	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
}
