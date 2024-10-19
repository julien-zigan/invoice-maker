package InvoiceMaker.businesslogic.LetterRegions;

import InvoiceMaker.businesslogic.Address;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;

public class ReturnInformation {
    final float POS_X = 85.0394f;
    final float POS_Y = 714.3308f;
    final float HEIGHT = 50.17323f;
    final float WIDTH = 226.772f;
    final float LINEHEIGHT = 10.034646f;
    final int NUMBER_OF_LINES = 5;
    final int FONTSIZE = 8;
    final PDType1Font FONT = new PDType1Font(Standard14Fonts.FontName.HELVETICA);

    public void print(PDPageContentStream contentStream, Address sender) throws IOException {
        contentStream.newLineAtOffset(POS_X, POS_Y - LINEHEIGHT * NUMBER_OF_LINES);
        contentStream.setNonStrokingColor(0.47f, 0.47f, 0.47f);

    }
}
