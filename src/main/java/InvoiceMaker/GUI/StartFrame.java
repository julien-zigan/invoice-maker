package InvoiceMaker.GUI;

import InvoiceMaker.businesslogic.LogIn;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class StartFrame extends JFrame {
    public StartFrame() {
        super("GDD Rechnung erstellen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(new DropPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    private class DropPanel extends JPanel {
        private DropPanel() {
            setBackground(Color.LIGHT_GRAY);
            setLayout(new BorderLayout());
            add(new DropLabel(), BorderLayout.CENTER);
            DropTargetListener dropTargetListener = new DropTargetListener() {
                @Override
                public void dragEnter(DropTargetDragEvent dtde) {
                    setBackground(Color.DARK_GRAY);
                }

                @Override
                public void dragExit(DropTargetEvent dte) {
                    setBackground(Color.LIGHT_GRAY);
                }

                @Override
                public void drop(DropTargetDropEvent dtde) {
                    dtde.acceptDrop(DnDConstants.ACTION_COPY);
                    Transferable tf = dtde.getTransferable();
                    DataFlavor[] flavors = tf.getTransferDataFlavors();
                    for (DataFlavor flavor : flavors) {
                        if (flavor.isFlavorJavaFileListType()) {
                            try {
                                java.util.List<File> files = (List) tf.getTransferData(flavor);
                                for (File file : files) {
                                    try(PDDocument document = Loader.loadPDF(file);){
                                        new EditorFrame(document);
                                    }
                                }
                            } catch (UnsupportedFlavorException | IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    setVisible(false);
                    dispose();
                }

                @Override
                public void dragOver(DropTargetDragEvent dtde) {}

                @Override
                public void dropActionChanged(DropTargetDragEvent dtde) {}
            };

            DropTarget dropTarget = new DropTarget(this, dropTargetListener);

            JPanel currentUser = new JPanel(new GridLayout(2, 0));
            JLabel showUser = new JLabel("Bitte melden Sie sich an!");
            currentUser.add(showUser);
            JButton logIn = new JButton("Anmelden");
            logIn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new LogIn();
                }
            });
            currentUser.add(logIn);
            add(currentUser);
        }
    }

    private static class DropLabel extends JLabel {
        private DropLabel() {
            setText("Drop your Deployment Confirmation here");
            setHorizontalAlignment(0);
        }
    }
}
