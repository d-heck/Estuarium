package model;

import java.util.ArrayList;
import java.util.Collection;
import java.io.InputStream;
import java.util.Scanner;

import view.View;
/**
 * Superclass for MangroveLevel, SaltMarshLevel, and OysterReefLevel that has
 * an organismList, number of strikes, background image, and lists for 
 * accepted and unaccepted organisms
 * @author David Heck
 * @author Jason Hickman
 */
public class Level {
	
	public ArrayList<Organism> organismList = new ArrayList<Organism>();
	public String background = "resources/images/tutorial.png";
	String name;
	ArrayList<Organism> acceptedOrganisms = new ArrayList<Organism> ();; //Holds Organisms with doesBelong = true;
	ArrayList<Organism> unacceptedOrganisms = new ArrayList<Organism> ();; //Holds Organisms with doesBelong = false;
	public String backgroundFull = "resources/images/tutorialfull.png";
	public static Scanner scanner = new Scanner(System.in);
	public int score = 0;
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
	public void setStrikes(int x) {
		strikes = x;
		return;
	}
	
	public int getScore() {
		//Parameters: none
		//Returns: the value of variable 'score'
		return score;
	}
	public void setScore(int x) {
		score = x;
		return;
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
		Organism Example1 = new Organism("Cooked Crab", false,"This is Cooked Crab's toString, he doesn't belong.", "resources/images/crab.png");
		organismList.add(Example1);
		
		Organism Example2 = new Organism("Fish", true,"This is a fish. He belongs.", "resources/images/fish.png",(int)(.1*View.getFrameWidth()),(int)(.22*View.getFrameHeight()));
		organismList.add(Example2);
		
		Organism Example3 = new Organism("Plant", true,"This is Plant's toString, he belongs.", "resources/images/kelp.png");
		organismList.add(Example3);
		
		Organism Example4 = new Organism("Oyster",true,"This is Oyster's toString, he belongs", "resources/images/oyster.png");
		organismList.add(Example4);
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
			System.out.println("\nDoes " + this.organismList.get(i).getName() + " belong in the Level? y/n");
			String input = scanner.nextLine();
			
			if(input.equals("y")) {
				Answer = true;
			}
			else if(input.equals("n")){
				Answer = false;
			}
			
			if(this.organismList.get(i).isDoesBelong() == Answer) {
				System.out.println(organismList.get(i));
				System.out.println("Very Good!");
				
			}
			else {
				System.out.println("Wrong! "+organismList.get(i));
				strikes++;
				if(strikes>=3){
					//Code for game over prompt
					//Recommend making a gameover method
					System.out.println("Game Over.");
					break;
				}
			}
			System.out.println("Number of strikes: "+strikes);
		}
		return;
	}
	
	/**
	 * Asks the user for a type of habitat (Mangrove, OysterReef, SaltMarsh or tutorial style
	 * Level)
	 * @return a {@code MangroveLevel}, {@code OysterReefLevel}, {@code SaltMarshLevel} or
	 * 			{@code Level} class based on {@code String} entered through Input Stream
	 */
	public static Level getLevel(){
		String choice = Menu.chooseLevel();

		if(choice.equals("l")){
			return new Level();
		}else if(choice.equals("m")){
			return new MangroveLevel();
		}else if(choice.equals("o")){
			return new OysterReefLevel();
		}else if(choice.equals("s")){
			return new SaltMarshLevel();
		}
		return null;
	}
}

