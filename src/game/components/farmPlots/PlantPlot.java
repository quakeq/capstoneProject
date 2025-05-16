package game.components.farmPlots;

import game.components.Plot;
import utility.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class PlantPlot extends Plot {

    JMenuItem harvest = new JMenuItem("Harvest");
    JMenuItem fertilizer = new JMenuItem("Use Fertilizer");
    JMenuItem plant = new JMenuItem("Plant");


    public PlantPlot(int pos) {
        super(Constants.PlotTypes.PLANT, pos);
    }
    @Override
    public void tickUpdate(){
        if (this.isDoneGrowing()){

        }

        super.tickUpdate();

    }
}
