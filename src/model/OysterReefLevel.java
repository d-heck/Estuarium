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
	 * @return Nothing
	 */
	private void createAcceptedList(){
		acceptedOrganisms.add(new Organism("Eastern Oyster",true,"I attach myself to others of my kind to form the main part of an oyster reef.","resources/images/easternoyster.png",300,175, "A small oyster."));
		acceptedOrganisms.add(new Organism("Goby",true,"I can hide from larger predators in small crevices in oyster reefs.","resources/images/goby.png",800,400, "A small fish found in bay areas"));
		acceptedOrganisms.add(new Organism("Black Drum",true,"As an adult, my teeth are large enough to crush oyster shells so I can eat the oyster within.","resources/images/blackdrum.png",750,175, "A fish who feast on oysters in the area."));
		acceptedOrganisms.add(new Organism("Microalgae",true,"I provide a source of food to the oysters in the reef, who can filter me out of the water.","resources/images/microalgae.png",600,250, "Tiny green stuff filled with life!"));
		acceptedOrganisms.add(new Organism("American Eel",true,"I can feed on a variety of organisms that call oyster reefs home.","resources/images/americaneel.png",650,500, "A slipperly slimy eel!"));
		acceptedOrganisms.add(new Organism("Oyster Toadfish",true,"While I mostly eat small crabs, I can also feed on the oysters and small fish.","resources/images/oystertoadfish.png",950,350, "Is it an oyster a toad or a fish?"));
	}//createAcceptedList
	
	/**
	 * createUnacceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to false.  These organisms do not belong in a oyster reef or are 
	 * invasive species.
	 * @return Nothing
	 */
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new Organism("Green Porcelain Crab",false,"I am an invasive species.","resources/images/greenporcelaincrab.png",300,60, "A big scary crab, looks mean."));
		unacceptedOrganisms.add(new Organism("Striped Barnacle",false,"I am an invasive species.","resources/images/barnacle.png",200,300,"Shelled creatures not native to this area."));
		unacceptedOrganisms.add(new Organism("European Green Crab",false,"I am an invasive species.","resources/images/europeangreencrab.png",0,400, "What's a crab from europe doing here?"));
		unacceptedOrganisms.add(new Organism("Tube Worm",false,"I am invasive and can damage the shell of oysters I burrow into.","resources/images/tubeworm.png",450,350, "A long worm that burrows into oysters!"));
		unacceptedOrganisms.add(new Organism("Orange-Striped Anemone",false,"I am invasive and can make it difficult for oysters to feed.","resources/images/anemone.png",400,125, "Look at all those warning colors!"));
		unacceptedOrganisms.add(new Organism("Charru Mussel",false,"I am invasive and can compete with oysters for food.","resources/images/charrumussel.png",900,100, "Looks like a big mean mussle!"));
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
