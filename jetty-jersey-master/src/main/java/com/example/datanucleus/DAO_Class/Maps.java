/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datanucleus.DAO_Class;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Groupe3
 */
public class Maps{
    public String name;
    public List <Marker> mark;
    public List <Event> ev;
    public List <User> access;
    
    public Maps(String n) {
    	this.name = n;
    	this.mark = new ArrayList<>();
    	this.ev = new ArrayList<>();
    	this.access = new ArrayList<>();
    }
    
}
