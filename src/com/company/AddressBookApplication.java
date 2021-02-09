package com.company;

/** main AddressBookApplication: purpose is to invoke some methods of the Menu classs
 **/

class AddressBookApplication {

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

        */

        AddressBook addressBook = new AddressBook();

        initAddressBookExercise(addressBook);

    }

    //Creates 2 instances of Address Entry, and adds them to ab, then calls ab.list().
    public static void initAddressBookExercise(AddressBook ab)
    {
        AddressEntry x = new AddressEntry("Michael", "LaRussa", "Calaveras Expy.", "Milpitas", "California", 95035, "555-123-4567", "Example@gmail.com");
        AddressEntry y = new AddressEntry("Nathan", "LaRussa", "Calaveras Expy.", "Milpitas", "California", 95035, "555-123-4567", "Example2@gmail.com");

        ab.add(x);
        ab.add(y);

        ab.list();

    }
}


