package Threads;
import javax.swing.*;
import java.awt.*;

public class CountDownWindow  {



    public CountDownWindow() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch ( UnsupportedLookAndFeelException |ClassNotFoundException  | InstantiationException |  IllegalAccessException e ) {
                    System.err.println(e.getMessage());
                }
                JFrame frame = new JFrame("CountDown");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.add(new CountDown()); // Thread2 --> Countdown
                //Thread1
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                System.out.println("Fertig");
            }
        })
    ;}

}



