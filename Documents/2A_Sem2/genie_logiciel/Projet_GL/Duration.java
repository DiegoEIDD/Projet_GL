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
public class Duration {
    public int day;
    public int month;
    public int year;
    public int start_hour;
    //public int end_hour;
    
    public Duration(int d, int m, int y, int h) {
    	this.day = d;
    	this.month = m;
    	this.year = y;
    	this.start_hour = h;
    }
}
