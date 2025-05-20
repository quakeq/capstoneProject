package utility;

import game.components.Plot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlobalTick {

    public GlobalTick(){}

    public static void tickUpdate(){
        for (Plot plot : User.getUser().getPlots()){
            if (Math.random() > 0.5){
                plot.tickUpdate();
            }
        }
    }



}
