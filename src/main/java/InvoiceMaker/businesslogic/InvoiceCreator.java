package InvoiceMaker.businesslogic;

import InvoiceMaker.businesslogic.LetterTypeA.ReturnInformation;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.IOException;

public class InvoiceCreator {
    public static PDDocument generateDocument(Deployment deployment) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        PDPageContentStream content = new PDPageContentStream(document, page);
        ReturnInformation.print(content, deployment.getContractor());
        content.close();
        return document;
    }
}
