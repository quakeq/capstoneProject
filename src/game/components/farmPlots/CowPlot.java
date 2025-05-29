package game.components.farmPlots;

import game.components.Plot;
import game.components.inventory.InventoryUI;
import utility.Constants;
import utility.User;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CowPlot extends Plot {

    private boolean isFed;
    private boolean hasItem;
    private int manureCount;

    private boolean hasSetFed;
    private boolean hasSetItem;

    JMenuItem feed = new JMenuItem("Feed");
    JMenuItem placeAnimal = new JMenuItem("Place Animal");
    JMenuItem butcher = new JMenuItem("Butcher Animal");
    JMenuItem collect = new JMenuItem("Collect Manure");


    public CowPlot(int pos) {
        super(Constants.PlotTypes.COW, pos);

        this.manureCount = 0;

        feed.addActionListener(e -> {
            if (User.getUser().getItemAmt(Constants.MoneyItems.WHEAT) > 0) {
                this.isFed = true;
                User.getUser().changeItemAmt(Constants.MoneyItems.WHEAT, -1);
                InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.WHEAT);
            }
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
            User.getUser().changeItemAmt(Constants.MoneyItems.FERTILIZER, this.manureCount);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.FERTILIZER);
            this.manureCount = 0;
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
        if (!this.isFed && !(this.isEmpty || this.curFrame == this.plotType.cycleFrames - 1) && User.getUser().getItemAmt(Constants.MoneyItems.WHEAT) > 0){
            this.popupMenu.add(feed);
        } else {
            this.popupMenu.remove(feed);
        }

        super.setMenu();
    }



    @Override
    public void tickUpdate(){

        if (this.curFrame == this.plotType.cycleFrames - 1){
            this.curFrame = 3;
            this.hasSetFed = false;
        }

        if (this.curFrame == 3 && !this.hasSetFed){
            this.isFed = false;
            this.hasSetFed = true;
        }

        if (this.curFrame == 3 || this.curFrame == 1){
            if (this.isFed){
                super.tickUpdate();
            }
        } else {
            super.tickUpdate();
        }
    }

    @Override
    public void fastUpdate(){
        if (this.curFrame == 3 && !this.hasSetItem){
            this.hasItem = true;
            this.manureCount++;
            this.hasSetItem = true;
            this.collect.setText("Collect Manure: " + this.manureCount);
        }
        if (this.curFrame != 3){
            this.hasSetItem = false;
        }
        this.isDoneGrowing = (this.curFrame == this.plotType.cycleFrames - 2 || this.curFrame == this.plotType.cycleFrames - 1);
        if (this.isEmpty){
            this.curFrame = 0;
        }

    }
}
