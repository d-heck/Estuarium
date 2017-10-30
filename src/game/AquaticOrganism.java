package game;

public class AquaticOrganism extends Organism {
	// Variables
	private boolean doesBelong = false;
	boolean canSwim = false;
	boolean canWalk = false;
	String name;
	String toString;
	String filepath;

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
	
	public AquaticOrganism(String Name, boolean Belongs, String File) {
		name = Name;
		doesBelong = Belongs;
		filepath = File;
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
