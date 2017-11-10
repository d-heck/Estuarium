package model;

import java.util.ArrayList;
import java.util.Collection;
import java.io.InputStream;
import java.util.Scanner;
/**
 * Superclass for MangroveLevel, SaltMarshLevel, and OysterReefLevel that has
 * an organismList, number of strikes, background image, and lists for 
 * accepted and unaccepted organisms
 * @author David Heck
 * @author Jason Hickman
 */
public class Level {
	
	public ArrayList<Organism> organismList = new ArrayList<Organism>();
	public String background = "resources/images/Background.png";
	String name;
	ArrayList<Organism> acceptedOrganisms; //Holds Organisms with doesBelong = true;
	ArrayList<Organism> unacceptedOrganisms; //Holds Organisms with doesBelong = false;
	public int strikes = 0;
	
	/**
	 * getStrikes returns the current value of the strikes attribute, which 
	 * corresponds to the number of incorrect answers.
	 * @return int An integer representing the number of incorrect answers so far
	 */
	public int getStrikes() {
		//Parameters: none
		//Returns: the value of variable 'strikes'
		return strikes;
	}

	/**
	 * Simple constructor that creates a generic Level and calls createOrganismList
	 */
	public Level() {
		createOrganismList();
	}
	
	/**
	 * createOrganismList creates a generic organismList used for testing.
	 */
	public void createOrganismList() {
		//Manually code in every organism we desire for a level.
		//exs)
		Organism Example1 = new Organism("Cooked Crab", false, "resources/images/crab.png");
		Example1.setToString("This is Cooked Crab's toString, he doesn't belong.");
		organismList.add(Example1);
		
		Organism Example2 = new Organism("Fish", true, "resources/images/fish.png");
		Example2.setToString("This is Fish's toString, he belongs.");
		organismList.add(Example2);
		
		
		Organism Example3 = new Organism("Plant", true, "resources/images/kelp.png");
		Example3.setToString("This is Plant's toString, he belongs.");
		organismList.add(Example3);
		
	}
	
	
	
	/**
	 * play plays the level, takes user input in the form of y or n to determine
	 * whether an organism is included or not, increases the number of strikes if
	 * the answer is wrong, and will terminate if strikes equals 3 after a turn.
	 */
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
				strikes++;
				System.out.println("Number of strikes: "+strikes);
				if(strikes>=3){
					//Code for game over prompt
					//Recommend making a gameover method
					System.out.println("Game Over.");
					break;
				}
			}

		}
		return;
	}
	
	
}

