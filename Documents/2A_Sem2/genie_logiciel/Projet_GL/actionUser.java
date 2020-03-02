import java.util.List;

public interface actionUser {
	/**
	 * 
	 * 
	 * */
	String getName();
	
	String getPassword();
	
	List<Maps> getMaps();
	//si map contenue dans list map d'access alors retourne vrai
	boolean getAcess();
	
	Position getPosition();
}
