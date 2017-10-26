package game;

public class Organism {
	//TODO: Construct Organism Class
	/* What characteristics make up an Organism for our game.
	 * Make sub classes for each Organism? Extend Organism?
	 */
	
	//Variables
	private boolean doesBelong = false;
	String name;
	
	//Contructors
	public Organism() {
		doesBelong = true;
	}//Organism
	
	public Organism(boolean X) {
		doesBelong = X;
	}//Organism
	
	public Organism(String Name, boolean X) {
		name = Name;
		doesBelong = X;
	}//Organism
	
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
			return "This Organism belongs in the estuary!";
		}//if
		else {
			return "This Organism does not belong in the estuary!";
		}//else
	}//toString
	
}//Class Organism