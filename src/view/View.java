package view;
import model.*;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

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
 * @author Kevin Doak
 * @author Nonso Iwu
 * @version 0.6
 */

public class View extends JFrame implements ActionListener, MouseMotionListener {
	public View(double Scale){
		//Create and set up the window.
		this.setScale(Scale);
		frame = new JFrame("Estuarium");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//Dimensions
	static double scale = 1.0; // 1.0 = Windowed 1.5 = Full Screen
	
	int frameWidth = (int) (1280 * scale);
	int frameHeight = (int) (760 * scale);
	
	int picture = 0;
	int maxTurns;
	JFrame frame;
	
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
		frame.setUndecorated(true);
		System.out.println(scale);
		if (scale > 1) {
			try {
				frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("resources/images/menufull.png")))));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("resources/images/menu.png")))));
				frame.setUndecorated(false);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}

		//Set up panels
		JPanel p = new JPanel(new GridBagLayout());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		if(scale>1.0) {
			p.setSize((int)screenSize.getWidth(), (int) screenSize.getHeight());
		}else {
			p.setSize(frameWidth, frameHeight);
		}
		p.setOpaque(false);

		//Add Button + Label
		
		ImageIcon tutorial = new ImageIcon("resources/images/tutorialbutton.png");
		ImageIcon saltmarsh = new ImageIcon("resources/images/saltmarshbutton.png");
		ImageIcon mangrove = new ImageIcon("resources/images/mangrovebutton.png");
		ImageIcon oysterreef = new ImageIcon("resources/images/oysterreefbutton.png");
		

		JButton b = new JButton(tutorial);
		JButton b1 = new JButton(saltmarsh);
		JButton b2 = new JButton(mangrove);
		JButton b3 = new JButton(oysterreef);
		JButton fs = new JButton("Toggle Fullscreen");
		
		//Tutorial Loader
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				tutorial();
			}
		});

		//Salt Marsh Loader
		b1.addActionListener(new ActionListener() {		
			/**
			 * actionPerformed returns nothing but disposes the current frame and loads the next level.
			 * @param ActionEvent an action performed
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				LoadLevel(new SaltMarshLevel());
				frame.dispose();					
			}
		});
		
		//Mangrove Loader
		b2.addActionListener(new ActionListener() {		
			/**
			 * actionPerformed returns nothing but disposes the current frame and loads the next level.
			 * @param ActionEvent an action performed
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LoadLevel(new MangroveLevel());	
				frame.dispose();			
			}

		});
		
		//Oyster Reef Loader
		b3.addActionListener(new ActionListener() {		
			/**
			 * actionPerformed returns nothing but disposes the current frame and loads the next level.
			 * @param ActionEvent an action performed
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LoadLevel(new OysterReefLevel());	
				frame.dispose();			
			}
		});	
		
		fs.addActionListener(new ActionListener() {
			/**
			 * actionPerformed returns nothing but makes a fullscreen version or windowed versio
			 * of the game.
			 * @param ActionEvent an action performed
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				scale = (scale>1.0)? 1.0 : 1.5;
				frame.dispose();			
				MainMenu();
			}
		});
		
		p.add(b);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(fs);

		//Display the window.
		frame.add(p);
		frame.pack();
		frame.setVisible(true);
		if(scale>1.0) { 
			p.setLayout(null);
			b.setBounds(((int)screenSize.getWidth()/2)-400,((int)screenSize.getHeight()/2)-200,200,400);
			b1.setBounds(((int)screenSize.getWidth()/2)-200,((int)screenSize.getHeight()/2)-200,200,400);
			b2.setBounds((int)screenSize.getWidth()/2,((int)screenSize.getHeight()/2)-200,200,400);
			b3.setBounds(((int)screenSize.getWidth()/2) + 200,((int)screenSize.getHeight()/2)-200,200,400);
			fs.setBounds(0,0,fs.getWidth(),fs.getHeight());
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setSize(screenSize.width,screenSize.height);
		}else {
			p.setLayout(null);
			b.setBounds(240,180,200,400);
			b1.setBounds(440,180,200,400);
			b2.setBounds(640,180,200,400);
			b3.setBounds(840,180,200,400);
			fs.setBounds(0,0,fs.getWidth(),fs.getHeight());
			frame.setSize(frameWidth, frameHeight);
		}
		
	}
	
	//Tutorial
	private void tutorial(){
		//Instantiate Level
		
		Level L = new Level();
		L.setStrikes(0);
		L.setScore(0);
		picture = 0;
		
		//Create and set up the window.
		JFrame frame = new JFrame("Estuarium");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);		
		
		//Create Panel
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints settings = new GridBagConstraints();

		//Add Card Label
		JLabel nameTag = new JLabel("Label");
		nameTag.setText("Test");
		p.add(nameTag);

		//Make Strike Panel
		JPanel strikePanel = new JPanel(new GridBagLayout());

		//Makes JPanel
		JPanel promptPanel = new JPanel(new GridBagLayout());
		//Sets background to Opaque so that we don't see the background on Panel
		promptPanel.setOpaque(true);
		//Creates color that's black
		Border blackline = BorderFactory.createLineBorder(Color.black);
		//Sets border to blackline
		promptPanel.setBorder(blackline);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//Sets Panel size and Location
		if(scale>1.0) {
			promptPanel.setSize( (int)(frameWidth/4), (int) (frameHeight/3));
			promptPanel.setLocation(frameWidth - promptPanel.getWidth() - 50, frameHeight/4);
		}else {
			promptPanel.setSize( (int)(frameWidth*scale/4), (int) (frameHeight*scale/3));
			promptPanel.setLocation((int) screenSize.getWidth() - (int) promptPanel.getWidth() - 50,(int) screenSize.getHeight()/4);
		}
		
		//Tutorial Panel
		JPanel tutorialPanel = new JPanel(new GridBagLayout());
		tutorialPanel.setOpaque(true);
		tutorialPanel.setBorder(blackline);
		tutorialPanel.setSize(frameWidth/4 +(int)(.078*frameWidth),frameHeight/4 -100);
		ArrayList<JLabel> instructions = new ArrayList<JLabel>();
		instructions.add(new JLabel("This guy doesn't belong. Choose the X."));
		instructions.add(new JLabel("Good Job. This one does belong. Choose the check."));
		instructions.add(new JLabel("Now get one wrong. Choose the X."));
		instructions.add(new JLabel("A strike! Get three wrong and you lose!"));
		tutorialPanel.add(instructions.get(picture));
		if (scale > 1){
			tutorialPanel.setLocation(screenSize.width/2 - (tutorialPanel.getWidth()/2), screenSize.height - (tutorialPanel.getHeight())-50);
			//tutorialPanel.setLocation(frameWidth/2 - 300, frameHeight/4 + 100);
		}
		else{
			tutorialPanel.setLocation(frameWidth/2 - 300, frameHeight/4 + 100);
			tutorialPanel.setLocation(frameWidth/2 - 150, 3 * frameHeight/4+ 50);
		}
		tutorialPanel.setVisible(true);
		
		JButton mainButton = new JButton("Main Menu");
		mainButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				MainMenu();
				frame.dispose();				
			}
		});
		
		ArrayList<JLabel> img_labels = new ArrayList<JLabel>(); //JLabels for Prompt
		ArrayList<JPanel> org_panels = new ArrayList<JPanel>(); //JLabels for Organisms
		//Makes JLabel of ArrayLists in images
		System.out.println("img_labels ArrayList made");
		//Iterates through organism list
		for(Organism o : L.organismList) {
			img_labels.add(new JLabel(new ImageIcon(o.image))); //adds organism image to img_labels
			JLabel tempimg_label = new JLabel(new ImageIcon(o.image)); //adds organism img to tempimg_label

			//Makes Panel for background
			JPanel temp_panel = new JPanel(new GridBagLayout()); //Temp_panel to be added to org_panels
			temp_panel.add(tempimg_label); //Adds tempimg_label
			temp_panel.setOpaque(false); 
			temp_panel.setLocation((int) (o.getXloc() * scale), (int) (o.getYloc() * scale)); //sets location for organism
			temp_panel.setVisible(false); //sets visibility to false
			temp_panel.setSize(400,400); // sets size of organism

			JPanel txtpanel = new JPanel(new GridBagLayout());
			JLabel txtlabel = new JLabel(o.toString());

			tempimg_label.addMouseListener(new java.awt.event.MouseAdapter() {			

				 public void mouseEntered(java.awt.event.MouseEvent evt) {	
				    	//Set Panel Size + Location
				    	txtpanel.setVisible(false);
				    	txtpanel.setSize(o.toString().length() * 6, 50); //Sets size based on toString Length, fixes bugs.
				    	
				    	if((o.getXloc()  * scale )+200 <=frameWidth/2) {
				    		//Show label to the right
				    		txtpanel.setLocation((int) (o.getXloc() * scale)+250, (int) (o.getYloc() * scale)+175);
				    	}else{
				    		//Show label to the left
				    		txtpanel.setLocation((int) ((o.getXloc() * scale) - txtpanel.getSize().getWidth() + 150), (int) ((o.getYloc() * scale)+175));		    		
				    	}	

				    	//Add + Show Panel
				    	txtlabel.setOpaque(true);
				    	txtpanel.setOpaque(true);
				    	txtlabel.setVisible(true);		  
				    	txtpanel.add(txtlabel);	
				    	
				    	frame.add(txtpanel);
				    	txtpanel.setVisible(true);
				    }
				    
				    public void mouseExited(java.awt.event.MouseEvent evt) {
				    	//Hide Panel on Exit
				    	txtpanel.setVisible(false);
				    }
				});
			org_panels.add(temp_panel); //Adds temp_panel to org_panels
			System.out.println("JLabel for organism made:" + o.toString());
		}
		p.add(img_labels.get(picture));

		frame.setUndecorated(true);
		if (scale > 1) {
			try {
				frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(L.backgroundFull)))));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(L.background)))));
				frame.setUndecorated(false);
			} catch (IOException e) {
				e.printStackTrace();
			}			
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

		//Set Up Strike Panel
		strikePanel.setSize(300,200);
		strikePanel.setOpaque(false);
		ImageIcon strike = new ImageIcon("resources/images/x_mark_red.png");
		JLabel strikeLabel1 = new JLabel(strike, JLabel.CENTER);
		JLabel strikeLabel2 = new JLabel(strike, JLabel.CENTER);
		JLabel strikeLabel3 = new JLabel(strike, JLabel.CENTER);
		strikePanel.add(strikeLabel1);
		strikePanel.add(strikeLabel2);
		strikePanel.add(strikeLabel3);
		strikePanel.getComponent(0).setVisible(false);
		strikePanel.getComponent(1).setVisible(false);
		strikePanel.getComponent(2).setVisible(false);

		maxTurns = L.organismList.size()-1;

		//Set First Test
		nameTag.setText(L.organismList.get(0).getName());

		//Button Functionality for prompt 
		bYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (picture == 1){				
					System.out.print(L.organismList.get(picture).toString());
					org_panels.get(picture).setVisible(true);
					nameTag.setText(L.organismList.get(picture + 1).getName());
					p.remove(img_labels.get(picture));
					tutorialPanel.removeAll();
					picture++;
					tutorialPanel.add(instructions.get(2));
					p.add(img_labels.get(picture));					
					p.revalidate();
					p.repaint();
				}
				else{
					System.out.println("Select NO");
				}

			}	
		});

		bNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(picture == 1) {
					System.out.println("Select YES");
					return;
				}
				if(L.organismList.get(picture).isDoesBelong() == true) {
					//Add Code To Display an X
					System.out.println(" Wrong!");
					L.setStrikes(L.getStrikes() + 1);
					strikePanel.getComponent(L.getStrikes()).setVisible(true);
				}
				
				if (picture==0){
					System.out.print(L.organismList.get(picture).toString());
					nameTag.setText(L.organismList.get(picture + 1).getName());
					p.remove(img_labels.get(picture));
					tutorialPanel.removeAll();
					picture++;
					tutorialPanel.add(instructions.get(1));
					p.add(img_labels.get(picture));					
					p.revalidate();
					p.repaint();
				}
				else if (picture == 2){
					System.out.print(L.organismList.get(picture).toString());
					nameTag.setText(L.organismList.get(picture + 1).getName());
					p.remove(img_labels.get(picture));
					tutorialPanel.removeAll();
					tutorialPanel.repaint();
					picture++;
					tutorialPanel.add(instructions.get(3));
					tutorialPanel.add(mainButton);
					p.add(img_labels.get(picture));
					promptPanel.setVisible(false);
					p.revalidate();
					p.repaint();
				}
				else{
					System.out.println("Select YES");
				}

			}
		});

		frame.add(strikePanel);
		frame.add(p, BorderLayout.CENTER);
		frame.add(promptPanel);
		frame.add(tutorialPanel);
		//Set Up Frame
		promptPanel.add(p);
		for(JPanel panel : org_panels) {
			frame.add(panel);
		}
		frame.pack();
		frame.setVisible(true);
		if(scale>1.0) { 
			//p.setLayout(null);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setSize(screenSize.width,screenSize.height);
		}else {
			frame.setSize(frameWidth, frameHeight);
		}
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
		
		//Instantiate Level
		L.setStrikes(0);
		L.setScore(0);
		picture = 0;
		
		//Create and set up the window.
		JFrame frame = new JFrame("Estuarium");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);

		//Create Panel
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints settings = new GridBagConstraints();
		
		//Add Card Label
		JLabel nameTag = new JLabel("Label");
		nameTag.setText("Test");
		p.add(nameTag);
		
		//Make Game Over Panel
		JPanel endPanel = new JPanel(new GridBagLayout());
		
		//Make Strike Panel
		JPanel strikePanel = new JPanel(new GridBagLayout());

		//Makes JPanel
		JPanel promptPanel = new JPanel(new GridBagLayout());
		//Sets background to Opaque so that we don't see the background on Panel
		promptPanel.setOpaque(true);
		//Creates color that's black
		Border blackline = BorderFactory.createLineBorder(Color.black);
		//Sets border to blackline
		promptPanel.setBorder(blackline);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//Sets Panel size and Location
		if(scale>1.0) {
			promptPanel.setSize( (int)(frameWidth/4), (int) (frameHeight/3));
			promptPanel.setLocation(frameWidth - promptPanel.getWidth() - 50, frameHeight/4);
		}else {
			promptPanel.setSize( (int)(frameWidth*scale/4), (int) (frameHeight*scale/3));
			promptPanel.setLocation((int) screenSize.getWidth() - (int) promptPanel.getWidth() - 50,(int) screenSize.getHeight()/4);
		}
		
		ArrayList<JLabel> img_labels = new ArrayList<JLabel>(); //JLabels for Prompt
		ArrayList<JPanel> org_panels = new ArrayList<JPanel>(); //JLabels for Organisms
		//Makes JLabel of ArrayLists in images
		System.out.println("img_labels ArrayList made");
		//Iterates through organism list
		for(Organism o : L.organismList) {
			img_labels.add(new JLabel(new ImageIcon(o.image))); //adds organism image to img_labels
			JLabel tempimg_label = new JLabel(new ImageIcon(o.image)); //adds organism img to tempimg_label
			
			//Makes Panel for background
			JPanel temp_panel = new JPanel(new GridBagLayout()); //Temp_panel to be added to org_panels
			temp_panel.add(tempimg_label); //Adds tempimg_label
			temp_panel.setOpaque(false); 
			temp_panel.setLocation((int) (o.getXloc() * scale), (int) (o.getYloc() * scale)); //sets location for organism
			temp_panel.setVisible(false); //sets visibility to false
			temp_panel.setSize(400,400); // sets size of organism
			
			JPanel txtpanel = new JPanel(new GridBagLayout());
			JLabel txtlabel = new JLabel(o.toString());
			
			
			tempimg_label.addMouseListener(new java.awt.event.MouseAdapter() {
				
			    public void mouseEntered(java.awt.event.MouseEvent evt) {	
			    	//Set Panel Size + Location
			    	txtpanel.setVisible(false);
			    	txtpanel.setSize(o.toString().length() * 6, 50); //Sets size based on toString Length, fixes bugs.
			    	
			    	if((o.getXloc() * scale)+200 <=frameWidth/2) {
			    		//Show label to the right
			    		txtpanel.setLocation((int) (o.getXloc() * scale)+250, (int) (o.getYloc() * scale)+175);
			    	}else{
			    		//Show label to the left
			    		txtpanel.setLocation((int) (o.getXloc() * scale - txtpanel.getSize().getWidth() + 150), (int) (o.getYloc() * scale+175));		    		
			    	}	

			    	//Add + Show Panel
			    	txtlabel.setOpaque(true);
			    	txtpanel.setOpaque(true);
			    	txtlabel.setVisible(true);
			    	if(o.isDoesBelong()) {
			    		txtlabel.setForeground(new Color(0,168,17)); //That is a custom green because the green they give you stabs your eyes
			    	}else {
			    		txtlabel.setForeground(Color.red);
			    	}
			    	txtpanel.add(txtlabel);	
			    	
			    	frame.add(txtpanel);
			    	txtpanel.setVisible(true);
			    }
			    
			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	//Hide Panel on Exit
			    	txtpanel.setVisible(false);
			    }
			});
			
			org_panels.add(temp_panel); //Adds temp_panel to org_panels
			System.out.println("JLabel for organism made:" + o.toString());
		}
		p.add(img_labels.get(picture));
		
		
		//Full Screen Or Windowed
		if (scale > 1) {
			try {
				frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(L.backgroundFull)))));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		else {
			try {
				frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(L.background)))));
				frame.setUndecorated(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
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
		
		//Set Up Strike Panel
		strikePanel.setSize(300,200);
		strikePanel.setOpaque(false);
		ImageIcon strike = new ImageIcon("resources/images/x_mark_red.png");
		JLabel strikeLabel1 = new JLabel(strike, JLabel.CENTER);
		JLabel strikeLabel2 = new JLabel(strike, JLabel.CENTER);
		JLabel strikeLabel3 = new JLabel(strike, JLabel.CENTER);
		strikePanel.add(strikeLabel1);
		strikePanel.add(strikeLabel2);
		strikePanel.add(strikeLabel3);
		strikePanel.getComponent(0).setVisible(false);
		strikePanel.getComponent(1).setVisible(false);
		strikePanel.getComponent(2).setVisible(false);
		
		//Set Up End Panel
		endPanel.setSize(400,150);
		JLabel endLabel1 = new JLabel("Game Over! ", JLabel.CENTER);
		JLabel endLabel2 = new JLabel();
		JButton restartButton = new JButton("Retry?");
		JButton quitButton = new JButton("Quit");
		//Keep default location, covers up the X's allows user to view estuary
		//endPanel.setLocation(3 * frameWidth/4 - 500, frameHeight/4 + 20);
		
		//Set up endpanel restartbutton
		restartButton.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				MainMenu();
				frame.dispose();				
			}
		});
		//Set up endpanel quit button
		quitButton.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();			
			}
		});

		maxTurns = L.organismList.size()-1;
		
		//Set First Test
		nameTag.setText(L.organismList.get(0).getName());
		
		//Button Functionality for prompt 
		bYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if( L.getStrikes() >= 2 && L.organismList.get(picture).isDoesBelong() == false) {
					strikePanel.getComponent(L.getStrikes()-1).setVisible(true); 
					
					//Add all elements to end-card
					endLabel2.setText("You Scored: " + L.getScore() + " out of " + "12" + "!");
					endPanel.add(endLabel1);
					endPanel.add(endLabel2);
					endPanel.add(restartButton);
					endPanel.add(quitButton);
					
					endPanel.setVisible(true);
					promptPanel.setVisible(false);

				}
				if (picture < maxTurns){				
					System.out.print(L.organismList.get(picture).toString());
					
					if(L.organismList.get(picture).isDoesBelong() == false) {
						System.out.println(" Wrong! \n");
						L.setStrikes(L.getStrikes() + 1);
						strikePanel.getComponent(L.getStrikes()-1).setVisible(true);
					}
					else {
						L.setScore(L.getScore()+1);
						System.out.println(" Right! \n");
					}
					
					org_panels.get(picture).setVisible(true);
					nameTag.setText(L.organismList.get(picture + 1).getName());
					p.remove(img_labels.get(picture));
					picture++;
					p.add(img_labels.get(picture));					
					p.revalidate();
					p.repaint();
				}
				else if (picture == maxTurns){
					System.out.println(L.organismList.get(2).toString());
					
					
					
					if(L.organismList.get(picture).isDoesBelong() == false) {
						System.out.println("Wrong!");
						L.setStrikes(L.getStrikes() + 1);
						strikePanel.getComponent(L.getStrikes()-1).setVisible(true);
					}
					
					org_panels.get(picture).setVisible(true);
					
					//Add all elements to end-card
					endLabel2.setText("You Scored: " + L.getScore() + " out of " + "12" + "!");
					endPanel.add(endLabel1);
					endPanel.add(endLabel2);
					endPanel.add(restartButton);
					endPanel.add(quitButton);
					
					endPanel.setVisible(true);
					promptPanel.setVisible(false);
					
					p.revalidate();
					p.repaint();
				}

			}	
		});

		bNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if( L.getStrikes() >= 2 && L.organismList.get(picture).isDoesBelong() == true) {
					strikePanel.getComponent(L.getStrikes()-1).setVisible(true);
					
					//Add all elements to end-card
					endLabel2.setText("You Scored: " + L.getScore() + " out of " + "12" + "!");
					endPanel.add(endLabel1);
					endPanel.add(endLabel2);
					endPanel.add(restartButton);
					endPanel.add(quitButton);
					
					endPanel.setVisible(true);
					promptPanel.setVisible(false);
				}
				if (picture < maxTurns){
					System.out.print(L.organismList.get(picture).toString());
					
					if(L.organismList.get(picture).isDoesBelong() == true) {
						System.out.println(" Wrong! \n");
						L.setStrikes(L.getStrikes() + 1);
						strikePanel.getComponent(L.getStrikes()-1).setVisible(true);
					}
					else {
						L.setScore(L.getScore() + 1);
						System.out.println(" Right! \n");
					}
					
					nameTag.setText(L.organismList.get(picture + 1).getName());;
					p.remove(img_labels.get(picture));
					picture++;
					p.add(img_labels.get(picture));					
					p.revalidate();
					p.repaint();
				}
				else if (picture == maxTurns){
					System.out.println(L.organismList.get(2).toString());
					
					if(L.organismList.get(picture).isDoesBelong() == true) {
						//Add Code To Display an X
						System.out.println(" Wrong!");
						L.setStrikes(L.getStrikes() + 1);
						strikePanel.getComponent(L.getStrikes()-1).setVisible(true);
					}
					
					//Add all elements to end-card
					endLabel2.setText("You Scored: " + L.getScore() + " out of " + "12" + "!");
					endPanel.add(endLabel1);
					endPanel.add(endLabel2);
					endPanel.add(restartButton);
					endPanel.add(quitButton);
					
					endPanel.setVisible(true);
					promptPanel.setVisible(false);
					
					p.revalidate();
					p.repaint();
				}
				
			}
		});
		
		frame.add(endPanel);
		endPanel.setVisible(false);
		frame.add(strikePanel);
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
		if(scale>1.0) frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public View(){
		//Create and set up the window.
		frame = new JFrame("Estuarium");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public double getScale() {
		return scale;
	}
	
	public void setScale(double x) {
		this.scale = x;
	}
	
	/**
	 * Calls function MainMenu
	 * 
	 */
	public void play() {
		MainMenu();
	}
}