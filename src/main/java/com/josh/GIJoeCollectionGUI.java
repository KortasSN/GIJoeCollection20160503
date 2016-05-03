package com.josh;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kortasthekiller on 4/22/16.
 */
public class GIJoeCollectionGUI extends JFrame {
    private JPanel rootPanel;
    private JLabel yearLabel;
    private JComboBox yearComboBox;
    private JButton submitButton;

    protected GIJoeCollectionGUI() {
        this.setContentPane(rootPanel);
        configureYear();
        configureButton();

        pack();
        setVisible(true);
    }
    //make change for git
    private void configureButton() {
        submitButton.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                String year = (String)yearComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(GIJoeCollectionGUI.this, year);
            }
        });
    }

    private void configureYear() {
        for (int x = 1982 ; x <=1994 ; x++) {
            yearComboBox.addItem(x);
        }
    }
}
