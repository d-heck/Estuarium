package model;

import java.util.ArrayList;
import java.util.Collections;

import view.View;
/**
 * SaltMarshLevel is a subclass of level that is associated with Salt Marsh environments. 
 * It contains two lists of organisms, acceptedOrganisms, which holds Organisms that can
 * be found in salt marshes, and unacceptedOrganisms, which holds Organisms that do not
 * belong in salt marshes.
 * @author Jason Hickman
 * @author Kevin Doak
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
		background = "resources/images/saltmarsh.png";
		backgroundFull = "resources/images/saltmarshfull.png";
	}//SaltMarshLevel
	
	/**
	 * createAcceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to true.  These organisms belong in a salt marsh.
	 * @return Nothing
	 */
	private void createAcceptedList(){
		acceptedOrganisms.add(new Organism("Muskrat",true,"I nest using the vegetation and mud of salt marshes.","resources/images/muskrat.png",300,50,"I can make a home using mud"));
		acceptedOrganisms.add(new Organism("Ribbed Mussel", true,"I live in areas flooded with the tides and attach myself to marsh grass roots.","resources/images/ribbedmussel.png",900,150,"There's alot of water here!"));
		acceptedOrganisms.add(new Organism("Whelk", true,"I feed on marsh detritus and provide food for wading and shore birds.","resources/images/whelk.png",700,350,"Is that my favorite food over there?!"));
		acceptedOrganisms.add(new Organism("Fiddler Crab", true,"I burrow into the mud of the marsh, which actually helps new plants grow.","resources/images/fiddlercrab.png",650,100,"The soil isnt too hard here!"));
		acceptedOrganisms.add(new Organism("Great Blue Heron",true,"I stand very still in the water before striking at fish or crabs.","resources/images/greatblueheron.png",250,400,"My prey will come out any second now..."));
		acceptedOrganisms.add(new Organism("Cordgrass",true,"I hold sediment in place which gives many creatures a place to nest and burrow.","resources/images/cordgrass.png",800,150,"Animals here help me by me helping them"));
	}//createAcceptedList
	
	/**
	 * createUnacceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to false.  These organisms do not belong in a salt marsh or are 
	 * invasive species.
	 * @return Nothing
	 */
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new Organism("Phragmites Reed",false,"I am an invasive species.","resources/images/phragmitesreed.png",50,200, "I hurt alot of organisms here but I dont care!"));
		unacceptedOrganisms.add(new Organism("Anglerfish",false,"I live further out in the ocean.","resources/images/anglerfish.png",300,300, "Eww, not enough water"));
		unacceptedOrganisms.add(new Organism("Lynx",false,"I live in forest, mountain, or desert regions.","resources/images/lynx.png",200,480, "Why is there so much water here?"));
		unacceptedOrganisms.add(new Organism("Purple Loosestrife",false,"I am an invasive species.","resources/images/purpleloosestrife.png",25,300, "I hurt alot of organisms here but I dont care!"));
		unacceptedOrganisms.add(new Organism("Narrow-Leaf Cattail",false,"I am an invasive species.","resources/images/narrowleafcattail.png",650,300, "I hurt alot of organisms here but I dont care!"));
		unacceptedOrganisms.add(new Organism("European Green Crab",false,"I am an invasive species.","resources/images/europeangreencrab.png",300,150,"I hurt alot of organisms here but I dont care!"));
	}//createUnacceptedList
	
	/**
	 * createOrganismList combines acceptedOrganisms and unacceptedOrganisms
	 * and uses Collections.shuffle to randomize the order of the list.
	 * @return Nothing
	 */
	public void createOrganismList(){
		organismList.addAll(acceptedOrganisms);
		organismList.addAll(unacceptedOrganisms);
		Collections.shuffle(organismList);
	}//createOrganismList

}
