package InvoiceMaker.GUI;

import InvoiceMaker.businesslogic.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class EditorFrame extends JFrame {


    public EditorFrame(PDDocument document) throws IOException {
        super("GDD Rechnung erstellen");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints gbc = initGridBag(this, 5, 6, 20, 5);

        setConstraints(gbc, 0, 0, 0.4);
        add(new ConfirmationPanel(document));

        setConstraints(gbc, 0, 0, 0.2);
        add(new ControlPanel(document));

        setConstraints(gbc, 2, 0, 0.4);
        Deployment d = DeploymentBuilder.build(document);
        add(new InvoicePanel(InvoiceCreator.generateDocument(d)));

        setVisible(true);
    }

    private class ConfirmationPanel extends JPanel {
        private ConfirmationPanel(PDDocument document) throws IOException {
                PDFRenderer pdfRenderer = new PDFRenderer(document);
                BufferedImage pageImage = pdfRenderer.renderImage(0); // Render first page
                JLabel label = new JLabel(new ImageIcon(pageImage));
                add(label);
        }
    }

    private class ControlPanel extends JPanel {
        private ControlPanel (PDDocument document) {
            setLayout(new GridLayout(7, 0, 50, 50));


            JPanel currentUser = new JPanel(new GridLayout(2, 0));
            JLabel showUser = new JLabel("Bitte melden Sie sich an!");
            currentUser.add(showUser);
            JButton logIn = new JButton("Anmelden");
            logIn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new LogIn(new JPanel());
                }
            });
            currentUser.add(logIn);
            add(currentUser);

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
                    try {
                        document.save("X:\\Einsatzverwaltung\\Einsatzverwaltung\\target\\generated-sources\\output\\testFile1.pdf");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            add(saveBtn);

            JButton printBtn = new JButton("Drucken");
            add(printBtn);
        }

    }

    private class InvoicePanel extends JPanel {
        static Einsatzbestaetigung eb;

        private InvoicePanel(PDDocument document) throws IOException {
            try {
                PDFRenderer pdfRenderer = new PDFRenderer(document);
                BufferedImage pageImage = pdfRenderer.renderImage(0); // Render first page
                JLabel label = new JLabel(new ImageIcon(pageImage));
                add(label);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private GridBagConstraints initGridBag(EditorFrame frame, int top, int left, int bottom, int right) {
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(top, left, bottom, right);
        return gbc;
    }

    private void setConstraints(GridBagConstraints gbc, int gridx, int gridy, double weightx) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weightx = weightx;
    }
}
