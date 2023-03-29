package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestGhostAttack extends TestCase {

  public void testGhostAttack() throws FileNotFoundException {
        //Creating A Map
        NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

        //Creating Players
        Ghost g1 = frame.addGhost(new Location(1, 1), "g1", Color.red); //Creates a red ghost named "name" at location x,y
        Ghost g2 = frame.addGhost(new Location(4, 5), "g2", Color.red);
        PacMan pacman = frame.addPacMan(new Location(5, 5)); //Creates PacMan at location x, y
    
        assert g1.attack() == false;
        assert g2.attack() == true;
        return;
  }
}
