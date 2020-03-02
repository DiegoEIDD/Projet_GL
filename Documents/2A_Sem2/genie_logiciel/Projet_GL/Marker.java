/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_gl;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrien.N
 */
public class Marker {
    public String name;
    public List<Image> picture;
    public List <String> message;
    public Position localisation;
    
    public Marker(String n, Position l) {
    	this.name = n;
    	this.picture = new ArrayList<>();
    	this.message = new ArrayList<>();
    	this.localisation = l;
    }
}
