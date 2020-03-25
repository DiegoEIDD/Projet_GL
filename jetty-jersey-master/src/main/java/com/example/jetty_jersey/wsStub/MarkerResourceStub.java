package com.example.jetty_jersey.wsStub;

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
import com.example.datanucleus.DAO_Class.Marker;
import com.example.datanucleus.DAO_Class.actionMarker;
import com.example.datanucleus.stub.StubActionMarker;
import com.example.datanucleus.stub.StubActionUser;

@Path("/marker")
public class MarkerResourceStub{
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addImg")
	public boolean addImage(/*String way*/) {
		//actionMarker.getInstance().addImage(way);
		StubActionMarker m = new StubActionMarker();
		return m.addImage("way");
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addMsg")
	public boolean addMessage(/*String msg*/) {
		//actionMarker.getInstance().addMessage(msg);
		StubActionMarker m = new StubActionMarker();
		return m.addMessage("msg");
	}
/*
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteImg")
	public boolean deleteImage(/*Image img*//*) {*/
/*		ActionMarker.getInstance().deleteImage(img);
		StubActionMarker m = new StubActionMarker();
		Image img = new Image();
		return m.deleteImage(img);
	}
	*/
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteMsg")
	public boolean deleteMessage(String msg) {
		//actionMarker.getInstance().deleteMessage(msg);
		StubActionMarker m = new StubActionMarker();
		return m.deleteMessage(msg);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/name")
	public Marker getName() {
		//return actionMarker.getInstance().getName();
		StubActionMarker m = new StubActionMarker();
		return m.getName();
	}
//	public Marker getName() {
//		//return actionMarker.getInstance().getName();
//		StubActionMarker m = new StubActionMarker();
//		return m.getName();
//	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/images")
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
	@Path("/messages")
	public List<String> getMessages() {
		//return actionMarker.getInstance().getMessages();
		StubActionMarker m = new StubActionMarker();
		return m.getMessages();
	}
    
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/position")
	public Position getPosition() {
		//return actionMarker.getInstance().getPosition();
		StubActionMarker m = new StubActionMarker();
		return m.getPosition();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/duration")
	public Duration getDuration() {
		//return actionMarker.getInstance().getDuration();
		StubActionMarker m = new StubActionMarker();
		return m.getDuration();
	}
	
}