package address.data;

public class Name {
    String firstName;
    String lastName;
    Name(){
        firstName="NONE";
        lastName="NONE";
    }
    Name(String a, String b){
        firstName=a;
        lastName=b;
    }

    String getFirstName(){ return firstName; }
    void setFirstName(String x){ firstName = x; }
    String getLastName(){ return lastName; }
    void setLastName(String x){ lastName = x; }
}
