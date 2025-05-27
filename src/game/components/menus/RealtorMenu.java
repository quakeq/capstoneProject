package game.components.menus;

import game.components.inventory.InventoryUI;
import utility.Constants;
import utility.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class RealtorMenu extends JFrame {


    private final Point[] points = {
            new Point(20,20), new Point(220,20), new Point(420,20),
            new Point(20, 200), new Point(220, 200), new Point(420, 200),
            new Point(20, 400), new Point(220, 400), new Point(420, 400)
    };

    private iconPlots[] plots = new iconPlots[9];

    public double plotCost = Constants.GameConstants.startMoney;


    public RealtorMenu(){
        this.setLayout(null);


        for (int i = 0; i < plots.length; i++){
            plots[i] = new iconPlots(i);
            this.add(plots[i]);
        }
    }

    private void updateIcons(){
        for (iconPlots plot : plots){
            plot.purchase.setText("Buy Plot: " + (int) plotCost);
            plot.purchase.repaint();
        }
    }

    private class iconPlots extends JPanel{

        JButton purchase = new JButton("Buy Plot: " + (int) plotCost);
        JButton plant = new JButton("Plant");
        JButton fish = new JButton("Fish");
        JButton hydroponics = new JButton("Hydroponic");
        JButton chicken = new JButton("Chicken");

        public iconPlots(int point){
            this.setBounds(new Rectangle(points[point], new Dimension(200,200)));
            this.setLayout(null);


            this.purchase.setBounds(15,65, 120,20);

            this.plant.setBounds(25,20, 100,20);
            this.fish.setBounds(25,50, 100,20);
            this.hydroponics.setBounds(25,80, 100,20);
            this.chicken.setBounds(25, 110, 100, 20);

            this.purchase.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (User.getUser().getMoneyAmt() >= plotCost) {
                        iconPlots.super.remove(purchase);
                        iconPlots.super.add(plant);
                        iconPlots.super.add(fish);
                        iconPlots.super.add(hydroponics);
                        iconPlots.super.add(chicken);
                        iconPlots.super.update(getGraphics());
                        User.getUser().changeMoneyAmt(-plotCost);
                        InventoryUI.getInventoryUI().changeUIVal(null);
                        updateCost();
                    }
                }
            });

                this.plant.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        User.getUser().setPlot(point, Constants.PlotTypes.WHEAT);
                    }
                });
                this.fish.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        User.getUser().setPlot(point, Constants.PlotTypes.COW);
                    }
                });
                this.hydroponics.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        User.getUser().setPlot(point, Constants.PlotTypes.RICE);
                    }
                });
                this.chicken.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        User.getUser().setPlot(point, Constants.PlotTypes.CHICKEN);
                    }
                });

            this.add(purchase);
        }

        public void updateCost(){
            plotCost += 100;
            updateIcons();
        }



        @Override
        public void paintComponent(Graphics g){
            Image draw = null;
            try {
                BufferedImage img = ImageIO.read(new File("src/graphics/plotImages/EMPTY/0.png"));
                draw = img.getScaledInstance(Constants.GraphicSizes.menuIconSize.width, Constants.GraphicSizes.menuIconSize.height, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(draw, 0,0, Constants.GraphicSizes.menuIconSize.width, Constants.GraphicSizes.menuIconSize.height, this);
        }




    }
}
