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
		background = "resources/images/mangrove.png";
	}//MangroveLevel

	/**
	 * createAcceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to true.  These organisms belong in a mangrove environment.
	 */
	private void createAcceptedList(){
		acceptedOrganisms.add(new Organism("Kingfisher",true,"I nest in the mangroves and feed on fish and mollusks.","resources/images/kingfisher.png"));
		acceptedOrganisms.add(new Organism("Fiddler Crab",true,"I burrow into the deeper mud at the mangroves roots.","resources/images/fiddlercrab.png"));
		acceptedOrganisms.add(new Organism("Barnacle",true,"I attach myself to any hard surface in the water - like the roots of mangroves.","resources/images/barnacle.png"));
		acceptedOrganisms.add(new Organism("Oyster",true,"I attaach myself to mangrove roots and filter the water.","resources/images/oyster.png"));
		acceptedOrganisms.add(new Organism("Red Mangrove",true,"My exposed roots help provide a nesting habitat for a variety of organisms.","resources/images/redmangrove.png"));
		acceptedOrganisms.add(new Organism("Shore Purslane",true,"I grow well in the always-damp soil found in mangrove environments.","resources/images/shorepurslane.png"));
	}//createAcceptedList

	/**
	 * createUnacceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to false.  These organisms do not belong in a mangrove environment or 
	 * are invasive species.
	 */
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new Organism("Gopher",false,"I can't tunnel well here, since there's too much water.","resources/images/gopher.png"));
		unacceptedOrganisms.add(new Organism("Spotted Turtle",false,"I live in fresh water.","resources/images/spottedturtle.png"));
		unacceptedOrganisms.add(new Organism("Rainbow Trout",false,"I live in fresh water.","resources/images/rainbowtrout.png"));
		unacceptedOrganisms.add(new Organism("Crappie",false,"I live in fresh water","resources/images/crappie.png"));
		unacceptedOrganisms.add(new Organism("Black Oak",false,"The salt in the water would damage my trunk and roots.","resources/images/blackoak.png"));
		unacceptedOrganisms.add(new Organism("Water Lily",false,"I grow best in fresh water.","resources/images/waterlily.png"));
	}//createUnacceptedList

	/**
	 * createOrganismList combines acceptedOrganisms and unacceptedOrganisms
	 * and uses Collections.shuffle to randomize the order of the list.
	 */
	public void createOrganismList(){
		Collections.shuffle(organismList);
	}//createOrganismList
}
