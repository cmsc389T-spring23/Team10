package pacman;
import java.util.ArrayList;
import java.util.HashSet;

public class Ghost {
  String myName;
  Location myLoc;
  Map myMap;

  public Ghost(String name, Location loc, Map map) {
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

    // Moving ghost
    myLoc = moves.get(locNum);
    myMap.move(myName, myLoc, Map.Type.GHOST);

    return true;
  }

  public boolean is_pacman_in_range() {
    int x = myLoc.x;
    int y = myLoc.y;

    //Right
    HashSet<Type> moves = myMap.getLoc(new Location(x+1,y));
    if(moves.contains(Map.Type.PACMAN)) {
      return true;
    }


    //Up
    moves = myMap.getLoc(new Location(x,y+1));
    if(moves.contains(Map.Type.PACMAN)) {
      return true;
    }

    //Down
    moves = myMap.getLoc(new Location(x,y-1));
    if(moves.contains(Map.Type.PACMAN)) {
      return true;
    }

    //Left
    moves = myMap.getLoc(new Location(x-1,y));
    if(moves.contains(Map.Type.PACMAN)) {
      return true;
    }

  // Diagonals
    moves = myMap.getLoc(new Location(x+1,y+1));
    if(moves.contains(Map.Type.PACMAN)) {
      return true;
    }

    moves = myMap.getLoc(new Location(x-1,y+1));
    if(moves.contains(Map.Type.PACMAN)) {
      return true;
    }

    moves = myMap.getLoc(new Location(x+1,y-1));
    if(moves.contains(Map.Type.PACMAN)) {
      return true;
    }

    moves = myMap.getLoc(new Location(x-1,y-1));
    if(moves.contains(Map.Type.PACMAN)) {
      return true;
    }

    return false;
  }

  public boolean attack() {
    return false;
  }
}
