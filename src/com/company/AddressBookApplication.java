package com.company;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.*;

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

    /**
     * Reads a text file, parses what is in it, and then places the values
     * into new Address Entries, which are then placed into a new AddressBook.
     * <p>
     * Currently, this method will error out if the text file is not perfectly
     * formatted, so I may need to tweak this.
     * @param filename The name of the file that will be read.
     */
    public static void init(String filename, AddressBook addressBookFile){
        try{
            FileReader input = new FileReader(filename);
            Scanner inFile = new Scanner(input);
            Integer loop = 0;
            Object[] arr = new Object[8];
            while(inFile.hasNextLine())
            {

                arr[loop] = inFile.nextLine();

                loop++;

                if (loop == 8) {
                    addressBookFile.add(new AddressEntry((String)arr[0], (String)arr[1], (String)arr[2], (String)arr[3], (String)arr[4], Integer.parseInt((String)arr[5]), (String)arr[6], (String)arr[7]));
                    loop = 0;
                }
            }
            inFile.close();
            addressBookFile.list();
        }
        catch (FileNotFoundException e){
            System.out.println("An error occurred reading the file.");
        }

    }

    static Scanner input = new Scanner(System.in);


    /**
     * Asks for a filename, and then gives it to our init function.
     * @param ab An AddressBook object so that we don't have to create one here.
     */
    public static void readFromFile(AddressBook ab) {
        System.out.println("Enter filename:");
        String in = input.nextLine();
        init(in, ab);
    }

    /**
     * Asks for all needed fields for a new, and then gives it to our init function.
     * @param ab An AddressBook object so that we don't have to create one here.
     */
    public static void addNewEntry(AddressBook ab) {
        AddressEntry ae = new AddressEntry();
        ae.setFirstName(Menu.prompt_FirstName());
        ae.setLastName(Menu.prompt_LastName());
        ae.setStreet(Menu.prompt_Street());
        ae.setCity(Menu.prompt_City());
        ae.setState(Menu.prompt_State());
        ae.setZip(Menu.prompt_Zip());
        ae.setPhone(Menu.prompt_Telephone());
        ae.setEmail(Menu.prompt_Email());
        System.out.println("Thank you, the following contact has been added to your list: ");
        System.out.println(ae.toString());
        ab.add(ae);
    }

    /**
     * A handler function so that this code need not be present in main, and passes most of its functionality to Address Book's Search to Remove method.
     * @param ab An Address Book, telling us which one to remove an entry from.
     */
    public static void removeEntry(AddressBook ab) {
        System.out.println("Enter the Last Name of a contact to remove: ");
        String in = input.nextLine();
        ab.searchToRemove(in);
    }

    /**
     * A handler function so that this code need not be present in main, and passes most of its functionality to Address Book's Search method.
     * @param ab An Address Book, telling us which one to search.
     */
    public static void search(AddressBook ab) {
        System.out.println("Enter the beginning of a Last Name of a contact to search by: ");
        String in = input.nextLine();
        ab.search(in);
    }
}


