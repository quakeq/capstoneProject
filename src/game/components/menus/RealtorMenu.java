package game.components.menus;

import core.PageSetup;
import game.components.farmPlots.EmptyPlot;
import utility.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class RealtorMenu extends JPanel {

    private JPanel[] plots = new JPanel[9];
    private JButton[] purchase = new JButton[9];
    private JButton[] swap = new JButton[9];

    private void loadPlots(JPanel plot, int plotNum){
        plot = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                Image draw = null;
                try {
                    BufferedImage img = ImageIO.read(new File("src/graphics/plotImages/EMPTY/0.png"));
                    draw = img.getScaledInstance(Constants.GraphicSizes.plotSize.width, Constants.GraphicSizes.plotSize.height, Image.SCALE_SMOOTH);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                g.drawImage(draw, 0,0, getWidth(), getHeight(), this);
            }
        };
        plot.setSize(100,100);
        this.add(plot);
    }

    public RealtorMenu(){
        
        this.setOpaque(false);
        PageSetup.getFrame().setGlassPane(this);

        this.setLayout(new GridBagLayout());

        int i = 1;
        for (JPanel plot : plots){
            loadPlots(plot, i);
        }
    }
}
