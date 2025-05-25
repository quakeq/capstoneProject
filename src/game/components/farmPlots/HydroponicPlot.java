package game.components.farmPlots;

import game.components.Plot;
import utility.Constants;

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

    }
}
