//// Zachary Ferraro
// IT313 Project 2a
// Drawing with JPanel
//
//This class extends the JPanel class and lays out the drawing.
//It receives variables from its instantiation in the Frame and 
//uses the variables to display a Pokemon on top of an adjusting
//background.
//
package pokecatch;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

//Extending JPanel to override its paintComponent class
public class MyPanel extends JPanel {
	
	//Declared public variables that are passed into the MyPanel constructor and used in the paintComponent method
	public BufferedImage img;
	public String pokeName;
	public int caughtNumber;
	public int randX;
	public int randY;
	public int legendariesCaught;
	
	//The MyPanel constructor takes a Pokemon name, the random generated Pokemon coordinates, the current total and Legendary caught count. 
	public MyPanel(String pokemon, int x, int y, int caught, int legends) {
		
		randX = x;
		randY = y;
		caughtNumber = caught;
		legendariesCaught = legends;
		pokeName = pokemon;
		try {
			img = ImageIO.read(new File("./Sprites/" + pokemon + ".png"));
			
		} catch (IOException e) {
			System.out.println("Couldn't get image.");
			e.printStackTrace();
		}
		
	}
	//Overriding the paintComponent method
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    
	    // Draw Sky.
        g.setColor(Color.decode("#3BB9FF"));
        g.fillRect(0, 0, 500, 250);
        g.setColor(Color.decode("#3BB9FF"));
        g.drawRect(0, 0, 500, 250); 
        
        // Draw hills.
        g.setColor(Color.decode("#00CD00"));
        g.fillOval(10, 200, 1000, 1000);
        // Draw hills.
        g.setColor(Color.decode("#00CD00"));
        g.fillOval(-400, 230, 1000, 1000);
        // Draw hills.
        g.setColor(Color.decode("#00CD00"));
        g.fillOval(0, 240, 500, 500);

	    
	    // Draw ground.
        g.setColor(Color.decode("#00CD00"));
        g.fillRect(0, 250, 500, 250);
        g.setColor(Color.decode("#00CD00"));
        g.drawRect(0, 250, 500, 250);

