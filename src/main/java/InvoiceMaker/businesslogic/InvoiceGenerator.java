package InvoiceMaker.businesslogic;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.File;

public class InvoiceGenerator {
    public static String generate(Einsatzbestaetigung einsatzbestaetigung) {
        String filepath = "";

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            float xOffsetTracker = 0;
            float yOffsetTracker = 0;



            PDImageXObject pdImage = PDImageXObject.createFromFile("X:\\invoice-maker\\src\\main\\resources\\logo1.PNG", document);
            contentStream.drawImage(pdImage, 380, 715);

            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 100 * 12, page.getMediaBox().getHeight() / 1000 * 806);
            xOffsetTracker += page.getMediaBox().getWidth() / 100 * 12;
            yOffsetTracker += page.getMediaBox().getHeight() / 1000 * 806;
            contentStream.showText("Anita Pacholik-Zuromska | Friedrich-Wilhelm-Str. 46A | 12103 Berlin");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 11);
            contentStream.newLineAtOffset(0,  -(page.getMediaBox().getHeight() / 1000 * 27));
            yOffsetTracker -= page.getMediaBox().getHeight() / 1000 * 27;
            contentStream.showText("Charite");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(0,  -(page.getMediaBox().getHeight() / 1000 * 17));
            yOffsetTracker -= page.getMediaBox().getHeight() / 1000 * 17;
            contentStream.showText("Finanz- und Rechnungswesen");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(0,  -(page.getMediaBox().getHeight() / 1000 * 16));
            yOffsetTracker -= page.getMediaBox().getHeight() / 1000 * 16;
            contentStream.showText("Hindenburgdamm 30");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(0,  -(page.getMediaBox().getHeight() / 1000 * 16));
            yOffsetTracker -= page.getMediaBox().getHeight() / 1000 * 16;
            contentStream.showText("12200 Berlin");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 465,  -(page.getMediaBox().getHeight() / 1000 * 58));
            xOffsetTracker += page.getMediaBox().getWidth() / 1000 * 465;
            yOffsetTracker -= page.getMediaBox().getHeight() / 1000 * 58;
            contentStream.showText("Leistungsdatum");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 159,  0);
            xOffsetTracker += page.getMediaBox().getWidth() / 1000 * 159;
            contentStream.showText("Rechnungsdatum");


            contentStream.endText();
            contentStream.close();

            filepath = "X:\\Einsatzverwaltung\\Einsatzverwaltung\\target\\generated-sources\\output\\testFile1.pdf";

            document.save(filepath);
            System.out.println("PDF created successfully.");
//            File file = new File("X:\\Einsatzverwaltung\\Einsatzverwaltung\\target\\generated-sources\\output\\testFile1.pdf");
//            Desktop.getDesktop().open(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filepath;
    }

    public static void generateFinal(Einsatzbestaetigung einsatzbestaetigung) {
        try {
            generate(einsatzbestaetigung);
            File file = new File("X:\\Einsatzverwaltung\\Einsatzverwaltung\\target\\generated-sources\\output\\testFile1.pdf");
            Desktop.getDesktop().open(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}