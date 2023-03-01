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

    //Creating Players
    PacMan pacman = frame.addPacMan(new Location(2, 3)); //Creates PacMan at location x, y

    assert(pacman.consume() instanceof JComponent);
    assert(frame.getMap().getCookies() == 1);
  }
}
