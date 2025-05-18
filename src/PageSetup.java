import game.components.Plot;
import game.components.farmPlots.EmptyPlot;
import utility.Constants.*;
import utility.GlobalTick;
import utility.UserValues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


public class PageSetup {

    private JFrame frame;



    public PageSetup(){

        frame = new JFrame("Container Example"); // Create a Frame

        for (Plot plot : UserValues.getPlots()){
            frame.add(plot);
        }

//        frame.add(new EmptyPlot(0));

        frame.setMinimumSize(GraphicSizes.windowMinSize);// Set the size of the frame
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        while (frame.isActive()){
            update();
        }
    }

    public void update(){
        GlobalTick.tickUpdate();
        frame.repaint();
    }

}
