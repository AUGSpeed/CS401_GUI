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
    AddressEntry x = new AddressEntry("Michael", "LaRussa", "Calaveras Expy.", "Milpitas", "California", 95035, "555-123-4567", "Example@gmail.com");


    public AddressBookGUI() {
        ab.add(x);
        setContentPane(contentPane);
        setModal(true);
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.setViewportView(new JLabel(ab.list()));
                System.out.println("Display");
            }
        });
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.setViewportView(new JLabel("New"));
                System.out.println("New");
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.setViewportView(new JLabel("Remove"));
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
