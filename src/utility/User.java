package utility;

import core.PageSetup;
import game.Plot;
import game.farmPlots.*;
import utility.Constants.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private static User user;

    private ArrayList<Plot> farmPlots = new ArrayList<>();


    private HashMap<MoneyItems, Integer> items;
    private double money;

    public User(){
        this.farmPlots.add(new EmptyPlot(0));
        this.farmPlots.add(new EmptyPlot(1));
        this.farmPlots.add(new EmptyPlot(2));
        this.farmPlots.add(new EmptyPlot(3));
        this.farmPlots.add(new EmptyPlot(4));
        this.farmPlots.add(new EmptyPlot(5));
        this.farmPlots.add(new EmptyPlot(6));
        this.farmPlots.add(new EmptyPlot(7));
        this.farmPlots.add(new EmptyPlot(8));

        this.items = new HashMap<>(MoneyItems.values().length);
        this.items.put(MoneyItems.WHEAT, 0);
        this.items.put(MoneyItems.EGGS, 0);
        this.items.put(MoneyItems.FERTILIZER, 0);
        this.items.put(MoneyItems.RICE, 0);
        this.items.put(MoneyItems.RICE_SEEDS, 0);
        this.items.put(MoneyItems.SEEDS, 2);
        this.items.put(MoneyItems.BEEF, 0);
        this.items.put(MoneyItems.CALF, 0);
        this.items.put(MoneyItems.CHICKEN_BUTCHERED, 0);
        this.items.put(MoneyItems.CHICKEN, 0);

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
        this.money += num;
    }

    public double getMoneyAmt(){
        return this.money;
    }

    public void setPlot(int pos, PlotTypes type){
        switch(type){
            case COW -> {
                PageSetup.getFrame().remove(farmPlots.get(pos));
                farmPlots.set(pos, new CowPlot(pos));
                farmPlots.get(pos).setBounds(new Rectangle(farmPlots.get(pos).getPoint(), GraphicSizes.plotSize));
                PageSetup.getFrame().add(farmPlots.get(pos));
                PageSetup.getFrame().revalidate();
                PageSetup.getFrame().repaint();
            }
            case CHICKEN -> {
                PageSetup.getFrame().remove(farmPlots.get(pos));
                farmPlots.set(pos, new ChickenPlot(pos));
                farmPlots.get(pos).setBounds(new Rectangle(farmPlots.get(pos).getPoint(), GraphicSizes.plotSize));
                PageSetup.getFrame().add(farmPlots.get(pos));
                PageSetup.getFrame().revalidate();
                PageSetup.getFrame().repaint();
            }
            case WHEAT -> {
                PageSetup.getFrame().remove(farmPlots.get(pos));
                farmPlots.set(pos, new PlantPlot(pos));
                farmPlots.get(pos).setBounds(new Rectangle(farmPlots.get(pos).getPoint(), GraphicSizes.plotSize));
                PageSetup.getFrame().add(farmPlots.get(pos));
                PageSetup.getFrame().revalidate();
                PageSetup.getFrame().repaint();
            }
            case RICE -> {
                PageSetup.getFrame().remove(farmPlots.get(pos));
                farmPlots.set(pos, new RicePlot(pos));
                farmPlots.get(pos).setBounds(new Rectangle(farmPlots.get(pos).getPoint(), GraphicSizes.plotSize));
                PageSetup.getFrame().add(farmPlots.get(pos));
                PageSetup.getFrame().revalidate();
                PageSetup.getFrame().repaint();
            }
        }
    }

    public ArrayList<Plot> getFarmPlots(){
        return farmPlots;
    }
    public static User getUser(){
        if (user == null){
            user = new User();
        }
        return user;
    }

}
