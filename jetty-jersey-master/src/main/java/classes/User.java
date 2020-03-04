
import java.util.ArrayList;
import java.util.List;
import projet_gl.Maps;
import projet_gl.Position;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Groupe3
 */
public class User implements actionUser{
    
	 public String name;
	 public String password;
	 public List <Maps> map;
	 //Access: list de maps
	 public Access acc;
	 //public Position localisation;
	 
	 public User(String n, String p, Access a) {
		 this.name = n;
		 this.password = p;
		 this.map = new ArrayList<>();
		 this.acc = a;
	 }
}
