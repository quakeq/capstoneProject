import game.components.Plot;
import game.components.inventory.InventoryUI;
import utility.Constants.*;
import utility.GlobalTick;
import utility.User;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class PageSetup {

    private JFrame frame;
    private User user;
    private JPanel contentPanel;
    private JPanel uiPanel;

    public PageSetup(){
        user = User.getUser();
        frame = new JFrame("Container Example"); // Create a Frame
        contentPanel = new JPanel(null);
        uiPanel = new InventoryUI();


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        contentPanel.setBounds(new Rectangle(new Point(0,0), GraphicSizes.plotPanelSize));
        uiPanel.setBounds(new Rectangle(new Point(0,600), GraphicSizes.uiPanelSize));

        for (Plot plot : user.getPlots()){
            plot.setBounds(new Rectangle(plot.getPoint(), GraphicSizes.plotSize));
            contentPanel.add(plot);
        }

        frame.add(uiPanel);
        frame.add(contentPanel);
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

}
