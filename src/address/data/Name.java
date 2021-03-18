package address.data;

/**
 *  Name Class
 * <p>
 * Name contains two strings consisting of a first name and a last name
 * There are two constructors, one default and one for user input
 * It also has a setter and getter for each variable respectively
 *
 */
public class Name {
    String firstName;
    String lastName;

    /**
     * Constructs a Name with a default first and last name
     */
    Name(){
        firstName="NONE";
        lastName="NONE";
    }

    /**
     * Constructs a Name with a first name (a) and last name (b) (input by user)
     * @param a first name (input by user)
     * @param b last name (input by user)
     */
    Name(String a, String b){
        firstName=a;
        lastName=b;
    }

    /**
     * Getter for first name
     * @return firstName
     */
    public String getFirstName(){ return firstName; }
    /**
     * Setter for first name
     * @param x first name (input by user)
     */
    public void setFirstName(String x){ firstName = x; }
    /**
     * Getter for last name
     * @return lastName
     */
    public String getLastName(){ return lastName; }

    /**
     * Setter for last name
     * @param x last name (input by user)
     */
    public void setLastName(String x){ lastName = x; }
}