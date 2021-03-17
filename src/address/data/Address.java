package address.data;

public class Address {
    String street;
    String city;
    String state;
    Integer zip;

    Address(){
        street="NONE";
        city="NONE";
        state="NONE";
        zip=0;
    }
    Address(String stree, String cit, String stat, Integer zi){
        street=stree;
        city=cit;
        state=stat;
        zip=zi;
    }
    String getStreet(){ return street; }
    void setStreet(String x){ street = x; }
    String getCity(){ return city; }
    void setCity(String x){ city = x; }
    String getState(){ return state; }
    void setState(String x){ state = x; }
    Integer getZip(){ return zip; }
    void setZip(int x){ zip = x; }
}