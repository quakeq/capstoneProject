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

    private JPanel upgrades;


    private JPanel itemBar;
    private JLabel seeds;
    private JLabel fertilizer;

    private JPanel productBar;
    private JLabel wheat;
    private JLabel fish;
    private JLabel seaweed;
    private JLabel eggs;
    private JLabel roe;

    private Icon loadIcon(MoneyItems item){
        try {
            BufferedImage img = ImageIO.read(new File("src/graphics/uiImages/" + item.toString() + ".png"));
            return new ImageIcon(img.getScaledInstance(GraphicSizes.iconSize.width, GraphicSizes.iconSize.height, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public InventoryUI(){
        this.setBackground(Color.GRAY);
        this.setLayout(null);

        this.productBar = new JPanel();
        this.productBar.setBounds(10,10,320,120);


        this.productBar.setLayout(new BoxLayout(this.productBar, BoxLayout.X_AXIS));

        this.wheat = new JLabel("0",loadIcon(MoneyItems.WHEAT), SwingConstants.LEFT);
        this.eggs = new JLabel("0",loadIcon(MoneyItems.EGGS), SwingConstants.LEFT);
        this.seaweed = new JLabel("0", loadIcon(MoneyItems.SEAWEED), SwingConstants.LEFT);
        this.roe = new JLabel("0", loadIcon(MoneyItems.ROE), SwingConstants.LEFT);

        this.productBar.add(this.wheat);
        this.productBar.add(this.eggs);
        this.productBar.add(this.seaweed);
        this.productBar.add(this.roe);

        this.productBar.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(this.productBar);

        this.itemBar = new JPanel();
        this.itemBar.setBounds(350,10,320,120);

        this.itemBar.setBackground(Color.pink);
        this.itemBar.setLayout(new BoxLayout(this.itemBar, BoxLayout.X_AXIS));

        this.seeds = new JLabel("0",loadIcon(MoneyItems.SEEDS), SwingConstants.LEFT);
        this.fertilizer = new JLabel("0",loadIcon(MoneyItems.FERTILIZER), SwingConstants.LEFT);

        for (MoneyItems item : MoneyItems.values()){
            changeUIVal(item);
        }

        this.itemBar.add(this.seeds);
        this.itemBar.add(this.fertilizer);

        this.itemBar.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(this.itemBar);
    }
    public void changeUIVal(MoneyItems item){
        switch (item){
            case WHEAT -> wheat.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.WHEAT)));
            case EGGS -> eggs.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.EGGS)));
            case SEEDS -> seeds.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.SEEDS)));
            case FERTILIZER -> fertilizer.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.FERTILIZER)));
            case ROE -> roe.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.ROE)));
            case SEAWEED -> seaweed.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.SEAWEED)));
        }
    }

    public static InventoryUI getInventoryUI(){
        if (inventoryUI == null){
            inventoryUI = new InventoryUI();
        }
        return inventoryUI;
    }

}