        // Draw sun.
        g.setColor(Color.yellow);
        g.fillOval(380, -120, 240, 240);
        g.setColor(Color.yellow);
        g.drawOval(380, -120, 240, 240);
        
        
        // Drawing a cloud that will adjust slightly with each frame that is drawn
        g.setColor(Color.decode("#F5F5F5"));
        g.fillOval(rumble(25), rumble(40), rumble(300), rumble(50));
        g.fillOval(rumble(25), rumble(40), rumble(300), rumble(50));
        g.fillOval(rumble(100), rumble(55), rumble(50), rumble(50));
        g.fillOval(rumble(100), rumble(55), rumble(50), rumble(50));
        g.fillOval(rumble(45), rumble(45), rumble(70), rumble(60));
        g.fillOval(rumble(45), rumble(45), rumble(70), rumble(60));
        g.fillOval(rumble(35), rumble(55), rumble(76), rumble(46));
        g.fillOval(rumble(35), rumble(55), rumble(76), rumble(46));
        g.fillOval(rumble(88), rumble(83), rumble(54), rumble(46));
        g.fillOval(rumble(88), rumble(83), rumble(54), rumble(46));
        g.fillOval(rumble(34), rumble(25), rumble(74), rumble(85));
        g.fillOval(rumble(34), rumble(25), rumble(74), rumble(85));
        g.fillOval(rumble(115), rumble(63), rumble(74), rumble(46));
        g.fillOval(rumble(115), rumble(63), rumble(74), rumble(46));
        g.fillOval(rumble(15), rumble(53), rumble(85), rumble(77));
        g.fillOval(rumble(155), rumble(25), rumble(77), rumble(69));
        g.fillOval(rumble(256), rumble(26), rumble(85), rumble(77));
        g.fillOval(rumble(15), rumble(22), rumble(85), rumble(77));
        g.fillOval(rumble(15), rumble(53), rumble(85), rumble(77));
        g.fillOval(rumble(155), rumble(25), rumble(77), rumble(69));
        g.fillOval(rumble(256), rumble(26), rumble(85), rumble(77));
        g.fillOval(rumble(15), rumble(22), rumble(85), rumble(77));
        g.fillOval(rumble(-25), rumble(34), rumble(67), rumble(72));
        g.fillOval(rumble(205), rumble(71), rumble(84), rumble(54));
        g.fillOval(rumble(256), rumble(26), rumble(65), rumble(77));
        g.fillOval(rumble(175), rumble(55), rumble(73), rumble(63));
        g.fillOval(rumble(-25), rumble(34), rumble(67), rumble(72));
        g.fillOval(rumble(205), rumble(71), rumble(73), rumble(54));
        g.fillOval(rumble(256), rumble(26), rumble(53), rumble(77));
        g.fillOval(rumble(175), rumble(55), rumble(73), rumble(63));
        g.fillOval(rumble(94), rumble(26), rumble(84), rumble(52));
        g.fillOval(rumble(142), rumble(36), rumble(73), rumble(53));
        g.fillOval(rumble(270), rumble(31), rumble(57), rumble(53));
        g.fillOval(rumble(132), rumble(45), rumble(73), rumble(72));
        g.fillOval(rumble(94), rumble(26), rumble(84), rumble(52));
        g.fillOval(rumble(142), rumble(36), rumble(73), rumble(82));
        g.fillOval(rumble(270), rumble(31), rumble(57), rumble(53));
        g.fillOval(rumble(132), rumble(45), rumble(73), rumble(72));
        g.fillOval(rumble(285), rumble(26), rumble(84), rumble(52));
        g.fillOval(rumble(300), rumble(26), rumble(67), rumble(63));
        g.fillOval(rumble(274), rumble(31), rumble(57), rumble(53));
        g.fillOval(rumble(143), rumble(25), rumble(62), rumble(23));
        g.fillOval(rumble(285), rumble(26), rumble(84), rumble(52));
        g.fillOval(rumble(300), rumble(26), rumble(74), rumble(52));
        g.fillOval(rumble(244), rumble(31), rumble(57), rumble(53));
        g.fillOval(rumble(133), rumble(25), rumble(62), rumble(23));
        g.fillOval(rumble(143), rumble(25), rumble(62), rumble(23));
        g.fillOval(rumble(285), rumble(26), rumble(52), rumble(52));
        g.fillOval(rumble(278), rumble(26), rumble(62), rumble(61));
        g.fillOval(rumble(244), rumble(31), rumble(57), rumble(53));
        g.fillOval(rumble(133), rumble(25), rumble(62), rumble(23));
        g.fillOval(rumble(25), rumble(40), rumble(300), rumble(50));
        g.fillOval(rumble(25), rumble(40), rumble(300), rumble(50));
        g.fillOval(rumble(100), rumble(55), rumble(50), rumble(50));
        g.fillOval(rumble(100), rumble(55), rumble(50), rumble(50));
        g.fillOval(rumble(45), rumble(45), rumble(70), rumble(60));
        g.fillOval(rumble(45), rumble(45), rumble(70), rumble(60));
        g.fillOval(rumble(35), rumble(55), rumble(76), rumble(46));
        g.fillOval(rumble(35), rumble(55), rumble(76), rumble(46));
        g.fillOval(rumble(88), rumble(83), rumble(54), rumble(46));
        g.fillOval(rumble(88), rumble(83), rumble(54), rumble(46));
        g.fillOval(rumble(34), rumble(25), rumble(74), rumble(85));
        g.fillOval(rumble(34), rumble(25), rumble(74), rumble(85));
        g.fillOval(rumble(115), rumble(63), rumble(74), rumble(46));
        g.fillOval(rumble(115), rumble(63), rumble(74), rumble(46));
        g.fillOval(rumble(15), rumble(53), rumble(85), rumble(77));
        g.fillOval(rumble(155), rumble(25), rumble(77), rumble(69));
        g.fillOval(rumble(256), rumble(26), rumble(85), rumble(77));
        g.fillOval(rumble(15), rumble(22), rumble(85), rumble(77));
        g.fillOval(rumble(15), rumble(53), rumble(85), rumble(77));
        g.fillOval(rumble(155), rumble(25), rumble(77), rumble(69));
        g.fillOval(rumble(256), rumble(26), rumble(85), rumble(77));
        g.fillOval(rumble(15), rumble(22), rumble(85), rumble(77));
        g.fillOval(rumble(-25), rumble(34), rumble(67), rumble(72));
        g.fillOval(rumble(205), rumble(71), rumble(84), rumble(54));
        g.fillOval(rumble(256), rumble(26), rumble(65), rumble(77));
        g.fillOval(rumble(175), rumble(55), rumble(73), rumble(63));
        g.fillOval(rumble(-25), rumble(34), rumble(67), rumble(72));
        g.fillOval(rumble(205), rumble(71), rumble(73), rumble(54));
        g.fillOval(rumble(256), rumble(26), rumble(53), rumble(77));
        g.fillOval(rumble(175), rumble(55), rumble(73), rumble(63));
        g.fillOval(rumble(94), rumble(26), rumble(84), rumble(52));
        g.fillOval(rumble(142), rumble(36), rumble(73), rumble(53));
        g.fillOval(rumble(270), rumble(31), rumble(57), rumble(53));
        g.fillOval(rumble(132), rumble(45), rumble(73), rumble(72));
        g.fillOval(rumble(94), rumble(26), rumble(84), rumble(52));
        g.fillOval(rumble(142), rumble(36), rumble(73), rumble(82));
        g.fillOval(rumble(270), rumble(31), rumble(57), rumble(53));
        g.fillOval(rumble(132), rumble(45), rumble(73), rumble(72));
        g.fillOval(rumble(285), rumble(26), rumble(84), rumble(52));
        g.fillOval(rumble(300), rumble(26), rumble(67), rumble(63));
        g.fillOval(rumble(274), rumble(31), rumble(57), rumble(53));
        g.fillOval(rumble(143), rumble(25), rumble(62), rumble(23));
        g.fillOval(rumble(285), rumble(26), rumble(84), rumble(52));
        g.fillOval(rumble(300), rumble(26), rumble(74), rumble(52));
        g.fillOval(rumble(244), rumble(31), rumble(57), rumble(53));
        g.fillOval(rumble(133), rumble(25), rumble(62), rumble(23));
        g.fillOval(rumble(143), rumble(25), rumble(62), rumble(23));
        g.fillOval(rumble(285), rumble(26), rumble(52), rumble(52));
        g.fillOval(rumble(278), rumble(26), rumble(62), rumble(61));
        g.fillOval(rumble(244), rumble(31), rumble(57), rumble(53));
        g.fillOval(rumble(133), rumble(25), rumble(62), rumble(23));
        g.fillOval(rumble(175), rumble(22), rumble(62), rumble(52));
        g.fillOval(rumble(175), rumble(22), rumble(62), rumble(52));
        
        
        // Print the counts for total caught Pokemon and caught Legendaries.
        g.setFont(new Font("arial", Font.BOLD, 30));
        g.setColor(Color.red);
        g.drawString("Pokémon Caught: " + caughtNumber, 30, 75);
        
        g.setFont(new Font("arial", Font.PLAIN, 20));
        g.setColor(Color.red);
        g.drawString("Legendaries Caught: " + legendariesCaught, 35, 100);

        
        
        // Print current Pokemon name
        g.setFont(new Font("arial", Font.BOLD, 25));
        g.setColor(Color.red);
        g.drawString("A wild " + pokeName + " appeared!", 60, 180);
     
        

        
        //Draw current Pokemon
        g.drawImage(img, randX, randY, 96, 96, null);
        
        
	}
	
	//Method to create slight variance in each frame to move the cloud around.
	public int rumble(int cloud) {
		double cloudRumble = (ThreadLocalRandom.current().nextInt(90,110)*.01) * cloud;
		return (int)Math.round(cloudRumble);
	}
}
