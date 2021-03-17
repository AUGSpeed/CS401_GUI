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

    public String getFirstName(){ return firstName; }
    public void setFirstName(String x){ firstName = x; }
    public String getLastName(){ return lastName; }
    public void setLastName(String x){ lastName = x; }
}
