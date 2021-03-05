package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

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

        //button for listing in JList
        //should call the address book class's list method and not directly
        // list from the database here
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin" +
                                    ":@adcsdb01.csueastbay.edu:1521:mcspdb.ad.csueastbay.edu"
                            , "MCS1018", "y_WrlhyT");
                   Statement stmt = conn.createStatement();
                   ResultSet rs = stmt.executeQuery("select * from " +
                           "ADDRESSENTRYTABLE");
                   int i = 0;
                    myaddressEntryListModel = new DefaultListModel<AddressEntry>();
                    while(rs.next()){
                       AddressEntry entry = new AddressEntry(rs.getString(1),
                               rs.getString(2),rs.getString(3),rs.getString(4),
                               rs.getString(5), rs.getInt(6), rs.getString(7),
                               rs.getString(8));

                       myaddressEntryListModel.add(i, entry);
                       ab.add(entry);
                       i++;

                   }
                    conn.close();
                }
                catch(Exception err){System.out.println(err);}

                addressEntryJList = new JList<AddressEntry>(myaddressEntryListModel);
                addressEntryJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                addressEntryJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                addressEntryJList.setVisibleRowCount(-1);
                scrollPane.setViewportView(addressEntryJList);
            }
        });

        //button for adding an element
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

        //button for removing an element
        //should remove element from database in addressBook method not here
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer index = addressEntryJList.getSelectedIndex();
               // ab.addressEntryList.removeElementAt(index);
                System.out.println(index);
                //remove from database
                try{
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin" +
                                    ":@adcsdb01.csueastbay.edu:1521:mcspdb.ad.csueastbay.edu"
                            , "MCS1018", "y_WrlhyT");

                    PreparedStatement stmt = conn.prepareStatement("DELETE " +
                            "FROM ADDRESSENTRYTABLE WHERE FIRST_NAME = ?");
                    stmt.setString(1,
                            ab.addressEntryList.get(index).firstName);
                    stmt.executeUpdate();

                    conn.close();
                }
                catch(Exception err){System.out.println(err);}

                ab.addressEntryList.removeElementAt(index);

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
