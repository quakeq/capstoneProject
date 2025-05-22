package game.components.inventory;

import utility.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static utility.Constants.*;

public class InventoryUI extends JPanel{

    private static InventoryUI inventoryUI;

    private JPanel itemBar;
    private JLabel seeds;
    private JLabel fishEggs;
    private JLabel fertilizer;


    private JPanel productBar;
    private JLabel wheat;
    private JLabel fish;
    private JLabel seaweed;
    private JLabel eggs;

    private Icon loadIcon(MoneyItems item){
        switch (item){
            case WHEAT -> {
                try {
                    BufferedImage img = ImageIO.read(new File("src/graphics/uiImages/WHEAT.png"));
                    return new ImageIcon(img.getScaledInstance(GraphicSizes.iconSize.width, GraphicSizes.iconSize.height, Image.SCALE_SMOOTH));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case EGGS -> {
                try {
                    BufferedImage img = ImageIO.read(new File("src/graphics/uiImages/EGG.png"));
                    return new ImageIcon(img.getScaledInstance(GraphicSizes.iconSize.width, GraphicSizes.iconSize.height, Image.SCALE_SMOOTH));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case SEEDS -> {
                try {
                    BufferedImage img = ImageIO.read(new File("src/graphics/uiImages/SEEDS.png"));
                    return new ImageIcon(img.getScaledInstance(GraphicSizes.iconSize.width, GraphicSizes.iconSize.height, Image.SCALE_SMOOTH));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case FERTILIZER -> {
                try {
                    BufferedImage img = ImageIO.read(new File("src/graphics/uiImages/FERTILIZER.png"));
                    return new ImageIcon(img.getScaledInstance(GraphicSizes.iconSize.width, GraphicSizes.iconSize.height, Image.SCALE_SMOOTH));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    public InventoryUI(){
        this.setBackground(Color.GRAY);
        this.setLayout(null);
        this.productBar = new JPanel();
        this.productBar.setBounds(10,10,600,140);
        this.productBar.setLayout(new BoxLayout(this.productBar, BoxLayout.X_AXIS));
        this.wheat = new JLabel("0",loadIcon(MoneyItems.WHEAT), SwingConstants.LEFT);
        this.eggs = new JLabel("0",loadIcon(MoneyItems.EGGS), SwingConstants.LEFT);
        this.productBar.add(this.wheat);
        this.productBar.add(this.eggs);
        this.productBar.setBorder(new LineBorder(Color.BLACK, 2)); // Set a visible border
        this.add(productBar);
    }
    public void changeUIVal(MoneyItems item){
        switch (item){
            case WHEAT -> wheat.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.WHEAT)));
            case EGGS -> eggs.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.WHEAT)));
            case SEEDS -> seeds.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.WHEAT)));
            case FERTILIZER -> fertilizer.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.WHEAT)));
        }
    }

    public static InventoryUI getInventoryUI(){
        if (inventoryUI == null){
            inventoryUI = new InventoryUI();
        }
        return inventoryUI;
    }

}
