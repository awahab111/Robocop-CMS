package CMS.DBHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static Database instance = null;;

    static final String url = "jdbc:mysql://localhost:3306/cms";
    static final String uname = "root";
    static final String password = "1234";

    private Connection conn;

    public static Database getInstance(){
        if (instance == null) {
            Database.instance = new Database();
        }
        return instance;
    }

    private Database(){
       
        try {
            conn = DriverManager.getConnection(url, uname, password);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }

    public Connection getconn(){
        return conn;
    }

    
}

