package game.components.farmPlots;

import game.components.Plot;
import utility.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class FishPlot extends Plot {
    public FishPlot(int pos) {
        super(Constants.PlotTypes.FISH, pos);
    }
}
