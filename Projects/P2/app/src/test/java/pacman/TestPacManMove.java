package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;
import java.util.ArrayList;
import pacman.Map.Type;


public class TestPacManMove extends TestCase {

  public void testPacManMove() throws FileNotFoundException {
    //Creating A Map
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Creating Players
    PacMan pacman = frame.addPacMan(new Location(1, 2)); //Creates a red ghost named "name" at location x,y
    ArrayList<Location> moves = pacman.get_valid_moves();

    assertTrue(pacman.move());
    Map map = frame.getMap();

    int found = 0;
    for (Location loc : moves) {
      if (map.getLoc(loc).contains(Type.PACMAN)) {
        found++;
      }
    }

    assertTrue(found == 1);
    return;
  }
}
