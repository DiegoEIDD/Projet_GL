package DaoPersistence;

import java.util.List;

import com.example.datanucleus.DAO_Class.Duration;
import com.example.datanucleus.DAO_Class.Event;
import com.example.datanucleus.DAO_Class.Maps;
import com.example.datanucleus.DAO_Class.Marker;
import com.example.datanucleus.DAO_Class.Position;
import com.example.datanucleus.DAO_Class.User;
import com.example.datanucleus.DAO_Class.actionMaps;

public class MapPers implements actionMaps {

	@Override
	public User getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marker> getMarker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAcess() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean printMap() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shareMap(Maps m, User friend) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unshareMap(Maps m, User friend) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMarker(String name, Position localisation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMarker(Marker point) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEvent(String name, Position localisation, Duration time) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEvent(Event evt) {
		// TODO Auto-generated method stub
		return false;
	}

}
