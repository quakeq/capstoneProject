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


    private JLabel gold;

    private JPanel upgrades;


    private JPanel itemBar;
    private JLabel seeds;
    private JLabel rice_seeds;
    private JLabel fertilizer;
    private JLabel chicken;
    private JLabel calf;

    private JPanel productBar;
    private JLabel wheat;
    private JLabel beef;
    private JLabel rice;
    private JLabel eggs;
    private JLabel butchered_chicken;

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
        this.productBar.setBounds(10,10,400,120);

        this.productBar.setLayout(new BoxLayout(this.productBar, BoxLayout.X_AXIS));

        this.wheat = new JLabel("0",loadIcon(MoneyItems.WHEAT), SwingConstants.LEFT);
        this.eggs = new JLabel("0",loadIcon(MoneyItems.EGGS), SwingConstants.LEFT);
        this.beef = new JLabel("0", loadIcon(MoneyItems.BEEF), SwingConstants.LEFT);
        this.rice = new JLabel("0", loadIcon(MoneyItems.RICE), SwingConstants.LEFT);
        this.butchered_chicken = new JLabel("0", loadIcon(MoneyItems.CHICKEN_BUTCHERED), SwingConstants.LEFT);

        this.productBar.add(this.wheat);
        this.productBar.add(this.eggs);
        this.productBar.add(this.beef);
        this.productBar.add(this.rice);
        this.productBar.add(this.butchered_chicken);

        this.productBar.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(this.productBar);

        this.itemBar = new JPanel();
        this.itemBar.setBounds(430,10,480,120);

        this.itemBar.setBackground(Color.pink);
        this.itemBar.setLayout(new BoxLayout(this.itemBar, BoxLayout.X_AXIS));

        this.gold = new JLabel("0", new ImageIcon("src/graphics/uiImages/GOLD.png"), SwingConstants.LEFT);
        this.seeds = new JLabel("0", loadIcon(MoneyItems.SEEDS), SwingConstants.LEFT);
        this.fertilizer = new JLabel("0", loadIcon(MoneyItems.FERTILIZER), SwingConstants.LEFT);
        this.rice_seeds = new JLabel("0", loadIcon(MoneyItems.RICE_SEEDS), SwingConstants.LEFT);
        this.calf = new JLabel("0", loadIcon(MoneyItems.CALF), SwingConstants.LEFT);
        this.chicken = new JLabel("0", loadIcon(MoneyItems.CHICKEN), SwingConstants.LEFT);

        for (MoneyItems item : MoneyItems.values()){
            changeUIVal(item);
        }
        changeUIVal(null);

        this.itemBar.add(this.gold);
        this.itemBar.add(this.seeds);
        this.itemBar.add(this.fertilizer);
        this.itemBar.add(this.rice_seeds);
        this.itemBar.add(this.calf);
        this.itemBar.add(this.chicken);

        this.itemBar.setBorder(new LineBorder(Color.BLACK, 2));
        this.add(this.itemBar);
    }
    public void changeUIVal(MoneyItems item){
        switch (item){
            case WHEAT -> wheat.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.WHEAT)));
            case EGGS -> eggs.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.EGGS)));
            case SEEDS -> seeds.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.SEEDS)));
            case FERTILIZER -> fertilizer.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.FERTILIZER)));
            case RICE -> rice.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.RICE)));
            case RICE_SEEDS -> rice_seeds.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.RICE_SEEDS)));
            case CALF -> calf.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.CALF)));
            case BEEF -> beef.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.BEEF)));
            case CHICKEN -> chicken.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.CHICKEN)));
            case CHICKEN_BUTCHERED -> butchered_chicken.setText(String.valueOf(User.getUser().getItemAmt(MoneyItems.CHICKEN_BUTCHERED)));
            case null, default -> gold.setText(String.valueOf(User.getUser().getMoneyAmt()));
        }
    }

    public static InventoryUI getInventoryUI(){
        if (inventoryUI == null){
            inventoryUI = new InventoryUI();
        }
        return inventoryUI;
    }

}
