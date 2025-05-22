package game.components.inventory;

import utility.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
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
    private JLabel fish;
    private JLabel seaweed;
    private JLabel eggs;

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




    public InventoryUI(){
        this.setBackground(Color.BLUE);
        this.setLayout(null);
        this.itemBar = new JPanel();
        this.itemBar.setBounds(0,0,100,100);
        this.itemBar.setBackground(Color.CYAN);
        this.itemBar.setBorder(new LineBorder(Color.BLACK, 2)); // Set a visible border
        this.add(itemBar);
    }
    public void changeUIVal(){
        seeds.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.SEEDS)));
    }

}
