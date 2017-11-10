package model;

import java.util.Collections;

/**
 * OysterReefLevel is a subclass of level that is associated with Oyster Reef 
 * environments. It contains two lists of organisms, acceptedOrganisms, which 
 * holds Organisms that can be found in oyster reefs, and unacceptedOrganisms,
 *  which holds Organisms that do not belong in oyster reefs.
 * @author Jason Hickman
 *
 */
public class OysterReefLevel extends Level{
	/**
	 * A basic constructor that instantiates a OysterReefLevel and produces a 
	 * randomized organismList. It does this by calling createAcceptedList, 
	 * createUnacceptedList, and createOrganismList.
	 */
	public OysterReefLevel(){
		createAcceptedList();
		createUnacceptedList();
		createOrganismList();
	}//OysterReefLevel
	
	/**
	 * createAcceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to true.  These organisms belong in an oyster reef.
	 */
	private void createAcceptedList(){
		acceptedOrganisms.add(new Organism("Eastern Oyster",true));
		acceptedOrganisms.add(new Organism("Goby",true));
		acceptedOrganisms.add(new Organism("Black Drum",true));
		acceptedOrganisms.add(new Organism("Microalgae",true));
		acceptedOrganisms.add(new Organism("American Eel",true));
		acceptedOrganisms.add(new Organism("Oyster Toadfish",true));
	}//createAcceptedList
	
	/**
	 * createUnacceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to false.  These organisms do not belong in a oyster reef or are 
	 * invasive species.
	 */
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new Organism("Green Porcelain Crab",false));
		unacceptedOrganisms.add(new Organism("Striped Barnacle",false));
		unacceptedOrganisms.add(new Organism("European Green Crab",false));
		unacceptedOrganisms.add(new Organism("Tube Worms",false));
		unacceptedOrganisms.add(new Organism("Striped Anemone",false));
		unacceptedOrganisms.add(new Organism("Charru Mussel",false));
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
