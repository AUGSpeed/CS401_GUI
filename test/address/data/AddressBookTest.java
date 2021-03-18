package address.data;

import address.gui.AddressBookGUI;
import junit.framework.TestCase;

public class AddressBookTest extends TestCase {

    public void testAdd() {
        AddressBook book = new AddressBook();
        int prevSize = book.addressEntryList.size();
        AddressEntry entry = new AddressEntry();
        book.add(entry);
        int currSize = book.addressEntryList.size();
        assertNotSame(prevSize, currSize);
    }

    public void testList() {
        AddressBook book = new AddressBook();
        AddressEntry entry = new AddressEntry();
        book.add(entry);
        String sortedList = book.list();
        assertNotNull(sortedList);
    }

    public void testSearch() {
        AddressBook book = new AddressBook();
        /*
        Name name = new Name("Colin", "Kawai");
        Name nameOne = new Name("Bill", "joe");
        Address address = new Address("nut", "oakland", "CA", 234);
        Address addressOne = new Address("tree", "alameda", "CA", 91);

         */

        AddressEntry entry = new AddressEntry("Colin", "Kawai", "nut",
                "oakland", "CA", 234, "234234", "23423424");
        AddressEntry entryOne = new AddressEntry("Bill", "Joe", "tree",
                "alameda", "CA", 234, "234234", "adfaf");
        book.add(entry);
        book.add(entryOne);
        assertEquals(book.addressEntryList.size(),
                book.search("").addressEntryList.size() );


    }
}