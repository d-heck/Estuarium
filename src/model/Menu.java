package model;

import java.util.Scanner;

public class Menu extends Level {
	
	//Constructor
	//Everything other than background is set to null in order to free up space
	Menu(){
		organismList = null;
		name = null;
		background = "resources/images/Background.png";
		acceptedOrganisms = null;
		unacceptedOrganisms = null;
	}
	
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
