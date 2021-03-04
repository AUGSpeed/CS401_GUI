package com.company;
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

    Vector<AddressEntry> addressEntryList = new Vector<>();
    static Scanner input = new Scanner(System.in);

    /**
     * Add Method
     * Adds a new AddressEntry object to the addressEntryList
     * @param addressEntry an AddressEntry object
     */

    public void add(AddressEntry addressEntry)
    {
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
     * This method does the bulk of the work when removing an entry, simply because I couldn't find an easy way to do it from the main class.
     * This method will search using the search query string, and then ask to remove any Entries that may show.
     * @param query The string passed to the function, which is assumed to be a Last Name, and will search the AddressBook for Last Name fields matching it.
     */
    public void searchToRemove(String query)
    {
        Integer count = 0;
        Integer numOfEntries = 1;
        Integer size = addressEntryList.size();
        int indexes[] = new int[size];
        for (int i = 0; i < addressEntryList.size(); i++)
        {
            if(addressEntryList.get(i).getLastName().contentEquals(query))
            {
                indexes[count] = i;
                count++;
            }
        }
        if (count > 0)
        {
            System.out.println("The following " + count + " entries were found. Select the number of the one you wish to remove:");
            for (int i = 0; i < count; i++)
            {
                System.out.println("(" + numOfEntries + ")");
                System.out.println(addressEntryList.get(indexes[i]).toString());
                numOfEntries++;
            }
            String in = input.nextLine();
            for (int i = 0; i < count; i++) {
                if (in.contentEquals(String.valueOf(i+1)))
                {
                    System.out.println("Do you want to remove this Entry? Y/N");
                    System.out.println(addressEntryList.get(indexes[i]).toString());
                    String answer = input.nextLine();
                    if (answer.contentEquals("Y") || answer.contentEquals("y"))
                    {
                        addressEntryList.remove(indexes[i]);
                    }
                    else
                    {
                        System.out.println("Returning to the Main Menu...");
                    }
                }
            }
        }
        else {
            System.out.println("No entries were found.");
        }


    }


    /**
     * This method will search using the search query string, and then display them.
     * @param query The string passed to the function, which is assumed to be a Last Name, and will search the AddressBook for Last Name fields containing it.
     */
    public void search(String query)
    {
        Integer count = 0;
        Integer numOfEntries = 1;
        Integer size = addressEntryList.size();
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
            //Display entries found
            System.out.println("The following " + count + " entries were found.");
            for (int i = 0; i < count; i++)
            {
                System.out.println("(" + numOfEntries + ")");
                System.out.println(addressEntryList.get(indexes[i]).toString());
                numOfEntries++;
            }
        }
        //No entries were found
        else {
            System.out.println("No entries were found.");
        }


    }
}
