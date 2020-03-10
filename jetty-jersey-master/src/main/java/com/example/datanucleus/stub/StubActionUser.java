package com.example.datanucleus.stub;

import java.util.ArrayList;
import java.util.List;

import com.example.datanucleus.DAO_Class.Maps;
import com.example.datanucleus.DAO_Class.User;


public class StubActionUser implements com.example.datanucleus.DAO_Class.actionUser{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		String name = "Maxcence";
		return name;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		String pas = "pasword";
		return pas;
	}

	@Override
	public List<Maps> getMaps() {
		// TODO Auto-generated method stub
		Maps map1 = new Maps("Jason");
		Maps map2 = new Maps("Anthony");
		List <Maps> lMaps = new ArrayList<>();
		lMaps.add(map1);
		lMaps.add(map2);
		return lMaps;
	}

	@Override
	public List<Maps> getAcess() {
		// TODO Auto-generated method stub
		Maps map1 = new Maps("Bruno");
		Maps map2 = new Maps("Moussa");
		List <Maps> lMaps = new ArrayList<>();
		lMaps.add(map1);
		lMaps.add(map2);
		return lMaps;
	}

	@Override
	public void addMap(Maps map) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteMap(Maps map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMapName(Maps map, String newName) {
		// TODO Auto-generated method stub
		//map.name = newName;
	}

	@Override
	public List<Maps> restrictedMapList(String search) {
		// TODO Auto-generated method stub
		Maps map1 = new Maps("Carl");
		Maps map2 = new Maps("Houssem");
		List <Maps> lMaps = new ArrayList<>();
		lMaps.add(map1);
		lMaps.add(map2);
		return lMaps;
	}

	@Override
	public void addFriends(User friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFriends(User friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getFriends() {
		// TODO Auto-generated method stub
		String s1= "Martin";
		String s2 = "Lucas";
		List <String> lString = new ArrayList<>();
		lString.add(s1);
		lString.add(s2);
		return lString;
	}

	@Override
	public List<String> restrictedFriendList(String search) {
		// TODO Auto-generated method stub
		String s1= "Leo";
		String s2 = "Jason";
		List <String> lString = new ArrayList<>();
		lString.add(s1);
		lString.add(s2);
		return lString;
	}

}
