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
        if (!this.isFed && !(this.isEmpty || this.isDoneGrowing)){
            this.popupMenu.add(feed);
        } else {
            this.popupMenu.remove(feed);
        }

        super.setMenu();
    }



    @Override
    public void tickUpdate(){
        if (this.curFrame+1 == this.plotType.cycleFrames){
            this.isFed = false;
        }
        if ((this.curFrame == 1 || this.curFrame == 3) && this.isFed){
            super.tickUpdate();
        } else if (this.curFrame != 1){
            super.tickUpdate();
        }
    }

    @Override
    public void fastUpdate(){
        this.isDoneGrowing = this.curFrame == this.plotType.cycleFrames - 2;
        if (this.isEmpty){
            this.curFrame = 0;
        }

    }
}
