package game.components.farmPlots;

import game.components.Plot;
import game.components.inventory.InventoryUI;
import utility.Constants;
import utility.User;

import javax.swing.*;

public class CowPlot extends Plot {

    private boolean isFed;
    private boolean hasItem;

    JMenuItem feed = new JMenuItem("Feed");
    JMenuItem placeAnimal = new JMenuItem("Place Animal");
    JMenuItem butcher = new JMenuItem("Butcher Animal");
    JMenuItem collect = new JMenuItem("Collect Manure");


    public CowPlot(int pos) {
        super(Constants.PlotTypes.COW, pos);

        feed.addActionListener(e -> {
            this.isFed = true;
            User.getUser().changeItemAmt(Constants.MoneyItems.WHEAT, -1);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.WHEAT);
        });
        placeAnimal.addActionListener(e -> {
            this.isEmpty = false;
            User.getUser().changeItemAmt(Constants.MoneyItems.CALF, -1);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.CALF);
        });
        butcher.addActionListener(e -> {
            this.isEmpty = true;
            this.isFed = false;
            User.getUser().changeItemAmt(Constants.MoneyItems.BEEF, 1);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.BEEF);
        });
        collect.addActionListener(e -> {
            this.hasItem = false;
        });
    }

    @Override
    public void setMenu(){
        if (this.isDoneGrowing && !this.isEmpty){
            this.popupMenu.add(butcher);
        } else {
            this.popupMenu.remove(butcher);
        }
        if (this.isEmpty && User.getUser().getItemAmt(Constants.MoneyItems.CALF) > 0){
            this.popupMenu.add(placeAnimal);
        } else {
            this.popupMenu.remove(placeAnimal);
        }
        if (this.hasItem){
            this.popupMenu.add(collect);
        } else {
            this.popupMenu.remove(collect);
        }
        if (!(this.isEmpty && this.isDoneGrowing && this.isFed)){
            this.popupMenu.add(feed);
        } else {
            this.popupMenu.remove(feed);
        }

        super.setMenu();
    }



    @Override
    public void tickUpdate(){
        if (this.isFed){
            super.tickUpdate();
        }
    }
}
