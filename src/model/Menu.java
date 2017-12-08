package model;

/**
 * The menu class extends level and allows the user the select the level they want to play in.
 * @author Nonso Iwu
 * @see Level
 *
 */
public class Menu extends Level {
	
	/**
	 *Creates an instance of Menu and sets fields to null because of lack of use
	 *
	 */
	
	Menu(){
		organismList = null;
		name = null;
		background = "resources/images/Background.png";
		acceptedOrganisms = null;
		unacceptedOrganisms = null;
	}
	
	/**
	 * Asks the user for which game they would like to play with the use
	 * of java.util.Scanner and returns a String indicating what choice was made
	 * @return input  String  Shows which type of Level to run in View or Model
	 */
	public static String chooseLevel(){
		System.out.println("Which ennvironment would you like to play in?");
		System.out.println("l = Level, m = Mangrove, o = Oyster Reef, s = SaltMarsh");
		int state = 0;
		String input = "";
		while(true){
			input = scanner.nextLine();
			if(input.matches("[lmso]")){
				state = 0;
			}else {
				state = 1;
			}
			switch(state){
				case 0:
					return input;
				case 1:
					System.out.println("Please input l (level), m (mangrove), o (Oyster Reef), or s(saltmarsh) in order to play that level");
					break;
			}
		}
	}
	
}
