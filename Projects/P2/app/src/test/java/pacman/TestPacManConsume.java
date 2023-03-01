package pacman;
import java.io.*;

import javax.swing.JComponent;

import com.google.common.graph.Graph;

import junit.framework.*;
import java.awt.Color;

public class TestPacManConsume extends TestCase {

  public void testPacManConsume() throws FileNotFoundException {
    //Creating A Map
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display
    JComponent c = new CookieComponent(2,3,2);

    //Creating Players
    PacMan pacman = frame.addPacMan(new Location(2, 3)); //Creates PacMan at location x, y
    frame.getMap().add("cookie!", new Location(2,3), c, Map.Type.COOKIE);

    assert(pacman.consume() != null);
    assert(pacman.consume() == null);
    return;
  }
}
