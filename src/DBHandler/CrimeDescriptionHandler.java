package DBHandler;
import java.sql.*;
import java.util.ArrayList;


public class CrimeDescriptionHandler {
    Database db = Database.getInstance();

    public int getCrimeID(String crimeDescription){


        java.sql.Connection conn = db.getconn();
        String stat = "select crime_id from crime_desc where crime_type = '" + crimeDescription + "'";
        try{
            Statement coStatement = conn.createStatement();
            ResultSet resultSet = coStatement.executeQuery(stat);
            resultSet.next();
            return resultSet.getInt(1);
        }catch(SQLException e){
            return -1;
        }
    }

    public void insertCrime(String crimeDescription){
        java.sql.Connection conn = db.getconn();
        String stat = "insert into crime_description (description) values ('" + crimeDescription + "')";
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(stat);
        }catch(SQLException e){
        }
    }

    public ArrayList<String> getCrimeDescription() throws SQLException {
        // Connect to the database
        java.sql.Connection conn = db.getconn();
        Statement statement = conn.createStatement();

        // Execute the query to retrieve crime descriptions
        String query = "select crime_type from crime_desc";
        ResultSet resultSet = statement.executeQuery(query);

        // Initialize the array to store crime descriptions
        ArrayList<String> crimeDescriptions = new ArrayList<String>();
        // Retrieve crime descriptions from the result set
        while(resultSet.next()) {
            crimeDescriptions.add(resultSet.getString("crime_type"));
        }

        return crimeDescriptions;
    }
}
