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

    //Initialize the borad with '-' 
    String[][] fill(String[][] array){

        for (int row = 0; row < this.rowsNum; row++) {
            for(int column = 0; column < this.columnsNum; column++){
                array[row][column] = "-";
            }
        }
        return array;
    }

    //Randomly places the mines
    void initializeMines(String[][] mineMap){

        Random random = new Random();
        int count = 0;
        
        while(count < this.minesNum){
            int row = random.nextInt(this.rowsNum);
            int column = random.nextInt(this.columnsNum);
            
            if(mineMap[row][column].equals("-")){
                mineMap[row][column] = "*";
                count++;
            }
        }
    }

    //play the game
    void run(){}
}