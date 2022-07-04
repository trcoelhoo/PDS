package lab03;

public class myGame implements lab03.JGaloInterface {
    int turn = 0;
    public char[][] board;
    int nmoves = 0; 
    private char player;
    private char winner;

    public myGame(char player) {
        this.player = player; // X or O
        this.board = new char[3][3];
        createEmptyBoard(board);

        if (player == 'X') {
            turn = 1; // impar
        } else {
            turn = 2;
        }

    }

    public void createEmptyBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                board[i][j] = ' ';
        }
    }

    public char getActualPlayer() {
        if (turn % 2 == 0) { // jogadas pares -> 0, 2, 4
            turn++;
            player = 'O';
            // System.out.println("player is -> " + player);
            return player;
        } else {
            turn++;
            player = 'X';
            // System.out.println("player is -> " + player);
            return player;
        }
    }

    public boolean setJogada(int lin, int col) {
        if (board[lin - 1][col - 1] == ' ') {
            board[lin - 1][col - 1] = player;
            nmoves++;
        }
        return false;
    }

    public boolean isFinished() {

        if (nmoves > 4) { // 5 is the minimum amount of moves to find a winner - starting in 0
            if ((board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][2] != ' ') || // row 1
                    (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] != ' ') || // row 2
                    (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] != ' ') || // row 3
                    (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] != ' ') || // col 1
                    (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] != ' ') || // col 2
                    (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] != ' ') || // col 3
                    (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != ' ') || // diagon \
                    (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] != ' ')) // diagon /
            {
                return true;
            } else if (nmoves == 9) { // 10 is the maximum amount of moves
                winner = ' ';
                return true;
            } else {

                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public char checkResult() {
        if (winner != ' ') {
            if (turn % 2 == 0) {
                return 'X';
            } else {
                return 'O';
            }
        } else {
            return ' ';
        }
    }
}
