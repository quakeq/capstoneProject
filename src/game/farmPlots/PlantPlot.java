package game.farmPlots;

import game.Plot;
import game.inventory.InventoryUI;
import utility.Constants;
import utility.User;

import javax.swing.*;

public class PlantPlot extends Plot {

    JMenuItem harvest = new JMenuItem("Harvest");
    JMenuItem fertilizer = new JMenuItem("Use Fertilizer");
    JMenuItem plant = new JMenuItem("Plant");


    public PlantPlot(int pos) {
        super(Constants.PlotTypes.WHEAT, pos);
        harvest.addActionListener(e -> {
            this.isEmpty = true;
            this.harvestedAmount++;
            User.getUser().changeItemAmt(Constants.MoneyItems.WHEAT, 1);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.WHEAT);
        });
        fertilizer.addActionListener(e -> {
            this.isFertilized = true;
            User.getUser().changeItemAmt(Constants.MoneyItems.FERTILIZER, -1);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.FERTILIZER);
        });
        plant.addActionListener(e -> {
            this.isEmpty = false;
            User.getUser().changeItemAmt(Constants.MoneyItems.SEEDS, -1);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.SEEDS);
        });
    }

    @Override
    public void setMenu(){
        if (this.isDoneGrowing && !this.isEmpty){
            this.popupMenu.add(harvest);
        } else {
            this.popupMenu.remove(harvest);
        }
        if (this.isEmpty && User.getUser().getItemAmt(Constants.MoneyItems.SEEDS) > 0){
            this.popupMenu.add(plant);
        } else {
            this.popupMenu.remove(plant);
        }
        if (!this.isFertilized && User.getUser().getItemAmt(Constants.MoneyItems.FERTILIZER) > 0){
            this.popupMenu.add(fertilizer);
        } else {
            this.popupMenu.remove(fertilizer);
        }
        super.setMenu();
    }

    @Override
    public void fastUpdate(){
        super.fastUpdate();
        if (this.harvestedAmount > 5){
            this.isFertilized = false;
            this.harvestedAmount = 0;
        }
    }
}
