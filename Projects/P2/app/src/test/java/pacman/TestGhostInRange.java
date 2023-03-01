package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostInRange extends TestCase {

  public void testGhostInRange() throws FileNotFoundException {
    //Creating A Map
  Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initializedy

  //Creating Players
  Ghost ghost = frame.addGhost(new Location(3, 4), "name", Color.red); //Creates a red ghost named "name" at location x,y
  PacMan pacman = frame.addPacMan(new Location(3, 3)); //Creates PacMan at location x, y

  if(pacman.is_ghost_in_range == true) {
    System.out.println("Ghost is in range. Test passed!");
  }
  else {
    System.out.println("Ghost is not in range. Test did not pass :(!");
  }
  
  }
}
