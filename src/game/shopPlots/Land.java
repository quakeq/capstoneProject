package game.shopPlots;

import game.Plot;
import game.menus.RealtorMenu;
import utility.Constants;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Land extends Plot {

    private final RealtorMenu menu;

    private boolean hasEntered;

    public Land() {
        super(Constants.PlotTypes.REALTOR, 9);
        this.menu = new RealtorMenu();

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
