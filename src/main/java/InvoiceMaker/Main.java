package InvoiceMaker;

import InvoiceMaker.GUI.StartFrame;
import InvoiceMaker.businesslogic.Contacts.Address;
import InvoiceMaker.businesslogic.LogIn;

import javax.swing.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        loadUser();
        SwingUtilities.invokeLater(StartFrame::new);
    }

    private static void loadUser() {
        try {
            String url = "jdbc:sqlite:seconddraft.db";
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            String sql = """
                            SELECT company, \
                            firstName, \
                            lastName, \
                            street, \
                            zipAndCity \
                            FROM users WHERE loggedIn = 1 \
                            ORDER BY column DESC LIMIT 1
                            """;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                LogIn.currentUser = new Address(
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
    }
}
