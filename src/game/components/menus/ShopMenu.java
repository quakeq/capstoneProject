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

public class ShopMenu extends JFrame {

    JButton fertilizer = new JButton(String.valueOf((int)Constants.MoneyItems.FERTILIZER.buyCost)+ " gold");
    JButton seeds = new JButton(String.valueOf((int)Constants.MoneyItems.SEEDS.buyCost) + " gold");
    JButton roe = new JButton(String.valueOf((int)Constants.MoneyItems.ROE.buyCost)+ " gold");
    JButton eggs = new JButton(String.valueOf((int)Constants.MoneyItems.EGGS.buyCost)+ " gold");

    public ShopMenu(){
        this.setLayout(null);

        this.fertilizer.setBounds(50,50, 200,100);
        this.seeds.setBounds(280,50, 200,100);
        this.roe.setBounds(50,150, 200,100);
        this.eggs.setBounds(280,150, 200,100);

        this.seeds.setIcon(new ImageIcon("src/graphics/uiImages/SEEDS.png"));
        this.fertilizer.setIcon(new ImageIcon("src/graphics/uiImages/FERTILIZER.png"));
        this.roe.setIcon(new ImageIcon("src/graphics/uiImages/ROE.png"));
        this.eggs.setIcon(new ImageIcon("src/graphics/uiImages/EGGS.png"));

        this.fertilizer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getMoneyAmt() >= Constants.MoneyItems.FERTILIZER.buyCost) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.FERTILIZER, 1);
                    User.getUser().changeMoneyAmt(-Constants.MoneyItems.FERTILIZER.buyCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.FERTILIZER);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });
        this.seeds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getMoneyAmt() >= Constants.MoneyItems.SEEDS.buyCost) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.SEEDS, 1);
                    User.getUser().changeMoneyAmt(-Constants.MoneyItems.SEEDS.buyCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.SEEDS);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });
        this.roe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getMoneyAmt() >= Constants.MoneyItems.ROE.buyCost) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.ROE, 1);
                    User.getUser().changeMoneyAmt(-Constants.MoneyItems.ROE.buyCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.ROE);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });
        this.eggs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getMoneyAmt() >= Constants.MoneyItems.EGGS.buyCost) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.EGGS, 1);
                    User.getUser().changeMoneyAmt(-Constants.MoneyItems.EGGS.buyCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.EGGS);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });



        this.add(fertilizer);
        this.add(eggs);
        this.add(roe);
        this.add(seeds);
    }
}

