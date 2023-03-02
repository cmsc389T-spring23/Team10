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
Functions - pacman.valid_moves(), ghost.valid_moves(), map.move

#### <b>Pacman.valid_moves()</b>
We go through all of the potential moves that pacman can go to. We then check if those spaces are not a wall. If it is not a wall then it is added as a potential valid move.

#### <b>Ghost.valid_moves()</b>
We go through all of the potential moves that Ghost can go to. We then check if those spaces are not a wall. If it is not a wall then it is added as a potential valid move.

#### <b>Map.move()</b>
For map.move we make sure first that it is either Pacman or a Ghost, because those are the only two things that can move. From there, we update the references of the previous spot to be empty, and the new spot to be filled. We update the field, locations, and components instance variables.

### Keith Code


### Brian Code

### Jason Code

