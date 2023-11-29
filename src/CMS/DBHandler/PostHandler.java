package CMS.DBHandler;

import java.sql.*;

public class PostHandler {
    public void createPost(String content, Date date, Time time) {
        Database db = new Database();        
        String query = "INSERT INTO posts (description, pub_dat, pub_time) VALUES ('" + content + "', '" + date + "', '" + time +"'";
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(query);
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    

}
