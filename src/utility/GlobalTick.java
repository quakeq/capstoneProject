package utility;

import game.components.Plot;

public class GlobalTick {

    public GlobalTick(){}

    public static void growUpdate(){
        for (Plot plot : User.getUser().getPlots()){
            plot.tickUpdate();
        }
    }
    public static void statusUpdate(){
        for (Plot plot : User.getUser().getPlots()){
            plot.fastUpdate();
            plot.setMenu();
        }
    }


}
