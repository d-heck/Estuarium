package game;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

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
    	ImageIcon image;
    	
    	//Pre Load List
    	L.createOrganismList();
    	
    	//Create and set up the window.
        JFrame frame = new JFrame("Estuarium");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(L.background)))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        /*
         * Was trying to add the organisms on cards here.
        //Show Each Organism
        for(int i = 0; i < L.organismList.size(); i++) {
        	image = new ImageIcon(L.organismList.get(i).getFilePath());
        	
        	
        }
        */
        
        JPanel p = new JPanel(new GridBagLayout());
        p.setSize(frameWidth, frameHeight);
        

        frame.pack();
        frame.setVisible(true);
        frame.setSize(frameWidth, frameHeight);
        
    	
    }
    public View() {
    	createAndShowGUI();
    }
    
	public static void main(String[] Args) {
		JPanel Menu = new JPanel();

		View view = new View();
	}
}
