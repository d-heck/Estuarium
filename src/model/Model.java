package model;
import model.Level;

public class Model {
	public static void main(String[] Args) {
		Menu menu = new Menu();
		String choice = menu.chooseLevel();
		if(choice.equals("l")){
			Level x = new Level();
			x.play();
		}
	}
}//Model
