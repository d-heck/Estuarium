package game;

public class AquaticOrganism extends Organism {
	// Variables
	private boolean doesBelong = false;
	boolean canSwim = false;
	boolean canWalk = false;
	String name;
	String toString;

	// Constructor
	public AquaticOrganism() {
			doesBelong = false;
			canSwim = false;
			canWalk = true;	
			name = "Aquatic Organism.";
		}

	// Overloaded Constructors
	public AquaticOrganism(String Name, Boolean x) {
			doesBelong = x;
			canSwim = true;
			canWalk = false;
			name = Name;
		}

	public AquaticOrganism(Boolean x) {
			doesBelong = x;
			canSwim = true;
			canWalk = false;	
			name = "Aquatic Organism.";
		}

	// Getters + Setters
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