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

        while (frame.isActive()){
            update();
        }
    }

    public void update(){
        GlobalTick.tickUpdate();
        frame.repaint();
    }

}
