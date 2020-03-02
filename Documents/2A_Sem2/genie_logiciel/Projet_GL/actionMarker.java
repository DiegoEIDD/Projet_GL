import java.awt.Image;
import java.util.List;

public interface actionMarker {
		
	String getName();
	
	List<Image> getImage();
	
	List<String> getMessage();
	
	Position getPosition();
}
