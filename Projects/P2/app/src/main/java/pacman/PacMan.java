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
    ArrayList<Location> moves = get_valid_moves();
    if (moves.size() == 0) {
      return false;
    }

    // Generating random 3 digit number between 0 and 0.999
    String timeString = String.valueOf(System.currentTimeMillis());
    double rand = (timeString.substring(timeString.length() - 3).parseDouble()) / 1000.0;
    int locNum = (int) (rand * moves.size());

    // Moving pacman
    myLoc = moves.get(locNum);
    myMap.move(myName, myLoc, Map.Type.PACMAN);

    return true;
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
