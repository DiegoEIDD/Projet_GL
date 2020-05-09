/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datanucleus.DAO_Class;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author Groupe3
 */
public class Marker{
    private String name;
	 @Persistent(dependentElement = "true")
    private List<Image> picture;
	 @Persistent(dependentElement = "true")
    private List <String> message;
    private Position localisation;
	 @PrimaryKey
	 @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    private int id;
    
    public Marker(String n, Position l) {
    	this.name = n;
    	this.picture = new ArrayList<>();
    	this.message = new ArrayList<>();
    	this.localisation = l;
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
