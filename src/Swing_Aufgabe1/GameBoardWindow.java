package Swing_Aufgabe1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameBoardWindow extends JFrame {
    private final Container PANE;
    private final JButton[][] GAME_BOARD;
    private boolean isShipPlaced;
    public ImageIcon BACK_GROUND;
    private int ROWS = 10;
    private int COLUMNS = 10;

    public GameBoardWindow() {
        super();
        this.PANE = getContentPane();
        this.PANE.setLayout(new GridLayout(10, 10));
        this.PANE.setBackground(Color.blue);
        setTitle("Ship Sinking");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.BACK_GROUND = new ImageIcon("C:\\Users\\UnknownUser\\IdeaProjects\\ShipSink\\src\\water.jpg");
        this.GAME_BOARD = new JButton[ROWS][COLUMNS];
        initializeGameBoard();
        setLocationRelativeTo(null);
    }

    private void initializeGameBoard () {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < ROWS; column++) {
                JButton button = new JButton("", BACK_GROUND);

                GAME_BOARD[row][column] = button;
                button.setForeground(Color.CYAN);
                button.setBackground(Color.BLUE);
                button.setText(row + " , " + column);

                //one ActionListener for each button
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == button)
                            System.out.println(button.getText());
                    }
                });
                PANE.add(button);
            }
        }
    }

    public JButton[][] getGAME_BOARD () {
        return GAME_BOARD;
    }

}


