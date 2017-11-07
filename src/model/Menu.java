package model;

import java.util.Scanner;

/**
 * 
 * @author Nonso Iwu
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
	 * @return input A String that shows which type of Level to run in View or Model
	 */
	public String chooseLevel(){
		System.out.println("Which ennvironment would you like to play in?");
		System.out.println("l = Level, m = Mangrove, s = SaltMarsh");
		int state = 0;
		String input = "";
		while(true){
			switch(state){
			case 0:
				Scanner scanner = new Scanner(System.in);
				input = scanner.nextLine();
				if("lms".contains(input)){
					state = 1;
				}else{
					System.out.println("Please input l (level), m (mangrove), or s(saltmarsh) in order to go to that level");
					state = 0;
				}
				break;
			case 1:
				if(input.equals("l")){
				}else{
					System.out.println("That level does not exist yet :^{");
				}
				return input;
			}
		}
	}
}
