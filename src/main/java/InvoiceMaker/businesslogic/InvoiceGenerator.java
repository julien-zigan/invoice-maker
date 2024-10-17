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


            //TODO////////////////
            //You are starting at (0,0) after calling contents.beginText();
            // . Thus if you want to work with absolute positions only, then put only one (absolute) positioning in a contents.beginText();
            // … contents.endText(); segment.
            //TODO////////////////


            //Seite initialisieren, contenstream öffnen
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);


            // logo
            PDImageXObject pdImage = PDImageXObject.createFromFile("X:\\invoice-maker\\src\\main\\resources\\logo1.PNG", document);
            contentStream.drawImage(pdImage, 380, 715);




        //Adressfeld
            contentStream.beginText();

            //Absender
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 100 * 12, page.getMediaBox().getHeight() / 1000 * 806);
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8);
            contentStream.showText("Anita Pacholik-Zuromska | Friedrich-Wilhelm-Str. 46A | 12103 Berlin");

        //Empfängeranschrift
            // Firmenname/ Empfänger /Kunde
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 11);
            contentStream.newLineAtOffset(0,  -(page.getMediaBox().getHeight() / 1000 * 27));
            contentStream.showText("Charite");

            // Bearbeiter / Abteilung
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(0,  -(page.getMediaBox().getHeight() / 1000 * 17));
            contentStream.showText("Finanz- und Rechnungswesen");

            //Straße
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(0,  -(page.getMediaBox().getHeight() / 1000 * 16));
            contentStream.showText("Hindenburgdamm 30");

            //PLZ Ort
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(0,  -(page.getMediaBox().getHeight() / 1000 * 16));
            contentStream.showText("12200 Berlin");

            contentStream.endText();



        //Referenzzeile
            //Leistungsdatum
            contentStream.beginText();
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);

            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 585,  page.getMediaBox().getHeight() / 1000 * 672);
            contentStream.showText("Leistungsdatum");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 9);
            contentStream.newLineAtOffset(0,  -(page.getMediaBox().getHeight() / 1000 * 14));
            contentStream.showText("TT.MM.JJJJ");

            contentStream.endText();

            //Rechnungsdatum
            contentStream.beginText();
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);

            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 744,  page.getMediaBox().getHeight() / 1000 * 672);
            contentStream.showText("Rechnungsdatum");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 9);
            contentStream.newLineAtOffset(0,  -(page.getMediaBox().getHeight() / 1000 * 14));
            contentStream.showText("TT.MM.JJJJ");

            contentStream.endText();





        //Referenzzeile data
            contentStream.beginText();

            //Leistungsdatumheader


            //Rechnungsdatumheader
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 159,  0);
            contentStream.showText("TT.MM.JJJJ");

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