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

  public boolean valid_move(Location loc){
    int x = loc.x;
    int y = loc.y;
    HashSet<Type> moves = this.myMap.getLoc(new Location(x,y));
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
    for (Location loc: return_val){
      if (valid_move(loc) == true) {
        i++;
      }else{
        return_val.remove(i);
      }
    }
    return return_val;
  }


  public boolean move() {
    return false;
  }

  public boolean is_pacman_in_range() {
    return false;
  }

  public boolean attack() {
    return false;
  }
}
