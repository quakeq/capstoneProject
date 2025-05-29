package game.shopPlots;

import game.Plot;
import game.menus.ShopMenu;
import utility.Constants;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Shop extends Plot {

    private ShopMenu menu;

    public Shop() {
        super(Constants.PlotTypes.SHOP, 10);
        this.menu = new ShopMenu();

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
