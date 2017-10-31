package model;

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
		acceptedOrganisms.add(new Organism("Muskrat",true));
		acceptedOrganisms.add(new Organism("Ribbed Mussel", true));
		acceptedOrganisms.add(new Organism("Whelk", true));
		acceptedOrganisms.add(new Organism("Fiddler Crab", true));
		acceptedOrganisms.add(new Organism("Great Blue Heron",true));
		acceptedOrganisms.add(new Organism("Cordgrass",true));
	}//createAcceptedList
	
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new Organism("Phragmites Reed",false));
		unacceptedOrganisms.add(new Organism("Anglerfish",false));
		unacceptedOrganisms.add(new Organism("Lynx",false));
		unacceptedOrganisms.add(new Organism("Purple Loosestrife",false));
		unacceptedOrganisms.add(new Organism("Narrow-Leaf Cattail",false));
		unacceptedOrganisms.add(new Organism("Green Crab",false));
	}//createUnacceptedList
	
	public void createOrganismList(){
		organismList.addAll(acceptedOrganisms);
		organismList.addAll(unacceptedOrganisms);
		Collections.shuffle(organismList);
	}
	

}
