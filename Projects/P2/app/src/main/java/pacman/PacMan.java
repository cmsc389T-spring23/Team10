package pacman;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JComponent;

public class PacMan {
  String myName;
  Location myLoc;
  Map myMap;
  Location shift;

  public PacMan(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    return null;
  }

  public boolean move() {
    return false;
  }

  public boolean is_ghost_in_range() {
    int x = myLoc.x;
    int y = myLoc.y;

    //Right
    HashSet<Type> moves = myMap.getLoc(new Location(x+1,y));
    if(moves.contains(Map.Type.GHOST)) {
      return true;
    }


    //Up
    moves = myMap.getLoc(new Location(x,y+1));
    if(moves.contains(Map.Type.GHOST)) {
      return true;
    }

    //Down
    moves = myMap.getLoc(new Location(x,y-1));
    if(moves.contains(Map.Type.GHOST)) {
      return true;
    }

    //Left
    moves = myMap.getLoc(new Location(x-1,y));
    if(moves.contains(Map.Type.GHOST)) {
      return true;
    }

  // Diagonals
    moves = myMap.getLoc(new Location(x+1,y+1));
    if(moves.contains(Map.Type.GHOST)) {
      return true;
    }

    moves = myMap.getLoc(new Location(x-1,y+1));
    if(moves.contains(Map.Type.GHOST)) {
      return true;
    }

    moves = myMap.getLoc(new Location(x+1,y-1));
    if(moves.contains(Map.Type.GHOST)) {
      return true;
    }

    moves = myMap.getLoc(new Location(x-1,y-1));
    if(moves.contains(Map.Type.GHOST)) {
      return true;
    }

    return false;
  }

  public JComponent consume() {
    return null;
  }
}
