package Swing_Aufgabe3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MouseListener extends JFrame implements java.awt.event.MouseListener {
    private static final int GAP = 3;
    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    private static final JButton[][] BUTTONS_IN_SQUARE = new JButton[ROWS][COLUMNS];

    public MouseListener () {
        super("Be quiet. Let's listen to the mouse!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(ROWS, COLUMNS);
        gridLayout.setHgap(GAP);
        setLayout(gridLayout);


        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {

                BUTTONS_IN_SQUARE[row][column] = new JButton();
                BUTTONS_IN_SQUARE[row][column].setPreferredSize(new Dimension(WIDTH, HEIGHT));
                BUTTONS_IN_SQUARE[row][column].setBackground(Color.BLUE);
                BUTTONS_IN_SQUARE[row][column].addMouseListener(this);
                add(BUTTONS_IN_SQUARE[row][column]);
            }
        }
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ( (JButton) e.getSource() ).setBackground(Color.MAGENTA);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ( (JButton) e.getSource() ).setBackground(Color.BLUE);
    }
}
