package model;

/* 
 * Parent Class of LandOranism, PlantBasedOrganism, and AquaticOrganisms
 * A default type of organism.
 */

public class Organism {
	
	//Variables
	boolean doesBelong = false;
	String name;
	String filepath;
	String purpose;
	int xloc;
	int yloc;
	
	//Contructors
	public Organism() {
		doesBelong = false;
		name = "Organism";
	}//Organism
	
	public Organism(boolean X) {
		doesBelong = X;
	}//Organism
	
	public Organism(String Name, boolean Belongs) {
		name = Name;
		doesBelong = Belongs;
	}//Organism
	
	public Organism(String Name, boolean Belongs, String Pur) {
		name = Name;
		doesBelong = Belongs;
		purpose = Pur;
	}
	
	//Getters + Setters
	public boolean isDoesBelong() {
		return doesBelong;
	}

	public void setDoesBelong(boolean doesBelong) {
		this.doesBelong = doesBelong;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getXloc() {
		return xloc;
	}

	public int getYloc() {
		return yloc;
	}

	public String getFilePath() {
		return filepath;
	}

	public void setFilePath(String filepath) {
		this.filepath = filepath;
	}
	
	
	public void setToString(String X){
		purpose = X;
	}
	
	public String toString(){
		return purpose;
	}
	
}//Class Organism