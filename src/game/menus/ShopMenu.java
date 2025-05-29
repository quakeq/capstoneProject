package game.menus;


import game.inventory.InventoryUI;
import utility.Constants;
import utility.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopMenu extends JFrame {

    JButton fertilizer = new JButton("-" + String.valueOf((int) Constants.MoneyItems.FERTILIZER.buyCost) + " gold");
    JButton seeds = new JButton("-" + String.valueOf((int) Constants.MoneyItems.SEEDS.buyCost) + " gold");
    JButton calf = new JButton("-" + String.valueOf((int) Constants.MoneyItems.CALF.buyCost) + " gold");
    JButton chicken = new JButton("-" + String.valueOf((int) Constants.MoneyItems.CHICKEN.buyCost) + " gold");
    JButton rice_seed = new JButton("-" + String.valueOf((int) Constants.MoneyItems.RICE_SEEDS.buyCost) + " gold");

    public ShopMenu(){
        this.setLayout(null);

        this.fertilizer.setBounds(50,50, 200,100);
        this.seeds.setBounds(280,50, 200,100);
        this.rice_seed.setBounds(50,150, 200,100);
        this.calf.setBounds(280, 150, 200,100);
        this.chicken.setBounds(50, 250, 200, 100);

        this.fertilizer.setIcon(new ImageIcon("src/graphics/uiImages/FERTILIZER.png"));
        this.calf.setIcon(new ImageIcon("src/graphics/uiImages/CALF.png"));
        this.chicken.setIcon(new ImageIcon("src/graphics/uiImages/CHICKEN.png"));
        this.rice_seed.setIcon(new ImageIcon("src/graphics/uiImages/RICE_SEEDS.png"));
        this.seeds.setIcon(new ImageIcon("src/graphics/uiImages/SEEDS.png"));

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
        this.rice_seed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getMoneyAmt() >= Constants.MoneyItems.RICE_SEEDS.buyCost) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.RICE_SEEDS, 1);
                    User.getUser().changeMoneyAmt(-Constants.MoneyItems.RICE_SEEDS.buyCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.RICE_SEEDS);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });
        this.calf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getMoneyAmt() >= Constants.MoneyItems.CALF.buyCost) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.CALF, 1);
                    User.getUser().changeMoneyAmt(-Constants.MoneyItems.CALF.buyCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.CALF);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });
        this.chicken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getMoneyAmt() >= Constants.MoneyItems.CHICKEN.buyCost) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.CHICKEN, 1);
                    User.getUser().changeMoneyAmt(-Constants.MoneyItems.CHICKEN.buyCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.CHICKEN);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });


        this.add(fertilizer);
        this.add(rice_seed);
        this.add(seeds);
        this.add(calf);
        this.add(chicken);
    }
}

