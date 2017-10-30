package game;

public class PlantBasedOrganism extends Organism{
	
	//Variables
	private boolean doesBelong = false;
	final boolean canSwim = false;
	final boolean canWalk = false;
	String name;
	String toString;
	String filepath;
	
	//Constructor
	public PlantBasedOrganism() {
		doesBelong = true;
		name = "Plant Based Organism";		
	}
	
	//Overloaded Constructors
	public PlantBasedOrganism(String Name, Boolean x) {
		doesBelong = x;
		name = Name;		
	}
	
	public PlantBasedOrganism(Boolean x) {
		doesBelong = x;
		name = "Plant Based Organism";		
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
	
	public String getFilePath() {
		return filepath;
	}

	public void setFilePath(String filepath) {
		this.filepath = filepath;
	}
	
	//toString
	public String toString() {
		return toString;
	}//toString
	
	public void setToString(String x) {
		toString = x;
	}
}
