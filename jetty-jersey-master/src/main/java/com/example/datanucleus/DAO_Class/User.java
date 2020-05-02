package com.example.datanucleus.DAO_Class;

import java.util.ArrayList;
import java.util.List;
import com.example.datanucleus.DAO_Class.Maps;
import com.example.datanucleus.DAO_Class.Position;
import javax.jdo.annotations.PersistenceCapable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Groupe3
 */
@PersistenceCapable
public class User{
    
	 private String name;
	 private String password;
	 private List <Maps> map;
	 //Access: list de maps
	 private Access acc;
	 //public Position localisation;
	 private int id;
	 
	 public User(String n, String p, int i) {
		 this.name = n;
		 this.password = p;
		 this.map = new ArrayList<>();
		 //this.acc = a;
		 this.id = i;
	 }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Maps> getMap() {
		return map;
	}

	public void setMap(List<Maps> map) {
		this.map = map;
	}

	public Access getAcc() {
		return acc;
	}

	public void setAcc(Access acc) {
		this.acc = acc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	 
}
