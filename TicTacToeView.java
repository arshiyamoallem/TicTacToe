import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.ActionListener;

public class TicTacToeView {
    private JFrame frame;
    private JPanel panel;
    private JButton[][] buttons = new JButton[3][3];

    public TicTacToeView() {
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(3,3, 10,10));
        addGridButtons();

        frame.setSize(400,400);
        frame.setVisible(true);
    }
    
    public void addGridButtons() {
        for (int i =0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                panel.add(buttons[i][j]);
            }
        }
    }

    public void setActionListener(ActionListener l) {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                buttons[i][j].addActionListener(l);;
            }
        }
    }

    public void updateBoard(char[][] boardData) {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                buttons[i][j].setText(""+boardData[i][j]);
            }
        }
    }

    public JButton[][] getButtons() {
        return buttons;
    }
}
