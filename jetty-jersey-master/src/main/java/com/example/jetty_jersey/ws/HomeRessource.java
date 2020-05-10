package com.example.jetty_jersey.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.datanucleus.DAO_Class.Access;
import com.example.datanucleus.DAO_Class.Duration;
import com.example.datanucleus.DAO_Class.Event;
import com.example.datanucleus.DAO_Class.Maps;
import com.example.datanucleus.DAO_Class.Marker;
import com.example.datanucleus.DAO_Class.Position;
import com.example.datanucleus.DAO_Class.User;
import com.example.datanucleus.DAO_Class.actionMaps;

@Path("/account")
public class HomeResource{
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/login")
	public String login(@FormParam("username") String name,@FormParam("password") String mdp) {
		
		actionUser uAction = DAO.getName();
		User u = uAction.restrictedFriendList(name).get(0);
		//User u = uAction.getName(name);
		if(Objects.isNull(u)) {
			return "Invalid email or password";
		}
		else if(u.getPassword().equals(mdp)) {
			return "Connected";
		}
		else {
			return "Invalid email or password";
		}
	}
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/signUp")
	public String signUp(@FormParam("userSign") String name, @FormParam("email") String email,@FormParam("passSign") String mdp) {
		if(Objects.isNull(name) || Objects.isNull(email) || Objects.isNull(mdp)){
			return "All fields must be completed";
		}
		actionUser uAction = DAO.getName();
		if(!Objects.isNull(uAction.getName(name))){
			return "Username already exist";
		}
		User u = new User(name,mdp);
		//u.setName(name);
		u.setEmail(email);
		//u.setPassword(mdp);
		uAction.createUser(u);
		return "Sign Up completed";
	}
}