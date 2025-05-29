package game.farmPlots;

import game.Plot;
import game.inventory.InventoryUI;
import utility.Constants;
import utility.User;

import javax.swing.*;

public class ChickenPlot extends Plot {

    private boolean isFed;
    private boolean hasItem;
    private int eggCount;

    private boolean hasSetFed;
    private boolean hasSetItem;

    JMenuItem feed = new JMenuItem("Feed");
    JMenuItem placeAnimal = new JMenuItem("Place Animal");
    JMenuItem butcher = new JMenuItem("Butcher Animal");
    JMenuItem collect = new JMenuItem("Collect Eggs");


    public ChickenPlot(int pos) {
        super(Constants.PlotTypes.CHICKEN, pos);

        this.eggCount = 0;

        feed.addActionListener(e -> {
            if (User.getUser().getItemAmt(Constants.MoneyItems.RICE) > 0) {
                this.isFed = true;
                User.getUser().changeItemAmt(Constants.MoneyItems.RICE, -1);
                InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.RICE);
            }
        });
        placeAnimal.addActionListener(e -> {
            this.isEmpty = false;
            User.getUser().changeItemAmt(Constants.MoneyItems.CHICKEN, -1);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.CHICKEN);
        });
        butcher.addActionListener(e -> {
            this.isEmpty = true;
            this.isFed = false;
            User.getUser().changeItemAmt(Constants.MoneyItems.CHICKEN_BUTCHERED, 1);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.CHICKEN_BUTCHERED);
        });
        collect.addActionListener(e -> {
            this.hasItem = false;
            User.getUser().changeItemAmt(Constants.MoneyItems.EGGS, this.eggCount);
            InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.EGGS);
        });
    }

    @Override
    public void setMenu(){
        if (this.isDoneGrowing && !this.isEmpty){
            this.popupMenu.add(butcher);
        } else {
            this.popupMenu.remove(butcher);
        }
        if (this.isEmpty && User.getUser().getItemAmt(Constants.MoneyItems.CHICKEN) > 0){
            this.popupMenu.add(placeAnimal);
        } else {
            this.popupMenu.remove(placeAnimal);
        }
        if (this.hasItem){
            this.popupMenu.add(collect);
        } else {
            this.popupMenu.remove(collect);
        }
        if (!this.isFed && !(this.isEmpty || this.curFrame == this.plotType.cycleFrames - 1) && User.getUser().getItemAmt(Constants.MoneyItems.RICE) > 0){
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
            this.eggCount++;
            this.hasSetItem = true;
            this.collect.setText("Collect Eggs: " + this.eggCount);
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
