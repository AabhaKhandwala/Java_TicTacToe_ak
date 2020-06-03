package TicTacToe_Java;

import java.util.Scanner;

public class TicTacToePlay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TicTacToeClass ttt = new TicTacToeClass();
        char p = 'X';
        while (!(ttt.isWinner('X') || ttt.isWinner('O') || ttt.isFull())) {
            ttt.displayBoard();
            System.out.println("Enter your location:(row,column): ");
            System.out.print("row: ");
            int row = scan.nextInt();
            System.out.print("column: ");
            int column = scan.nextInt();

            while (ttt.isValid(row, column) == false || ttt.playerAt(row, column) != ' ') {

                if (ttt.isValid(row, column) == false)
                    System.out.println("That is not a valid location. Try again.");
                else if (ttt.playerAt(row, column) != ' ')
                    System.out.println("That location is already full. Try again.");

                System.out.print("Enter your location (row, column): ");
                System.out.print("row: ");

                row = scan.nextInt();
                System.out.print("column: ");
                column = scan.nextInt();
            }

            ttt.playMove(p, row, column);

            if (p == 'X') {
                p = 'O';
            } else {
                p = 'X';
            }
        }
        ttt.displayBoard();

        if (ttt.isWinner('X'))
            System.out.println("X is the winner!");
        if (ttt.isWinner('O'))
            System.out.println("O is the winner!");
        if (ttt.isCat())
            System.out.println("The game is a tie.");
        scan.close();

    }
}
