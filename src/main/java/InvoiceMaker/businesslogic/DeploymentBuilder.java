package InvoiceMaker.businesslogic;

import InvoiceMaker.businesslogic.Contacts.Address;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.sql.Date;

public class DeploymentBuilder {
    public static Deployment build(PDDocument doc) throws IOException {
        StringBuilder text = extractText(doc);


            //TODO for testing only!!!!!
        return new Deployment(new Address("Anita", "Pacholik", "Straße 13", "15021 Kölle"),
                null, null, null, null, 0f, 0f, 0, 0);

    }

    static StringBuilder extractText(PDDocument doc) throws IOException {
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        pdfTextStripper.setSortByPosition(true);
        String extractedText = pdfTextStripper.getText(doc);
        doc.close();
        return new StringBuilder(extractedText);
    }
}
