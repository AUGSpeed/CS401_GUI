package address;
import address.data.AddressBook;
import address.data.AddressEntry;


import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Address Book Application is a program that can store Addresses of
 * multiple people inside of it, either read from a file or user input.
 * <p>
 * @author  Michael LaRussa
 * @since   2/15/2021
 */

class AddressBookApplication {

    /**
     * This is just like any other main method, it runs the program.
     * Currently, it is being used to test the init method.
     * @param args
     */
/*
    public static void main(String args[]) {

        //simply invokes static methods of the Menu class

        /* Exercise 1 stuff

        Menu.prompt_FirstName();

        Menu.prompt_LastName();

        Menu.prompt_Street();

        Menu.prompt_City();

        Menu.prompt_State();

        Menu.prompt_Zip();

        Menu.prompt_Telephone();

        Menu.prompt_Email();



        AddressBook addressBook = new AddressBook();

        init("AddressInputDataFile.txt");
        //initAddressBookExercise(addressBook);
        */
        /*AddressBook mainAddressBook = new AddressBook();
        boolean working = true;
        while(working == true)
        {
            String in = Menu.mainMenu();
            if (in.contentEquals("a"))
            {
                readFromFile(mainAddressBook);
            }
            else if (in.contentEquals("b"))
            {
                addNewEntry(mainAddressBook);
            }
            else if (in.contentEquals("c"))
            {
                removeEntry(mainAddressBook);
            }
            else if (in.contentEquals("d"))
            {
                search(mainAddressBook);
            }
            else if (in.contentEquals("e"))
            {
                mainAddressBook.list();
            }
            else if (in.contentEquals("f"))
            {
                System.out.println("Goodbye!");
                working = false;
            }
            else
            {
                System.out.println("That is an invalid input, please try again.");
            }
        }


    }
*/
    /**
     * Creates 2 instances of Address Entry, and adds them to ab, then calls ab.list().
     * @param ab An AddressBook Object passed to the function to add new Address Entries to it.
     */
    public static void initAddressBookExercise(AddressBook ab)
    {
        AddressEntry x = new AddressEntry("Michael", "LaRussa", "Calaveras Expy.", "Milpitas", "California", 95035, "555-123-4567", "Example@gmail.com");
        AddressEntry y = new AddressEntry("Nathan", "LaRussa", "Calaveras Expy.", "Milpitas", "California", 95035, "555-123-4567", "Example2@gmail.com");

        ab.add(x);
        ab.add(y);

        ab.list();

    }

}


