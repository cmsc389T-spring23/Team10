package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestPacManValidMoves extends TestCase {

  public void testPacManValidMoves() throws FileNotFoundException {
    //Creating A Map
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Creating Players
    Ghost ghost = frame.addGhost(new Location(1, 1), "Blinky", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(1, 2)); //Creates PacMan at location x, y

    Map map = frame.getMap();
    assertTrue(pacman.get_valid_moves().size() > 0);
  }
}
