package com.company;
import java.util.Scanner;

/**
 * Menu class currently only has static methods to prompt to standard output information about a Contact like name,etc
 * @author Michael LaRussa
 * @since 2/15/2021
 */

class Menu {

    static Scanner input = new Scanner(System.in);

    /**
     * Generates a standard Menu prompt, and then takes user input and returns it.
     */
    public static String mainMenu() {
        System.out.println("-----------------------------------------");
        System.out.println("Please enter your menu selection:");
        System.out.println("(a) Loading from file");
        System.out.println("(b) Addition");
        System.out.println("(c) Removal");
        System.out.println("(d) Find");
        System.out.println("(e) Listing");
        System.out.println("(f) Quit");
        System.out.println("-----------------------------------------");

        String in = input.nextLine();
        return in;
    }


    /**
     * Generates a standard output prompt for the First Name to be entered, and then takes user input and returns it.
     */
    public static String prompt_FirstName() {
        System.out.println("First Name:");
        String in = input.nextLine();
        return in;
    }
    /**
     * Generates a standard output prompt for the Last Name to be entered, and then takes user input and returns it.
     */
    public static String prompt_LastName() {
        System.out.println("Last Name:");
        String in = input.nextLine();
        return in;
    }
    /**
     * Generates a standard output prompt for the Street to be entered, and then takes user input and returns it.
     */
    public static String prompt_Street() {

        System.out.println("Street:");
        String in = input.nextLine();
        return in;
    }
    /**
     * Generates a standard output prompt for the City to be entered, and then takes user input and returns it.
     */
    public static String prompt_City() {

        System.out.println("City:");
        String in = input.nextLine();
        return in;
    }
    /**
     * Generates a standard output prompt for the State to be entered, and then takes user input and returns it.
     */
    public static String prompt_State() {

        System.out.println("State:");
        String in = input.nextLine();
        return in;
    }
    /**
     * Generates a standard output prompt for the Zip to be entered, and then takes user input and returns it.
     */
    public static Integer prompt_Zip() {

        System.out.println("Zip:");
        Integer in = Integer.parseInt(input.nextLine());
        return in;
    }
    /**
     * Generates a standard output prompt for the Telephone to be entered, and then takes user input and returns it.
     */
    public static String prompt_Telephone() {

        System.out.println("Telephone:");
        String in = input.nextLine();
        return in;
    }
    /**
     * Generates a standard output prompt for the Email to be entered, and then takes user input and returns it.
     */
    public static String prompt_Email() {

        System.out.println("Email:");
        String in = input.nextLine();
        return in;
    }

}
