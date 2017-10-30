package game;

import java.awt.*;
import java.awt.event.*;
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

public class View extends JPanel implements ActionListener, MouseMotionListener {
	
	
	//Dimensions
	final static int frameWidth = 720;
	final static int frameHeight = 1080;
	
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
	
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Estuarium");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Set up panels
        JPanel p = new JPanel(new GridBagLayout());
        p.setSize(frameWidth, frameHeight);
        p.setBackground(Color.GRAY);
        
        //Add Button + Label
        JButton b1 = new JButton("Play");
        JLabel l1 = new JLabel("Click here to play!"); 
        
        p.add(b1);
        p.add(l1);
        
        //Display the window.
        frame.add(p);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(frameHeight, frameWidth);
        
    }
    
	public static void main(String[] Args) {
		JPanel Menu = new JPanel();
		createAndShowGUI();
	
	}
}
