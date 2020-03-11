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
public class Position {
    public int latitude;
    public int longitude;
    
    public Position(int la, int lo) {
    	this.latitude = la;
    	this.longitude = lo;
    }
}
