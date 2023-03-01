import java.util.*;

class MineSweeper{
        
    Scanner scanner = new Scanner(System.in);

    private int rowsNum;
    private int columnsNum;
    private String[][] mineMap;
    private String[][] board;
    private int minesNum;
    //private int lineNo;
    //private int columnNo;

    MineSweeper(int rowsNum, int columnsNum){
        this.rowsNum = rowsNum;
        this.columnsNum = columnsNum;
        this.mineMap = new String[rowsNum][columnsNum];
        this.board = new String[rowsNum][columnsNum];
        fill(this.board);
        this.minesNum = (rowsNum * columnsNum) / 4;
        initializeMines(this.mineMap);
    }

    // Prompt user for number of rows and columns
    void welcomePage(){

    System.out.print("Welcome the mine sweeper game!\n"
                        + "First of all you should declare the size of the gameboard."
                        + "Enter the number of rows: ");
    this.numOfRows = scanner.nextInt();
    
    System.out.println("Now, enter the number of columns: ");
    this.numOfColumns = scanner.nextInt();
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

        welcomePage();
        System.out.println("Here is your board:");
        printInitialStatment();

        boolean gameEnded = false;
        while(!gameEnded){

            
        }
    }
}