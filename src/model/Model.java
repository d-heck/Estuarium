package model;
import model.Level;

/**
 * Main Class instantiates the model
 * @author David Heck
 *
 */
public class Model {
	public static void main(String[] Args) {
		Level x = Level.getLevel();
		x.play();
	}
}//Model
