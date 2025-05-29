package utility;

import game.Plot;

public class GlobalTick {

    public GlobalTick(){}

    public static void slowerGrowUpdate(){
        for (Plot plot : User.getUser().getFarmPlots()){
            if (!plot.isFertilized()){
                plot.tickUpdate();
            }
        }
    }

    public static void fasterGrowUpdate(){
        for (Plot plot : User.getUser().getFarmPlots()){
            if (plot.isFertilized()){
                plot.tickUpdate();
            }
        }
    }

    public static void statusUpdate(){
        for (Plot plot : User.getUser().getFarmPlots()){
            plot.fastUpdate();
            plot.setMenu();
        }
    }


}

