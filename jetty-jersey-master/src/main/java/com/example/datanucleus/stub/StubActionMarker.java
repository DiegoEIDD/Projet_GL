package com.example.datanucleus.stub;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.example.datanucleus.DAO_Class.Duration;
import com.example.datanucleus.DAO_Class.Event;
import com.example.datanucleus.DAO_Class.Maps;
import com.example.datanucleus.DAO_Class.Marker;
import com.example.datanucleus.DAO_Class.Position;
import com.example.datanucleus.DAO_Class.User;

public class StubActionMarker implements com.example.datanucleus.DAO_Class.actionMarker{

	@Override
	public Marker getName() {
		// TODO Auto-generated method stub
		//String name = "a";
		Position pos = new Position(1,2);
		String n = "Mark";
		Marker m = new Marker(n,pos);
		return m;
	}

	/*@Override
	public List<Image> getImages() {
		//return actionMarker.getInstance().getImages();
		Image img1 = ImageIO.read(new File("../../../../../../../../1.PNG"));
		Image img2 = ImageIO.read(new File("../../../../../../../../1.PNG"));
		List <Image> lImg = new ArrayList<>();
		lImg.add(img1);
		lImg.add(img2);
		return lImg;
	}*/

	@Override
	public List<String> getMessages() {
		//return actionMarker.getInstance().getMessages();
		String s1= "msg1";
		String s2 = "msg2";
		List <String> lString = new ArrayList<>();
		lString.add(s1);
		lString.add(s2);
		return lString;
	}
    
    @Override
	public Position getPosition() {
		//return actionMarker.getInstance().getPosition();
		Position pos = new Position(1,2);
		return pos;
    }
    
    @Override
	public Duration getDuration() {
		//return actionMarker.getInstance().getDuration();
		Duration dur = new Duration(9,3,2020,10);
		return dur;
	}

	@Override
	public boolean addImage(String way) {
		//actionMarker.getInstance().addImage(way);
		return true;
	}

	@Override
	public boolean deleteImage(Image img) {
		//actionMarker.getInstance().deleteImage(img);
		return true;
	}

	@Override
	public boolean addMessage(String msg) {
		//actionMarker.getInstance().addMessage(msg);
		return true;
	}

	@Override
	public boolean deleteMessage(String msg) {
		//actionMarker.getInstance().deleteMessage(msg);
		return true;
	}

	@Override
	public List<Image> getImages() {
		// TODO Auto-generated method stub
		return null;
	}

}
