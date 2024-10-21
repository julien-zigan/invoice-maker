package InvoiceMaker.businesslogic;

import javax.swing.*;
import java.awt.*;

public class LogIn extends JDialog {
    int WIDTH = 400;
    int HEIGHT = 300;
    int X_OFFSET = 10;
    int NUM_OF_FIELDS = 6;
    int FIELDHEIGHT = HEIGHT / (NUM_OF_FIELDS - 1)  / 3;

    public LogIn() {
        setTitle("Anmelden");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel company = new JLabel("Firma");
        company.setBounds(X_OFFSET, 0, WIDTH / 3 - X_OFFSET, HEIGHT / NUM_OF_FIELDS);
        panel.add(company);
        JTextField companyInput = new JTextField(15);
        companyInput.setBounds(WIDTH / 3 -X_OFFSET, HEIGHT / NUM_OF_FIELDS / 2 - FIELDHEIGHT / 2, WIDTH * 2 / 3 - X_OFFSET, FIELDHEIGHT);
        panel.add(companyInput);


        JLabel firstName = new JLabel("Vorname");
        firstName.setBounds(X_OFFSET, HEIGHT / NUM_OF_FIELDS, WIDTH / 3 - X_OFFSET, HEIGHT / NUM_OF_FIELDS);
        panel.add(firstName);
        JTextField firstNameInput = new JTextField(20);
        firstNameInput.setBounds(WIDTH / 3 -X_OFFSET, HEIGHT / NUM_OF_FIELDS + FIELDHEIGHT, WIDTH * 2 / 3 - X_OFFSET, FIELDHEIGHT);
        panel.add(firstNameInput);

        JLabel lastName = new JLabel("Nachname");
        lastName.setBounds(X_OFFSET, HEIGHT / NUM_OF_FIELDS * 2, WIDTH / 3 - X_OFFSET, HEIGHT / NUM_OF_FIELDS);
        panel.add(lastName);
        JTextField lastNameInput = new JTextField(20);
        lastNameInput.setBounds(WIDTH / 3 -X_OFFSET, HEIGHT / NUM_OF_FIELDS * 2 + FIELDHEIGHT, WIDTH * 2 / 3 - X_OFFSET, FIELDHEIGHT);
        panel.add(lastNameInput);

        JLabel street = new JLabel("Straße");
        street.setBounds(X_OFFSET, HEIGHT / NUM_OF_FIELDS * 3, WIDTH / 3 - X_OFFSET, HEIGHT / NUM_OF_FIELDS);
        panel.add(street);
        JTextField streetInput = new JTextField(20);
        streetInput.setBounds(WIDTH / 3 -X_OFFSET, HEIGHT / NUM_OF_FIELDS * 3 + FIELDHEIGHT, WIDTH * 2 / 3 - X_OFFSET, FIELDHEIGHT);
        panel.add(streetInput);

        JLabel zipAndCity = new JLabel("PLZ und Stadt");
        zipAndCity.setBounds(X_OFFSET, HEIGHT / NUM_OF_FIELDS * 4, WIDTH / 3 - X_OFFSET, HEIGHT / NUM_OF_FIELDS);
        panel.add(zipAndCity);
        JTextField zipAndCityInput = new JTextField(20);
        zipAndCityInput.setBounds(WIDTH / 3 -X_OFFSET, HEIGHT / NUM_OF_FIELDS * 4 + FIELDHEIGHT, WIDTH * 2 / 3 - X_OFFSET, FIELDHEIGHT);
        panel.add(zipAndCityInput);

        add(panel);
        setVisible(true);
    }
}
