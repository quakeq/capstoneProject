package src;

import src.game.components.Plot;
import src.utility.Constants.*;
import src.utility.GlobalTick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


public class PageSetup {

    private JFrame frame;

    private final List<List<Plot>> plotMap = new ArrayList<>();

    public PageSetup(){

        this.frame = new JFrame("Container Example"); // Create a Frame

        frame.setMinimumSize(GraphicSizes.windowMinSize);// Set the size of the frame
        frame.setVisible(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.update();



    }

    public void update(){
        GlobalTick.tickUpdate(plotMap);
        frame.repaint();
    }

}
