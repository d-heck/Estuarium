package game;

public class LandOrganism extends Organism{
	//Variables
	private boolean doesBelong = false;
	boolean canSwim = false;
	boolean canWalk = false;
	String name;
	String toString;
	
	//Constructor
	public LandOrganism() {
		doesBelong = false;
		canSwim = false;
		canWalk = true;	
		name = "Land Organism.";
	}
	
	//Overloaded Constructors
	public LandOrganism(String Name, Boolean x) {
		doesBelong = x;
		canSwim = false;
		canWalk = true;
		name = Name;
	}
	
	public LandOrganism(Boolean x) {
		doesBelong = x;
		canSwim = false;
		canWalk = true;	
		name = "Land Organism.";
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

	public boolean iscanWalk() {
		return canWalk;
	}

	public void setcanWalk(boolean canWalk) {
		this.canWalk = canWalk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	//toString
	public String toString() {
		return toString;
	}//toString
	
	public void setToString(String x) {
		toString = x;
	}
}
