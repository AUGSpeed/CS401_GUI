package address.gui;
import address.data.AddressBook;
import address.data.AddressEntry;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.io.*;
import java.util.*;

public class AddressBookGUI extends JDialog{
    private JPanel contentPane;
    private JButton displayButton;
    private JButton removeButton;
    private JButton newButton;
    private JScrollPane scrollPane;
    private JButton exitButton;
    private JButton searchButton;
    private String userDB;
    private String passDB;
    JList <AddressEntry> addressEntryJList = new JList<AddressEntry>();
    DefaultListModel<AddressEntry> myaddressEntryListModel = new DefaultListModel<AddressEntry>();
    AddressBook ab = new AddressBook();

    FileReader reader;
    {
        try {
            reader = new FileReader("src/address/db.properties");
            Properties p = new Properties();
            p.load(reader);
            userDB = (p.getProperty("user"));
            passDB = (p.getProperty("password"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public AddressBookGUI() {
        setContentPane(contentPane);
        setModal(true);

        //button for listing in JList
        //should call the address book class's list method and not directly
        // list from the database here
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ab = new AddressBook();
                try{
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin" +
                                    ":@adcsdb01.csueastbay.edu:1521:mcspdb.ad.csueastbay.edu"
                            , userDB, passDB);
                   Statement stmt = conn.createStatement();
                   ResultSet rs = stmt.executeQuery("select * from " +
                           "ADDRESSENTRYTABLE");
                    myaddressEntryListModel = new DefaultListModel<AddressEntry>();
                    while(rs.next()){
                       AddressEntry entry = new AddressEntry(rs.getString(1),
                               rs.getString(2),rs.getString(3),rs.getString(4),
                               rs.getString(5), rs.getInt(6), rs.getString(7),
                               rs.getString(8));
                       ab.addressEntryList.addElement(entry);

                   }
                    conn.close();
                }
                catch(Exception err){System.out.println(err);}

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
                            , userDB, passDB);

                    PreparedStatement stmt = conn.prepareStatement("DELETE " +
                            "FROM ADDRESSENTRYTABLE WHERE FIRST_NAME = ?");
                    stmt.setString(1,
                            ab.addressEntryList.get(index).name.getFirstName());
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
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search search = new Search(ab);
                search.pack();
                search.setVisible(true);
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
