package src.utility;

import src.game.components.Plot;

import java.util.List;
import java.util.Timer;

public class GlobalTick {

    public GlobalTick(){}

    public static void tickUpdate(List<List<Plot>> plots){

        for (List<Plot> row : plots){
            for (Plot cell : row){
                if (Math.random() > cell.)
                cell.tickUpdate();
            }
        }
    }



}
