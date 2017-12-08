package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Organism is a class that holds the object to be placed in the level.
 * 
 * 
 * @author David Heck
 * @author Jason Hickman
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
	String description;
	int xloc;
	int yloc;
	public BufferedImage image;
	
	//Contructors
	
	/**
	 * 2 param Constructor for most basic organism
	 * @param Name The name of the organism
	 * @param Belongs the boolean determining if the organism belongs in the level
	 */
	public Organism(String Name, boolean Belongs) {
		name = Name;
		doesBelong = Belongs;
	}//Organism
	
	/**
	 * 3 param Constructor 
	 * @param Name The name of the organism	
	 * @param Belongs the boolean determining if the organism belongs in the level
	 * @param Pur Sets the toString
	 */
	public Organism(String Name, boolean Belongs, String Pur) {
		name = Name;
		doesBelong = Belongs;
		purpose = Pur;
	}
	
	/**
	 * 4 param constructor
	 * @param Name The name of the organism
	 * @param Belongs the boolean determining if the organism belongs in the level
	 * @param Pur Sets the toString
	 * @param File Sets the filepath for the image of the organism
	 */
	public Organism(String Name, boolean Belongs, String Pur, String File){
		name = Name;
		doesBelong = Belongs;
		purpose = Pur;
		filepath = File;
		try {
			image = ImageIO.read(new File(filepath));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 7 param constructor
	 * @param Name The name of the organism
	 * @param Belongs the boolean determining if the organism belongs in the level
	 * @param Pur Sets the toString
	 * @param File Sets the filepath for the image of the organism
	 * @param x Sets the int x location for image placement
	 * @param y Sets the int y location for image placement
	 * @param desc Sets the string description that gives a hint for the organism
	 */
	public Organism(String Name, boolean Belongs, String Pur, String File, int x, int y, String desc){
		name = Name;
		doesBelong = Belongs;
		purpose = Pur;
		filepath = File;
		try {
			image = ImageIO.read(new File(filepath));

		} catch (IOException e) {
			e.printStackTrace();
		}
		xloc = x;
		yloc = y;
		description = desc;
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
	 * @return int of x location
	 */
	public int getXloc() {
		return xloc;
	}

	/**
	 * Gets the yloc field of the organism
	 * @return int of y location
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
	 * @return the string explaining why the organism does/doesn't belong
	 */
	public String getToString(){
		return purpose;
	}
	
	/**
	 * 
	 * @return the string giving the description/hint for the organism
	 */
	public String getdesc(){
		return description;
	}
	
}//Class Organism