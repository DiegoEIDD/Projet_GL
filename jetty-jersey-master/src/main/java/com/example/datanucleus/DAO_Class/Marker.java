/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datanucleus.DAO_Class;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Groupe3
 */
public class Marker{
    private String name;
    private List<Image> picture;
    private List <String> message;
    private Position localisation;
    private int id;
    
    public Marker(String n, Position l, int i) {
    	this.name = n;
    	this.picture = new ArrayList<>();
    	this.message = new ArrayList<>();
    	this.localisation = l;
    	this.id = i;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Image> getPicture() {
		return picture;
	}

	public void setPicture(List<Image> picture) {
		this.picture = picture;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public Position getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Position localisation) {
		this.localisation = localisation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
}
