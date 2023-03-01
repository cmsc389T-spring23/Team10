package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;
import pacman.Map.Type;
import java.util.ArrayList;

public class TestGhostMove extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
    //Creating A Map
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Creating Players
    Ghost ghost = frame.addGhost(new Location(1, 2), "Blinky", Color.red);
    ArrayList<Location> moves = ghost.get_valid_moves();

    assertTrue(ghost.move());
    Map map = frame.getMap();

    int found = 0;
    for (Location loc : moves) {
      if (map.getLoc(loc).contains(Type.GHOST)) {
        found++;
      }
    }
    assertTrue(found != 0);
    assertTrue(found == 1);
    return;
  }
}
