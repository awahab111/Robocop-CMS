package CMS.DBHandler;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import CMS.CriminalRecord;

public class CriminalRecordHandler {
    public void insertRecord(String name, String fatherName, String birthplace, String address, String cnic, ArrayList<String> crimes){
        String query = "INSERT INTO criminal_record (name, father_name, birthplace, address, cnic) VALUES ('" + name + "', '" + fatherName + "', '" + birthplace + "', '" + address + "', '" + cnic + "')";
        Database db = new Database();
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(query);
        }catch(SQLException e){
            System.out.println(e);
        }
        
        for(int i = 0; i < crimes.size(); i++){
            String history_query = "INSERT INTO criminal_history (cnic, crime) VALUES ('" + cnic + "', '" + crimes.get(i) + "')";
            try{
                Statement coStatement = conn.createStatement();
                coStatement.executeUpdate(history_query);
            }catch(SQLException e){
                System.out.println(e);
            }
        }


    }

    public ArrayList<CriminalRecord> getAllRecords(){
        ArrayList<CriminalRecord> records = new ArrayList<CriminalRecord>();
        String query = "SELECT * FROM criminal_record";
        Database db = new Database();
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            java.sql.ResultSet rs = coStatement.executeQuery(query);
            while(rs.next()){
                CriminalRecord record = new CriminalRecord();
                record.setCriminal_id(rs.getInt("criminal_id"));
                record.setName(rs.getString("name"));
                record.setFatherName(rs.getString("father_name"));
                record.setBirthplace(rs.getString("birthplace"));
                record.setAddress(rs.getString("address"));
                record.setCnic(rs.getString("cnic"));
                record.setCrimes(getCrimeHistory(record.getCriminal_id()));
                records.add(record);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return records;
    }

    public CriminalRecord getRecord(int criminal_id){
        CriminalRecord record = new CriminalRecord();
        String query = "SELECT * FROM criminal_record WHERE criminal_id = '" + criminal_id + "'";
        Database db = new Database();
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            java.sql.ResultSet rs = coStatement.executeQuery(query);
            while(rs.next()){
                record.setCriminal_id(rs.getInt("criminal_id"));
                record.setName(rs.getString("name"));
                record.setFatherName(rs.getString("father_name"));
                record.setBirthplace(rs.getString("birthplace"));
                record.setAddress(rs.getString("address"));
                record.setCnic(rs.getString("cnic"));
                record.setCrimes(getCrimeHistory(criminal_id));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return record;
    }

    public ArrayList<String> getCrimeHistory(int criminal_id){
        ArrayList<String> crimes = new ArrayList<String>();
        String query = "SELECT * FROM criminal_history WHERE criminal_id = '" + criminal_id + "'";
        Database db = new Database();
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            java.sql.ResultSet rs = coStatement.executeQuery(query);
            while(rs.next()){
                crimes.add(rs.getString("crime"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return crimes;

    }
    
}
