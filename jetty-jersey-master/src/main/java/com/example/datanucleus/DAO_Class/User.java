package com.example.datanucleus.DAO_Class;

import java.util.ArrayList;
import java.util.List;
import com.example.datanucleus.DAO_Class.Maps;
import com.example.datanucleus.DAO_Class.Position;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Groupe3
 */
public class User{
    
	 public String name;
	 public String password;
	 public List <Maps> map;
	 //Access: list de maps
	 public Access acc;
	 //public Position localisation;
	 public int id;
	 
	 public User(String n, String p, int i) {
		 this.name = n;
		 this.password = p;
		 this.map = new ArrayList<>();
		 //this.acc = a;
		 this.id = i;
	 }
}
