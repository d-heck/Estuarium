package model;

import java.util.Collections;

import view.View;

/**
 * OysterReefLevel is a subclass of level that is associated with Oyster Reef 
 * environments. It contains two lists of organisms, acceptedOrganisms, which 
 * holds Organisms that can be found in oyster reefs, and unacceptedOrganisms,
 *  which holds Organisms that do not belong in oyster reefs.
 * @author Jason Hickman
 * @author Kevin Doak
 * @see Level
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
		background = "resources/images/oysterreef.png";
		backgroundFull = "resources/images/oysterreeffull.png";
	}//OysterReefLevel
	
	/**
	 * createAcceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to true.  These organisms belong in an oyster reef.
	 */
	private void createAcceptedList(){
		acceptedOrganisms.add(new Organism("Eastern Oyster",true,"I attach myself to others of my kind to form the main part of an oyster reef.","resources/images/easternoyster.png",300,175));
		acceptedOrganisms.add(new Organism("Goby",true,"I can hide from larger predators in small crevices in oyster reefs.","resources/images/goby.png",800,400));
		acceptedOrganisms.add(new Organism("Black Drum",true,"As an adult, my teeth are large enough to crush oyster shells so I can eat the oyster within.","resources/images/blackdrum.png",100,175));
		acceptedOrganisms.add(new Organism("Microalgae",true,"I provide a source of food to the oysters in the reef, who can filter me out of the water.","resources/images/microalgae.png",600,250));
		acceptedOrganisms.add(new Organism("American Eel",true,"I can feed on a variety of organisms that call oyster reefs home.","resources/images/americaneel.png",650,500));
		acceptedOrganisms.add(new Organism("Oyster Toadfish",true,"While I mostly eat small crabs, I can also feed on the oysters and small fish.","resources/images/oystertoadfish.png",600,100));
	}//createAcceptedList
	
	/**
	 * createUnacceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to false.  These organisms do not belong in a oyster reef or are 
	 * invasive species.
	 */
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new Organism("Green Porcelain Crab",false,"I am an invasive species.","resources/images/greenporcelaincrab.png",300,0));
		unacceptedOrganisms.add(new Organism("Striped Barnacle",false,"I am an invasive species.","resources/images/barnacle.png",200,300,"Shelled creatures not native to this area."));
		unacceptedOrganisms.add(new Organism("European Green Crab",false,"I am an invasive species.","resources/images/europeangreencrab.png",0,400));
		unacceptedOrganisms.add(new Organism("Tube Worm",false,"I am invasive and can damage the shell of oysters I burrow into.","resources/images/tubeworm.png",450,350));
		unacceptedOrganisms.add(new Organism("Orange-Striped Anemone",false,"I am invasive and can make it difficult for oysters to feed.","resources/images/anemone.png",400,125));
		unacceptedOrganisms.add(new Organism("Charru Mussel",false,"I am invasive and can compete with oysters for food.","resources/images/charrumussel.png",900,50));
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
