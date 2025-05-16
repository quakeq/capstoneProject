package src.game.components.shopPlots;

import src.game.components.Plot;
import src.utility.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Market extends Plot {
    public Market(Point point) {
        super(Constants.PlotTypes.MARKET, point);
    }
    @Override
    public void interaction(){

    }
}
