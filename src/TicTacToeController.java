import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TicTacToeController implements ActionListener{
    
    private TicTacToeModel model;
    private TicTacToeView view;
    
    public TicTacToeController(TicTacToeModel m, TicTacToeView v) {
        this.model = m;
        this.view = v;
        this.view.setActionListener(this);
    }

    public void resetEntireGame() {
        model.resetGame();
        view.resetBoard();
        view.updateBoard(model.getBoard());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton[][] buttons = view.getButtons();
        
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                
                if (e.getSource() == buttons[i][j]) {
                    model.makeMove(i,j,model.getCurrentPlayer());
                    view.updateBoard(model.getBoard());
                    ((JButton)e.getSource()).setEnabled(false);                    

                    if (model.checkWinner()) {
                        JOptionPane.showMessageDialog(null, "Game Over! Player " +  model.getCurrentPlayer() + " has won.");
                        resetEntireGame();
                    } else if (model.isDraw()) { 
                        JOptionPane.showMessageDialog(null, "It's a draw!");
                        resetEntireGame();
                    } else {
                        model.playerTurn();
                    }

                }

            }
        }
        
    }
}
