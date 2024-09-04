/*package comm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC {
    public static void main(String[] args) throws SQLException {

        DBConnector.getInstance();

        Statement stmt = DBConnector.conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM hotel");

        while (rs.next()) {
            int hotel_id = rs.getInt("id");
            String hotel_name = rs.getString("name");
            String hotel_address = rs.getString("address");
            String city = rs.getString("city");

            System.out.println(hotel_id +
                    ", hotel_name : " + hotel_name +
                    ", hotel_address : " + hotel_address +
                    ", city : " + city);
        }

    }
}*/