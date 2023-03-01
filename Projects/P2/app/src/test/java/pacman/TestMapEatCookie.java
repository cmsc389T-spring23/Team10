package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
    //Creating A Map
    NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

    //Creating Players
    PacMan pacman = frame.addPacMan(new Location(2, 3)); //Creates PacMan at location x, y

    assert frame.getMap().eatCookie("pacman") != null;
    assert frame.getMap().eatCookie("pacman") == null;
    return;

  }
}
