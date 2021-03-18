package address.data;

/**
 * AddressEntry is an Object that holds 7 Strings and 1 Integer, meant to
 * represent the address of someone, and then placed into a list of other
 * Address Entries using the Address Book class.
 *
 * @author  Michael LaRussa
 * @since   2/15/2021
 */

public class AddressEntry implements Comparable<AddressEntry>{

    /**
     * Holds values for the name.
     */
    public Name name = new Name();
    /**
     * Holds values for the address.
     */
    public Address address = new Address();
    /**
     * Holds a String for a phone number.
     */
    public String phone;
    /**
     * Holds a String for an email.
     */
    public String email;
    /**
     * Holds a String for an id.
     */
    public String id;

    /**
     * Address Entry Initializer
     * This is the initializing call, and will be performed whenever
     * an Address Entry is created.
     */
    public AddressEntry()
    {
        name.firstName = "";
        name.lastName = "";
        address.street = "";
        address.city = "";
        address.state = "";
        address.zip = 0;
        phone = "";
        email = "";
    }

    /**
     * Address Entry Initializer
     * This initializer takes input in the form of parameters to be
     * placed into their respective variables inside of the Address Entry.
     *
     * @param fn String parameter, to be placed into firstName.
     * @param ln String parameter, to be placed into lastName.
     * @param ci String parameter, to be placed into city.
     * @param str String parameter, to be placed into street.
     * @param sta String parameter, to be placed into state.
     * @param zi Inteher parameter, to be placed into zip.
     * @param ph String parameter, to be placed into phone.
     * @param em String parameter, to be placed into email.
     */

    public AddressEntry(String fn, String ln, String str, String ci, String sta, Integer zi, String ph, String em) {
        name.firstName = fn;
        name.lastName = ln;
        address.street = str;
        address.city = ci;
        address.state = sta;
        address.zip = zi;
        phone = ph;
        email = em;
    }

    public AddressEntry(Name _name, Address _address, String _email, String _phone, String _id){
        name.firstName=_name.firstName;
        name.lastName=_name.lastName;
        address.street=_address.street;
        address.city=_address.city;
        address.state=_address.state;
        address.zip=_address.zip;
        phone=_phone;
        email=_email;
        id=_id;
    }


    /**
     * Extending the Comparable.java method compareTo, to allow our sorting to work.
     * @param ae Simply the other address entry to compare to.
     * @return determines if something is higher or lower than another object.
     */
    public int compareTo(AddressEntry ae)
    {
        if(name.lastName.compareToIgnoreCase(ae.name.lastName) > 0) {
            return 1;
        }
        else if(name.lastName.compareToIgnoreCase(ae.name.lastName) < 0) {
            return -1;
        }
        else if(name.lastName.compareToIgnoreCase(ae.name.lastName) == 0) {
            return 0;
        }
        System.out.println("An Error occurred when comparing.");
        return 0;
    }

    /**
     * toString Method
     * This method simply turns the Address Entry into a String.
     * @return Returns a formatted string containing all variables present in this Address Entry.
     */
    public String toString()
    {
        return "\nFirst Name: " + name.firstName + "\nLast Name: " + name.lastName + "\nStreet: " + address.street + "\nCity: " + address.city + "\nState: " + address.state + "\nZip: " + address.zip.toString() + "\nPhone: " + phone + "\nEmail: " + email;
    }

    /**
     * setFirstName Method
     * Simply takes a value as a parameter, and places it into firstName.
     * @param fn String parameter, to be placed into firstName.
     */

    public void setFirstName(String fn)
    {
        name.firstName = fn;
    }

    /**
     * setLastName Method
     * Simply takes a value as a parameter, and places it into lastName.
     * @param ln String parameter, to be placed into lastName.
     */

    public void setLastName(String ln)
    {
        name.lastName = ln;
    }

    /**
     * setState Method
     * Simply takes a value as a parameter, and places it into street.
     * @param str String parameter, to be placed into street.
     */

    public void setStreet(String str)
    {
        address.street = str;
    }

    /**
     * setCity Method
     * Simply takes a value as a parameter, and places it into city.
     * @param ci String parameter, to be placed into city.
     */

    public void setCity(String ci)
    {
        address.city = ci;
    }

    /**
     * setState Method
     * Simply takes a value as a parameter, and places it into state.
     * @param sta String parameter, to be placed into state.
     */

    public void setState(String sta)
    {
        address.state = sta;
    }

    /**
     * setZip Method
     * Simply takes a value as a parameter, and places it into zip.
     * @param zi String parameter, to be placed into zip.
     */

    public void setZip(Integer zi)
    {
        address.zip = zi;
    }

    /**
     * setPhone Method
     * Simply takes a value as a parameter, and places it into phone.
     * @param ph String parameter, to be placed into phone.
     */

    public void setPhone(String ph)
    {
        phone = ph;
    }

    /**
     * setEmail Method
     * Simply takes a value as a parameter, and places it into email.
     * @param em String parameter, to be placed into email.
     */

    public void setEmail(String em)
    {
        email = em;
    }

    /**
     * getFirstName Method
     * Simply returns the String value of firstName.
     * @return Returns the value of firstName
     */

    public String getFirstName()
    {
        return name.firstName;
    }

    /**
     * getLastName Method
     * Simply returns the String value of lastName.
     * @return Returns the value of lastName
     */

    public String getLastName()
    {
        return name.lastName;
    }

    /**
     * getStreet Method
     * Simply returns the String value of street.
     * @return Returns the value of street
     */

    public String getStreet()
    {
        return address.street;
    }

    /**
     * getCity Method
     * Simply returns the String value of city.
     * @return Returns the value of city
     */

    public String getCity()
    {
        return address.city;
    }

    /**
     * getState Method
     * Simply returns the String value of state.
     * @return Returns the value of state
     */

    public String getState()
    {
        return address.state;
    }

    /**
     * getZip Method
     * Simply returns the Integer value of zip.
     * @return Returns the value of zip
     */

    public Integer getZip()
    {
        return address.zip;
    }

    /**
     * getPhone Method
     * Simply returns the String value of phone.
     * @return Returns the value of phone
     */

    public String getPhone()
    {
        return phone;
    }

    /**
     * getEmail Method
     * Simply returns the String value of email.
     * @return Returns the value of email
     */

    public String getEmail()
    {
        return email;
    }


}
