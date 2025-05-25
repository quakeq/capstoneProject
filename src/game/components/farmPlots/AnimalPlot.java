package game.components.farmPlots;

import game.components.Plot;
import utility.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class AnimalPlot extends Plot {

    JMenuItem harvest = new JMenuItem("Collect");
    JMenuItem feed = new JMenuItem("Feed Chickens");
    JMenuItem placeEgg = new JMenuItem("Place Egg");

    public AnimalPlot(int pos) {
        super(Constants.PlotTypes.ANIMAL, pos);
    }
    @Override
    public void setMenu(){

    }
}
