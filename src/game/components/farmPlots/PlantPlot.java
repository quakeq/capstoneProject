package game.components.farmPlots;

import game.components.Plot;
import utility.Constants;
import utility.User;

import javax.swing.*;

public class PlantPlot extends Plot {

    private boolean isFertilized;

    JMenuItem harvest = new JMenuItem("Harvest");
    JMenuItem fertilizer = new JMenuItem("Use Fertilizer");
    JMenuItem plant = new JMenuItem("Plant");


    public PlantPlot(int pos) {
        super(Constants.PlotTypes.PLANT, pos);
        harvest.addActionListener(e -> {
            this.isEmpty = true;
            this.isDoneGrowing = false;
        });
        fertilizer.addActionListener(e -> {
            this.isFertilized = true;
            User.getUser().changeItemAmt(Constants.MoneyItems.FERTILIZER, -1);
        });
        plant.addActionListener(e -> {
            this.isEmpty = false;
        });
    }
    @Override
    public void tickUpdate(){
        super.tickUpdate();
    }
    @Override
    public void setMenu(){
        if (this.isDoneGrowing){
            this.popupMenu.add(harvest);
        } else {
            this.popupMenu.remove(harvest);
        }
        if (this.isEmpty){
            this.popupMenu.add(plant);
        } else {
            this.popupMenu.remove(plant);
        }
        if (!this.isFertilized){
            this.popupMenu.add(fertilizer);
        } else {
            this.popupMenu.remove(fertilizer);
        }
        super.setMenu();
    }
}
