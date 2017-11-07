package model;

import java.util.ArrayList;
import java.util.Collections;
/**
 * MangroveLevel is a subclass of level that is associated with Mangrove environments. 
 * It contains two lists of organisms, acceptedOrganisms, which holds Organisms that can
 * be found in mangroves, and unacceptedOrganisms, which holds Organisms that do not
 * belong in mangroves.
 * @author Jason Hickman
 *
 */
public class MangroveLevel extends Level{

	ArrayList<Organism> acceptedOrganisms; //Holds Organisms with doesBelong = true;
	ArrayList<Organism> unacceptedOrganisms; //Holds Organisms with doesBelong = false;
	
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
		acceptedOrganisms.add(new Organism("Kingfisher",true));
		acceptedOrganisms.add(new Organism("Fiddler Crab",true));
		acceptedOrganisms.add(new Organism("Barnacles",true));
		acceptedOrganisms.add(new Organism("Oysters",true));
		acceptedOrganisms.add(new Organism("Red Mangroves",true));
		acceptedOrganisms.add(new Organism("Shore Purslane",true));
	}//createAcceptedList
	
	/**
	 * createUnacceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to false.  These organisms do not belong in a mangrove environment or 
	 * are invasive species.
	 */
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new Organism("Gopher",false));
		unacceptedOrganisms.add(new Organism("Spotted Turtle",false));
		unacceptedOrganisms.add(new Organism("Rainbow Trout",false));
		unacceptedOrganisms.add(new Organism("Crappies",false));
		unacceptedOrganisms.add(new Organism("Black Oak",false));
		unacceptedOrganisms.add(new Organism("Water Lily",false));
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
