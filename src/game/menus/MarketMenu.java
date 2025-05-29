package game.menus;

import game.inventory.InventoryUI;
import utility.Constants;
import utility.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarketMenu extends JFrame {
    JButton fertilizer = new JButton(String.valueOf("+" + (int) Constants.MoneyItems.FERTILIZER.sellCost) + " gold");
    JButton wheat = new JButton(String.valueOf("+" + (int)Constants.MoneyItems.WHEAT.sellCost) + " gold");
    JButton beef = new JButton(String.valueOf("+" + (int)Constants.MoneyItems.BEEF.sellCost) + " gold");
    JButton eggs = new JButton(String.valueOf("+" + (int)Constants.MoneyItems.EGGS.sellCost) + " gold");
    JButton rice = new JButton(String.valueOf("+" + (int)Constants.MoneyItems.RICE.sellCost) + " gold");
    JButton dead_chicken = new JButton(String.valueOf("+" + (int)Constants.MoneyItems.CHICKEN_BUTCHERED.sellCost) + " gold");

    public MarketMenu() {
        this.setLayout(null);

        this.fertilizer.setBounds(50, 50, 200, 100);
        this.wheat.setBounds(280, 50, 200, 100);
        this.beef.setBounds(50, 150, 200, 100);
        this.eggs.setBounds(280, 150, 200, 100);
        this.rice.setBounds(50,250, 200,100);
        this.dead_chicken.setBounds(280, 250, 200, 100);

        this.wheat.setIcon(new ImageIcon("src/graphics/uiImages/WHEAT.png"));
        this.fertilizer.setIcon(new ImageIcon("src/graphics/uiImages/FERTILIZER.png"));
        this.beef.setIcon(new ImageIcon("src/graphics/uiImages/BEEF.png"));
        this.eggs.setIcon(new ImageIcon("src/graphics/uiImages/EGGS.png"));
        this.rice.setIcon(new ImageIcon("src/graphics/uiImages/RICE.png"));
        this.dead_chicken.setIcon(new ImageIcon("src/graphics/uiImages/CHICKEN_BUTCHERED.png"));


        this.fertilizer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getItemAmt(Constants.MoneyItems.FERTILIZER) > 0) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.FERTILIZER, -1);
                    User.getUser().changeMoneyAmt(Constants.MoneyItems.FERTILIZER.sellCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.FERTILIZER);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });
        this.wheat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getItemAmt(Constants.MoneyItems.WHEAT) > 0) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.WHEAT, -1);
                    User.getUser().changeMoneyAmt(Constants.MoneyItems.WHEAT.sellCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.WHEAT);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });
        this.beef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getItemAmt(Constants.MoneyItems.BEEF) > 0) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.BEEF, -1);
                    User.getUser().changeMoneyAmt(Constants.MoneyItems.BEEF.sellCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.BEEF);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });
        this.eggs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getItemAmt(Constants.MoneyItems.EGGS) > 0) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.EGGS, -1);
                    User.getUser().changeMoneyAmt(Constants.MoneyItems.EGGS.sellCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.EGGS);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });
        this.rice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getItemAmt(Constants.MoneyItems.RICE) > 0) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.RICE, -1);
                    User.getUser().changeMoneyAmt(Constants.MoneyItems.RICE.sellCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.RICE);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });
        this.dead_chicken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (User.getUser().getItemAmt(Constants.MoneyItems.CHICKEN_BUTCHERED) > 0) {
                    User.getUser().changeItemAmt(Constants.MoneyItems.CHICKEN_BUTCHERED, -1);
                    User.getUser().changeMoneyAmt(Constants.MoneyItems.CHICKEN_BUTCHERED.sellCost);
                    InventoryUI.getInventoryUI().changeUIVal(Constants.MoneyItems.CHICKEN_BUTCHERED);
                    InventoryUI.getInventoryUI().changeUIVal(null);
                }
            }
        });


        this.add(fertilizer);
        this.add(eggs);
        this.add(beef);
        this.add(wheat);
        this.add(rice);
        this.add(dead_chicken);
    }
}
