package model;

import java.util.ArrayList;
import java.util.Collections;
/**
 * MangroveLevel is a subclass of level that is associated with Mangrove environments. 
 * It contains two lists of organisms, acceptedOrganisms, which holds Organisms that can
 * be found in mangroves, and unacceptedOrganisms, which holds Organisms that do not
 * belong in mangroves.
 * @author Jason Hickman
 * @see Level
 *
 */
public class MangroveLevel extends Level{
	/**
	 * A basic constructor that instantiates a MangroveLevel and produces a 
	 * randomized organismList. It does this by calling createAcceptedList, 
	 * createUnacceptedList, and createOrganismList.
	 */
	public MangroveLevel(){
		createAcceptedList();
		createUnacceptedList();
		createOrganismList();
	}//MangroveLevel
	
	/**
	 * createAcceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to true.  These organisms belong in a mangrove environment.
	 */
	private void createAcceptedList(){
		acceptedOrganisms.add(new Organism("Kingfisher",true,"I nest in the mangroves and feed on fish and mollusks."));
		acceptedOrganisms.add(new Organism("Fiddler Crab",true,"I burrow into the deeper mud at the mangroves roots."));
		acceptedOrganisms.add(new Organism("Barnacle",true,"I attach myself to any hard surface in the water - like the roots of mangroves."));
		acceptedOrganisms.add(new Organism("Oyster",true,"I attaach myself to mangrove roots and filter the water."));
		acceptedOrganisms.add(new Organism("Red Mangrove",true,"My exposed roots help provide a nesting habitat for a variety of organisms."));
		acceptedOrganisms.add(new Organism("Shore Purslane",true,"I grow well in the always-damp soil found in mangrove environments."));
	}//createAcceptedList
	
	/**
	 * createUnacceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to false.  These organisms do not belong in a mangrove environment or 
	 * are invasive species.
	 */
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new Organism("Gopher",false,"I can't tunnel well here, since there's too much water."));
		unacceptedOrganisms.add(new Organism("Spotted Turtle",false,"I live in fresh water."));
		unacceptedOrganisms.add(new Organism("Rainbow Trout",false,"I live in fresh water."));
		unacceptedOrganisms.add(new Organism("Crappie",false,"I live in fresh water"));
		unacceptedOrganisms.add(new Organism("Black Oak",false,"The salt in the water would damage my trunk and roots."));
		unacceptedOrganisms.add(new Organism("Water Lily",false,"I grow best in fresh water."));
	}//createUnacceptedList
	
	/**
	 * createOrganismList combines acceptedOrganisms and unacceptedOrganisms
	 * and uses Collections.shuffle to randomize the order of the list.
	 */
	public void createOrganismList(){
		Collections.shuffle(organismList);
	}//createOrganismList
	
}
