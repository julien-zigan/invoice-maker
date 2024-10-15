package InvoiceMaker;

import InvoiceMaker.GUI.StartFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(StartFrame::new);
    }
}
