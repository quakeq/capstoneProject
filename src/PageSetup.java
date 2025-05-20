import game.components.Plot;
import game.components.farmPlots.EmptyPlot;
import utility.Constants;
import utility.Constants.*;
import utility.GlobalTick;
import utility.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;


public class PageSetup {

    private JFrame frame;
    private User user;


    public PageSetup(){
        user = User.getUser();
        frame = new JFrame("Container Example"); // Create a Frame

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(GraphicSizes.windowMinSize);// Set the size of the frame
        frame.setResizable(false);
        frame.setLayout(null);

        for (Plot plot : user.getPlots()){
            plot.setBounds(new Rectangle(plot.getPoint(), frame.getSize()));
            frame.add(plot);
        }


        frame.setVisible(true);

        java.util.Timer timer = new Timer();

        // Schedule the task to run every 1000 milliseconds (1 second)
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, 3000);
    }

    public void update(){
        GlobalTick.tickUpdate();
        frame.repaint();
    }

}
