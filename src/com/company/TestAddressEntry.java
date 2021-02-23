package com.company;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAddressEntry {


    @Test
    public void testAddressEntry()
    {
        Integer zero = 0;
        AddressEntry test = new AddressEntry();

        assertEquals("", test.firstName);
        assertEquals(zero, test.zip);
    }

    @Test
    public void testAddressEntry2()
    {
        String fn = "Michael";
        String ln = "LaRussa";
        String str = "Street";
        String ci = "Cityville";
        String sta = "State";
        Integer zi = 99999;
        String ph = "555-555-5555";
        String em = "email@email.gov";

        AddressEntry test = new AddressEntry(fn, ln, str, ci, sta, zi, ph, em);

        assertEquals("Michael", test.firstName);
        assertEquals(zi, test.zip);
    }

    @Test
    public void testCompareTo()
    {
        AddressEntry test1 = new AddressEntry("Person", "LastName", "Street", "Cityville", "State", 99999, "555-555-5555", "email@email.edu");
        AddressEntry test2 = new AddressEntry("Person", "LastName", "Street", "Cityville", "State", 99999, "555-555-5555", "email@email.edu");
        AddressEntry test3 = new AddressEntry("Person", "AastName", "Street", "Cityville", "State", 99999, "555-555-5555", "email@email.edu");

        assertEquals(1, test1.compareTo(test3));
        assertEquals(-1, test3.compareTo(test1));
        assertEquals(0, test1.compareTo(test2));
    }

    @Test
    public void testSetLastName()
    {
        AddressEntry test = new AddressEntry();
        test.setLastName("LaRussa");
        assertEquals("LaRussa", test.lastName);
        test.setLastName("Shriver");
        assertEquals("Shriver", test.lastName);
    }

    @Test
    public void testSetStreet()
    {
        AddressEntry test = new AddressEntry();
        test.setStreet("Street");
        assertEquals("Street", test.street);
        test.setStreet("New Street");
        assertEquals("New Street", test.street);
    }

    @Test
    public void testSetCity()
    {
        AddressEntry test = new AddressEntry();
        test.setCity("Cityville");
        assertEquals("Cityville", test.city);
        test.setCity("Townsville");
        assertEquals("Townsville", test.city);
    }

    @Test
    public void testSetState()
    {
        AddressEntry test = new AddressEntry();
        test.setState("State");
        assertEquals("State", test.state);
        test.setState("California");
        assertEquals("California", test.state);
    }

    @Test
    public void testSetZip()
    {
        AddressEntry test = new AddressEntry();
        test.setZip(99999);
        Integer testzip = 99999;
        assertEquals(testzip, test.zip);
        test.setZip(11111);
        testzip = 11111;
        assertEquals(testzip, test.zip);
    }

    @Test
    public void testSetPhone()
    {
        AddressEntry test = new AddressEntry();
        test.setPhone("555-555-5555");
        assertEquals("555-555-5555", test.phone);
        test.setPhone("111-111-1111");
        assertEquals("111-111-1111", test.phone);
    }

    @Test
    public void testSetEmail()
    {
        AddressEntry test = new AddressEntry();
        test.setEmail("Email");
        assertEquals("Email", test.email);
        test.setEmail("Email2");
        assertEquals("Email2", test.email);
    }

    @Test
    public void testGetFirstName()
    {
        AddressEntry test = new AddressEntry();
        test.setFirstName("Michael");
        assertEquals("Michael", test.getFirstName());
        test.setFirstName("Nathan");
        assertEquals("Nathan", test.getFirstName());
    }

    @Test
    public void testGetLastName()
    {
        AddressEntry test = new AddressEntry();
        test.setLastName("LaRussa");
        assertEquals("LaRussa", test.getLastName());
        test.setLastName("Shriver");
        assertEquals("Shriver", test.getLastName());
    }

    @Test
    public void testGetStreet()
    {
        AddressEntry test = new AddressEntry();
        test.setStreet("Street");
        assertEquals("Street", test.getStreet());
        test.setStreet("New Street");
        assertEquals("New Street", test.getStreet());
    }

    @Test
    public void testGetCity()
    {
        AddressEntry test = new AddressEntry();
        test.setCity("Cityville");
        assertEquals("Cityville", test.getCity());
        test.setCity("Townsville");
        assertEquals("Townsville", test.getCity());
    }

    @Test
    public void testGetState()
    {
        AddressEntry test = new AddressEntry();
        test.setState("State");
        assertEquals("State", test.getState());
        test.setState("California");
        assertEquals("California", test.getState());
    }

    @Test
    public void testGetZip()
    {
        AddressEntry test = new AddressEntry();
        test.setZip(99999);
        Integer testzip = 99999;
        assertEquals(testzip, test.getZip());
        test.setZip(11111);
        testzip = 11111;
        assertEquals(testzip, test.getZip());
    }

    @Test
    public void testGetPhone()
    {
        AddressEntry test = new AddressEntry();
        test.setPhone("555-555-5555");
        assertEquals("555-555-5555", test.getPhone());
        test.setPhone("111-111-1111");
        assertEquals("111-111-1111", test.getPhone());
    }

    @Test
    public void testGetEmail()
    {
        AddressEntry test = new AddressEntry();
        test.setEmail("Email");
        assertEquals("Email", test.getEmail());
        test.setEmail("Email2");
        assertEquals("Email2", test.getEmail());
    }
}
