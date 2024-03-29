package DBHandler;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import CMS.FIR.FIR;

public class FIRHandler {

    Database db = Database.getInstance();

    public void insertFIR(Date sqlDate, Time time, String location, String description, String evidence, int crimeDescId , int user_id) {
        String query = "INSERT INTO FIR (pub_date, pub_time, location, description, evidence, crime_desc_id, user_id) VALUES ('" + sqlDate + "', '" + time + "', '" + location + "', '" + description + "', '" + evidence + "', " + crimeDescId + ", " + user_id + ")";
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(query);
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }

    public void updateFIR(int FIR_id, String investi_report) {
        String query = "update fir set investigation_report = '"+ investi_report +"' where FIR_id = "+ FIR_id +" ";
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(query);
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public ArrayList<Integer> getFIRs(int user_id) {
        ArrayList<Integer> firList = new ArrayList<Integer>();
        String query = "SELECT * FROM FIR where user_id = "+ user_id +" " ;
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            java.sql.ResultSet rs = coStatement.executeQuery(query);
            while(rs.next()){
                firList.add(rs.getInt("FIR_id"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return firList;
    }

    public FIR getFIR(int FIR_id) {
        FIR fir = new FIR();
        String query = "select * from fir inner join crime_desc on crime_desc.crime_id = fir.crime_desc_id where FIR_id = "+ FIR_id +" " ;
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            java.sql.ResultSet rs = coStatement.executeQuery(query);
            while(rs.next()){
                fir.setFIR_ID(rs.getInt("FIR_id"));
                fir.setDate(rs.getDate("pub_date").toString());
                fir.setTime(rs.getTime("pub_time").toString());
                fir.setLocation(rs.getString("location"));
                fir.setDescription(rs.getString("description"));
                fir.setEvidence(rs.getString("evidence"));
                fir.setCrime_desc(rs.getString("crime_type"));
                fir.setStatus(rs.getBoolean("assigned_status"));
                fir.setReport(rs.getString("investigation_report"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return fir;
    }

    public ArrayList<Integer> getAssignedFIRs(int officer_id) {
        ArrayList<Integer> firList = new ArrayList<Integer>();
        System.out.println(officer_id);
        String query = "SELECT * FROM FIR where officer_id = "+ officer_id +" " ;
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            java.sql.ResultSet rs = coStatement.executeQuery(query);
            while(rs.next()){
                firList.add(rs.getInt("FIR_id"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }

        

        return firList;
    }
}
