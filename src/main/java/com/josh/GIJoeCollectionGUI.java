package com.josh;

import com.sun.beans.decoder.ValueObject;
import org.omg.CORBA.portable.ValueOutputStream;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
    private JButton submitChangesButton;
    private Main mainDatabase;
    private boolean hasAcc1;
    private boolean hasAcc2;
    private boolean hasAcc3;
    private boolean hasAcc4;
    private boolean hasAcc5;
    private boolean hasAcc6;
    private boolean hasAcc7;
    private boolean hasAcc8;
    private boolean hasAcc9;
    private boolean hasAcc10;




    protected GIJoeCollectionGUI(Main database) {
        this.mainDatabase = database;  //todo maybe rename things
        this.setContentPane(rootPanel);
        configureYear();
        configureButton();

        pack();
        setVisible(true);
        buttonConfig();
        //accConfig(accHash);


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
            yearComboBox.addItem(x + "");   //hack to convert the number to a String

        }

  }
        //todo put name in after retrieving from database//
    private void configureNames(ArrayList namesFromYear) {
           for (int y = 0; y < namesFromYear.size(); y++) {

               //String namesFromYearName = namesFromYear(y);
               nameComboBox.addItem(namesFromYear.get(y));
           }
        }

    public void buttonConfig() {

        //YEAR submit button//
        yearSubmitButton.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
//                            for (int x = 1982; x <= 1994; x++) {
//                                yearComboBox.addItem(x);
                                String yearSelected = String.valueOf(yearComboBox.getSelectedItem());
                                ArrayList names = null;
                                try {
                                    names = mainDatabase.requestNamesForYear(yearSelected);
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                                configureNames(names);
                }
                //sent to configure names for names combobox
//                            }
            });


        //NAME submit button//
        nameSubmitButton.addActionListener(new ActionListener() {
                                               public void actionPerformed(ActionEvent e) {
                                                   String nameChosen = (String) nameComboBox.getSelectedItem();
                                                   String yearSelected = (String) yearComboBox.getSelectedItem();
                                                   HashMap<String, Boolean> accessories = null;
                                                   HashMap testHash = null;
                                                   try {
                                                       //accessories =
                                                       testHash = mainDatabase.requestAccessoriesForName(nameChosen, yearSelected);
                                                   } catch (SQLException e2) {
                                                       e2.printStackTrace();
                                                   }

                                                   //setting the accessories text information//

                                                   System.out.println(testHash);


                                                   Iterator iterator = testHash.keySet().iterator();
                                                   int y = testHash.size();
                                                   int z = 0;
                                                   //while (iterator.hasNext()) {
                                                   //String key1 = testHash.get()
                                                   // for (int y = 1; y < testHash.size(); y++) {
                                                   if (z >= y) {
                                                       acc1CheckBox.setText("NA");
                                                   } else {
                                                       String key = (String) iterator.next();
                                                       acc1CheckBox.setText(key);
                                                   }
                                                   z++;
                                                   if (z >= y) {
                                                       acc2CheckBox.setText("NA");
                                                   } else {
                                                       String key = (String) iterator.next();
                                                       acc2CheckBox.setText(key);
                                                   }
                                                   z++;
                                                   if (z >= y) {
                                                       acc3CheckBox.setText("NA");
                                                   } else {
                                                       String key = (String) iterator.next();
                                                       acc3CheckBox.setText(key);
                                                   }
                                                   z++;        //String key1 = testHash.keySet().toString();
                                                   if (z >= y) {
                                                       acc4CheckBox.setText("NA");
                                                   } else {
                                                       String key = (String) iterator.next();
                                                       acc4CheckBox.setText(key);
                                                   }
                                                   z++;
                                                   if (z >= y) {
                                                       acc5CheckBox.setText("NA");
                                                   } else {
                                                       String key = (String) iterator.next();
                                                       acc5CheckBox.setText(key);
                                                   }
                                                   z++;
                                                   if (z >= y) {
                                                       acc6CheckBox.setText("NA");
                                                   } else {
                                                       String key = (String) iterator.next();
                                                       acc6CheckBox.setText(key);
                                                   }
                                                   z++;
                                                   if (z >= y) {
                                                       acc7CheckBox.setText("NA");
                                                   } else {
                                                       String key = (String) iterator.next();
                                                       acc7CheckBox.setText(key);
                                                   }
                                                   z++;
                                                   if (z >= y) {
                                                       acc8CheckBox.setText("NA");
                                                   } else {
                                                       String key = (String) iterator.next();
                                                       acc8CheckBox.setText(key);
                                                   }
                                                   z++;
                                                   if (z >= y) {
                                                       acc9CheckBox.setText("NA");
                                                   } else {
                                                       String key = (String) iterator.next();
                                                       acc9CheckBox.setText(key);
                                                   }
                                                   z++;
                                                   if (z >= y) {
                                                       acc10CheckBox.setText("NA");
                                                   } else {
                                                       String key = (String) iterator.next();
                                                       acc10CheckBox.setText(key);
                                                   }
                                                   z++;
//
//                    key = (String) iterator.next();
//                    acc3CheckBox.setText(key);
//                    key = (String) iterator.next();
//                    acc4CheckBox.setText(key);
//                    key = (String) iterator.next();
//                    acc5CheckBox.setText(key);
//
//                    boolean value = (boolean) testHash.get(key);
//                    System.out.println(key + " " + value);


                                                   acc1CheckBox.addItemListener(new ItemListener() {
                                                       @Override
                                                       public void itemStateChanged(ItemEvent e) {
                                                           hasAcc1 = acc1CheckBox.isSelected();
                                                       }
                                                   });

                                                    acc2CheckBox.addItemListener(new ItemListener() {
                                                        @Override
                                                        public void itemStateChanged(ItemEvent e) {
                                                            hasAcc2 = acc2CheckBox.isSelected();
                                                          }
                                                     });
                                                   acc3CheckBox.addItemListener(new ItemListener() {
                                                       @Override
                                                       public void itemStateChanged(ItemEvent e) {
                                                           hasAcc3 = acc3CheckBox.isSelected();
                                                       }
                                                   });

                                                   acc4CheckBox.addItemListener(new ItemListener() {
                                                       @Override
                                                       public void itemStateChanged(ItemEvent e) {
                                                           hasAcc4 = acc4CheckBox.isSelected();
                                                       }
                                                   });

                                                   acc5CheckBox.addItemListener(new ItemListener() {
                                                       @Override
                                                       public void itemStateChanged(ItemEvent e) {
                                                           hasAcc5 = acc5CheckBox.isSelected();
                                                       }
                                                   });

                                                   acc6CheckBox.addItemListener(new ItemListener() {
                                                       @Override
                                                       public void itemStateChanged(ItemEvent e) {
                                                           hasAcc6 = acc6CheckBox.isSelected();
                                                       }
                                                   });

                                                   acc7CheckBox.addItemListener(new ItemListener() {
                                                       @Override
                                                       public void itemStateChanged(ItemEvent e) {
                                                           hasAcc7 = acc7CheckBox.isSelected();
                                                       }
                                                   });

                                                   acc8CheckBox.addItemListener(new ItemListener() {
                                                       @Override
                                                       public void itemStateChanged(ItemEvent e) {
                                                           hasAcc8 = acc8CheckBox.isSelected();
                                                       }
                                                   });

                                                   acc9CheckBox.addItemListener(new ItemListener() {
                                                       @Override
                                                       public void itemStateChanged(ItemEvent e) {
                                                           hasAcc9 = acc9CheckBox.isSelected();
                                                       }
                                                   });
                                                   acc10CheckBox.addItemListener(new ItemListener() {
                                                       @Override
                                                       public void itemStateChanged(ItemEvent e) {
                                                           hasAcc10 = acc10CheckBox.isSelected();
                                                       }
                                                   });

                                                   final HashMap finalTestHash = testHash;
                                                   submitChangesButton.addActionListener(new ActionListener() {
                                                       @Override
                                                       public void actionPerformed(ActionEvent e) {
                                                           if (hasAcc1 == true) {
                                                               String acc1Text = acc1CheckBox.getText();
                                                               finalTestHash.put(acc1Text, true);
                                                           }
                                                               if (hasAcc2 == true) {
                                                               String acc2Text = acc2CheckBox.getText();
                                                               finalTestHash.put(acc2Text, true);

                                                           }
                                                           if (hasAcc3 == true) {
                                                               String acc3Text = acc3CheckBox.getText();
                                                               finalTestHash.put(acc3Text, true);

                                                           }
                                                           if (hasAcc4 == true) {
                                                               String acc4Text = acc4CheckBox.getText();
                                                               finalTestHash.put(acc4Text, true);

                                                           }
                                                           if (hasAcc5 == true) {
                                                               String acc5Text = acc5CheckBox.getText();
                                                               finalTestHash.put(acc5Text, true);

                                                           }
                                                           if (hasAcc6 == true) {
                                                               String acc6Text = acc6CheckBox.getText();
                                                               finalTestHash.put(acc6Text, true);

                                                           }
                                                           if (hasAcc7 == true) {
                                                               String acc7Text = acc7CheckBox.getText();
                                                               finalTestHash.put(acc7Text, true);

                                                           }
                                                           if (hasAcc8 == true) {
                                                               String acc8Text = acc8CheckBox.getText();
                                                               finalTestHash.put(acc8Text, true);

                                                           }
                                                           if (hasAcc9 == true) {
                                                               String acc9Text = acc9CheckBox.getText();
                                                               finalTestHash.put(acc9Text, true);

                                                           }
                                                           if (hasAcc10 == true) {
                                                               String acc10Text = acc10CheckBox.getText();
                                                               finalTestHash.put(acc10Text, true);

                                                           }
                                                           JOptionPane.showMessageDialog(GIJoeCollectionGUI.this, "Confirm Changes");
                                                       }
                                                   });
                                               }


        });
    }
}


