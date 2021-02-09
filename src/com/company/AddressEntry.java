package com.company;

public class AddressEntry {

    public String firstName;
    public String lastName;
    public String street;
    public String city;
    public String state;
    public Integer zip;
    public String phone;
    public String email;

    public AddressEntry()
    {
        firstName = "";
        lastName = "";
        street = "";
        city = "";
        state = "";
        zip = 0;
        phone = "";
        email = "";
    }

    public AddressEntry(String fn, String ln, String ci, String str, String sta, Integer zi, String ph, String em) {
        firstName = fn;
        lastName = ln;
        street = ci;
        city = str;
        state = sta;
        zip = zi;
        phone = ph;
        email = em;
    }

    public String toString()
    {
        return "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nStreet: " + street + "\nCity: " + city + "\nState: " + state + "\nZip: " + zip.toString() + "\nPhone: " + phone + "\nEmail: " + email;
    }

    public void setFirstName(String fn)
    {
        firstName = fn;
    }

    public void setLastName(String ln)
    {
        lastName = ln;
    }

    public void setStreet(String str)
    {
        street = str;
    }

    public void setCity(String ci)
    {
        city = ci;
    }

    public void setState(String sta)
    {
        state = sta;
    }

    public void setZip(Integer zi)
    {
        zip = zi;
    }

    public void setPhone(String ph)
    {
        phone = ph;
    }

    public void setEmail(String em)
    {
        email = em;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getStreet()
    {
        return street;
    }

    public String getCity()
    {
        return city;
    }

    public String getState()
    {
        return state;
    }

    public Integer getZip()
    {
        return zip;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }



}
