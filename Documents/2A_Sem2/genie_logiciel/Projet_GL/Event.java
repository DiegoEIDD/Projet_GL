/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_gl;

/**
 *
 * @author Adrien.N
 */
public class Event extends Marker {
    public Duration date;
    
    public Event(Duration d, String n, Position l) {
    	super(n,l);
    	this.date = d;
    }
}
