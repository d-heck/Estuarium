package game;

import java.util.ArrayList;
import java.util.Collection;
import java.io.InputStream;
import java.util.Scanner;
/*
 * Model Class for the levels
 */

public class Level {
	//TODO: Level's Class
	/*
	 * Should have all the functionality of a level.
	 * 		- Should create an Acceptable Creatures List
	 * 		- This is where all the organisms should be constructed + added to level.
	 * 		- Should not load any images (this is model not view)
	 * 		- May want to use this as a superclass and every actual level as a subclass.
	 */
	
	ArrayList<Organism> organismList = new ArrayList<Organism>();
	String name;
	String background = "resources/images/Background.png";
	ArrayList<Organism> acceptedOrganisms; //Holds Organisms with doesBelong = true;
	ArrayList<Organism> unacceptedOrganisms; //Holds Organisms with doesBelong = false;
	
	//Constuctor
	public Level() {
		createOrganismList();
	}
	
	//Create list of all organisms for particular level
	private void createOrganismList() {
		//Manually code in every organism we desire for a level.
		//exs)
		Organism Example1 = new Organism("Jerald", false, "resources/images/crab.png");
		Example1.setToString("This is Jerald's toString, he doesn't belong.");
		organismList.add(Example1);
		
		Organism Example2 = new Organism("Fish Boi", true, "resources/images/fish.png");
		Example2.setToString("This is Fish Boi's toString, he belongs.");
		organismList.add(Example2);
		
		
		Organism Example3 = new Organism("Planter", true, "resources/images/kelp.png");
		Example3.setToString("This is Planter's toString, he belongs.");
		organismList.add(Example3);
		
	}
	
	public void play() {
		//Plays the level.
		//For now I will just be using string input as Y or N but should be changed to
		//clicking in the future.;
		Boolean Answer = true;
		
		for(int i = 0; i < organismList.size(); i++) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Does " + organismList.get(i).getName() + " belong in the Level? y/n");
			String input = scanner.nextLine();
			
			if(input.equals("y")) {
				Answer = true;
			}
			else if(input.equals("n")){
				Answer = false;
			}
			
			if(organismList.get(i).isDoesBelong() == Answer) {
				System.out.println(organismList.get(i));
				System.out.println("Very Good!");
				
			}
			else {
				System.out.println(organismList.get(i));
				System.out.println("Wrong!");
			}

		}
		return;
	}
}

