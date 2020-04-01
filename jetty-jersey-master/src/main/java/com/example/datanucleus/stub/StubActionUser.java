package com.example.datanucleus.stub;

import java.util.ArrayList;
import java.util.List;

import com.example.datanucleus.DAO_Class.Access;
import com.example.datanucleus.DAO_Class.Maps;
import com.example.datanucleus.DAO_Class.User;


public class StubActionUser implements com.example.datanucleus.DAO_Class.actionUser{

	@Override
	public User getName() {
		// TODO Auto-generated method stub
		//Access a = new Access();
		User u = new User("juninho", "pernambucano",8);
		return u;
	}

	@Override
	public User getPassword() {
		// TODO Auto-generated method stub
		//Access a = new Access();
		User u = new User("juninho", "pernambucano",9);
		return u;
	}

	@Override
	public List<Maps> getMaps() {
		// TODO Auto-generated method stub
		Maps map1 = new Maps("Jason",10);
		Maps map2 = new Maps("Anthony",11);
		List <Maps> lMaps = new ArrayList<>();
		lMaps.add(map1);
		lMaps.add(map2);
		return lMaps;
	}

	@Override
	public List<Maps> getAcess() {
		// TODO Auto-generated method stub
		Maps map1 = new Maps("Bruno",12);
		Maps map2 = new Maps("Moussa",13);
		List <Maps> lMaps = new ArrayList<>();
		lMaps.add(map1);
		lMaps.add(map2);
		return lMaps;
	}

	@Override
	public boolean addMap(Maps map) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteMap(Maps map) {
		// TODO Auto-generated method stub
		return true;		
	}

	@Override
	public boolean modifyMapName(Maps map, String newName) {
		// TODO Auto-generated method stub
		//map.name = newName;
		return true;
	}

	@Override
	public List<Maps> restrictedMapList(String search) {
		// TODO Auto-generated method stub
		Maps map1 = new Maps("Carl",14);
		Maps map2 = new Maps("Houssem",15);
		List <Maps> lMaps = new ArrayList<>();
		lMaps.add(map1);
		lMaps.add(map2);
		return lMaps;
	}

	@Override
	public boolean addFriends(User friend) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteFriends(User friend) {
		// TODO Auto-generated method stub
		return true;
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
