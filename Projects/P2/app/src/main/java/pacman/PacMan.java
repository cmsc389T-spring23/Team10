package pacman;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JComponent;
import java.lang.Math;

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

  public boolean valid_move(Location loc){
    int x = loc.x;
    int y = loc.y;
    HashSet<Map.Type> moves = this.myMap.getLoc(new Location(x,y));
    if(moves.contains(Map.Type.WALL)) {
      return false;
    }
    return true;
  }

  public ArrayList<Location> get_valid_moves() {
    int x = this.myLoc.x;
    int y = this.myLoc.y;
    ArrayList<Location> return_val = new ArrayList();
    return_val.add(new Location(x, y+1));
    return_val.add(new Location(x+1, y+1));
    return_val.add(new Location(x-1, y+1));
    return_val.add(new Location(x+1, y-1));
    return_val.add(new Location(x-1, y-1));
    return_val.add(new Location(x, y-1));
    return_val.add(new Location(x+1, y));
    return_val.add(new Location(x-1, y));
    int i = 0;
    ArrayList<Location> valid_moves = new ArrayList();
    for (Location move : return_val) {
        if (valid_move(move)) {
            valid_moves.add(move);
        }
    }
    // Note
    return valid_moves;
  }


  public boolean move() {
    ArrayList<Location> moves = get_valid_moves();
    if (moves.size() == 0) {
      return false;
    }

    // Generating random location
    int locNum = (int) (Math.random() * moves.size());

    // Moving pacman
    myLoc = moves.get(locNum);
    myMap.move(myName, myLoc, Map.Type.PACMAN);

    return true;
  }

  public boolean is_ghost_in_range() {
    int x = myLoc.x;
    int y = myLoc.y;

    //Right
    HashSet<Map.Type> moves = myMap.getLoc(new Location(x+1,y));
    if (moves != null){
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
      //RIght
      moves = myMap.getLoc(new Location(x+1,y));
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
    }
    return true;
  }

  public JComponent consume() {
    // Calls cookie method that handles everything
    return myMap.eatCookie(this.myName);
  }
}