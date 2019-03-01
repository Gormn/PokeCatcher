// Zachary Ferraro
// IT313 Project 2a
// Drawing with JPanel
//
//This is the class extending JFrame that initializes an instance of MyPanel
//It displays a Pokemon on the drawn background based on some random math.
//It displays a custom cursor and checks to see if you click on the image of the
//Pokemon. If you click on the image when it is on the screen, it counts as a catch. 

package pokehunter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;

//Extending the JFrame class
public class MyFrame extends JFrame {
	
	private MyPanel p;
	
	//A String array of all the Pokmemon you can catch in the game.
    public String[] pokemon = {"Bulbasaur","Ivysaur","Venusaur","Charmander","Charmeleon","Charizard","Squirtle","Wartortle","Blastoise","Caterpie","Metapod","Butterfree","Weedle","Kakuna","Beedrill",
    							"Pidgey","Pidgeotto","Pidgeot","Rattata","Raticate","Spearow","Fearow","Ekans","Arbok","Pikachu","Raichu","Sandshrew","Sandslash","NidoranF","Nidorina","Nidoqueen",
    							"NidoranM","Nidorino","Nidoking","Clefairy","Clefable","Vulpix","Ninetales","Jigglypuff","Wigglytuff","Zubat","Golbat","Oddish","Gloom","Vileplume","Paras","Parasect",
    							"Venonat","Venomoth","Diglett","Dugtrio","Meowth","Persian","Psyduck","Golduck","Mankey","Primeape","Growlithe","Arcanine","Poliwag","Poliwhirl","Poliwrath","Abra",
    							"Kadabra","Alakazam","Machop","Machoke","Machamp","Bellsprout","Weepinbell","Victreebel","Tentacool","Tentacruel","Geodude","Graveler","Golem","Ponyta","Rapidash",
    							"Slowpoke","Slowbro","Magnemite","Magneton","Farfetch'd","Doduo","Dodrio","Seel","Dewgong","Grimer","Muk","Shellder","Cloyster","Gastly","Haunter","Gengar","Onix",
    							"Drowzee","Hypno","Krabby","Kingler","Voltorb","Electrode","Exeggcute","Exeggutor","Cubone","Marowak","Hitmonlee","Hitmonchan","Lickitung","Koffing","Weezing",
    							"Rhyhorn","Rhydon","Chansey","Tangela","Kangaskhan","Horsea","Seadra","Goldeen","Seaking","Staryu","Starmie","Mr. Mime","Scyther","Jynx","Electabuzz","Magmar",
    							"Pinsir","Tauros","Magikarp","Gyarados","Lapras","Ditto","Eevee","Vaporeon","Jolteon","Flareon","Porygon","Omanyte","Omastar","Kabuto","Kabutops","Aerodactyl",
    							"Snorlax","Articuno","Zapdos","Moltres","Dratini","Dragonair","Dragonite","Mewtwo","Mew"};
    
    //A string of Legendary Pokemon for comparison
    public String[] legendaries = { "Articuno", "Zapdos", "Moltres", "Mewtwo", "Mew" };
    
    //Declared/initialized public strings that will be used both in the Frame initialization and in conditionals
    public boolean clicked;
    public boolean isLegendary;
    public int caughtNumber = 0;
    public int legendaryCaught = 0;
    public String currentPokemon;
    
    //The JLabel that will serve as the clickable overlay to the image of the Pokemon
    public JLabel pokeLabel;

    //The MyFrame constructor- throws InterruptedException because there is a loop that sleeps
    public MyFrame() throws InterruptedException
    {	
		//Calling the super method and passing in the title of the Frame- "Poke Hunter"
    	super("Poke Hunter");
    	
    	//Calling the cursor override method
    	customCursor();
    	
    	//This loop will continuously call the Panel to draw and redraw until the Frame is closed
    	while(true) {	
    		//At the beginning of the loop, these booleans must be set to false
    		clicked = false;
    		isLegendary = false;
    		pokeLabel = null;
    		
    		//The random coordinates on the land where the Pokemon will be drawn are calculated.
    		int x = ThreadLocalRandom.current().nextInt(0,400);
    		int y = ThreadLocalRandom.current().nextInt(190,400);
    		
    		//The current Pokemon is randomly selected from the array
    		currentPokemon = pokemon[ThreadLocalRandom.current().nextInt(0,151)];
    		
    		//Check to see if the current Pokemon is a legendary
        	for (String n : legendaries) {
        		if (currentPokemon.equals(n)){
        			isLegendary = true;
        		}
        	}
    		
        	//The MyPanel class is instantiated and the current Pokemon is drawn along with the background
    		p = new MyPanel(currentPokemon, x, y, caughtNumber, legendaryCaught);
		    p.setLayout(null);
		    
		    //This JLabel is used to make the Pokemon clickable on the screen. It overlays a JLabel on the same spot that the Pokemon is.
		    pokeLabel= new JLabel();
    	    pokeLabel.setBounds(p.randX,p.randY,96,96);
    	    //Listens for a mouse click on the JPanel, and counts the caught Pokemon if it happens
    	    //If the Pokemon is a Legendary, it increases that count as well.
	        pokeLabel.addMouseListener(new MouseAdapter(){
	        	public void mouseReleased(MouseEvent e) {
	        	    if(pokeLabel.contains(e.getPoint())){
	        	        if (clicked == false) {
	        	        	caughtNumber++;
        	        		if (isLegendary == true){
        	        			legendaryCaught++;
        	        		}
	        	        }
	        	        clicked = true;     	        
	        	    }
	        	}
	        });
		    
		   //Add the JLabel to the MyPanel
	        p.add(pokeLabel);
	        
	        //Add the MyPanel p to the Frame
	        this.add(p);
	        
	        //Set the Frame to 500 by 500, make it impossible to resize.
		    setSize(500, 500);
		    setResizable(false);
		    setVisible(true);
		    
		    //Set the icon image of the Frame
		    setIconImage(new ImageIcon("pokeCursor.png").getImage());
		    
		    //If the window is closed, Java will exit
		    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    
		    //Calculate an amount of time to sleep between 1 and 4 seconds
		    int sleepTime = ThreadLocalRandom.current().nextInt(1000,4000);
		    
		    //If the current Pokemon is legendary, it will only show on the screen for half the amount of calculated time
		    if (isLegendary) {
		    	Thread.sleep(sleepTime/2);
		    }
		    else {
		    	Thread.sleep(sleepTime);
		    }
		    //BUG FIXED- if I don't remove the JLabel here at the end of the loop, it stays for the next loop. You 
		    //end up having a screen filled with them, and everywhere you click is valid to catch the Pokemon.
		    p.remove(pokeLabel);
    	}
    }
	
    //The method to override the cursor and replace it with a Pokeball
	public void customCursor() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image cursorImage = toolkit.getImage("pokeCursor.png");
		Point cursorHotSpot = new Point(0,0);
		Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
		setCursor(customCursor);
	}
}
