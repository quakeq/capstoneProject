import game.components.Plot;
import game.components.farmPlots.EmptyPlot;
import game.components.farmPlots.PlantPlot;
import utility.Constants;
import utility.Constants.*;
import utility.GlobalTick;
import utility.User;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;


public class PageSetup {

    private JFrame frame;
    private User user;
    private JPanel contentPanel;

    public PageSetup(){
        user = User.getUser();
        frame = new JFrame("Container Example"); // Create a Frame
        contentPanel = new JPanel(null);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        contentPanel.setBounds(new Rectangle(new Point(0,0), GraphicSizes.windowMinSize));



        for (Plot plot : user.getPlots()){
            plot.setBounds(new Rectangle(plot.getPoint(), GraphicSizes.plotSize));

            JPopupMenu popupMenu = new JPopupMenu();

            JMenuItem item2 = new JMenuItem("Option 2");

            item2.addActionListener(e -> System.out.println(plot.getName()));

            popupMenu.add(item2);

            plot.addMouseListener(new MouseAdapter() {
              public void mouseReleased(MouseEvent e) {
                  if (e.isPopupTrigger()) {
                      popupMenu.show(e.getComponent(), e.getX(), e.getY());
                  }
              }
            });
            contentPanel.add(plot);
        }

        frame.add(contentPanel);
        frame.setSize(GraphicSizes.windowMinSize);// Set the size of the frame
        frame.setVisible(true);

        java.util.Timer timer = new Timer();

        // Schedule the task to run every 1000 milliseconds (1 second)
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, 3000);
    }

    public void update(){
        GlobalTick.tickUpdate();
        frame.repaint();
    }

}
