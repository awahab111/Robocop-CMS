package CMS.DBHandler;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PostHandler {
    Database db = Database.getInstance();

    public void createPost(String content, int user_id) {
        
        java.util.Date currentDate = new java.util.Date();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(currentDate);
        java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);

        // Create a time variable with the current time
        java.sql.Time sqlTime = new java.sql.Time(currentDate.getTime());
        
        String query = "INSERT INTO post (description,user_id, pub_date, pub_time ) VALUES ('" + content + "', " + user_id + ", '"+ sqlDate +"' , '"+ sqlTime +"' )";
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(query);
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    

}
