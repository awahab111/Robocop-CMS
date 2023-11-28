package CMS.DBHandler;

import java.sql.SQLException;
import java.sql.Statement;

public class FIRHandler {
    public void insertFIR(String date, String time, String location, String description, String status, String evidence, int crimeDescId) {
        String query = "INSERT INTO FIR (pub_date, pub_time, location, description, assigned_status, evidence, crime_desc_id) VALUES ('" + date + "', '" + time + "', '" + location + "', '" + description + "', " + status + ", '" + evidence + "', " + crimeDescId + ")";
        Database db = new Database();
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(query);
        }catch(SQLException e){
        }
        
    }
}
