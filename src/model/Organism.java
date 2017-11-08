package model;

/* 
 * Parent Class of LandOranism, PlantBasedOrganism, and AquaticOrganisms
 * A default type of organism.
 */
/**
 * Organism is a class that holds the object to be placed in the level.
 * 
 * 
 * @author David Heck
 * @author Kevin Doak
 * @author Jeremy Gouveia
 * @see Level
 *
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
	
	/**
	 * Constructor for organism
	 * @return Organism an Organism object
	 */
	
	public Organism() {
		doesBelong = false;
		name = "Organism";
	}//Organism
	
	/**
	 * Constructor for organism
	 * @param X is a boolean
	 * @return Organism an Organism object
	 */
	
	public Organism(boolean X) {
		doesBelong = X;
	}//Organism
	
	/**
	 * Constructor for organism
	 * @param Name The name of the organism
	 * @param Belongs the boolean determining if the organism belongs in the level
	 * @return Organism an Organism object
	 */
	public Organism(String Name, boolean Belongs) {
		name = Name;
		doesBelong = Belongs;
	}//Organism
	
	/**
	 * 
	 * @param Name The name of the organism	
	 * @param Belongs the boolean determining if the organism belongs in the level
	 * @param File The name of the file the organism belongs to
	 */
	public Organism(String Name, boolean Belongs, String File) {
		name = Name;
		doesBelong = Belongs;
		filepath = File;
	}
	
	//Getters + Setters
	/**
	 * isDoesBelong() returns the doesBelong field
	 * @return boolean returns boolean field
	 */
	public boolean isDoesBelong() {
		return doesBelong;
	}

	/**
	 * setDoesBelong sets the doesBelong field
	 * @param doesBelong boolean
	 */
	public void setDoesBelong(boolean doesBelong) {
		this.doesBelong = doesBelong;
	}

	/**
	 * Gets the name of the organism
	 * @return name the name of the organism
	 */
	public String getName() {
		return name;
	}
	/**
	 * setName sets the name field
	 * @param name the name to replace the organism
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the xloc field of the organism
	 * @return
	 */
	public int getXloc() {
		return xloc;
	}

	/**
	 * Gets the yloc field of the organism
	 * @return
	 */
	public int getYloc() {
		return yloc;
	}

	/**
	 * Gets the filepath field of the organism
	 * @return filepath the name of the filepath
	 */
	public String getFilePath() {
		return filepath;
	}

	/**
	 * Sets the filepath field of the organism
	 * @param filepath the name for the filepath
	 */
	public void setFilePath(String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Sets the purpose of the organism
	 * @param X the string to set the purpose with
	 */
	public void setToString(String X){
		purpose = X;
	}
	
	/**
	 * returns the purpose of the organism
	 */
	public String toString(){
		return purpose;
	}
	
}//Class Organism