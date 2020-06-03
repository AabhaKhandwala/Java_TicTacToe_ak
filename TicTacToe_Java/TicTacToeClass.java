package TicTacToe_Java;

public class TicTacToeClass {
    // Instance Variables
    private char[][] board;
    private int turns;

    // Constructors
    public TicTacToeClass() {
        board = new char[3][3];
        turns = 0;

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';
    }

    // Accessor Methods

    public boolean isWinner(char p) {
        for (int r = 0; r <= 2; r++) {
            if (p == board[r][0] && board[r][0] == board[r][1] && board[r][1] == board[r][2])
                return true;
        }
        for (int c = 0; c <= 2; c++) {
            if (p == board[0][c] && board[0][c] == board[1][c] && board[1][c] == board[2][c])
                return true;
        }
        if (p == board[0][0] && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        else if (p == board[0][2] && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;
        return false;

    }

    public boolean isFull() {
        if (numTurns() != 9) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isCat() {
        if ((!isWinner('X') && isFull()) || (!isWinner('O') && isFull()))
            return true;
        return false;
    }

    public boolean isValid(int r, int c) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2)
            return true;
        else
            return false;
    }

    public int numTurns() {
        return turns;
    }

    public char playerAt(int r, int c) {
        if (isValid(r, c))
            return board[r][c];
        else
            return '@';
    }

    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers
    public void playMove(char p, int r, int c) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (i == r && j == c) {
                    board[r][c] = p;
                    turns++;

                }
            }
    }
}