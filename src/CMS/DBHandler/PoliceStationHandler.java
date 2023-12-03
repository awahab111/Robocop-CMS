package CMS.DBHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import CMS.PoliceStation;

public class PoliceStationHandler {
    Database db = Database.getInstance();


    public void insertPoliceStation(int station_id, String name, String location, String phone) {
        String query = "INSERT INTO POLICE_STATION (station_id, location, station_name, contact_number) VALUES (" + station_id + ", '" + location + "', '" + name + "', '" + phone + "')";
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(query);
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public ArrayList<String> getPoliceStation() throws SQLException {
        // Connect to the database
        java.sql.Connection conn = db.getconn();
        Statement statement = conn.createStatement();

        // Execute the query to retrieve police station names
        String query = "select station_name from police_station";
        ResultSet resultSet = statement.executeQuery(query);

        // Initialize the array to store police station names
        ArrayList<String> policeStationNames = new ArrayList<String>();
        // Retrieve police station names from the result set
        while(resultSet.next()) {
            policeStationNames.add(resultSet.getString("station_name"));
        }

        return policeStationNames;
    }

    public PoliceStation getPoliceStationDetails(String policeStationName) {
        PoliceStation policeStation = null;
        String query = "SELECT * FROM POLICE_STATION WHERE station_name = '" + policeStationName + "'";
        java.sql.Connection conn = db.getconn();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int stationId = resultSet.getInt("station_id");
                String location = resultSet.getString("location");
                String name = resultSet.getString("station_name");
                String phone = resultSet.getString("contact_number");
                policeStation = new PoliceStation(stationId, name, location, phone);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return policeStation;
    }
}
