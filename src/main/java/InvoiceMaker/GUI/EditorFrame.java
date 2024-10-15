package InvoiceMaker.GUI;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EditorFrame extends JFrame {


    public EditorFrame(File deploymentConfirmationPDF) throws IOException {
        super("GDD Rechnung erstellen");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2));
        add(new ConfirmationPanel(deploymentConfirmationPDF));
        setVisible(true);
    }

    private class ConfirmationPanel extends JPanel {
        private ConfirmationPanel(File deploymentConfirmationPDF) throws IOException {
            try (PDDocument document = Loader.loadPDF(deploymentConfirmationPDF)){
                PDFRenderer pdfRenderer = new PDFRenderer(document);
                BufferedImage pageImage = pdfRenderer.renderImage(0); // Render first page
                JLabel label = new JLabel(new ImageIcon(pageImage));
                add(label);

            } catch (IOException e) {
                e.printStackTrace();
            }

            /////////For visual testing only/////////
            setBackground(Color.yellow);
            ///////////////////////////////////////
        }
    }



//////////////QUICK-TESTING///////////////
//    public static void main(String[] args) {
//        new EditorFrame();
//    }
////////////////////////////////////////////
}
