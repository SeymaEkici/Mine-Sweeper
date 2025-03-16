MineSweeper Game in Java
========================

Overview
--------

This is a simple console-based implementation of the classic **MineSweeper** game in Java. The game allows the user to specify the board size and then play by uncovering tiles. If the player uncovers a mine, the game ends; otherwise, they continue until all non-mine tiles are revealed.

Features
--------

-   The user can define the number of rows and columns for the game board.
-   Mines are randomly placed across the board.
-   The game provides real-time feedback on user moves.
-   The board updates dynamically as the user uncovers safe tiles.
-   The game checks for a win condition when all non-mine tiles are revealed.

How to Play
-----------

1.  Run the program.
2.  Enter the number of rows and columns for the game board.
3.  The board is initialized with hidden cells (`-`).
4.  Enter a row and column to uncover a tile.
5.  If the tile contains a mine, the game ends.
6.  If the tile does not contain a mine, the number of neighboring mines is displayed.
7.  Continue uncovering tiles until all non-mine tiles are revealed to win the game.

Installation & Execution
------------------------

1.  Ensure you have Java installed on your system.
2.  Download and compile the files using:

    ```
    javac Main.java MineSweeper.java

    ```

3.  Run the game using:

    ```
    java Main

    ```

Code Structure
--------------

### `Main.java`

-   Handles user input for board dimensions.
-   Initializes the `MineSweeper` class and starts the game.

### `MineSweeper.java`

-   Manages game logic, board setup, and user interactions.
-   Randomly places mines on the board.
-   Handles user moves, checks for mines, and updates the board accordingly.
-   Implements a recursive function to uncover adjacent empty tiles.
-   Determines when the game is won or lost.

Example Gameplay
----------------

```
Welcome to the MineSweeper game!
First of all, you should declare the size of the game board.
Enter the number of rows: 5
Now, enter the number of columns: 5

Here is your board:
- - - - -
- - - - -
- - - - -
- - - - -
- - - - -

Enter row and column to uncover (separated by space): 2 3
0 1 1 - -
1 2 M - -
M 2 1 - -
1 1 0 - -
0 0 0 - -

Game Over! (If the player hits a mine)

```

Future Improvements
-------------------

-   Implement a graphical user interface (GUI) using Java Swing.
-   Allow users to flag potential mines.
-   Add difficulty levels with adjustable mine density.
-   Implement a timer for tracking game duration.

License
-------

This project is open-source and free to use for educational and personal purposes.
