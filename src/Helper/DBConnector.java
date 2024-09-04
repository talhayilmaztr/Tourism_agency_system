package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static Connection conn = null;


    // Veritabanı Bağlantı Metodu
    private Connection DBConnector() {
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USER, Config.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Veritabanı bağlantısı başarısız oldu.");
        }
        return conn;
    }

    public static Connection getInstance(){
        DBConnector dbConnector = new DBConnector();
        return dbConnector.DBConnector();
    }
}
