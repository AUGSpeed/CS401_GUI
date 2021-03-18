package address.data;

/**
 *  Address Class
 * <p>
 *  Address contains three string variables for street, city, and state,
 *  as well as an integer variable for zipcode.
 *  There are two constructors, one default and one for user input
 *  There are also Setters and Getters for each variable respectively
 */
public class Address {
    String street;
    String city;
    String state;
    Integer zip;

    /**
     * Constructs an Address with a Default street, city, state, and zip
     */
    Address(){
        street="NONE";
        city="NONE";
        state="NONE";
        zip=0;
    }

    /**
     * Constructs an Address with user inputted street, city, state, and zip
     * @param stree street (user input)
     * @param cit city (user input)
     * @param stat state (user input)
     * @param zi zipcode (user input)
     */
    Address(String stree, String cit, String stat, Integer zi){
        street=stree;
        city=cit;
        state=stat;
        zip=zi;
    }

    /**
     * Getter for street
     * @return street
     */
    String getStreet(){ return street; }

    /**
     * Setter for street
     * @param x street (user input)
     */
    void setStreet(String x){ street = x; }

    /**
     * Getter for city
     * @return city
     */
    String getCity(){ return city; }

    /**
     * Setter for city
     * @param x city(user input)
     */
    void setCity(String x){ city = x; }

    /**
     *  Getter for state
     * @return state
     */
    String getState(){ return state; }

    /**
     *  Setter for state
     * @param x state (user input)
     */
    void setState(String x){ state = x; }

    /**
     *  Getter for zipcode
     * @return zipcode
     */
    Integer getZip(){ return zip; }

    /**
     *  Setter for zipcode
     * @param x zipcode (user input)
     */
    void setZip(int x){ zip = x; }
}