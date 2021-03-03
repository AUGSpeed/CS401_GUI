package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddressBookGUI extends JDialog{
    private JPanel contentPane;
    private JButton displayButton;
    private JButton removeButton;
    private JButton newButton;
    private JScrollPane scrollPane;
    AddressBook ab = new AddressBook();

    public AddressBookGUI() {
        setContentPane(contentPane);
        setModal(true);
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Display");
            }
        });
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("New");
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Remove");
            }
        });
    }

    public static void main(String[] args) {
        AddressBookGUI dialog = new AddressBookGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
