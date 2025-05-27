package game.components.farmPlots;

import game.components.Plot;
import game.components.inventory.InventoryUI;
import utility.Constants;
import utility.User;

import javax.swing.*;

public class RicePlot extends Plot {


    private boolean isFertilized;

    JMenuItem harvest = new JMenuItem("Harvest");
    JMenuItem fertilizer = new JMenuItem("Use Fertilizer");
    JMenuItem plant = new JMenuItem("Plant");


    public RicePlot(int pos) {
        super(Constants.PlotTypes.WHEAT, pos);
        harvest.addActionListener(e -> {
            this.isEmpty = true;
            this.isDoneGrowing = false;
            User.getUser().changeItemAmt(Constants.MoneyItems.RICE, 3);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.RICE);
        });
        fertilizer.addActionListener(e -> {
            this.isFertilized = true;
            User.getUser().changeItemAmt(Constants.MoneyItems.FERTILIZER, -1);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.FERTILIZER);
        });
        plant.addActionListener(e -> {
            this.isEmpty = false;
            this.isDoneGrowing = false;
            User.getUser().changeItemAmt(Constants.MoneyItems.RICE_SEEDS, -1);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.RICE_SEEDS);
        });
    }

    @Override
    public void setMenu(){
        if (this.isDoneGrowing && !this.isEmpty){
            this.popupMenu.add(harvest);
        } else {
            this.popupMenu.remove(harvest);
        }
        if (this.isEmpty && User.getUser().getItemAmt(Constants.MoneyItems.RICE_SEEDS) > 0){
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
