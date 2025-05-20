package game.components.farmPlots;

import game.components.Plot;
import utility.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class PlantPlot extends Plot {

    MenuItem harvest = new MenuItem("Harvest");
    MenuItem fertilizer = new MenuItem("Use Fertilizer");
    MenuItem plant = new MenuItem("Plant");

    public PlantPlot(int pos) {
        super(Constants.PlotTypes.PLANT, pos);
    }
    @Override
    public void tickUpdate(){
        super.tickUpdate();
        if (this.isDoneGrowing()){
            this.menu.add(harvest);
        }
    }
}
