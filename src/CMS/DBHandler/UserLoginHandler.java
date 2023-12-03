package CMS.DBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLoginHandler {
    Database db = Database.getInstance();

    public boolean checkUser(String username){
        java.sql.Connection conn = db.getconn();
        String stat = "select * from user_login where username = '" + username + "' ";
        try{
            Statement coStatement = conn.createStatement();
            ResultSet resultSet = coStatement.executeQuery(stat);
            return resultSet.next();
        }catch(SQLException e){
            return false;
        }
    }

    public int getUserID(String username, String password){
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
        java.sql.Connection conn = db.getconn();
        String stat = "insert into user_login (username, password) values ('" + username + "', '" + password + "')";
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(stat);
        }catch(SQLException e){
        }
    }


}
