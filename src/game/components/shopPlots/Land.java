package game.components.shopPlots;

import core.PageSetup;
import game.components.Plot;
import game.components.menus.RealtorMenu;
import utility.Constants;

import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Land extends Plot {

    private final RealtorMenu menu;

    private boolean hasEntered;

    public Land() {
        super(Constants.PlotTypes.REALTOR, 9);
        this.menu = new RealtorMenu();

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (hasEntered){
                    PageSetup.getFrame().getGlassPane().setVisible(true);
                } else {
                    PageSetup.getFrame().getGlassPane().setVisible(false);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                hasEntered = true;
            }
            @Override
            public void mouseExited(MouseEvent e) {
                hasEntered = false;
            }
        });
    }

}
