package InvoiceMaker.GUI;

import InvoiceMaker.businesslogic.Einsatzbestaetigung;
import InvoiceMaker.businesslogic.EinsatzbestaetigungBuilder;
import InvoiceMaker.businesslogic.InvoiceGenerator;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EditorFrame extends JFrame {


    public EditorFrame(File deploymentConfirmationPDF) throws IOException {
        super("GDD Rechnung erstellen");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 20, 5, 20);

        // First Column = Deployment Confirmation View
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        add(new ConfirmationPanel(deploymentConfirmationPDF));

        // Control Panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        add(new ControlPanel(deploymentConfirmationPDF));

        // Invoice View
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        add(new InvoicePanel(deploymentConfirmationPDF));


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
        }
    }

    private class ControlPanel extends JPanel {
        private ControlPanel (File deploymentConfirmationPDF) {
            setLayout(new GridLayout(6, 0, 50, 50));

            JButton editBtn = new JButton("Daten korrigieren");
            add(editBtn);

            JPanel hoursPanel = new JPanel();
            JLabel hoursLabel = new JLabel("Geleistete Stunden");
            hoursPanel.add(hoursLabel);
            Float[] h = {1f, 2f, 2.5f, 3f, 3.5f, 4f, 4.5f, 5f};
            JComboBox<Float> hourSetter = new JComboBox<>(h);
            hoursPanel.add(hourSetter);
            add(hoursPanel);

            JPanel ratePanel = new JPanel();
            JLabel rateLabel = new JLabel("Stundensatz in Euro");
            ratePanel.add(rateLabel);
            Float[] r = {30f, 35f, 40f, 45f, 50f, 55f, 60f, 65f, 70f, 75f, 80f, 85f, 90f, 95f, 100f};
            JComboBox<Float> rateSetter = new JComboBox<>(r);
            rateSetter.setSelectedIndex(4);
            ratePanel.add(rateSetter);
            add(ratePanel);

            JPanel signaturePanel = new JPanel(new GridLayout(3, 0));
            JLabel signatureLabel = new JLabel("Unterschrift hinzufügen");
            signaturePanel.add(signatureLabel);

            ButtonGroup bg = new ButtonGroup();
            JRadioButton manual = new JRadioButton("von Hand");
            manual.setSelected(true);
            JRadioButton automatic = new JRadioButton("automatisch");
            bg.add(manual);
            bg.add(automatic);
            signaturePanel.add(manual);
            signaturePanel.add(automatic);

            add(signaturePanel);

            JButton saveBtn = new JButton("Speichern");
            saveBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InvoiceGenerator.generateFinal(InvoicePanel.eb);
                }
            });
            add(saveBtn);

            JButton printBtn = new JButton("Drucken");
            add(printBtn);
        }

    }

    private class InvoicePanel extends JPanel {
        static Einsatzbestaetigung eb;

        private InvoicePanel(File deploymentConfirmationPDF) throws IOException {
            try {
                eb = EinsatzbestaetigungBuilder.build(deploymentConfirmationPDF);
                String filepath = InvoiceGenerator.generate(eb);
                File file = new File(filepath);
                PDDocument doc = Loader.loadPDF(file);
                PDFRenderer pdfRenderer = new PDFRenderer(doc);
                BufferedImage pageImage = pdfRenderer.renderImage(0); // Render first page
                JLabel label = new JLabel(new ImageIcon(pageImage));
                add(label);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
