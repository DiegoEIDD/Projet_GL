package com.example.jetty_jersey.ws;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.datanucleus.DAO_Class.DAO;
import com.example.datanucleus.DAO_Class.Duration;
import com.example.datanucleus.DAO_Class.Position;
import com.example.datanucleus.DAO_Class.User;
import com.example.datanucleus.DAO_Class.Marker;
import com.example.datanucleus.DAO_Class.actionMarker;
import com.example.datanucleus.DAO_Class.actionUser;

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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("name")
	public String getName() {
		//return actionMarker.getInstance().getName();
		
		Marker m = new Marker("Mark",1,2);
		return m.getName();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public boolean create(@FormParam("markeradd") String name ,@FormParam("lat") float a,@FormParam("lon") float b) {
		actionMarker uAction = DAO.getMark();
		Marker m=new Marker(name, a,b);
		return uAction.createMarker(m);
		
		
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getmarker")
	public List<Marker> getMarker() {
		System.out.printf("aa");
		actionMarker uAction = DAO.getMark();
		return uAction.getMarker();
		
	}
	
	
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