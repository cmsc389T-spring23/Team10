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
    return false;
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
