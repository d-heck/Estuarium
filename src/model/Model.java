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
		else if(choice.equals("s")){
			SaltMarshLevel x = new SaltMarshLevel();
			x.play();
		}
		else if(choice.equals("m")){
			MangroveLevel x = new MangroveLevel();
			x.play();
		}
		else if(choice.equals("o")){
			OysterReefLevel x = new OysterReefLevel();
			x.play();
		}
	}
}//Model
