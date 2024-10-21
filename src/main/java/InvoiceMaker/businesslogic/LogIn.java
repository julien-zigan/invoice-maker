package InvoiceMaker.businesslogic;

import InvoiceMaker.GUI.StartFrame;
import InvoiceMaker.businesslogic.Contacts.Address;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LogIn extends JDialog {
    int WIDTH = 400;
    int HEIGHT = 300;
    int X_OFFSET = 10;
    int NUM_OF_FIELDS = 8;
    int FIELDHEIGHT = HEIGHT / (NUM_OF_FIELDS - 1)  / 3;

    public static Address currentUser;

    public LogIn(JPanel currentUser) {
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

        JCheckBox stayLoggedIn = new JCheckBox("Angemeldet bleiben?");
        stayLoggedIn.setBounds(WIDTH / 4, HEIGHT / NUM_OF_FIELDS * 6, WIDTH / 2, HEIGHT / NUM_OF_FIELDS);
        panel.add(stayLoggedIn);

        JButton login = new JButton("Anmelden");
        login.setBounds(WIDTH / 2 -(WIDTH / 3 - X_OFFSET)/2, HEIGHT / NUM_OF_FIELDS * 5, WIDTH / 3 - X_OFFSET, HEIGHT / NUM_OF_FIELDS);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int permLog = stayLoggedIn.isSelected() ? 1 : 0;
                    String url = "jdbc:sqlite:seconddraft.db";
                    Connection connection = DriverManager.getConnection(url);
                    Statement statement = connection.createStatement();
                    String sql = """
                            insert into users (company, firstName, LastName, street, zipAndCity, loggedIn)
                            values ("%s", "%s", "%s", "%s", "%s", "%d")
                            """.formatted(companyInput.getText(),
                            firstNameInput.getText(),
                            lastNameInput.getText(),
                            streetInput.getText(),
                            zipAndCityInput.getText(),
                            permLog);
                    statement.executeUpdate(sql);

                } catch (SQLException se) {
                    System.err.println(se.getMessage() + "ERE AM I");
                }
                currentUser.repaint();
                setVisible(false);
                dispose();
            }

        });
        panel.add(login);



        add(panel);
        setVisible(true);

        try {
            String url = "jdbc:sqlite:seconddraft.db";
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String sql = """
                            create table if not exists users (
                                id integer primary key,
                                company text,
                                firstName text,
                                lastName text,
                                street text,
                                zipAndCity text,
                                loggedIn integer)
                            """;
            statement.executeUpdate(sql);

        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
    }
}
