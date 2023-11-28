package CMS.DBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLoginHandler {
    public int getUserID(String username, String password){
        Database db = new Database();
        java.sql.Connection conn = db.getconn();
        String stat = "select userid from user_login where username = '" + username + "' AND password = '" + password + "'";
        try{
            Statement coStatement = conn.createStatement();
            ResultSet resultSet = coStatement.executeQuery(stat);
            resultSet.next();
            return resultSet.getInt(1);
        }catch(SQLException e){
            return -1;
        }
    }

    public void insertUser(String username, String password){
        Database db = new Database();
        java.sql.Connection conn = db.getconn();
        String stat = "insert into user_login (username, password) values ('" + username + "', '" + password + "')";
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(stat);
        }catch(SQLException e){
        }
    }


}
