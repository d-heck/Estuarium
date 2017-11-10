package model;

import java.util.ArrayList;
import java.util.Collections;
/**
 * SaltMarshLevel is a subclass of level that is associated with Salt Marsh environments. 
 * It contains two lists of organisms, acceptedOrganisms, which holds Organisms that can
 * be found in salt marshes, and unacceptedOrganisms, which holds Organisms that do not
 * belong in salt marshes.
 * @author Jason Hickman
 *
 */
public class SaltMarshLevel extends Level{
	/**
	 * A basic constructor that instantiates a SaltMarshLevel and produces a 
	 * randomized organismList. It does this by calling createAcceptedList, 
	 * createUnacceptedList, and createOrganismList.
	 */
	public SaltMarshLevel(){
		createAcceptedList(); //Generates things that belong
		createUnacceptedList(); //Generates things that don't belong
		createOrganismList(); //Combines above two lists in a random order
	}//SaltMarshLevel
	
	/**
	 * createAcceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to true.  These organisms belong in a salt marsh.
	 */
	private void createAcceptedList(){
		acceptedOrganisms.add(new Organism("Muskrat",true));
		acceptedOrganisms.add(new Organism("Ribbed Mussel", true));
		acceptedOrganisms.add(new Organism("Whelk", true));
		acceptedOrganisms.add(new Organism("Fiddler Crab", true));
		acceptedOrganisms.add(new Organism("Great Blue Heron",true));
		acceptedOrganisms.add(new Organism("Cordgrass",true));
	}//createAcceptedList
	
	/**
	 * createUnacceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to false.  These organisms do not belong in a salt marsh or are 
	 * invasive species.
	 */
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new Organism("Phragmites Reed",false));
		unacceptedOrganisms.add(new Organism("Anglerfish",false));
		unacceptedOrganisms.add(new Organism("Lynx",false));
		unacceptedOrganisms.add(new Organism("Purple Loosestrife",false));
		unacceptedOrganisms.add(new Organism("Narrow-Leaf Cattail",false));
		unacceptedOrganisms.add(new Organism("European Green Crab",false));
	}//createUnacceptedList
	
	/**
	 * createOrganismList combines acceptedOrganisms and unacceptedOrganisms
	 * and uses Collections.shuffle to randomize the order of the list.
	 */
	public void createOrganismList(){
		organismList.addAll(acceptedOrganisms);
		organismList.addAll(unacceptedOrganisms);
		Collections.shuffle(organismList);
	}//createOrganismList

}
