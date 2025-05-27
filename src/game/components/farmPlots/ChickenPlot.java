package game.components.farmPlots;

import game.components.Plot;
import utility.Constants;

import javax.swing.*;

public class ChickenPlot extends Plot {

    JMenuItem harvest = new JMenuItem("Collect");
    JMenuItem feed = new JMenuItem("Feed Chickens");
    JMenuItem placeEgg = new JMenuItem("Place Egg");

    public ChickenPlot(int pos) {
        super(Constants.PlotTypes.CHICKEN, pos);
    }
    @Override
    public void setMenu(){

    }
}
