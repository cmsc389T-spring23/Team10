package pacman;
import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
    //Creating A Map
  Mainframe frame = new MainFrame(); //Creates A New Map With Walls and Tokens Initialized

  //Creating Players
  Ghost ghost = frame.addGhost(new Location(0, 0), "name", Color.red); //Creates a red ghost named "name" at location x,y
  PacMan pacman = frame.addPacMan(new Location(2, 3)); //Creates PacMan at location x, y
  CookieComponent cookie = new CookieComponent(2,2,2);
  Map cool = new Map(10);

  assert cool.eatCookie("pacman") != null;
  assert cool.eatCookie("pacman") == null;

  }
}
