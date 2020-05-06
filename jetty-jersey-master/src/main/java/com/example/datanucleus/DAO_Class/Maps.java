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
public class Maps{
    private String name;
    private List <Marker> mark;
    private List <Event> ev;
    private List <User> access;
    private int id;
    
    public Maps(String n,int i) {
    	this.name = n;
    	this.mark = new ArrayList<>();
    	this.ev = new ArrayList<>();
    	this.access = new ArrayList<>();
    	this.id = i;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Marker> getMark() {
		return mark;
	}

	public void setMark(List<Marker> mark) {
		this.mark = mark;
	}

	public List<Event> getEv() {
		return ev;
	}

	public void setEv(List<Event> ev) {
		this.ev = ev;
	}

	public List<User> getAccess() {
		return access;
	}

	public void setAccess(List<User> access) {
		this.access = access;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    
}
