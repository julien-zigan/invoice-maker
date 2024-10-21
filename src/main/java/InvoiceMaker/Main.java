package InvoiceMaker;

import InvoiceMaker.GUI.StartFrame;
import InvoiceMaker.businesslogic.Contacts.Address;

import javax.swing.*;
import java.sql.*;

public class Main {
    public static Address user;

    public static void main(String[] args) {

        try {
            String url = "jdbc:sqlite:seconddraft.db";
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String sql = """
                            select company, firstName, lastName, street, zipAndCity from users where loggedIn = 1
                            """;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                user = new Address(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }

        } catch (SQLException se) {
            System.err.println(se.getMessage());
        }
        SwingUtilities.invokeLater(StartFrame::new);
    }
}
