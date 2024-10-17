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


            //TODO/////
            // float pagewidth = page.getMediaBox().getWidth();
            //    float text_width = (font.getStringWidth(text) / 1000.0f) * size;
            //    float x = pagewidth - ((paddingRight * 2) + text_width);
            //    contentStream.newLineAtOffset(x, 0);
            //    contentStream.setFont(font, size);
            //    contentStream.showText(text);
            //    contentStream.newLineAtOffset(-x, 0);

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
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 806);
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


        //Rechnung Heading
            contentStream.beginText();

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 20);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 120,  page.getMediaBox().getHeight() / 1000 * 591);
            contentStream.showText("Rechnung Nr. 12345");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(0,  -(page.getMediaBox().getHeight() / 1000 * 33));
            contentStream.showText("Ich bedanke mich für die gute Zusammenarbeit und stelle Ihnen vereinbarungsgemäß folgende");

            contentStream.newLineAtOffset(0,  -(page.getMediaBox().getHeight() / 1000 * 13));
            contentStream.showText("Leistungen in Rechnung:");

            contentStream.endText();

//HorizontalLine
            contentStream.beginText();
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 120,  page.getMediaBox().getHeight() / 1000 * 522);
            contentStream.showText("__________________________________________________________________________________");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 120,  page.getMediaBox().getHeight() / 1000 * 500);
            contentStream.showText("Pos.");

            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 72,  0);
            contentStream.showText("Bezeichnung");

            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 334,  0);
            contentStream.showText("Menge");

            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 180,  0);
            contentStream.showText("Einzel (€)");

            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 93,  0);
            contentStream.showText("Gesamt (€)");

            contentStream.endText();

            //HorizontalLine
            contentStream.beginText();
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 120,  page.getMediaBox().getHeight() / 1000 * 485);
            contentStream.showText("__________________________________________________________________________________");
            contentStream.endText();

            //einzelpositionen
            contentStream.beginText();
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 120,  page.getMediaBox().getHeight() / 1000 * 460);
            contentStream.showText("1");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 72,  0);
            contentStream.showText("Dolmetschen");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 334,  0);
            contentStream.showText("1 Stunde");

            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 180,  0);
            contentStream.showText("      50,00");

            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 93,  0);
            contentStream.showText("       50,00");

            contentStream.newLineAtOffset(-(page.getMediaBox().getWidth() / 1000 * 607),  -(page.getMediaBox().getHeight() / 1000 * 14));
            contentStream.showText("Deutsch-Polnisch / Polnisch-Deutsch");

            contentStream.endText();


            contentStream.beginText();
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 120,  page.getMediaBox().getHeight() / 1000 * 421);
            contentStream.showText("2");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 72,  0);
            contentStream.showText("Anfahrt");

            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 334,  0);
            contentStream.showText("Pauschaul");

            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 180,  0);
            contentStream.showText("      10,00");

            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 93,  0);
            contentStream.showText("       10,00");

            contentStream.endText();

            // Summe Netto
            contentStream.beginText();
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 672, page.getMediaBox().getHeight() / 1000 * 364);
            contentStream.showText("Summe Netto");

            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 168, 0);
            contentStream.showText("€ 60,00");
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 120,  page.getMediaBox().getHeight() / 1000 * 345);
            contentStream.showText("__________________________________________________________________________________");
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 120,  page.getMediaBox().getHeight() / 1000 * 323);
            contentStream.showText("Gemäß §19 Abs. 1 UstG wird keine Umsatzsteuer ausgewiesen     € 0");
            contentStream.endText();


            contentStream.beginText();
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);

            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 120,  page.getMediaBox().getHeight() / 1000 * 308);
            contentStream.showText("__________________________________________________________________________________");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 672, page.getMediaBox().getHeight() / 1000 * 286);
            contentStream.showText("Rechnungsbetrag € 60");
            contentStream.endText();

            contentStream.beginText();
            contentStream.setNonStrokingColor(0.7f,0.7f,0.7f);
            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
            contentStream.newLineAtOffset(page.getMediaBox().getWidth() / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 268);
            contentStream.showText("__________________________________________________________________________________");
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