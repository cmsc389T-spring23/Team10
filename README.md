# cmsc389T-spring23
# Project 2: PacMan
Team Members: Brian Lau, Keith Lee, Keshav Ganapathy, Jason Werneth

![alt text](https://github.com/cmsc389T-spring23/Team10/blob/main/Projects/P2/documentation/PacMan%20Game%20Over.png)

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
#### <b>Pacman.consume</b>
Consume calls eatCookie. eatCookie checks all edge cases and returns either null if no cookie was eaten or the JComponent associated with the eaten cookie. See Map.eatCookie for further details.

Pacman.consume test places pacman on on a cookie (cookie is placed by default by frame). Then pacman eats a cookie then tries to eat the same cookie. We try to eat the cookie a second time to make sure that the initial cookie was eaten and removed properly.

#### <b>Ghost.attack</b>
Attack checks first to see if pacman is in range by using is_pacman_in_range() then either calls Maps.attack function to process the attack or false if pacman is not in range.

Ghost.attack test places a ghost and pacman close together and calls the attack function.

#### <b>Map.eatCookie</b>
EatCookie gets the location of pacman, then checks to see if a cookie is at pacman's location. If so, the cookie counter is incremented, the cookie JComponent is removed and then returned. Else null is returned. 

Map.eatCookie test places pacman on on a cookie (cookie is placed by default by frame). Then pacman eats a cookie then tries to eat the same cookie. We try to eat the cookie a second time to make sure that the initial cookie was eaten and removed properly.

### Brian Code

### Jason Code

