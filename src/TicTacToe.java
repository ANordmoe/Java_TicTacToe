public class TicTacToe {
    // Instance Variables
    private char[][] board;
    private int turns;

    // Constructors
    public TicTacToe() {
        board = new char[3][3];
        turns = 0;

        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = ' ';
    }

    // Accessor Methods

    public boolean isWinner(char p)

    // returns true if the letter passed in currently has three in a row.
    // That is, isWinner('X') will return true if X has won, and isWinner('O')
    // will return true if O has won
    {
        // rows
        for (int r = 0; r < 3; r++) {
            if (board[r][0] == board[r][1] && board[r][1] == board[r][2] && board[r][0] != ' ') {
                return true;
            }
        }
        // columns
        for (int c = 0; c < 3; c++) {
            if (board[0][c] == board[1][c] && board[1][c] == board[2][c] && board[c][0] != ' ') {
                return true;
            }
        }
        // diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != ' ') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != ' ') {
            return true;
        }
        // otherwise if nobody has won yet...
        return false;
    }

    public boolean isFull() {
        if (turns == 9) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isCat() {
        if (isFull() && !isWinner('X') && !isWinner('O')) {
            return true;
        } else {
            return false;
        }  
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
        turns += 1;
        board[r][c] = p;
    }

}
