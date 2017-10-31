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
import javax.swing.border.Border;
import javax.swing.JInternalFrame;

public class View extends JFrame implements ActionListener, MouseMotionListener {
	
	//Dimensions
	final static int frameWidth = 1280;
	final static int frameHeight = 760;

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
    private void createAndShowGUI() {
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
    	BufferedImage cardImg = null;
    	
    	//Pre Load List
    	L.createOrganismList();
    	
    	//Create and set up the window.
        JFrame frame = new JFrame("Estuarium");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create Panel
        JPanel p = new JPanel(new GridBagLayout());
        //GridBagConstraints settings = new GridBagConstraints();
        
        //Makes JPanel
        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        //Sets background to Opaque so that we don't see the background on Panel
        backgroundPanel.setOpaque(true);
        //Creates color that's black
        Border blackline = BorderFactory.createLineBorder(Color.black);
        //Sets border to blackline
        backgroundPanel.setBorder(blackline);
        //Sets Panel size
        backgroundPanel.setSize(frameWidth/4, frameHeight/2);
        //Sets Panel location
        backgroundPanel.setLocation(frameWidth/2 + 150, frameHeight/4);
        
              
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(L.background)))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
      
        
         /*
        //Show Each Organism
        for(int i = 0; i < L.organismList.size(); i++) {
			try {
				cardImg = ImageIO.read(new File(L.organismList.get(i).getFilePath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
        	JLabel picLabel = new JLabel(new ImageIcon(cardImg));
        	card.add(picLabel);
        	
        	JButton yes = new JButton("Yes");
        	//Yes Listener
            yes.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				System.out.print(L.organismList.get(i).toString());		
    			}
            	
            });
            
        	JButton no = new JButton("No");
            no.addActionListener(new ActionListener() {

     			@Override
     			public void actionPerformed(ActionEvent arg0) {
     				System.out.print(L.organismList.get(i).toString());		
     			}
             	
             });
            
        	card.add(yes);
        	card.add(no);
        }
       
      	*/
        
        
        //Create Buttons For Card
    	JButton bYes = new JButton("YES");
    	JButton bNo = new JButton("NO");
    	
    	bYes.setSize(800, 800);
    	bNo.setSize(800, 800);
    	
    	//Button Functionality          
    	bYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.print(L.organismList.get(1).toString());		
			}	
        });
    	
    	bNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.print(L.organismList.get(1).toString());		
			}	
        });
    	
    	
    	//Get Image From Organism
		try {
			cardImg = ImageIO.read(new File(L.organismList.get(1).getFilePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Organism Image
    	JLabel picLabel = new JLabel(new ImageIcon(cardImg));
    	
    	picLabel.setSize(800,800);
    	
    	//Set Up Panel
    	p.add(picLabel);
    	p.add(bYes); 
    	p.add(bNo);
    	p.setSize(400, 400);
    	
    	
    	//Set Up Frame
    	backgroundPanel.add(p);
        //frame.add(p, BorderLayout.CENTER);
    	frame.add(backgroundPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(frameWidth, frameHeight);    

    }
    public View() {
    	createAndShowGUI();
    }
    
    public void createCard() {
    	//MyInternalFrame frame = new MyInternalFrame();
    }
    
	public static void main(String[] Args) {
		View view = new View();
	}
}
