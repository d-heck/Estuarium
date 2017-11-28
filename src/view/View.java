package view;
import model.*;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import model.Level;

import javax.swing.JInternalFrame;

/**
 * View is a public class that extends JFrame and implements ActionListener and MouseMotionListener.
 * which communicates with the controller to modify the model. It put all images on the screen and allows
 * for user input for an interactive game experience. It also works on displaying the prompt for placement
 * of any Estuarium objects.
 * @author Jeremy Gouveia
 * @author David Heck
 * @author Jason Hickman
 * @version 0.6
 */

public class View extends JFrame implements ActionListener, MouseMotionListener {

	//Dimensions
	final static int frameWidth = 1280;
	final static int frameHeight = 760;
	int picture = 0;
	int maxTurns;

	
	/**
	 * mouseDragged returns nothing but potentially changes the state of the game if the mouse is 
	 * dragged.
	 * @param MouseEvent A mouse drag
	 * 
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	/**
	 * mouseMoved returns nothing but potentially changes the state of the game if the mouse is moved.
	 * @param MouseEvent A mouse move
	 * 
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * actionPerformed returns nothing but potentially changes the state of the game if an action is done.
	 * @param ActionEvent an Action Performed
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	// TODO: View Class

	/**
	 * MainMenu returns nothing but changes the state of the game. It loads the main menu and launches
	 * the level
	 * 
	 */
	//Load Main Menu, Launch Level on Play
	private void MainMenu() {
		//Create and set up the window.
		JFrame frame = new JFrame("Estuarium");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set up panels
		JPanel p = new JPanel(new GridBagLayout());
		p.setSize(frameWidth, frameHeight);
		p.setBackground(Color.GRAY);

		//Add Button + Label
		JButton b1 = new JButton("Play");

		//Play Button
		b1.addActionListener(new ActionListener() {
			
			/**
			 * actionPerformed returns nothing but disposes the current frame and loads the next level.
			 * @param ActionEvent an action performed
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				LoadLevel(new Level());	
			}

		});
		JLabel l1 = new JLabel("Click here to play!");

		p.add(b1);
		p.add(l1);

		//Display the window.
		frame.add(p);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(frameWidth, frameHeight);

	}

	
	/**
	 *LoadLevel returns nothing but loads a level into the game. It initializes the organism list
	 *and loads a BG image.
	 * 
	 * @param L a level
	 * @see Organism 
	 */
	//Loads a Level to play, initializes organism list and loads BG image

	public void LoadLevel(Level L) {
		//TODO: This method should "play" the level.

		//Create and set up the window.
		JFrame frame = new JFrame("Estuarium");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create Panel
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints settings = new GridBagConstraints();

		//Makes JPanel
		JPanel promptPanel = new JPanel(new GridBagLayout());
		//Sets background to Opaque so that we don't see the background on Panel
		promptPanel.setOpaque(true);
		//Creates color that's black
		Border blackline = BorderFactory.createLineBorder(Color.black);
		//Sets border to blackline
		promptPanel.setBorder(blackline);
		//Sets Panel size
		promptPanel.setSize(frameWidth/4, frameHeight/2);
		//Sets Panel location
		promptPanel.setLocation(frameWidth/2 + 150, frameHeight/4);
		
		ArrayList<JLabel> img_labels = new ArrayList<JLabel>(); //JLabels for Prompt
		ArrayList<JPanel> org_panels = new ArrayList<JPanel>(); //JLabels for Organisms
		//Makes JLabel of ArrayLists in images
		System.out.println("img_labels ArrayList made");
		int counter = 70; //used in placement of images
		//Iterates through organism list
		for(Organism o : L.organismList) {
			img_labels.add(new JLabel(new ImageIcon(o.image))); //adds organism image to img_labels
			JLabel tempimg_label = new JLabel(new ImageIcon(o.image)); //adds organism img to tempimg_label
			JLabel temptext_label = new JLabel(o.toString()); //adds organism to string to temptext_label
			
			//Makes Panel for background
			JPanel temp_panel = new JPanel(new GridBagLayout()); //Temp_panel to be added to org_panels
			temp_panel.add(temptext_label); //Adds temptext label
			temp_panel.add(tempimg_label); //Adds tempimg_label
			temp_panel.setOpaque(false); 
			temp_panel.setLocation((100 + counter) % (frameWidth - 100), (250 + counter) % (frameHeight - 100)); //sets location for organism
			temp_panel.setVisible(false); //sets visibility to false
			temp_panel.setSize(400,400); // sets size of organism
			
			org_panels.add(temp_panel); //Adds temp_panel to org_panels
			
			System.out.println("JLabel for organism made:" + o.toString());
			counter = (counter * 2) % 200; //Modifies the counter for a unique placement
		}
		p.add(img_labels.get(picture));


		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(L.background)))));
		} catch (IOException e) {
			e.printStackTrace();
		}


		//Create Buttons For Card
		ImageIcon YES = new ImageIcon("resources/images/check_mark_green.png");
		ImageIcon NO = new ImageIcon("resources/images/x_mark_red.png");
		JButton bYes = new JButton(YES);
		settings.fill = GridBagConstraints.HORIZONTAL;
		settings.anchor = GridBagConstraints.PAGE_END;
		settings.gridx = 0;
		settings.gridwidth = 1;
		settings.gridy = 3;
		p.add(bYes, settings);
		
		JButton bNo = new JButton(NO);
		settings.fill = GridBagConstraints.HORIZONTAL;
		settings.weightx = 0.5;
		settings.gridx = 1;
		settings.gridwidth = 1;
		settings.gridy = 3;
		p.add(bNo, settings);
		
		//Set Up Panel
		p.setSize(400, 400);

		bYes.setSize(800, 800);
		bNo.setSize(800, 800);


		maxTurns = L.organismList.size()-1;
		
		//Button Functionality for prompt 
		bYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (picture < maxTurns){
					System.out.print(L.organismList.get(picture).toString());	
					org_panels.get(picture).setVisible(true);					
					p.remove(img_labels.get(picture));
					picture++;
					p.add(img_labels.get(picture));					
					p.revalidate();
					p.repaint();
				}
				else if (picture == maxTurns){
					System.out.println(L.organismList.get(2).toString());			
					org_panels.get(picture).setVisible(true);
					promptPanel.setVisible(false);
					p.revalidate();
					p.repaint();
				}

			}	
		});

		bNo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (picture < maxTurns){
					System.out.print(L.organismList.get(1).toString());	
					p.remove(img_labels.get(picture));
					picture++;
					p.add(img_labels.get(picture));					
					p.revalidate();
					p.repaint();
				}
				else if (picture == maxTurns){
					System.out.println(L.organismList.get(2).toString());
					promptPanel.setVisible(false);
					p.revalidate();
					p.repaint();
				}
				
			}
		});


		//frame.add(p, BorderLayout.CENTER);
		frame.add(promptPanel);
		//Set Up Frame
		promptPanel.add(p);
		for(JPanel panel : org_panels) {
			frame.add(panel);
		}
		frame.pack();
		frame.setVisible(true);
		frame.setSize(frameWidth, frameHeight);

	}

	/**
	 * View constructs the class for view and calls function MainMenu
	 * 
	 */
	public View() {
		MainMenu();
	}
}