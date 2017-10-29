package game;

import java.util.ArrayList;
import java.util.Collections;

public class SaltMarshLevel extends Level{
	
	ArrayList<Organism> acceptedOrganisms; //Holds Organisms with doesBelong = true;
	ArrayList<Organism> unacceptedOrganisms; //Holds Organisms with doesBelong = false;
	
	//Constructor
	public SaltMarshLevel(){
		createAcceptedList(); //Generates things that belong
		createUnacceptedList(); //Generates things that don't belong
		createOrganismList(); //Combines above two lists in a random order
	}//SaltMarshLevel
	
	
	private void createAcceptedList(){
		acceptedOrganisms.add(new LandOrganism("Muskrat",true));
		acceptedOrganisms.add(new AquaticOrganism("Ribbed Mussel", true));
		acceptedOrganisms.add(new AquaticOrganism("Whelk", true));
		acceptedOrganisms.add(new LandOrganism("Fiddler Crab", true));
		acceptedOrganisms.add(new LandOrganism("Great Blue Heron",true));
		acceptedOrganisms.add(new PlantBasedOrganism("Cordgrass",true));
	}//createAcceptedList
	
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new PlantBasedOrganism("Phragmites Reed",false));
		unacceptedOrganisms.add(new AquaticOrganism("Anglerfish",false));
		unacceptedOrganisms.add(new LandOrganism("Lynx",false));
		unacceptedOrganisms.add(new PlantBasedOrganism("Purple Loosestrife",false));
		unacceptedOrganisms.add(new PlantBasedOrganism("Narrow-Leaf Cattail",false));
		unacceptedOrganisms.add(new LandOrganism("Green Crab",false));
	}//createUnacceptedList
	
	public void createOrganismList(){
		organismList.addAll(acceptedOrganisms);
		organismList.addAll(unacceptedOrganisms);
		Collections.shuffle(organismList);
	}
	

}
