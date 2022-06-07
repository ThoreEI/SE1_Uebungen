package Swing_Aufgabe4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class MouseListener extends JFrame implements java.awt.event.MouseListener {
    private static final int GAP = 3;
    private static final int ROWS = 20;
    private static final int COLUMNS = 20;
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private static final JButton[][] BUTTONS_IN_SQUARE = new JButton[ROWS][COLUMNS];
    private static final int NUMBER_OF_TEMPORARY_RECOLORED_BUTTONS = 10;
    private final LinkedList<JButton> currentRecoloredButtons = new LinkedList<>();

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
                BUTTONS_IN_SQUARE[row][column].setBackground(Color.DARK_GRAY);
                BUTTONS_IN_SQUARE[row][column].addMouseListener(this);
                add(BUTTONS_IN_SQUARE[row][column]);
            }
        }
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton recoloredButton = (JButton) e.getSource();
        recoloredButton.setBackground(Color.GREEN);
        currentRecoloredButtons.addFirst(recoloredButton);
        if (this.currentRecoloredButtons.size() > NUMBER_OF_TEMPORARY_RECOLORED_BUTTONS) {
            recoloredButton = currentRecoloredButtons.removeLast(); // last --> first
            recoloredButton.setBackground(Color.DARK_GRAY);
        }
    }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }
