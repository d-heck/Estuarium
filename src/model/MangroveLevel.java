package model;

import java.util.ArrayList;
import java.util.Collections;
import view.*;
/**
 * MangroveLevel is a subclass of level that is associated with Mangrove environments. 
 * It contains two lists of organisms, acceptedOrganisms, which holds Organisms that can
 * be found in mangroves, and unacceptedOrganisms, which holds Organisms that do not
 * belong in mangroves.
 * @author Jason Hickman
 * @author Kevin Doak
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
		backgroundFull = "resources/images/mangrovefull.png";
	}//MangroveLevel

	/**
	 * createAcceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to true.  These organisms belong in a mangrove environment.
	 */
	private void createAcceptedList(){
		acceptedOrganisms.add(new Organism("Kingfisher",true,"I nest in the mangroves.","resources/images/kingfisher.png",(int)(.684*View.getFrameWidth()),(int)(-.164*View.getFrameHeight())));
		acceptedOrganisms.add(new Organism("Fiddler Crab",true,"I burrow into mud at the mangroves roots.","resources/images/fiddlercrab.png",(int)(.43*View.getFrameWidth()),(int)(.263*View.getFrameHeight())));
		acceptedOrganisms.add(new Organism("Barnacle",true,"I attach myself to the roots of mangroves.","resources/images/barnacle.png",(int)(.625*View.getFrameWidth()),(int)(.461*View.getFrameHeight())));
		acceptedOrganisms.add(new Organism("Oyster",true,"I attach myself to mangrove roots.","resources/images/oyster.png",(int)(.684*View.getFrameWidth()),(int)(.526*View.getFrameHeight())));
		acceptedOrganisms.add(new Organism("Red Mangrove",true,"My exposed roots provide a nesting habitat.","resources/images/redmangrove.png",(int)(.781*View.getFrameWidth()),(int)(.461*View.getFrameHeight())));
		acceptedOrganisms.add(new Organism("Shore Purslane",true,"I grow well in the always-damp soil.","resources/images/shorepurslane.png",(int)(-.117*View.getFrameWidth()),(int)(.395*View.getFrameHeight())));
	}//createAcceptedList

	/**
	 * createUnacceptedList creates an ArrayList of Organisms for which doesBelong
	 * is set to false.  These organisms do not belong in a mangrove environment or 
	 * are invasive species.
	 */
	private void createUnacceptedList(){
		unacceptedOrganisms.add(new Organism("Gopher",false,"I can't tunnel since there's too much water.","resources/images/gopher.png",(int)(.508*View.getFrameWidth()),(int)(.263*View.getFrameHeight())));
		unacceptedOrganisms.add(new Organism("Spotted Turtle",false,"I live in fresh water.","resources/images/spottedturtle.png",(int)(.156*View.getFrameWidth()),(int)(.263*View.getFrameHeight())));
		unacceptedOrganisms.add(new Organism("Rainbow Trout",false,"I live in fresh water.","resources/images/rainbowtrout.png",(int)(.313*View.getFrameWidth()),(int)(.526*View.getFrameHeight())));
		unacceptedOrganisms.add(new Organism("Crappie",false,"I live in fresh water","resources/images/crappie.png",(int)(.078*View.getFrameWidth()),(int)(.592*View.getFrameHeight())));
		unacceptedOrganisms.add(new Organism("Black Oak",false,"The salt water would damage my trunk and roots.","resources/images/blackoak.png",(int)(-.117*View.getFrameWidth()),0));
		unacceptedOrganisms.add(new Organism("Water Lily",false,"I grow best in fresh water.","resources/images/waterlily.png",(int)(.078*View.getFrameWidth()),(int)(.395*View.getFrameHeight())));
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
