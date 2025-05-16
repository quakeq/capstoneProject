package utility;

import game.components.Plot;

import java.util.List;
import java.util.Timer;


public class GlobalTick {

    public GlobalTick(){}

    public static void tickUpdate(){
        for (Plot plot : UserValues.getPlots()){
            plot.tickUpdate();
        }
    }



}
