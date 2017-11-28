package model;

import java.util.ArrayList;
import java.util.Collections;
/**
 * SaltMarshLevel is a subclass of level that is associated with Salt Marsh environments. 
 * It contains two lists of organisms, acceptedOrganisms, which holds Organisms that can
 * be found in salt marshes, and unacceptedOrganisms, which holds Organisms that do not
 * belong in salt marshes.
 * @author Jason Hickman
 * @see Level
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
		acceptedOrganisms.add(new Organism("Muskrat",true,"I nest using the vegetation and mud of salt marshes."));
		acceptedOrganisms.add(new Organism("Ribbed Mussel", true,"I live in areas flooded with the tides and attach myself to marsh grass roots."));
		acceptedOrganisms.add(new Organism("Whelk", true,"I feed on marsh detritus and provide food for wading and shore birds."));
		acceptedOrganisms.add(new Organism("Fiddler Crab", true,"I burrow into the mud of the marsh, which actually helps new plants grow."));
		acceptedOrganisms.add(new Organism("Great Blue Heron",true,"I stand very still in the water before striking at fish or crabs."));
		acceptedOrganisms.add(new Organism("Cordgrass",true,"I hold sediment in place which gives many creatures a place to nest and burrow."));
	}//createAcceptedList
	
	/**
	 * createUnacceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to false.  These organisms do not belong in a salt marsh or are 
	 * invasive species.
	 */
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new Organism("Phragmites Reed",false,"I am an invasive species."));
		unacceptedOrganisms.add(new Organism("Anglerfish",false,"I live further out in the ocean."));
		unacceptedOrganisms.add(new Organism("Lynx",false,"I live in forest, mountain, or desert regions."));
		unacceptedOrganisms.add(new Organism("Purple Loosestrife",false,"I am an invasive species."));
		unacceptedOrganisms.add(new Organism("Narrow-Leaf Cattail",false,"I am an invasive species."));
		unacceptedOrganisms.add(new Organism("European Green Crab",false,"I am an invasive species."));
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
