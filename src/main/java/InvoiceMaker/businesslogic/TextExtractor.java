package InvoiceMaker.businesslogic;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class TextExtractor {

    public static StringBuilder extract(File file) //Might change to other argument type, depending on drag n drop impl
            throws IOException {
        var pdDocument = Loader.loadPDF(file);
        var pdfTextStripper = new PDFTextStripper();
        pdfTextStripper.setSortByPosition(true);
        var extractedText = pdfTextStripper.getText(pdDocument);
        pdDocument.close();
        return new StringBuilder(extractedText);
    }
}
