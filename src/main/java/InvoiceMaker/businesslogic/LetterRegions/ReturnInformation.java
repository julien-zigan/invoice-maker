package InvoiceMaker.businesslogic.LetterRegions;

import InvoiceMaker.businesslogic.Contacts.Address;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;
import java.util.ArrayList;


    //TODO: Handle too long lines by abbreviating/throwing err resp.

public class ReturnInformation {
    static final float POS_X = 85.0394f;
    static final float POS_Y = 714.3308f;
    static final float HEIGHT = 50.17323f;
    static final float WIDTH = 226.772f;
    static final float LINEHEIGHT = 10.034646f;
    static final int NUMBER_OF_LINES = 5;
    static final int FONTSIZE = 8;
    static final PDType1Font FONT = new PDType1Font(Standard14Fonts.FontName.HELVETICA);

    public static void print(PDPageContentStream contentStream, Address sender) throws IOException {
        contentStream.beginText();
        contentStream.newLineAtOffset(POS_X, POS_Y - LINEHEIGHT * NUMBER_OF_LINES);
        contentStream.setNonStrokingColor(0.47f, 0.47f, 0.47f);
        contentStream.setFont(FONT, FONTSIZE);
        String addressLine = setUpAddressLine(sender);
        contentStream.showText(addressLine);
        contentStream.endText();
    }

    private static String setUpAddressLine(Address address) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> items = address.getItems();
        if (!items.getFirst().isEmpty()) {
            sb.append(items.getFirst());
            sb.append(" | ");
        }
        for (int i = 1; i < items.size() - 1; i++) {
            sb.append(items.get(i));
            sb.append(" | ");
        }
        return sb.toString();
    }
}
