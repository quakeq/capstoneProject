package core;

import game.components.Plot;
import game.components.inventory.InventoryUI;
import game.components.shopPlots.Land;
import game.components.shopPlots.Market;
import game.components.shopPlots.Shop;
import utility.Constants.*;
import utility.GlobalTick;
import utility.User;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class PageSetup {

    private static JFrame frame;
    private User user;
    private JPanel uiPanel;
    private Land land;
    private Shop shop;
    private Market market;

    public PageSetup(){
        user = User.getUser();
        uiPanel = InventoryUI.getInventoryUI();
        frame = PageSetup.getFrame();
        land = new Land();
        shop = new Shop();
        market = new Market();


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        uiPanel.setBounds(new Rectangle(new Point(0,620), GraphicSizes.uiPanelSize));

        for (Plot plot : user.getFarmPlots()){
            plot.setBounds(new Rectangle(plot.getPoint(), GraphicSizes.plotSize));
            frame.add(plot);
        }

        land.setBounds(new Rectangle(land.getPoint(), GraphicSizes.plotSize));
        frame.add(land);

        shop.setBounds(new Rectangle(shop.getPoint(), GraphicSizes.plotSize));
        frame.add(shop);

        market.setBounds(new Rectangle(market.getPoint(), GraphicSizes.plotSize));
        frame.add(market);

        frame.add(uiPanel);
        frame.setSize(GraphicSizes.windowMinSize);// Set the size of the frame

        frame.setVisible(true);



        java.util.Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                fastUpdate();
            }
        }, 0, 100);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                slowUpdate();
            }
        }, 0, 3000);
    }

    public void slowUpdate(){
        GlobalTick.growUpdate();
        frame.repaint();
    }

    public void fastUpdate(){
        GlobalTick.statusUpdate();
        frame.repaint();
    }
    public static JFrame getFrame(){
        if (frame == null){
            frame = new JFrame("Container Example"); // Create a Frame
        }
        return frame;
    }

}
