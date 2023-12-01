package CMS.DBHandler;

import java.sql.*;

public class PostHandler {
    public void createPost(String content, int user_id) {
        Database db = new Database();        
        String query = "INSERT INTO posts (description,user_id ) VALUES ('" + content + "', " + user_id + " " + ")";
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(query);
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    

}
