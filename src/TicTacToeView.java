import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.ActionListener;

public class TicTacToeView {

    private static int width = 600;
    private static int height = 650; 

    private JFrame frame;
    private JPanel boardPanel = new JPanel();
    private JLabel textLabel = new JLabel();
    private JPanel textPanel = new JPanel();
    
    private JButton[][] buttons = new JButton[3][3];
    

    public TicTacToeView() {
        frame = new JFrame("Tic Tac Toe");

        ImageIcon appIcon = new ImageIcon("../img/tictactoe.png");
        frame.setIconImage(appIcon.getImage());

        textLabel.setBackground(Color.DARK_GRAY);
        textLabel.setForeground(Color.WHITE);
        textLabel.setText("Tic Tac Toe");
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 40));
        textLabel.setOpaque(true);
        frame.add(textLabel);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel,BorderLayout.NORTH);
        
        boardPanel.setLayout(new GridLayout(3,3));
        addGridButtons();
        frame.add(boardPanel);
        boardPanel.setBackground(Color.DARK_GRAY);
        
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    public void addGridButtons() {
        for (int i =0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.DARK_GRAY);
                buttons[i][j].setForeground(Color.WHITE);
                buttons[i][j].setPreferredSize(new Dimension(100, 100));
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                
                buttons[i][j].setFocusable(false);
                
                boardPanel.add(buttons[i][j]);
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

    public void resetBoard() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
    }

    public JButton[][] getButtons() {
        return buttons;
    }
}
