package game;

import java.util.ArrayList;
import java.util.Collections;

public class MangroveLevel extends Level{

	ArrayList<Organism> acceptedOrganisms; //Holds Organisms with doesBelong = true;
	ArrayList<Organism> unacceptedOrganisms; //Holds Organisms with doesBelong = false;
	
	//Constructor
	public MangroveLevel(){
		createAcceptedList(); //Generates things that belong
		createUnacceptedList(); //Generates things that don't belong
		createOrganismList(); //Combines above two lists in a random order
	}//MangroveLevel
	
	private void createAcceptedList(){
		acceptedOrganisms.add(new Organism("Kingfisher",true));
		acceptedOrganisms.add(new Organism("Fiddler Crab",true));
		acceptedOrganisms.add(new Organism("Barnacles",true));
		acceptedOrganisms.add(new Organism("Oysters",true));
		acceptedOrganisms.add(new Organism("Red Mangroves",true));
		acceptedOrganisms.add(new Organism("Shore Purslane",true));
	}
	
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new Organism("Gopher",false));
		unacceptedOrganisms.add(new Organism("Spotted Turtle",false));
		unacceptedOrganisms.add(new Organism("Rainbow Trout",false));
		unacceptedOrganisms.add(new Organism("Crappies",false));
		unacceptedOrganisms.add(new Organism("Black Oak",false));
		unacceptedOrganisms.add(new Organism("Water Lily",false));
	}
	
	private void createOrganismList(){
		organismList.addAll(acceptedOrganisms);
		organismList.addAll(unacceptedOrganisms);
		Collections.shuffle(organismList);
	}
	
}
