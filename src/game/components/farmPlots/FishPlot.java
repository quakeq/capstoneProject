package src.game.components.farmPlots;

import src.game.components.Plot;
import src.utility.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class FishPlot extends Plot {
    public FishPlot(Point point) {
        super(Constants.PlotTypes.FISH, point);
    }
    @Override
    public void interaction(){

    }
}
