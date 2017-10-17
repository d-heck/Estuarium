package game;

public class Animal {
	//TODO: Construct Animal Class
	/* What characteristics make up an animal for our game.
	 * Make sub classes for each animal? Extend animal?
	 */
	
	//Variables
	private boolean doesBelong = false;
	
	//Contructors
	public Animal() {
		doesBelong = true;
	}//Animal
	
	public Animal(boolean X) {
		doesBelong = X;
	}//Animal
	
	//Getters + Setters
	public boolean getDoesBelong() {
		return doesBelong;
	}//geDoesBelong


	public void setDoesBelong(boolean doesBelong) {
		this.doesBelong = doesBelong;
	}//setDoesBelong
	
	//toString
	public String toString() {
		if(doesBelong = true) {
			return "This animal belongs in the estuary!";
		}//if
		else {
			return "This animal does not belong in the estuary!";
		}//else
	}//toString
	
}//Class Animal