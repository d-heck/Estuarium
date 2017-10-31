package game;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
import javax.swing.JInternalFrame;

public class View extends JFrame implements ActionListener, MouseMotionListener {

	//Dimensions
	final static int frameWidth = 1280;
	final static int frameHeight = 760;
	int picture = 1;

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	// TODO: View Class

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

	//Loads a Level to play, initializes organism list and loads BG image

	public void LoadLevel(Level L) {
		//TODO: This method should "play" the level.
		//Variables
		BufferedImage fishImg = null;
		BufferedImage crabImg = null;
		BufferedImage kelpImg = null;

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


		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(L.background)))));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Get Image From Organism
		try {
			crabImg = ImageIO.read(new File(L.organismList.get(0).getFilePath()));
			fishImg = ImageIO.read(new File(L.organismList.get(1).getFilePath()));
			kelpImg = ImageIO.read(new File(L.organismList.get(2).getFilePath()));

		} catch (IOException e) {
			e.printStackTrace();
		}

		//Organism Image
		JLabel fishLabel = new JLabel(new ImageIcon(fishImg));
		JLabel fishLabel2 = new JLabel(new ImageIcon(fishImg)); //Label for background frame NOT prompt
		JLabel crabLabel = new JLabel(new ImageIcon(crabImg));
		JLabel crabLabel2 = new JLabel(new ImageIcon(crabImg));
		JLabel kelpLabel = new JLabel(new ImageIcon(kelpImg));
		JLabel kelpLabel2 = new JLabel(new ImageIcon(kelpImg));

		//Organism Labels
		JLabel crabLabel_text = new JLabel(L.organismList.get(0).toString());
		JLabel fishLabel_text = new JLabel(L.organismList.get(1).toString());
		JLabel kelpLabel_text = new JLabel(L.organismList.get(2).toString());

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
		p.add(fishLabel);
		p.setSize(400, 400);

		bYes.setSize(800, 800);
		bNo.setSize(800, 800);

		//Set up Fish Panel
		JPanel fishPanel = new JPanel(new GridBagLayout()); //For fishy on background
		fishPanel.add(fishLabel_text);
		fishPanel.add(fishLabel2);
		fishPanel.setOpaque(false);
		fishPanel.setLocation(100, 250);
		fishPanel.setVisible(false);
		fishPanel.setSize(400,400);
		//End set up Fish Panel

		//Set up Crab Panel
		JPanel crabPanel = new JPanel(new GridBagLayout()); //For fishy on background
		crabPanel.add(crabLabel_text);
		crabPanel.add(crabLabel2);
		crabPanel.setOpaque(false);
		crabPanel.setLocation(200, 350);
		crabPanel.setVisible(false);
		crabPanel.setSize(400,400);
		//End set up Crab Panel

		//Set up Kelp Panel
		JPanel kelpPanel = new JPanel(new GridBagLayout()); //For fishy on background
		kelpPanel.add(kelpLabel_text);
		kelpPanel.add(kelpLabel2);
		kelpPanel.setOpaque(false);
		kelpPanel.setLocation(650, 420);
		kelpPanel.setVisible(false);
		kelpPanel.setSize(400,400);
		//End set up Kelp Panel

		//Button Functionality for prompt 
		bYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(picture) {
				case 1: 
					System.out.print(L.organismList.get(1).toString());	
					fishPanel.setVisible(true);
					p.remove(fishLabel);
					p.add(crabLabel);				
					p.revalidate();
					p.repaint();
					picture++;
					break;
				case 2: 
					System.out.print(L.organismList.get(0).toString());	
					crabPanel.setVisible(true);					
					p.remove(crabLabel);
					p.add(kelpLabel);
					p.revalidate();
					p.repaint();
					picture++;
					break;
				case 3:
					System.out.println(L.organismList.get(2).toString());
					kelpPanel.setVisible(true);
					promptPanel.setVisible(false);				
					p.revalidate();
					p.repaint();
					picture++;
					break;
				}

			}	
		});

		bNo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch(picture) {
				case 1: 
					System.out.print(L.organismList.get(1).toString());	
					p.remove(fishLabel);
					p.add(crabLabel);				
					p.revalidate();
					p.repaint();
					picture++;
					break;
				case 2: 
					System.out.print(L.organismList.get(0).toString());	
					p.remove(crabLabel);
					p.add(kelpLabel);
					p.revalidate();
					p.repaint();
					picture++;
					break;
				case 3:
					System.out.println(L.organismList.get(2).toString());
					promptPanel.setVisible(false);
					p.revalidate();
					p.repaint();
					picture++;
					break;
				}
			}	
		});


		//frame.add(p, BorderLayout.CENTER);
		frame.add(promptPanel);
		//Set Up Frame
		promptPanel.add(p);
		frame.add(fishPanel);
		frame.add(crabPanel);
		frame.add(kelpPanel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(frameWidth, frameHeight);

	}

	public View() {
		MainMenu();
	}
}
