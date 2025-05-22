package utility;

import game.components.Plot;
import game.components.farmPlots.*;
import utility.Constants.*;

import java.util.HashMap;

public class User {
    private static User user;

    private Plot[] plots = {
            new PlantPlot(0), new EmptyPlot(1), new EmptyPlot(2),
            new EmptyPlot(3), new EmptyPlot(4), new EmptyPlot(5),
            new EmptyPlot(6), new EmptyPlot(7), new EmptyPlot(8)
    };
    private HashMap<MoneyItems, Integer> items = new HashMap<>(MoneyItems.values().length);
    private double money;

    public User(){
        this.money = GameConstants.startMoney;
    }

    public void changeItemAmt(MoneyItems item, int num){
        if ((items.get(item) + num) > 0){
            items.put(item, items.get(item) + num);
        }
    }

    public Integer getItemAmt(MoneyItems item){
        return items.get(item);
    }

    public void changeMoneyAmt(double num){
        money += num;
    }

    public double getMoneyAmt(){
        return money;
    }

    public void setPlot(int pos, PlotTypes type){
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

    public Plot[] getPlots(){
        return plots;
    }
    public static User getUser(){
        if (user == null){
            user = new User();
        }
        return user;
    }

}
