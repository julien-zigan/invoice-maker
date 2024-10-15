package InvoiceMaker.businesslogic;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.awt.*;
import java.io.File;

public class InvoiceGenerator {
    public static String generate(Einsatzbestaetigung einsatzbestaetigung) {
        String filepath = "";

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            PDType1Font font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(250, 700);
            contentStream.showText("Rechnung");

            contentStream.newLineAtOffset(-150, -100);
            RecipientCompositor.compose(contentStream, einsatzbestaetigung.getRecipient().testrecip);

            contentStream.newLineAtOffset(0, -40);
            contentStream.showText("Rechnungsnummer: " + einsatzbestaetigung.getAuftragsNr().getAUFTRAGSNR());
            contentStream.endText();

            contentStream.close();

            filepath = "X:\\Einsatzverwaltung\\Einsatzverwaltung\\target\\generated-sources\\output\\testFile1.pdf";

            document.save(filepath);
//            System.out.println("PDF created successfully.");
//            File file = new File("X:\\Einsatzverwaltung\\Einsatzverwaltung\\target\\generated-sources\\output\\testFile1.pdf");
//            Desktop.getDesktop().open(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filepath;
    }

    public static void generateFinal(Einsatzbestaetigung einsatzbestaetigung) {
        String filepath = "";

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            PDType1Font font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.newLineAtOffset(250, 700);
            contentStream.showText("Rechnung");

            contentStream.newLineAtOffset(-150, -100);
            RecipientCompositor.compose(contentStream, einsatzbestaetigung.getRecipient().testrecip);

            contentStream.newLineAtOffset(0, -40);
            contentStream.showText("Rechnungsnummer: " + einsatzbestaetigung.getAuftragsNr().getAUFTRAGSNR());
            contentStream.endText();

            contentStream.close();

            filepath = "X:\\Einsatzverwaltung\\Einsatzverwaltung\\target\\generated-sources\\output\\testFile1.pdf";

            document.save(filepath);
            System.out.println("PDF created successfully.");
            File file = new File("X:\\Einsatzverwaltung\\Einsatzverwaltung\\target\\generated-sources\\output\\testFile1.pdf");
            Desktop.getDesktop().open(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}