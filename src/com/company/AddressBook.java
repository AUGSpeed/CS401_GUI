package com.company;
import java.util.*;

public class AddressBook {

    Vector<AddressEntry> addressEntryList = new Vector<>();

    //Add new AddressEntry object to the addressEntryList
    public void add(AddressEntry addressEntry)
    {
        addressEntryList.addElement(addressEntry);
    }

    //iterate through addressEntryList and for each item call toString and print it out
    public void list()
    {
        Iterator<AddressEntry> iterate = addressEntryList.iterator();
        Integer count = 1;
        while(iterate.hasNext())
        {
            System.out.println("\nEntry Number " + count);
            System.out.println(iterate.next().toString());
            count++;
        }
    }
}
