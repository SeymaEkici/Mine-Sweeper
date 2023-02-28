import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Welcome the mine sweeper game!\n"
                            + "First of all you should choose the area of the game."
                            + "Enter the line's number: ");
        int rowsNum = scanner.nextInt();
        System.out.println("Now, enter the column's number: ");
        int columnsNum = scanner.nextInt();

        MineSweeper game = new MineSweeper(rowsNum, columnsNum);
        game.run();

        scanner.close();
    }   
}
