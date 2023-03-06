import java.util.*;

public class MineSweeper{

    Scanner scanner = new Scanner(System.in);

    private int numOfRows;
    private int numOfColumns;
    private int[][] board;
    private int mineCount;
    private boolean[][] mineBoard;

    public MineSweeper(int numOfRows, int numOfColumns){
        
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.board = new int[numOfRows][numOfColumns];
        this.mineCount = (numOfRows * numOfColumns) / 4;
        this.mineBoard = new boolean[numOfRows][numOfColumns];
        firstInitializeWithZero(this.board);
        mineInitializition(this.mineCount);
    }
    
    // Initialize board as 2D array of integers with all elements set to 0
    void firstInitializeWithZero(int[][] board){
        
        for(int row = 0; row < numOfRows; row++){
            for(int column = 0; column < numOfColumns; column++){
                board[row][column] = 0;
            }
        }
    }

    // Places the mines randomly
    void mineInitializition(int mineCount){

        Random random = new Random();
        int count = 0;
        while (count < mineCount){
            
            int row = random.nextInt(this.numOfRows);
            int col = random.nextInt(this.numOfColumns);
            if (!mineBoard[row][col]) {
                mineBoard[row][col] = true;
                count++;
            }
        }
    }

    // Print the initial statment of board with all elements hidden
    void printInitialStatment(){

        for(int row = 0; row < this.numOfRows; row++){
            for(int column = 0; column < this.numOfColumns; column++){
                System.out.print("- ");
            }
            System.out.println();
        }
    }

    // Runs the game
    void run(){

        System.out.println("Here is your board:");
        printInitialStatment();

        boolean gameEnded = false;
        while(!gameEnded){

            // Prompt the user to enter row and column to uncover
            System.out.println("Enter row and column to uncover (seperated by space): ");
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            // Check if selected square is not within bounds of broad
            if(row < 0 || row >= numOfRows || column < 0 || column >= numOfColumns){
                System.out.println("Invalid input! Please enter a valid row and column number.");
                continue;
            }

            // Check if selected square contains a mine
            if(mineBoard[row][column]){
                System.out.println("Game over!");
                gameEnded = true;
                continue;
            }

            // If selected square does not contain a mine, count neighboring mines and update board
            int neighboringMines = countNeighboringMines(mineBoard, row, column);
            board[row][column] = neighboringMines;

            // If selected square is blank, recursively uncover adjacent squares
            if(neighboringMines == 0){
                uncoverAdjacentSquares(board, mineBoard, row, column);
            }

            // Check if all squares except mines have been uncovered
            if(checkWin(board, mineBoard)){
                System.out.println("You win!");
                gameEnded = true;
            }

            // Print the current state of board
            for(int i = 0; i < numOfRows; i++){
                for(int j = 0; j < numOfColumns; j++){
                    if(board[i][j] == 0){
                        System.out.print("- ");

                    } else {
                        System.out.print(board[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    // Helper func to count the number of mines in neighboring squares
    int countNeighboringMines (boolean[][] mines, int row, int column){

        int count= 0;
        for(int i = row - 1; i <= row + 1; i++){
            for(int j = column - 1; j <= column + 1; j++){
               
                // Check if it is within the mine board
                if( i >= 0 && i <= mineBoard.length && j >= 0 && j <= mineBoard.length){
                    if(mineBoard[i][j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Helper func to recursively uncover adjacent blank squares and non-mine values
    void uncoverAdjacentSquares(int board[][], boolean mineBoard[][], int row, int column){

        for(int i = row - 1; i <= row + 1; i++){
            for(int j = column - 1; j <= column + 1; j++){

                //Check if it is within the board
                if( i >= 0 && i <= board.length && j >= 0 && j <= board.length){

                    board[i][j] = countNeighboringMines(mineBoard, i, j);
                    
                    if (board[i][j] == 0){
                        uncoverAdjacentSquares(board, mineBoard, i, j);
                    }
                }
            }
        }
    }

    // Helper func to check if all squares except mines have been uncovered
    boolean checkWin(int[][] board, boolean[][] mines){

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(board[i][j] == 0 && !mineBoard[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}