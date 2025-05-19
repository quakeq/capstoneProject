package utility;

import game.components.Plot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GlobalTick {

    public GlobalTick(){}

    public static void tickUpdate(){
        for (Plot plot : User.getUser().getPlots()){
            Timer timer = new Timer(10000, new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    plot.tickUpdate();
                }
            });
            timer.start();
        }
    }



}
