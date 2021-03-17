package address.gui;

import address.data.AddressBook;
import address.data.AddressEntry;

import javax.swing.*;
import java.awt.event.*;

public class Search extends JDialog {
    private JPanel contentPane;
    private JButton searchButton;
    private JButton buttonCancel;
    JList <AddressEntry> addressEntryJList = new JList<AddressEntry>();
    DefaultListModel<AddressEntry> myaddressEntryListModel = new DefaultListModel<AddressEntry>();
    private JTextField textField1;
    private JScrollPane scrollPane;

    public Search(address.data.AddressBook ab) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(searchButton);

        addressEntryJList = new JList<AddressEntry>(myaddressEntryListModel);
        addressEntryJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        addressEntryJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        addressEntryJList.setVisibleRowCount(-1);
        scrollPane.setViewportView(addressEntryJList);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddressBook ab2 = new AddressBook();
                ab2 = ab.search(textField1.getText());

                for(int i = 0; i<ab2.addressEntryList.size(); i++)
                {  myaddressEntryListModel.add(i, ab2.addressEntryList.elementAt(i)); }
                addressEntryJList = new JList<AddressEntry>(myaddressEntryListModel);
                addressEntryJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                addressEntryJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                addressEntryJList.setVisibleRowCount(-1);
                scrollPane.setViewportView(addressEntryJList);
            }
        });
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
