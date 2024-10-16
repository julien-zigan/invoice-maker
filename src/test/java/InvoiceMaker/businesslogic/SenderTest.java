package InvoiceMaker.businesslogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SenderTest {
    Address company;
    Address simpleSender;

    @BeforeEach
    void setUpTestSenders() {
        company = new Address("Company", "FnameC", "LnameC", "StreetC", "CityC");
        simpleSender = new Address("Fname", "Lname", "Street", "City");
    }

    @Test
    void testGetters() {
        String msg = "Problem with constructor or getters of Class Sender!";

        assertEquals("Company", company.getCompany(), msg);
        assertEquals("FnameC", company.getFirstName(), msg);
        assertEquals("LnameC", company.getLastName(), msg);
        assertEquals("StreetC", company.getStreet(), msg);
        assertEquals("CityC", company.getCity(), msg);

        assertTrue(simpleSender.getCompany().isEmpty(), msg);
        assertEquals("Fname", simpleSender.getFirstName(), msg);
        assertEquals("Lname", simpleSender.getLastName(), msg);
        assertEquals("Street", simpleSender.getStreet(), msg);
        assertEquals("City", simpleSender.getCity(), msg);
    }

    @Test
    void testSetters() {
        String msg = "Problem with setters of Class Sender";
        String compSet = "SetSuccess";

        company.setCompany(compSet);
        company.setFirstName(compSet);
        company.setLastName(compSet);
        company.setStreet(compSet);
        company.setCity(compSet);
        assertEquals(compSet, company.getCompany(), msg);
        assertEquals(compSet, company.getFirstName(), msg);
        assertEquals(compSet, company.getLastName(), msg);
        assertEquals(compSet, company.getStreet(), msg);
        assertEquals(compSet, company.getCity(), msg);

        assertEquals(5, company.getItems().size());
        for (String string : company.getItems()) {
            assertEquals(compSet, string);
        }

        simpleSender.setCompany(compSet);
        simpleSender.setFirstName(compSet);
        simpleSender.setLastName(compSet);
        simpleSender.setStreet(compSet);
        simpleSender.setCity(compSet);
        assertEquals(compSet, simpleSender.getCompany(), msg);
        assertEquals(compSet, simpleSender.getFirstName(), msg);
        assertEquals(compSet, simpleSender.getLastName(), msg);
        assertEquals(compSet, simpleSender.getStreet(), msg);
        assertEquals(compSet, simpleSender.getCity(), msg);
    }

}