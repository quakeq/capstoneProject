package game.components.shopPlots;

import game.components.Plot;
import game.components.menus.MarketMenu;
import game.components.menus.RealtorMenu;
import utility.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Market extends Plot {

    private MarketMenu menu;

    public Market() {
        super(Constants.PlotTypes.MARKET, 11);
        this.menu = new MarketMenu();

        this.menu.setBounds(new Rectangle(new Point(300,100), new Dimension(600,600)));
        this.menu.setResizable(false);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menu.setVisible(true);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }



}
