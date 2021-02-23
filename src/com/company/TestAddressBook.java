package com.company;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAddressBook {

    @Test
    public void testAdd()
    {
        AddressBook test = new AddressBook();
        AddressEntry added = new AddressEntry();

        test.add(added);

        assertEquals(1, test.addressEntryList.size());

        AddressEntry added2 = new AddressEntry();
        AddressEntry added3 = new AddressEntry();

        test.add(added2);
        test.add(added3);

        assertEquals(3, test.addressEntryList.size());

    }

    @Test
    public void testList()
    {
        AddressBook test = new AddressBook();
        AddressEntry added = new AddressEntry("Michael", "MaRussa", "Street", "City", "State", 99999, "555-555-5555", "email@email.com");
        AddressEntry added1 = new AddressEntry("Michael", "LaRussa", "Street", "City", "State", 99999, "555-555-5555", "email@email.com");
        AddressEntry added2 = new AddressEntry("Michael", "ZaRussa", "Street", "City", "State", 99999, "555-555-5555", "email@email.com");
        AddressEntry added3 = new AddressEntry("Michael", "AaRussa", "Street", "City", "State", 99999, "555-555-5555", "email@email.com");

        test.add(added);
        test.add(added1);
        test.add(added2);
        test.add(added3);
        test.list();

        assertEquals("AaRussa", test.addressEntryList.get(0).getLastName());

        AddressEntry added4 = new AddressEntry("Michael", "AaaRussa", "Street", "City", "State", 99999, "555-555-5555", "email@email.com");
        test.add(added4);
        test.list();

        assertEquals("AaaRussa", test.addressEntryList.get(0).getLastName());
    }

    //I don't know what to test by for search and search to remove, so I am skipping them.

}
