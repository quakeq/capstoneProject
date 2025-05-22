package game.components.inventory;

import utility.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static utility.Constants.*;

public class InventoryUI extends JPanel{

    private JPanel itemBar;

    private JLabel seeds;

    private JLabel fishEggs;

    private JLabel fertilizer;


    private JPanel productBar;


    private JLabel wheat;

    private Image loadImage(MoneyItems item){
        switch (item){
            case WHEAT -> {
                try {
                    BufferedImage img = ImageIO.read(new File("src/graphics/uiImages/WHEAT.png"));
                    return img.getScaledInstance(GraphicSizes.plotSize.width, GraphicSizes.plotSize.height, Image.SCALE_SMOOTH);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case EGGS -> {
                try {
                    BufferedImage img = ImageIO.read(new File("src/graphics/uiImages/EGG.png"));
                    return img.getScaledInstance(GraphicSizes.plotSize.width, GraphicSizes.plotSize.height, Image.SCALE_SMOOTH);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case SEEDS -> {
                try {
                    BufferedImage img = ImageIO.read(new File("src/graphics/uiImages/SEEDS.png"));
                    return img.getScaledInstance(GraphicSizes.plotSize.width, GraphicSizes.plotSize.height, Image.SCALE_SMOOTH);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case FERTILIZER -> {
                try {
                    BufferedImage img = ImageIO.read(new File("src/graphics/uiImages/FERTILIZER.png"));
                    return img.getScaledInstance(GraphicSizes.plotSize.width, GraphicSizes.plotSize.height, Image.SCALE_SMOOTH);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private JLabel seaweed;

    private JLabel fish;



    public InventoryUI(){
        this.itemBar = new JPanel();
        this.itemBar.setLayout(new BoxLayout(itemBar, BoxLayout.Y_AXIS));
        this.itemBar.setBounds(new Rectangle(1000,0,50,50));
        this.seeds = new JLabel("0", new ImageIcon(Objects.requireNonNull(loadImage(MoneyItems.WHEAT))), SwingConstants.CENTER);
//        this.seeds = new JLabel("0", new ImageIcon(Objects.requireNonNull(loadImage(MoneyItems.SEEDS))), SwingConstants.CENTER);
        this.itemBar.add(seeds);
        this.add(itemBar);
    }
    public void changeUIVal(){
        seeds.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.SEEDS)));
    }

}
