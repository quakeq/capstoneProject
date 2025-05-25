package utility;

import game.components.Plot;
import game.components.farmPlots.*;
import utility.Constants.*;

import java.util.HashMap;

public class User {
    private static User user;

    private Plot[] farmPlots = {
            new PlantPlot(0), new PlantPlot(1), new PlantPlot(2),
            new PlantPlot(3), new PlantPlot(4), new PlantPlot(5),
            new EmptyPlot(6), new EmptyPlot(7), new EmptyPlot(8)
    };
    private HashMap<MoneyItems, Integer> items;
    private double money;

    public User(){
        this.items = new HashMap<>(MoneyItems.values().length);
        this.items.put(MoneyItems.WHEAT, 0);
        this.items.put(MoneyItems.EGGS, 0);
        this.items.put(MoneyItems.FERTILIZER, 0);
        this.items.put(MoneyItems.ROE, 0);
        this.items.put(MoneyItems.SEAWEED, 0);
        this.items.put(MoneyItems.SEEDS, 2);
        this.money = GameConstants.startMoney;
    }

    public void changeItemAmt(MoneyItems item, int num){
        if ((items.get(item) + num) >= 0){
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
                farmPlots[pos] = new FishPlot(pos);
            }
            case ANIMAL -> {
                farmPlots[pos] = new AnimalPlot(pos);
            }
            case PLANT -> {
                farmPlots[pos] = new PlantPlot(pos);
            }
            case HYDROPONIC -> {
                farmPlots[pos] = new HydroponicPlot(pos);
            }
        }
    }

    public Plot[] getFarmPlots(){
        return farmPlots;
    }
    public static User getUser(){
        if (user == null){
            user = new User();
        }
        return user;
    }

}
