package utility;

import game.components.Plot;
import game.components.farmPlots.*;
import utility.Constants.*;

import java.util.HashMap;

public class UserValues {


    private static Plot[] plots = {
            new EmptyPlot(0), new EmptyPlot(1), new EmptyPlot(2),
            new EmptyPlot(3), new EmptyPlot(4), new EmptyPlot(5),
            new EmptyPlot(6), new EmptyPlot(7), new EmptyPlot(8)
    };

    private static HashMap<ShopItems, Integer> items = new HashMap<>(ShopItems.values().length);
    private static double money = GameConstants.startMoney;


    public static void changeItemAmt(ShopItems item, int num){
        if ((items.get(item) + num) > 0){
            items.put(item, items.get(item) + num);
        }
    }

    public static Integer getItemAmt(ShopItems item){
        return items.get(item);
    }

    public static void changeMoneyAmt(double num){
        money += num;
    }

    public static double getMoneyAmt(){
        return money;
    }

    public static void setPlot(int pos, PlotTypes type){
        switch(type){
            case FISH -> {
                plots[pos] = new FishPlot(pos);
            }
            case ANIMAL -> {
                plots[pos] = new AnimalPlot(pos);
            }
            case PLANT -> {
                plots[pos] = new PlantPlot(pos);
            }
            case HYDROPONIC -> {
                plots[pos] = new HydroponicPlot(pos);
            }
        }
    }
    public static Plot[] getPlots(){
        return plots;
    }

}
