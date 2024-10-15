package InvoiceMaker.businesslogic;

public class Einsatzbestaetigung {
    private Recipient recipient;
    private AuftragsNr auftragsNr;


    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public void setAuftragsNr(AuftragsNr auftragsNr) throws Exception {
        this.auftragsNr = auftragsNr;
    }

    public AuftragsNr getAuftragsNr() {
        return auftragsNr;
    }
}
