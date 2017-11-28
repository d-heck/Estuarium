package model;

public class Model {
	public static void main(String[] Args) {
		Menu menu = new Menu();
		String choice = menu.chooseLevel();
		if(choice.equals("l")){
			Level x = new Level();
			x.play();
		}
		if(choice.equals("m")){
			Level x = new MangroveLevel();
			x.play();
		}
		if(choice.equals("s")){
			Level x = new SaltMarshLevel();
			x.play();
		}
		if(choice.equals("o")){
			Level x = new OysterReefLevel();
			x.play();
		}
	}
}//Model
