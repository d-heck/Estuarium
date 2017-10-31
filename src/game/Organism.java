package game;

/* 
 * Parent Class of LandOranism, PlantBasedOrganism, and AquaticOrganisms
 * A default type of organism.
 */

public class Organism {
	
	//Variables
	private boolean doesBelong = false;
	boolean canSwim = false;
	boolean canWalk = false;
	String name;
	String filepath;
	
	//Contructors
	public Organism() {
		doesBelong = false;
		canWalk = false;
		canSwim = false;
		name = "Organism";
	}//Organism
	
	public Organism(boolean X) {
		doesBelong = X;
	}//Organism
	
	public Organism(String Name, boolean Belongs) {
		name = Name;
		doesBelong = Belongs;
	}//Organism
	
	public Organism(String Name, boolean Belongs, String File) {
		name = Name;
		doesBelong = Belongs;
		filepath = File;
	}
	
	//Getters + Setters
	public boolean isDoesBelong() {
		return doesBelong;
	}

	public void setDoesBelong(boolean doesBelong) {
		this.doesBelong = doesBelong;
	}

	public boolean isCanSwim() {
		return canSwim;
	}

	public void setCanSwim(boolean canSwim) {
		this.canSwim = canSwim;
	}

	public boolean isCanWalk() {
		return canWalk;
	}

	public void setCanWalk(boolean canWalk) {
		this.canWalk = canWalk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getFilePath() {
		return filepath;
	}

	public void setFilePath(String filepath) {
		this.filepath = filepath;
	}
	
	
	//toString
	public String toString() {
		if(doesBelong = true) {
			return "This Organism belongs in the estuary! \n";
		}//if
		else {
			return "This Organism does not belong in the estuary! \n";
		}//else
	}//toString
	
}//Class Organism