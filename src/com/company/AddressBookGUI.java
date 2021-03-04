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
    JList <AddressEntry> addressEntryJList = new JList<AddressEntry>();
    DefaultListModel<AddressEntry> myaddressEntryListModel = new DefaultListModel<AddressEntry>();
    AddressBook ab = new AddressBook();


    public AddressBookGUI() {
        setContentPane(contentPane);
        setModal(true);


        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myaddressEntryListModel = new DefaultListModel<AddressEntry>();
                for(int i = 0; i<ab.addressEntryList.size(); i++)
                {  myaddressEntryListModel.add(i, ab.addressEntryList.elementAt(i)); }
                addressEntryJList = new JList<AddressEntry>(myaddressEntryListModel);
                addressEntryJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                addressEntryJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                addressEntryJList.setVisibleRowCount(-1);
                scrollPane.setViewportView(addressEntryJList);

            }
        });
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewGUI newGUI = new NewGUI(ab);
                newGUI.pack();
                newGUI.setVisible(true);

                //Display
                myaddressEntryListModel = new DefaultListModel<AddressEntry>();
                for(int i = 0; i<ab.addressEntryList.size(); i++)
                {  myaddressEntryListModel.add(i, ab.addressEntryList.elementAt(i)); }
                addressEntryJList = new JList<AddressEntry>(myaddressEntryListModel);
                addressEntryJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                addressEntryJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                addressEntryJList.setVisibleRowCount(-1);
                scrollPane.setViewportView(addressEntryJList);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer index = addressEntryJList.getSelectedIndex();
                ab.addressEntryList.removeElementAt(index);

                //Display
                myaddressEntryListModel = new DefaultListModel<AddressEntry>();
                for(int i = 0; i<ab.addressEntryList.size(); i++)
                {  myaddressEntryListModel.add(i, ab.addressEntryList.elementAt(i)); }
                addressEntryJList = new JList<AddressEntry>(myaddressEntryListModel);
                addressEntryJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                addressEntryJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                addressEntryJList.setVisibleRowCount(-1);
                scrollPane.setViewportView(addressEntryJList);
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
