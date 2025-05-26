package game.components.farmPlots;

import game.components.Plot;
import utility.Constants;
import utility.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class HydroponicPlot extends Plot {

    JMenuItem harvest = new JMenuItem("Harvest");
    JMenuItem fertilizer = new JMenuItem("Use Fertilizer");
    JMenuItem plant = new JMenuItem("Plant");

    public HydroponicPlot(int pos) {
        super(Constants.PlotTypes.HYDROPONIC, pos);
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
        super.setMenu();
    }

}
