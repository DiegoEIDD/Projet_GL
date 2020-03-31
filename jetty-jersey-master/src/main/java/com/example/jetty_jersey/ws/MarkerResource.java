package com.example.jetty_jersey.ws;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.datanucleus.DAO_Class.Duration;
import com.example.datanucleus.DAO_Class.Position;
import com.example.datanucleus.DAO_Class.actionMarker;

@Path("/marker")
public class MarkerResource{
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addImg")
	public void addImage(/*String way*/) {
		//actionMarker.getInstance().addImage(way);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addMsg")
	public void addMessage(/*String msg*/) {
		//actionMarker.getInstance().addMessage(msg);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteImg")
	public boolean deleteImage(/*Image img*/) {
		//actionMarker.getInstance().deleteImage(img);
		return true;
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteMsg")
	public void deleteMessage(String msg) {
		//actionMarker.getInstance().deleteMessage(msg);
	}
	
//MODIF	
/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("name")
	public Marker getName() {
		//return actionMarker.getInstance().getName();
		Position pos = new Position(1,2);
		Marker m = new Marker("Mark",pos);
		return name;
	}
	
*/
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("images")
//	public List<Image> getImages() {
//		//return actionMarker.getInstance().getImages();
//		Image img1 = null;
//		try {
//			img1 = ImageIO.read(new File("../../../../../../../../3.PNG"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		Image img2 = null;
//		try {
//			img2 = ImageIO.read(new File("../../../../../../../../3.PNG"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List <Image> lImg = new ArrayList<>();
//		lImg.add(img1);
//		lImg.add(img2);
//		return lImg;
//	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("messages")
	public List<String> getMessages() {
		//return actionMarker.getInstance().getMessages();
		String s1= "msg1";
		String s2 = "msg2";
		List <String> lString = new ArrayList<>();
		lString.add(s1);
		lString.add(s2);
		return lString;
	}
    
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("position")
	public Position getPosition() {
		//return actionMarker.getInstance().getPosition();
		Position pos = new Position(1,2);
		return pos;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("duration")
	public Duration getDuration() {
		//return actionMarker.getInstance().getDuration();
		Duration dur = new Duration(9,3,2020,10);
		return dur;
	}
	
}