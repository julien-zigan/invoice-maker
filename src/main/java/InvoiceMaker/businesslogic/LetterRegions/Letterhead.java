package InvoiceMaker.businesslogic.LetterRegions;


import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.IOException;

public class Letterhead {
    final float POS_X = 0f;
    final float POS_Y = 841.8898f;
    final float HEIGHT = 127.559f;
    final float WIDTH = 595.27563f;

    public Letterhead(PDPageContentStream contentStream) throws IOException {
        contentStream.newLineAtOffset(POS_X, POS_Y);
    }
}
