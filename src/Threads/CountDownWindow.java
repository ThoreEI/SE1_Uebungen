package Threads;
import javax.swing.*;
import java.awt.*;

public class CountDownWindow {

    private JFrame frame;


    public CountDownWindow() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch ( UnsupportedLookAndFeelException |ClassNotFoundException  | InstantiationException |  IllegalAccessException e ) {
                    System.err.println(e.getMessage());
                }

                frame = new JFrame("CountDown");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new CountDown());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);


            }
        })
    ;}
}



