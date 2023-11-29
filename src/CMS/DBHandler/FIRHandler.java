package CMS.DBHandler;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class FIRHandler {
    public void insertFIR(Date sqlDate, Time time, String location, String description, String evidence, int crimeDescId , int user_id) {
        String query = "INSERT INTO FIR (pub_date, pub_time, location, description, evidence, crime_desc_id, user_id) VALUES ('" + sqlDate + "', '" + time + "', '" + location + "', '" + description + "', '" + evidence + "', " + crimeDescId + ", " + user_id + ")";
        Database db = new Database();
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(query);
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
}
