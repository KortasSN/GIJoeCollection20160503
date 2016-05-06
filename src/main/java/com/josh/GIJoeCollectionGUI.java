package com.josh;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by kortasthekiller on 4/22/16.
 */
public class GIJoeCollectionGUI extends JFrame {
    private JPanel rootPanel;
    private JLabel yearLabel;
    private JComboBox yearComboBox;
    private JButton yearSubmitButton;
    private JComboBox nameComboBox;
    private JButton nameSubmitButton;
    private JCheckBox acc1CheckBox;
    private JCheckBox acc2CheckBox;
    private JCheckBox acc3CheckBox;
    private JCheckBox acc4CheckBox;
    private JCheckBox acc5CheckBox;
    private JCheckBox acc6CheckBox;
    private JCheckBox acc7CheckBox;
    private JCheckBox acc8CheckBox;
    private JCheckBox acc9CheckBox;
    private JCheckBox acc10CheckBox;
    private Main mainDatabase;

    protected GIJoeCollectionGUI(Main database) {
        this.mainDatabase = database;  //todo maybe rename things
        this.setContentPane(rootPanel);
        configureYear();
        configureButton();

        pack();
        setVisible(true);
        buttonConfig();


    }
    //make change for git
    private void configureButton() {
        yearSubmitButton.addActionListener(new ActionListener() {
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

    public void buttonConfig() {

        //YEAR submit button//
        yearSubmitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                for (int x = 1982; x <= 1994; x++) {
                    yearComboBox.addItem(x);
                    String yearSelected = (String) yearComboBox.getSelectedItem();
                    ArrayList names = mainDatabase.requestNamesForYear(yearSelected);
                }
            }
            });


        //NAME submit button//
        nameSubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });


    }
}
