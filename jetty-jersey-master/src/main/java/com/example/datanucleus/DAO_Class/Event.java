/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datanucleus.DAO_Class;

/**
 *
 * @author Groupe3
 */
public class Event extends Marker {
    public Duration date;
    
    public Event(Duration d, String n, Position l, int i) {
    	super(n,l);
    	this.date = d;
    }
}
