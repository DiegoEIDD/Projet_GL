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
    public double latitude;
    public double longitude;
    
    public Position(double la, double lo) {
    	this.latitude = la;
    	this.longitude = lo;
    }
}
