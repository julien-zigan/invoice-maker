package InvoiceMaker.businesslogic;


import InvoiceMaker.businesslogic.Contacts.Address;

import java.sql.Date;
import java.time.Duration;

public class Deployment {
    Address contractor;
    Address customer;
    Date date;
    Duration duration;
    String languages;
    float rate;
    float travelCosts;
    int GDD_ID;
    int ID;

    public Deployment(
            Address contractor,
            Address customer,
            Date date,
            Duration duration,
            String languages,
            float rate,
            float travelCosts,
            int GDD_ID,
            int ID
    ) {
        this.contractor = contractor;
        this.customer = customer;
        this.date = date;
        this.duration = duration;
        this.languages = languages;
        this.rate = rate;
        this.travelCosts = travelCosts;
        this.GDD_ID = GDD_ID;
        this.ID = ID;
    }


    public Address getContractor() {
        return contractor;
    }

    public void setContractor(Address contractor) {
        this.contractor = contractor;
    }

    public Address getCustomer() {
        return customer;
    }

    public void setCustomer(Address customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getTravelCosts() {
        return travelCosts;
    }

    public void setTravelCosts(float travelCosts) {
        this.travelCosts = travelCosts;
    }

    public int getGDD_ID() {
        return GDD_ID;
    }

    public void setGDD_ID(int GDD_ID) {
        this.GDD_ID = GDD_ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
