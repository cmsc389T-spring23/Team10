# cmsc389T-spring23
# Project 2: PacMan
Team Members: Brian Lau, Keith Lee, Keshav Ganapathy, Jason Werneth

<img src="cmsc389T-spring23/Team10/Projects/P2/documentation/PacMan Game Over.png"/>

### How to Run Code
```
gradle build
gradle run
```

### Keshav Code
```java


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

    return valid_moves;
  }

  public boolean valid_move(Location loc){
    int x = loc.x;
    int y = loc.y;
    HashSet<Map.Type> moves = this.myMap.getLoc(new Location(x,y));
    if(moves != null && moves.contains(Map.Type.WALL)) {
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

    return valid_moves;
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
```

### Keith Code


### Brian Code

### Jason Code

