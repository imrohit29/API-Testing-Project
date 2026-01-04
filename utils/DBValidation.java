package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBValidation {

    private static String dbURL = "jdbc:mysql://localhost:3306/mydb";
    private static String dbUser = "root";
    private static String dbPass = "root";

    public static boolean isProductInCart(String userId, String productId) {
        boolean exists = false;
        try {
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM cart WHERE user_id='" + userId + "' AND product_id='" + productId + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                exists = true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }
}
