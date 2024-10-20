//package InvoiceMaker.businesslogic;
//
//import InvoiceMaker.businesslogic.Contacts.Address;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.common.PDRectangle;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
//import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
//import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
//
//import java.awt.*;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//
//
//public class InvoiceGenerator {
//    static final float WIDTH = 595.27563f;
//    static final float HEIGHT = 841.8898f;
//    static final PDType1Font FONT = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
//
//    static String filepath = "";
//    static PDDocument document;
//    static PDPage page;
//    static PDPageContentStream contentStream;
//
//    public static String generate(Einsatzbestaetigung einsatzbestaetigung /*User w/ credentials incl. logo */) {
//
//        try {
//            setUpDocument();
//            printLogo("X:\\invoice-maker\\src\\main\\resources\\logo1.PNG"/*replace when user class exists*/,
//                    new Point(380, 715));
////            printAdressField(
////                    new Address("Company", "First", "Last", "Street", "City"),
////                    new Address("Anita", "Pacholik", "Friedo", "Berlin"));
////
//
//
//
//            //Referenzzeile
//            //Leistungsdatum
//            contentStream.beginText();
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
//
//            contentStream.newLineAtOffset(WIDTH / 1000 * 585, page.getMediaBox().getHeight() / 1000 * 672);
//            contentStream.showText("Leistungsdatum");
//
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 9);
//            contentStream.newLineAtOffset(0, -(page.getMediaBox().getHeight() / 1000 * 14));
//            contentStream.showText("TT.MM.JJJJ");
//
//            contentStream.endText();
//
//            //Rechnungsdatum
//            contentStream.beginText();
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
//
//            contentStream.newLineAtOffset(WIDTH / 1000 * 744, page.getMediaBox().getHeight() / 1000 * 672);
//            contentStream.showText("Rechnungsdatum");
//
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 9);
//            contentStream.newLineAtOffset(0, -(page.getMediaBox().getHeight() / 1000 * 14));
//            contentStream.showText("TT.MM.JJJJ");
//
//            contentStream.endText();
//
//
//            //Rechnung Heading
//            contentStream.beginText();
//
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 20);
//            contentStream.newLineAtOffset(WIDTH / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 591);
//            contentStream.showText("Rechnung Nr. 12345");
//
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
//            contentStream.newLineAtOffset(0, -(page.getMediaBox().getHeight() / 1000 * 33));
//            contentStream.showText("Ich bedanke mich für die gute Zusammenarbeit und stelle Ihnen vereinbarungsgemäß folgende");
//
//            contentStream.newLineAtOffset(0, -(page.getMediaBox().getHeight() / 1000 * 13));
//            contentStream.showText("Leistungen in Rechnung:");
//
//            contentStream.endText();
//
////HorizontalLine
//            contentStream.beginText();
//            contentStream.newLineAtOffset(WIDTH / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 522);
//            contentStream.showText("__________________________________________________________________________________");
//            contentStream.endText();
//
//            contentStream.beginText();
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
//            contentStream.newLineAtOffset(WIDTH / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 500);
//            contentStream.showText("Pos.");
//
//            contentStream.newLineAtOffset(WIDTH / 1000 * 72, 0);
//            contentStream.showText("Bezeichnung");
//
//            contentStream.newLineAtOffset(WIDTH / 1000 * 334, 0);
//            contentStream.showText("Menge");
//
//            contentStream.newLineAtOffset(WIDTH / 1000 * 180, 0);
//            contentStream.showText("Einzel (€)");
//
//            contentStream.newLineAtOffset(WIDTH / 1000 * 93, 0);
//            contentStream.showText("Gesamt (€)");
//
//            contentStream.endText();
//
//            //HorizontalLine
//            contentStream.beginText();
//            contentStream.newLineAtOffset(WIDTH / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 485);
//            contentStream.showText("__________________________________________________________________________________");
//            contentStream.endText();
//
//            //einzelpositionen
//            contentStream.beginText();
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
//            contentStream.newLineAtOffset(WIDTH / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 460);
//            contentStream.showText("1");
//
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
//            contentStream.newLineAtOffset(WIDTH / 1000 * 72, 0);
//            contentStream.showText("Dolmetschen");
//
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
//            contentStream.newLineAtOffset(WIDTH / 1000 * 334, 0);
//            contentStream.showText("1 Stunde");
//
//            contentStream.newLineAtOffset(WIDTH / 1000 * 180, 0);
//            contentStream.showText("      50,00");
//
//            contentStream.newLineAtOffset(WIDTH / 1000 * 93, 0);
//            contentStream.showText("       50,00");
//
//            contentStream.newLineAtOffset(-(WIDTH / 1000 * 607), -(page.getMediaBox().getHeight() / 1000 * 14));
//            contentStream.showText("Deutsch-Polnisch / Polnisch-Deutsch");
//
//            contentStream.endText();
//
//
//            contentStream.beginText();
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
//            contentStream.newLineAtOffset(WIDTH / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 421);
//            contentStream.showText("2");
//
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
//            contentStream.newLineAtOffset(WIDTH / 1000 * 72, 0);
//            contentStream.showText("Anfahrt");
//
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
//            contentStream.newLineAtOffset(WIDTH / 1000 * 334, 0);
//            contentStream.showText("Pauschal");
//
//            contentStream.newLineAtOffset(WIDTH / 1000 * 180, 0);
//            contentStream.showText("      10,00");
//
//            contentStream.newLineAtOffset(WIDTH / 1000 * 93, 0);
//            contentStream.showText("       10,00");
//
//            contentStream.endText();
//
//            // Summe Netto
//            contentStream.beginText();
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
//            contentStream.newLineAtOffset(WIDTH / 1000 * 672, page.getMediaBox().getHeight() / 1000 * 364);
//            contentStream.showText("Summe Netto");
//
//            contentStream.newLineAtOffset(WIDTH / 1000 * 168, 0);
//            contentStream.showText("€ 60,00");
//            contentStream.endText();
//
//            contentStream.beginText();
//            contentStream.newLineAtOffset(WIDTH / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 345);
//            contentStream.showText("__________________________________________________________________________________");
//            contentStream.endText();
//
//            contentStream.beginText();
//            contentStream.newLineAtOffset(WIDTH / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 323);
//            contentStream.showText("Gemäß §19 Abs. 1 UstG wird keine Umsatzsteuer ausgewiesen     € 0");
//            contentStream.endText();
//
//
//            contentStream.beginText();
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
//
//            contentStream.newLineAtOffset(WIDTH / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 308);
//            contentStream.showText("__________________________________________________________________________________");
//            contentStream.endText();
//
//            contentStream.beginText();
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA_BOLD)), 10);
//            contentStream.newLineAtOffset(WIDTH / 1000 * 672, page.getMediaBox().getHeight() / 1000 * 286);
//            contentStream.showText("Rechnungsbetrag € 60");
//            contentStream.endText();
//
//            contentStream.beginText();
//            contentStream.setNonStrokingColor(0.7f, 0.7f, 0.7f);
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
//            contentStream.newLineAtOffset(WIDTH / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 268);
//            contentStream.showText("__________________________________________________________________________________");
//            contentStream.endText();
//
//
//            contentStream.beginText();
//            contentStream.setNonStrokingColor(0f, 0f, 0f);
//            contentStream.setFont(new PDType1Font((Standard14Fonts.FontName.HELVETICA)), 10);
//            contentStream.newLineAtOffset(WIDTH / 1000 * 120, page.getMediaBox().getHeight() / 1000 * 231);
//            contentStream.showText("Zahlung bitte innerhalb von 14 Tagen an die folgende Bankverbindung:");
//            contentStream.newLineAtOffset(WIDTH / 1000 * 72, -(page.getMediaBox().getHeight() / 1000 * 20));
//            contentStream.showText("Berliner Sparkasse");
//            contentStream.newLineAtOffset(0, -(page.getMediaBox().getHeight() / 1000 * 15));
//            contentStream.showText("IBAN: DE21100500001070507390");
//            contentStream.newLineAtOffset(0, -(page.getMediaBox().getHeight() / 1000 * 15));
//            contentStream.showText("BIC: BELADEBEXXX");
//            contentStream.newLineAtOffset(0, -(page.getMediaBox().getHeight() / 1000 * 15));
//            contentStream.showText("Kto. Inh: Anita Pacholik-Zuromska");
//            contentStream.newLineAtOffset(-(WIDTH / 1000 * 72), -(page.getMediaBox().getHeight() / 1000 * 30));
//            contentStream.showText("Mit freundlichen Grüßen");
//            contentStream.endText();
//
//
//            contentStream.close();
//
//            filepath = "X:\\Einsatzverwaltung\\Einsatzverwaltung\\target\\generated-sources\\output\\testFile1.pdf";
//
//            document.save(filepath);
//            System.out.println("PDF created successfully.");
////            File file = new File("X:\\Einsatzverwaltung\\Einsatzverwaltung\\target\\generated-sources\\output\\testFile1.pdf");
////            Desktop.getDesktop().open(file);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return filepath;
//    }
//
//    public static void generateFinal(Einsatzbestaetigung einsatzbestaetigung) {
//        try {
//            generate(einsatzbestaetigung);
//            File file = new File("X:\\Einsatzverwaltung\\Einsatzverwaltung\\target\\generated-sources\\output\\testFile1.pdf");
//            Desktop.getDesktop().open(file);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void setUpDocument() throws IOException {
//        document = new PDDocument();
//        page = new PDPage(PDRectangle.A4);
//        document.addPage(page);
//        contentStream = new PDPageContentStream(document, page);
//    }
//
//    private static void setFoldMark() {
//
//    }
//
//    private static void setPosition(float x, float y) throws IOException {
//        contentStream.beginText();
//        contentStream.newLineAtOffset(x, y);
//    }
//
//    private static void printLogo(String filepath, Point position) throws IOException {
//        PDImageXObject pdImage = PDImageXObject.createFromFile(filepath, document);
//        contentStream.drawImage(pdImage, position.x, position.y);
//    }
//
//    private static class AddressField {
//        static final float POSITION_X = 70.8661f;
//        static final float POSITION_Y = 714.331f;
//        static final float WIDTH = 226.772f;
//        static final float HEIGHT = 127.559f;
//        static final int FONT_SIZE_SENDER = 8;
//        static final int FONT_SIZE_RECEIVER_COMPANY = 11;
//        static final int FONT_SIZE_RECEIVER = 10;
//        static Address sender;
//        static Address recipient;
//
//        private static void print(Address sender, Address recipient)
//                throws IOException {
//            AddressField.sender = sender;
//            AddressField.recipient = recipient;
//            setPosition(POSITION_X, POSITION_Y);
//            printAddress();
//            contentStream.endText();
//        }
//
//        private static void printAddress() {
//            verticalAlignCenter();
//            printSender();
//          //  printRecipient();
//        }
//
//        private static void verticalAlignCenter() {
//            ArrayList<String> formattedSenderAdress = formatSenderAdress();
////            formatRecipientAdress();
////            int y = calculateOffset();
////            contentStream.newLineAtOffset(0, y);
//        }
//
//        private static ArrayList<String> formatSenderAdress() throws IOException {
//            StringBuilder senderAdressLine = new StringBuilder();
//
//            ArrayList<String> items = sender.getItems();
//            for (int i = 0; i + 1 < items.size(); i++) {
//                if (items.get(i).isEmpty()) {
//                    continue;
//                }
//                senderAdressLine.append(items.get(i));
//                senderAdressLine.append(" | ");
//            }
//            senderAdressLine.append(items.getLast());
//
//            contentStream.setFont(FONT, AddressField.FONT_SIZE_SENDER);
//            float textWidth = FONT.getStringWidth(senderAdressLine.toString()) / 1000.0f * FONT_SIZE_SENDER;
//          //  if (
//
//        }
//
//    }
//
//
//////////////////////////////////////////////////////////////////////////////////
//        ///////////////SenderField////////////
//
//
//        for (int i = 0; i + 1 < items.size(); i++) {
//            if (items.get(i).isEmpty()) {
//                continue;
//            }
//            recipientAdressLine.append(items.get(i));
//            recipientAdressLine.append(" | ");
//        }
//        recipientAdressLine.append(items.getLast());
//
//        PDType1Font normalFont = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
//        PDType1Font boldFont = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
//
//        contentStream.setFont(normalFont, 8);
//        float textWidth = normalFont.getStringWidth(recipientAdressLine.toString()) / 1000.0f * 8;
//
//        float totalHeight = 0;
//
//        if (textWidth <= WIDTH) {
//            totalHeight += 8;
//        }
//        ArrayList<String> recipientTtems = recipient.getItems();
//        if (!recipientTtems.getFirst().isEmpty()) {
//            totalHeight += 20;
//        }
//        for (int i = 1; i < recipientTtems.size(); i++) {
//            totalHeight += 14;
//        }
//
//        float startOffsetY= -((HEIGHT - totalHeight) / 2);
//
//
//        contentStream.newLineAtOffset(0, startOffsetY - 8);
//        contentStream.setNonStrokingColor(0.47f, 0.47f, 0.47f);
//        contentStream.showText(recipientAdressLine.toString());
//        contentStream.setNonStrokingColor(0f, 0f, 0f);
//
//        contentStream.setFont(boldFont, 11);
//        if (!recipientTtems.getFirst().isEmpty()) {
//
//            contentStream.newLineAtOffset(0, -20);
//            contentStream.showText(recipientTtems.getFirst());
//        }
//
//        contentStream.setFont(normalFont, 10);
//        for (int i = 1; i < recipientTtems.size(); i++) {
//            contentStream.newLineAtOffset(0, -14);
//            contentStream.showText(recipientTtems.get(i));
//        }
//
//        contentStream.endText();
//    }
//
//
//
//
//
//
//    private void printSender(Address sender) {
//        setPosition();
//    }
//
////    public static void main(String[] args) {
////        Adress sender = new Adress("Com", "First", "Last", "Street", "City");
////
////        try {
////            setUpDocument();
////            addAdressField(contentStream, sender);
////        } catch (Exception e) {System.out.println(e);}
////    }
//}
//
//
////TODO/////
//// float pagewidth = paOge.getMediaBox().getWidth();
////    float text_width = (font.getStringWidth(text) / 1000.0f) * size;
////    float x = pagewidth - ((paddingRight * 2) + text_width);
////    contentStream.newLineAtOffset(x, 0);
////    contentStream.setFont(font, size);
////    contentStream.showText(text);
////    contentStream.newLineAtOffset(-x, 0);
//// Document WIDTH: 595.27563
//// Document height: 841.8898
//
