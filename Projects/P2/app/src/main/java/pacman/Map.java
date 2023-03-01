package pacman;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

  public enum Type {
    EMPTY,
    PACMAN,
    GHOST,
    WALL,
    COOKIE
  }

  private HashMap<Location, HashSet<Type>> field;
  private boolean gameOver;
  private int dim;

  private HashMap<String, Location> locations;
  private HashMap<String, JComponent> components;
  private HashSet<Type> emptySet;
  private HashSet<Type> wallSet;

  private int cookies = 0;

  public Map(int dim) {
    gameOver = false;
    locations = new HashMap<String, Location>();
    components = new HashMap<String, JComponent>();
    field = new HashMap<Location, HashSet<Type>>();

    emptySet = new HashSet<Type>();
    wallSet = new HashSet<Type>();
    emptySet.add(Type.EMPTY);
    wallSet.add(Type.WALL);
    this.dim = dim;
  }

  public void add(String name, Location loc, JComponent comp, Type type) {
    locations.put(name, loc);
    components.put(name, comp);
    if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
    field.get(loc).add(type);
  }

  public int getCookies() {
    return cookies;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public boolean move(String name, Location loc, Type type) {
    // Update field locations and jcomponent
    if (name.equals("pacman")){
      HashSet<Type>  old = new HashSet<>();
      old.add(Type.EMPTY);
      Location old_loc = locations.get(name);
      HashSet<Type>  new_set = new HashSet<>();
      new_set.add(Type.PACMAN);
      locations.put(name, loc);
      field.put(old_loc, old);
      field.put(loc, new_set);
      components.get(name).setLocation(loc.x, loc.y);
      return true;
    }else if ((name.equals("Inky") || name.equals("Blinky") || name.equals("Pinky") || name.equals("Clyde"))){
      HashSet<Type>  old = new HashSet<>();
      old.add(Type.EMPTY);
      Location old_loc = locations.get(name);
      HashSet<Type>  new_set = new HashSet<>();
      new_set.add(Type.GHOST);
      locations.put(name, loc);
      field.put(old_loc, old);
      field.put(loc, new_set);
      components.get(name).setLocation(loc.x, loc.y);
      return true;
    }
    return false;
  }

  public HashSet<Type> getLoc(Location loc) {
    HashSet<Type> thingsAtLoc = field.get(loc);
    HashSet<Type> result = new HashSet<Type>();

    if (thingsAtLoc == null) {
      return result;
    }

    if (thingsAtLoc.contains(Type.EMPTY)) {
      result.add(Type.EMPTY);
    } else if (thingsAtLoc.contains(Type.WALL)) {
      result.add(Type.WALL);
    } else {
      for (Type thing : thingsAtLoc) {
        result.add(thing);
      }
    }

    return result;
  }

  public boolean attack(String Name) {
    Location curr = locations.get(Name);
    int x = curr.x;
    int y = curr.y;

    HashSet<Type> around = getLoc(new Location(x+1,y));
    if(around.contains(Map.Type.PACMAN)) {
      gameOver = true;
      return true;
    }

    around = getLoc(new Location(x-1,y));
     if(around.contains(Map.Type.PACMAN)) {
      gameOver = true;
      return true;
    }

    around = getLoc(new Location(x,y+1));
     if(around.contains(Map.Type.PACMAN)) {
      gameOver = true;
      return true;
    }

    around = getLoc(new Location(x,y-1));
     if(around.contains(Map.Type.PACMAN)) {
      gameOver = true;
      return true;
    }

    around = getLoc(new Location(x+1,y+1));
     if(around.contains(Map.Type.PACMAN)) {
      gameOver = true;
      return true;
    }

    around = getLoc(new Location(x+1,y-1));
     if(around.contains(Map.Type.PACMAN)) {
      gameOver = true;
      return true;
    }

    around = getLoc(new Location(x-1,y+1));
     if(around.contains(Map.Type.PACMAN)) {
      gameOver = true;
      return true;
    }

    around = getLoc(new Location(x-1,y-1));
     if(around.contains(Map.Type.PACMAN)) {
      gameOver = true;
      return true;
    }

    return false;
  }

  public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1
    Location loc = locations.get(name); // Gets location of pacman

    if (field.get(loc).contains(Type.COOKIE)) { // Sees if location has a cookie
      cookies++; // Updates cookes
      String id = "tok_x" + Integer.toString(loc.x) + "_y" + Integer.toString(loc.y);
      field.get(loc).remove(Type.COOKIE); // Removes from field
      return components.remove(id); // Removes from components
    } else {
      return null; // No cookie found
    }
  }
}




