package address.data;

import java.sql.*;
import java.util.*;


/**
 * Address Book uses a vector data structure to hold multiple Address Entry objects
 * in succession, allowing us to iterate through them and print them all out in succession.
 * @author Michael LaRussa
 * @since 2/15/2021
 */

public class AddressBook {

    /**
     * Address Entry List
     * <p>
     * A vector which is the data structure used to hold all of
     * the Address Entry objects placed into the Address Book.
     */

    public Vector<AddressEntry> addressEntryList = new Vector<>();
    static Scanner input = new Scanner(System.in);

    /**
     * Add Method
     * Adds a new AddressEntry object to the addressEntryList
     * @param addressEntry an AddressEntry object
     */

    public void add(AddressEntry addressEntry)
    {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin" +
                            ":@adcsdb01.csueastbay.edu:1521:mcspdb.ad.csueastbay.edu"
                    , "MCS1018", "y_WrlhyT");
            // Statement stmt = conn.createStatement();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO " +
                    "ADDRESSENTRYTABLE values(?,?,?,?,?,?,?,?, " +
                    "default )");
            stmt.setString(1, addressEntry.name.firstName);
            stmt.setString(2, addressEntry.name.lastName);
            stmt.setString(3, addressEntry.address.street);
            stmt.setString(4, addressEntry.address.city);
            stmt.setString(5, addressEntry.address.state);
            stmt.setInt(6, addressEntry.address.zip);
            stmt.setString(7, addressEntry.phone);
            stmt.setString(8, addressEntry.email);
            stmt.executeUpdate();

            conn.close();
        }
        catch(Exception e){System.out.println(e);}

        addressEntryList.addElement(addressEntry);
    }

    /**
     * List Method
     * Sort everything in the Address Book, then iterate through addressEntryList and for each item call toString and print it out
     */
    public String list()
    {
        addressEntryList.sort(null);
        Iterator<AddressEntry> iterate = addressEntryList.iterator();
        Integer count = 1;
        String all = "";
        while(iterate.hasNext())
        {
            all += "\nEntry Number " + count;
            all += iterate.next().toString();
            count++;
        }
        System.out.println(all);
        return all;
    }


    /**
     * This method will search using the search query string, and then display them.
     * @param query The string passed to the function, which is assumed to be a Last Name, and will search the AddressBook for Last Name fields containing it.
     */
    public AddressBook search(String query)
    {
        Integer count = 0;
        Integer size = addressEntryList.size();
        AddressBook ab = new AddressBook();
        int indexes[] = new int[size];
        //For loop, iterating through our entire list of Address Entries
        for (int i = 0; i < addressEntryList.size(); i++)
        {
            //If the lastname is the search query
            if(addressEntryList.get(i).getLastName().contains(query))
            {
                indexes[count] = i;
                count++;
            }
        }
        //If we found anything
        if (count > 0)
        {
            //Add entries found
            for (int i = 0; i < count; i++)
            {
                ab.addressEntryList.add(addressEntryList.get(indexes[i]));
            }
        }
        //No entries were found
        else {
            System.out.println("No entries were found.");
        }

        return ab;

    }
}