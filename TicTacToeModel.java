

public class TicTacToeModel {
    
    char[][] board = new char[3][3];
    char player1= 'X';
    char player2 = 'O';
    int turnCounter = 0;

    char currentPlayer;

    public TicTacToeModel() {
        this.currentPlayer = 'X';
    }

    public void boardSetup() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j]= ' ';
            }
        }
    }

    public void playerTurn() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void makeMove(int row, int col, char player) {
        if (board[row][col] == ' ') {
            board[row][col] = player;
            turnCounter++;
        }
    }

    public boolean checkWinner() {

        for (int i = 0; i < 3; i++){
            if (board[i][0] != ' ' && board[i][1] == board[i][0] && board[i][2] == board[i][0]) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++){
            if (board[0][j] != ' ' && board[1][j] == board[0][j] && board[2][j] == board[0][j]) {
                return true;
            }
        }
               
        // check diagonals for winner
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && 
            board[1][1] == board[2][2]) {
                return true;
        }
        else if (board[0][2]!= ' ' && board[0][2] == board[1][1] && 
            board[1][1] == board[2][0]) {
                return true;
        }
        return false;
    }

    public boolean isDraw() {
        if (turnCounter == 9 && checkWinner() == false) {return true;}
        return false;
    }

    public void resetGame() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j]= ' ';
            }
        }
    }

    public char[][] getBoard() {
        return this.board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}