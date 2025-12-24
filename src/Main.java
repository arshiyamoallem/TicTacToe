public class Main {
    public static void main(String[] args) {
        TicTacToeModel model = new TicTacToeModel();
        model.boardSetup(); // Fills board with ' '
        
        TicTacToeView view = new TicTacToeView();
        
        // The Controller wires them together
        new TicTacToeController(model, view);
    }
}