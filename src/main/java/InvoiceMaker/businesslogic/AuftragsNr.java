package InvoiceMaker.businesslogic;

public class AuftragsNr {
    private final int AUFTRAGSNR;

    public AuftragsNr(int auftragsnr) {
        AUFTRAGSNR = auftragsnr;
    }

    public int getAUFTRAGSNR() {
        return AUFTRAGSNR;
    }

    public String toString() {
        return String.valueOf(getAUFTRAGSNR());
    }
}
