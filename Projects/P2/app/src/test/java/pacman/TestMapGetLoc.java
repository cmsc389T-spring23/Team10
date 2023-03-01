package pacman;
import java.io.*;
import junit.framework.*;
import pacman.Map.Type;

import java.awt.Color;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
    //Creating A Map
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Creating Players
    Ghost ghost = frame.addGhost(new Location(1, 1), "Blinky", Color.red); //Creates a red ghost named "name" at location x,y
    PacMan pacman = frame.addPacMan(new Location(1, 2)); //Creates PacMan at location x, y

    Map map = frame.getMap();
    assertTrue(map.getLoc(new Location(1, 1)).contains(Type.GHOST));
    assertTrue(map.getLoc(new Location(1, 2)).contains(Type.PACMAN));
    assertTrue(map.getLoc(new Location(0, 0)).contains(Type.WALL));
    assertTrue(map.getLoc(new Location(1, 4)).contains(Type.COOKIE));
    return;
  }
}
