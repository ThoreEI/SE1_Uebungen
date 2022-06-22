package Threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class CountDown extends JPanel{

    private Timer timer;
    private long startTime;
    private final long DURATION = 7213;
    private JLabel label; // for prints

    public CountDown () {
        setLayout(new GridBagLayout());
        timer = new Timer(100, e -> {
            if (startTime < 0)
                startTime = System.currentTimeMillis();
            long currentTime = System.currentTimeMillis();
            long secondsLeft = currentTime - startTime;
            if (secondsLeft >= DURATION) {
                secondsLeft = DURATION;
                System.out.println("FertigCountdown");
                timer.stop();
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss:SS");
            label.setText(dateFormat.format(DURATION - secondsLeft));
        });

        timer.setInitialDelay(0);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!timer.isRunning()) {
                    startTime = -1;
                    timer.start();
                }
            }
        });
        label = new JLabel("CountDown");
        add(label);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

}
