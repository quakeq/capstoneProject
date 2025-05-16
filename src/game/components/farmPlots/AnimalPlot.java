package game.components.farmPlots;

import game.components.Plot;
import utility.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AnimalPlot extends Plot {
    public AnimalPlot(int pos) {
        super(Constants.PlotTypes.ANIMAL, pos);
    }
}
