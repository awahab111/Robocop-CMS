package CMS.DBHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/* Things i can change
 * 1. Make new class for each table then call relevant class and also this class is inheriting the database class
 * 2. Make only one instance of database class and use it everywhere
 * 3. Make multiple packages 
 *  
 * 
 */

public class Database {
    static final String url = "jdbc:mysql://localhost:3306/cms";
    static final String uname = "root";
    static final String password = "1234";
    private Connection conn;
    public static void main(String[] args) {
        Database db = new Database();
        Connection conn = db.getconn();
        String stat = "select * from user_login";
        try{
            Statement coStatement = conn.createStatement();
            ResultSet resultSet = coStatement.executeQuery(stat);
            while (resultSet.next()) {
                String data = "";
                for (int i = 1; i <= 3; i++) {
                    data += resultSet.getString(i) + " ";
                } 
                System.out.println(data);          
            }
        }catch(SQLException e){
        }
    }
    public Database(){
       
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

