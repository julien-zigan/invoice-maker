package InvoiceMaker.businesslogic;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.IOException;
import java.util.StringTokenizer;

public class RecipientCompositor {
    public static void compose(PDPageContentStream cs, String address) throws IOException {
        StringTokenizer tokens = new StringTokenizer(address, "\r\n");
        while (tokens.hasMoreTokens()) {
            cs.showText(tokens.nextToken().trim());
            cs.newLineAtOffset(0, -20);
        }
    }

    public static String compose(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokens = tokenize(s);
        while (tokens.hasMoreTokens()) {
           sb.append(tokens.nextToken());
           sb.append("\r\n");
       }
       return sb.toString();
    }

    private static StringTokenizer tokenize(String s) {
        String noRN = s.replaceAll("\r\n", "");
        return new StringTokenizer(noRN, ",");
    }
}
