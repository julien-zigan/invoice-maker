package InvoiceMaker.businesslogic;

import java.util.ArrayList;

public class Address {
    private ArrayList<String> items;
    private String company;
    private String firstName;
    private String lastName;
    private String street;
    private String city;

    public Address(
            String firstName,
            String lastName,
            String street,
            String city
    ) {
        this("", firstName, lastName, street, city);
    }

    public Address(
            String company,
            String firstName,
            String lastName,
            String street,
            String city
    ) {
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        items = new ArrayList<>();
        items.add(company);
        items.add(firstName);
        items.add(lastName);
        items.add(street);
        items.add(city);

    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
            this.company = company;
            items.set(0, company);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        items.set(1, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        items.set(2, lastName);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
        items.set(3, street);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        items.set(4, city);
    }

    public ArrayList<String> getItems() {
        return items;
    }
}
