package src.game.components.farmPlots;

import src.game.components.Plot;
import src.utility.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlantPlot extends Plot {
    public PlantPlot(Point point) {
        super(Constants.PlotTypes.PLANT, point);
    }
    @Override
    public void interaction(){

    }
}
