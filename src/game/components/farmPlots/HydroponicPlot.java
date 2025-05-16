package src.game.components.farmPlots;

import src.game.components.Plot;
import src.utility.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HydroponicPlot extends Plot {
    public HydroponicPlot(Point point) {
        super(Constants.PlotTypes.HYDROPONIC, point);
    }
    @Override
    public void interaction(){

    }
}
